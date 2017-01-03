package com.hyzsnt.onekeyhelp.module.search;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.help.bean.LocationInfo;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.search.activity.SwitchCityActivity;
import com.hyzsnt.onekeyhelp.module.search.adapter.CommunityListAdapter;
import com.hyzsnt.onekeyhelp.module.search.bean.CommunityResultBean;
import com.hyzsnt.onekeyhelp.module.search.bean.HotTagBean;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class SearchCommunityActivity extends BaseActivity implements TextWatcher {

    @BindView(R.id.et_search_content)
    EditText mEtSearchContent;
    @BindView(R.id.iv_search_delete)
    ImageView mIvSearchDelete;
    @BindView(R.id.ll_search)
    LinearLayout mLlSearch;
    @BindView(R.id.tv_city_name)
    TextView mTvCityName;
    @BindView(R.id.tv_switch_city)
    TextView mTvSwitchCity;
    @BindView(R.id.rl_city_list)
    RecyclerView mRlCityList;
    @BindView(R.id.id_flowlayout)
    TagFlowLayout mIdFlowlayout;
    @BindView(R.id.sv_tag)
    ScrollView mSvTag;
    private String mRegid;
    private double mLatitude;
    private double mLongitude;
    private String mUid;
    private HotTagBean mHotTagBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_community;
    }

    @Override
    protected void initListener() {
        super.initListener();
        mEtSearchContent.addTextChangedListener(this);
    }

    @Override
    protected void initData() {
        LocationInfo location = App.getLocation();
        String userDetail = (String) SPUtils.get(this, "userDetail", "");
        ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
        mUid = userInfo.get(0).getmInfo().getUserInfoInfo().getUid();
        if (location != null) {
            mRegid = location.getRegid();
            mLatitude = location.getLatitude();
            mLongitude = location.getLongitude();
            getHotTagByLocation();
        } else {
            ToastUtils.showShort(this, "定位失败！");
        }
    }

    private void showSearchResults(String cmid) {
        mSvTag.setVisibility(View.GONE);
        mRlCityList.setVisibility(View.VISIBLE);

        List<String> params = new ArrayList<>();
        params.add("1");
        params.add("20");
        params.add("1");
        params.add(mUid);
        params.add(mLatitude + "");
        params.add(mLongitude + "");
        params.add("");//8
        params.add(cmid);//8
        params.add("");//8
        HttpUtils.post(Api.COMMUNITY, Api.Community.GETCOMMUNITYLIST, params, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
                LogUtils.e("onError:" + e.getMessage());
            }

            @Override
            public void onSuccess(String response, int id) {
                LogUtils.e("onSuccess:" + response);
                if (JsonUtils.isSuccess(response)) {
                    CommunityResultBean communityResultBean = new Gson().fromJson(response, CommunityResultBean.class);
                    mRlCityList.setLayoutManager(new LinearLayoutManager(SearchCommunityActivity.this, OrientationHelper.VERTICAL, false));
                    mRlCityList.setAdapter(new CommunityListAdapter(SearchCommunityActivity.this, communityResultBean));
                } else {

                }
            }
        });
    }

    private void getHotTagByLocation() {
        List<String> params = new ArrayList<>();
        params.add("0");//定位检索
        params.add(mUid);
        params.add(mLatitude + "");
        params.add(mLongitude + "");
        params.add(mRegid);
        HttpUtils.post(Api.PUBLIC, Api.Public.GETHOTAREA, params, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
                LogUtils.e("onError:" + e.getMessage());
            }

            @Override
            public void onSuccess(String response, int id) {
                LogUtils.e("onSuccess:" + response);
                if (JsonUtils.isSuccess(response)) {
                    mHotTagBean = new Gson().fromJson(response, HotTagBean.class);
                    mTvCityName.setText(mHotTagBean.getInfo().getRegname());
                    List<HotTagBean.ListBean> list = mHotTagBean.getList();
                    mIdFlowlayout.setAdapter(new HotTagAdapter(list));
                    mIdFlowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                        @Override
                        public boolean onTagClick(View view, int position, FlowLayout parent) {
                            HotTagBean.ListBean bean = mHotTagBean.getList().get(position);
                            showSearchResults(bean.getHid());
                            return false;
                        }
                    });
                } else {
                    LogUtils.e("请求错误：" + JsonUtils.getErrorMessage(response));
                    ToastUtils.showShort(SearchCommunityActivity.this, "请求错误：" + JsonUtils.getErrorMessage(response));
                }
            }
        });
    }

    @OnClick({R.id.iv_search_delete, R.id.iv_search_back, R.id.tv_switch_city})
    public void clearText(View view) {
        switch (view.getId()) {
            case R.id.iv_search_delete:
                mEtSearchContent.setText("");
                mSvTag.setVisibility(View.VISIBLE);
                mRlCityList.setVisibility(View.INVISIBLE);
                break;
            case R.id.iv_search_back:
                finish();
                break;
            case R.id.tv_switch_city:
                Intent intent = new Intent(this, SwitchCityActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!TextUtils.isEmpty(s)) {
            mIvSearchDelete.setVisibility(View.VISIBLE);
            mSvTag.setVisibility(View.GONE);
            mRlCityList.setVisibility(View.VISIBLE);
        } else {
            mIvSearchDelete.setVisibility(View.INVISIBLE);
            mSvTag.setVisibility(View.VISIBLE);
            mRlCityList.setVisibility(View.GONE);
        }
        List<String> params = new ArrayList<>();
        params.add("1");
        params.add("20");
        params.add("1");
        params.add(mUid);
        params.add(mLatitude + "");
        params.add(mLongitude + "");
        params.add(mRegid);//8
        params.add("");//8
        params.add(s.toString());//8
        HttpUtils.post(Api.COMMUNITY, Api.Community.GETCOMMUNITYLIST, params, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
                LogUtils.e("onError:" + e.getMessage());
            }

            @Override
            public void onSuccess(String response, int id) {
                LogUtils.e("onSuccess:" + response);
                if (JsonUtils.isSuccess(response)) {
                    CommunityResultBean communityResultBean = new Gson().fromJson(response, CommunityResultBean.class);
                    mRlCityList.setLayoutManager(new LinearLayoutManager(SearchCommunityActivity.this, OrientationHelper.VERTICAL, false));
                    mRlCityList.setAdapter(new CommunityListAdapter(SearchCommunityActivity.this, communityResultBean));
                } else {

                }
            }
        });


    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtils.e("onActivityResult");
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String regname = data.getStringExtra("Regname");
            String regid = data.getStringExtra("Regid");
            LogUtils.e("onActivityResult:" + regname);
            Toast.makeText(SearchCommunityActivity.this, "regname", Toast.LENGTH_SHORT).show();
            mTvCityName.setText(regname);
            mRegid = regid;
            showHotTag(regid);
        }
    }

    private void showHotTag(String regid) {
        List<String> params = new ArrayList<>();
        params.add("1");//定位检索
        params.add(mUid);
        params.add("");
        params.add("");
        params.add(regid);
        HttpUtils.post(Api.PUBLIC, Api.Public.GETHOTAREA, params, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
                LogUtils.e("onError:" + e.getMessage());
            }

            @Override
            public void onSuccess(String response, int id) {
                LogUtils.e("onSuccess:" + response);
                if (JsonUtils.isSuccess(response)) {
                    mHotTagBean = new Gson().fromJson(response, HotTagBean.class);
                    List<HotTagBean.ListBean> list = mHotTagBean.getList();
                    mIdFlowlayout.setAdapter(new HotTagAdapter(list));
                    mIdFlowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                        @Override
                        public boolean onTagClick(View view, int position, FlowLayout parent) {
                            HotTagBean.ListBean bean = mHotTagBean.getList().get(position);
                            mEtSearchContent.setText(bean.getHname());
                            showSearchResults(bean.getHid());
                            return false;
                        }
                    });
                } else {
                    LogUtils.e("请求错误：" + JsonUtils.getErrorMessage(response));
                    ToastUtils.showShort(SearchCommunityActivity.this, "请求错误：" + JsonUtils.getErrorMessage(response));
                }
            }
        });
    }

    class HotTagAdapter extends TagAdapter {

        public HotTagAdapter(List data) {
            super(data);
        }

        @Override
        public View getView(FlowLayout parent, int position, Object o) {
            HotTagBean.ListBean listBean = mHotTagBean.getList().get(position);
            TextView view = (TextView) View.inflate(SearchCommunityActivity.this, R.layout.flow_item, null);
            view.setText(listBean.getHname());
            return view;
        }
    }


}
