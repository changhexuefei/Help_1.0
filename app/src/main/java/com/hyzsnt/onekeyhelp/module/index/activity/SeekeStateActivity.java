package com.hyzsnt.onekeyhelp.module.index.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.index.adapter.CommunityListAdapter;
import com.hyzsnt.onekeyhelp.module.index.bean.CommunityList;
import com.hyzsnt.onekeyhelp.module.index.bean.HotAreaInfo;
import com.hyzsnt.onekeyhelp.module.index.bean.MyHotAreaInfo;
import com.hyzsnt.onekeyhelp.module.index.bean.MyHotAreaList;
import com.hyzsnt.onekeyhelp.module.index.bean.ProvinceAndCityInfo;
import com.hyzsnt.onekeyhelp.module.index.fragment.SearchCommunityListFragment;
import com.hyzsnt.onekeyhelp.module.index.fragment.SearchHotAreaFragment;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

/**
 * 在主页面点击搜索图标进入到搜索页面
 */

public class SeekeStateActivity extends BaseActivity implements SearchHotAreaFragment.CallBackValue {

    @BindView(R.id.tv_delete_text)
    TextView tv_delete_text;
    @BindView(R.id.btn_return)
    ImageView btn_return;
    @BindView(R.id.search_estate_bar)
    EditText mSearchEstateBar;

    @BindView(R.id.city_name)
    TextView tv_cityName;
    @BindView(R.id.btn_change)
    Button btn_change;
    @BindView(R.id.city)
    LinearLayout linCity;
    @BindView(R.id.hotArea)
    TextView tv_hotArea;
    @BindView(R.id.fuzzyList)
    LRecyclerView mComList;
    @BindView(R.id.currentLocation)
    TextView tv_currentLocation;

    List<CommunityList.ListBean> mCommunityLists;
    CommunityListAdapter mAdapter;
    ArrayList<HotAreaInfo> mHotAreaInfos;
    HotAreaInfo mHotAreaInfo;
    MyHotAreaInfo mMyHotAreaInfo;
    MyHotAreaList mMyHotAreaList;
    private FragmentManager manager;


    //获取行政区信息的接口 a
    private static final String REGIONAL = "getRegional";
    //获取热门地区的接口 a
    private static final String HOTAREA = "getHotArea";
    //每次展现数量
    private static final String NUM = "1";
    //获取页数，初次检索默认1
    private static final String PAGENUM = "1";

