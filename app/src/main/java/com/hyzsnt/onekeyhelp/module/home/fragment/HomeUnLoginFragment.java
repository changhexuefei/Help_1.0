package com.hyzsnt.onekeyhelp.module.home.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.view.CommonHeader;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.help.bean.LocationInfo;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeUnLoginAdapter;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeUnLoginHeadAdapter;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.bean.UserInfoInfo;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.index.activity.SeekeStateActivity;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeUnLoginFragment extends BaseFragment {

    @BindView(R.id.home_tv_title)
    TextView homeTvTitle;
    @BindView(R.id.homeimage_search)
    ImageView homeimageSearch;
    @BindView(R.id.home_ll_title)
    LinearLayout homeLlTitle;
    @BindView(R.id.home_image_location)
    ImageView homeImageLocation;
    @BindView(R.id.home_lrv)
    LRecyclerView homeLrv;
    private String mUid;
    private double mLatitude;
    private double mLongitude;
    private UserInfoInfo mUserInfoInfo;

    public HomeUnLoginFragment() {
        // Required empty public constructor
    }

    @Override
    protected List<String> getParams() {
        return null;
    }

    @Override
    protected void initData(String content) {

        LocationInfo location = App.getLocation();
        if(location!=null){
            homeTvTitle.setText(location.getAddrStr());
        }
        initUserinfo();
        final HomeUnLoginAdapter mHomeAdapter = new HomeUnLoginAdapter(getActivity());
        homeLrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        final LRecyclerViewAdapter adapter = new LRecyclerViewAdapter(mHomeAdapter);
        homeLrv.setItemAnimator(new DefaultItemAnimator());
        homeLrv.setAdapter(adapter);
        homeLrv.setPullRefreshEnabled(false);
        //加入头布局
        CommonHeader header=new CommonHeader(getActivity(),R.layout.item_home_lrv_head);
        adapter.addHeaderView(header);

        RecyclerView homeLrvHead = (RecyclerView) header.findViewById(R.id.home_lrv_head);
        HomeUnLoginHeadAdapter homeHeadAdapter = new HomeUnLoginHeadAdapter(getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        homeLrvHead.setLayoutManager(layoutManager);
        homeLrvHead.setAdapter(homeHeadAdapter);
        homeLrvHead.setItemAnimator(new DefaultItemAnimator());


        List params = new ArrayList<String>();
        // 检索类别(0定位检索，1条件检索)/ 获取数量(每次展现数量)/获取页数(获取页数，初次检索默认1)/用户ID/纬度/经度	/区县编码	热区编码	 小区名称

        //获取小区列表
        params.add("0");//
        params.add("10");
        params.add("1");
        params.add(mUid);
        params.add(String.valueOf(mLatitude));
        params.add(String.valueOf(mLongitude));
        params.add("");
        params.add("");
        params.add("");
        HttpUtils.post(Api.COMMUNITY, Api.Community.GETCOMMUNITYLIST, params, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onSuccess(String response, int id) {
                if(JsonUtils.isSuccess(response)){
                    ArrayList<MDate> dates = Resovle.getCommunityList(response);
                    mHomeAdapter.setDates(dates);
                    mHomeAdapter.notifyDataSetChanged();
                    adapter.notifyDataSetChanged();
                }else {
                    ToastUtils.showShort(mActivity,JsonUtils.getErrorMessage(response));
                }

            }

            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });

    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_un_login;
    }
    @Override
    public String getC() {
        return null;
    }
    @Override
    public String getA() {
        return null;
    }
    @OnClick({R.id.homeimage_search,R.id.home_image_location})
    public void onClick(View view) {
        switch (view.getId()) {
            //搜索小区
            case R.id.homeimage_search:
                startActivity(new Intent(getActivity(), SeekeStateActivity.class));
                break;
            //加入小区
            case R.id.home_image_location:{
                String registrationID = JPushInterface.getRegistrationID(getActivity());
                List params = new ArrayList<String>();
                //params 用户id/小区id
                params.add(mUid);
                //获取当前小区id
                params.add( mUserInfoInfo.getIncommunity());
                HttpUtils.post(Api.USER, Api.User.JOINCOMMUNITY, params, new ResponseHandler() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        if(JsonUtils.isSuccess(response)){
                            ToastUtils.showShort(mActivity,"加入小区成功");
                        }else{
                            ToastUtils.showShort(mActivity,JsonUtils.getErrorMessage(response));
                        }
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                    }
                });
            }
        }
    }

    @Override
    protected void initView(View contentView) {
        super.initView(contentView);
    }

    public void setTitle(String addrStr) {
        if (addrStr != null) {
            homeTvTitle.setText(addrStr);
        } else {
            homeTvTitle.setText("定位中...");
        }
    }
    //初始化用户信息
    public void initUserinfo(){
        //用户信息详情
        String userDetail = (String) SPUtils.get(getActivity(), "userDetail", "");
        //用户信息解析
        ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
        //用户信息
        mUserInfoInfo = userInfo.get(0).getmInfo().getUserInfoInfo();
        //用户id
        mUid = mUserInfoInfo.getUid();
        //用户经纬度
        if(App.getLocation() == null){
            mLatitude =69.233;
            mLongitude = 133.56643;
        }else{
            mLatitude = App.getLocation().getLatitude();
            mLongitude = App.getLocation().getLongitude();
        }


    }
}
