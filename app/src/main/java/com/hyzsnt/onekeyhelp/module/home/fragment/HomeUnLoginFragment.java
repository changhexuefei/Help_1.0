package com.hyzsnt.onekeyhelp.module.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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


        String userDetail = (String) SPUtils.get(getActivity(), "userDetail", "");
        ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
        UserInfoInfo userInfoInfo = userInfo.get(0).getmInfo().getUserInfoInfo();
        String uid = userInfoInfo.getUid();

        List params = new ArrayList<String>();
        //params.add("15551675396");//用户ID：7   纬度	：	39.923594   经度	：	116.539995
        params.add("0");
        params.add("10");
        params.add("1");
        params.add(uid);
        params.add("39.923594");
        params.add("116.539995");
        params.add("");
        params.add("");
        params.add("");
        HttpUtils.post(Api.COMMUNITY, Api.Community.GETCOMMUNITYLIST, params, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onSuccess(String response, int id) {
                ArrayList<MDate> dates = Resovle.getCommunityList(response);
                mHomeAdapter.setDates(dates);
                mHomeAdapter.notifyDataSetChanged();
                adapter.notifyDataSetChanged();
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

    @OnClick({R.id.home_image_location, R.id.homeimage_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_image_location:
                break;
            case R.id.homeimage_search:
                Intent i = new Intent(getActivity(), SeekeStateActivity.class);
                startActivity(i);
                break;
        }
    }

    @Override
    protected void initView(View contentView) {
        super.initView(contentView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.home_image_location)
    public void onClick() {
        String registrationID = JPushInterface.getRegistrationID(getActivity());
        List params = new ArrayList<String>();
        //params.add("15551675396");//用户ID：7   纬度	：	39.923594   经度	：	116.539995
        params.add("2803");
        params.add("7");
        HttpUtils.post(Api.USER, Api.User.JOINCOMMUNITY, params, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onSuccess(String response, int id) {
                Log.e("8888888888888888888",response+"");
            }
            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });
    }
}