    //定位检索
    private static final String ORIENTATION = "0";
    //区域检索
    private static final String AREA = "1";
    //用户ID
    private String userid = "";
    //最高級上级行政区域ID
    private String regid = "100000";
    //条件集合
    List<String> parms = new ArrayList<>();
    private String lat;
    private String lon;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;
    private String mCityID;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_seeke_state;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initData() {
        userid = (String) SPUtils.get(this, "uid", "0");
        Log.d("ggg", userid);
        mAdapter = new CommunityListAdapter();
        mHotAreaInfos = new ArrayList<HotAreaInfo>();
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.myFragment, new SearchHotAreaFragment()).commit();
        getCurrentLocation();
    }

    /**
     * 得到当前位置的方法
     */
    private void getCurrentLocation() {
        if (Double.toString(App.getLocation().getLatitude()) != null &&
                Double.toString(App.getLocation().getLongitude()) != null) {
            lat = Double.toString(App.getLocation().getLatitude());
            Log.d("lat", lat);
            lon = Double.toString(App.getLocation().getLongitude());
            Log.d("lon", lon);
            mCityID = App.getLocation().getRegid();
            String regname = App.getLocation().getRegname();
            Log.i("zzzz", regname);
            tv_currentLocation.setText(regname);
//            parms.add("");
            parms.add("0");
            parms.add(userid);
            parms.add(lat);
            parms.add(lon);
            parms.add(mCityID);
            HttpUtils.post(Api.PUBLIC, HOTAREA, parms, new JsonResponseHandler() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    LogUtils.e("onError:" + e.getMessage());
                    ToastUtils.showShort(SeekeStateActivity.this, "失败！");
                }

                @Override
                public void onSuccess(String response, int id) {
                    Log.d("我的位置是：", response);
                    if (JsonUtils.isSuccess(response)) {
                        try {
                            JSONObject object = new JSONObject(response);
                            int res = object.optInt("res", 0);
                            if (res == 0) {
                                ToastUtils.showShort(SeekeStateActivity.this, "链接错误！");
                            } else if (res == 1) {
                                mMyHotAreaInfo = new MyHotAreaInfo();
                                JSONObject info = object.getJSONObject("info");
                                String regname = info.getString("regname");
                                mMyHotAreaInfo.setRegname(regname);
                                String regid = info.getString("regid");
                                mMyHotAreaInfo.setRegid(regid);
                                String position = info.getString("position");
                                mMyHotAreaInfo.setPosition(position);

                                Log.d("12345678", mMyHotAreaInfo.getRegname());
                                if (mMyHotAreaInfo.getRegname() != null) {
                                    tv_cityName.setText(mMyHotAreaInfo.getRegname());
                                } else {
                                    tv_cityName.setVisibility(View.GONE);
                                }
                                JSONObject list = object.getJSONObject("list");
                                Log.d("list", "" + list);
                                Iterator<String> iterator = list.keys();
                                while (iterator.hasNext()) {
                                    mHotAreaInfo = new HotAreaInfo();
                                    mMyHotAreaList = new MyHotAreaList();
                                    String key = iterator.next();
                                    Log.d("key+++++++", key);
                                    mMyHotAreaList.setHotID(key);
                                    String value = list.getString(key);
                                    Log.d("value+++++", value);
                                    mMyHotAreaList.setHotName(value);
                                    mHotAreaInfo.setList(mMyHotAreaList);
                                    mHotAreaInfos.add(mHotAreaInfo);
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String err = JsonUtils.getErrorMessage(response);
                        LogUtils.e(err);
                    }
                }
            });

        } else {

        }
    }


    @Override
    protected void initListener() {
        super.initListener();
        //点击左上角图标退出本页面，返回上一页面
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //点击取消，清空搜索框中的文字
        tv_delete_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchEstateBar.setText("");

            }
        });

        //搜索框的监听事件
        mSearchEstateBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    mComList.setVisibility(View.GONE);
                    return;
                }
                parms.clear();
                parms.add("1");
                parms.add("10");
                parms.add("1");
                parms.add("4");
                parms.add(lat);
                parms.add(lon);
                parms.add(mCityID);
                parms.add("");
                parms.add(s.toString());

                HttpUtils.post(Api.COMMUNITY, "getCommunityList", parms, new JsonResponseHandler() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e("onError:" + e.getMessage());
                        ToastUtils.showShort(SeekeStateActivity.this, "搜索失败！");
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        Log.d("xxxxxxx", response);
                        if (JsonUtils.isSuccess(response)) {
                            try {
                                JSONObject object = new JSONObject(response);
                                int res = object.optInt("res", 0);
                                if (res == 0) {
                                    ToastUtils.showShort(SeekeStateActivity.this, "搜索失败！");
                                } else if (res == 1) {
                                    mCommunityLists = new ArrayList<CommunityList.ListBean>();
                                    Gson gson = new Gson();
                                    CommunityList communityList = gson.fromJson(response, CommunityList.class);
                                    mComList.setVisibility(View.VISIBLE);
                                    mCommunityLists = communityList.getList();
                                    mAdapter.setCommunityLists(mCommunityLists);
                                    LinearLayoutManager manager = new LinearLayoutManager(SeekeStateActivity.this, LinearLayoutManager.VERTICAL, false);
                                    mComList.setLayoutManager(manager);
                                    mComList.setHasFixedSize(true);
                                    mComList.setItemAnimator(new DefaultItemAnimator());
                                    mLRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
                                    mComList.setAdapter(mLRecyclerViewAdapter);
                                    //行点击事件
                                } else {

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }

        });
        //显示省份列表
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeekeStateActivity.this, ProvinceListActivity.class);
                intent.putExtra("regid", regid);
                startActivity(intent);
            }
        });
    }

    @Subscriber(tag = "toSeek", mode = ThreadMode.ASYNC)
    private void receivePCmsg(ProvinceAndCityInfo info) {
        LogUtils.e(info.toString());
        Log.i("EventBus", "receiverPCmsg.toSeek = " + info.getCityID());
        String provinceName = info.getProvinceName();
        mCityID = info.getCityID();
        String cityName = info.getCityName();
        StringBuffer sb = new StringBuffer();
        final String PCName = sb.append(provinceName).append(cityName).toString();
        Log.d("PCName", PCName);
//        tv_cityName.setText("");
        tv_cityName.post(new Runnable() {
            @Override
            public void run() {
                tv_cityName.setText(PCName);
            }
        });

        ToastUtils.showShort(this, PCName);
        final FragmentTransaction ft = manager.beginTransaction();
        SearchHotAreaFragment searchCommunityListFragment = new SearchHotAreaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("mCityID", mCityID);
        Log.i("232323", mCityID);
        Log.i("8888", bundle + "");
        searchCommunityListFragment.setArguments(bundle);
        ft.replace(R.id.myFragment, searchCommunityListFragment);
        ft.commit();

    }


    @Override
    public void SendMessageValue(final String comID, String comName, final String mCityID) {

        if (comName != null) {
            tv_hotArea.setVisibility(View.VISIBLE);
            tv_hotArea.setText(comName);
            final FragmentTransaction ft = manager.beginTransaction();
            SearchCommunityListFragment searchCommunityListFragment = new SearchCommunityListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("comID", comID);
            searchCommunityListFragment.setArguments(bundle);
            ft.replace(R.id.myFragment, searchCommunityListFragment);
            ft.commit();

            tv_hotArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_hotArea.setText("");
                    tv_hotArea.setVisibility(View.GONE);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    SearchHotAreaFragment hotAreaFragment = new SearchHotAreaFragment();
//                    Bundle b = new Bundle();
//                    b.putString("mCityID",mCityID);
//                    Log.i("abcdef",b+"");
//                    Log.d("%%%%%",mCityID);
//                    hotAreaFragment.setArguments(b);
                    transaction.replace(R.id.myFragment, hotAreaFragment).commit();
                }
            });

        } else if ("".equals(comName)) {
            tv_hotArea.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
