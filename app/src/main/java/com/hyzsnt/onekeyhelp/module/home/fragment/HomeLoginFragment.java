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

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.activity.StateActivity;
import com.hyzsnt.onekeyhelp.module.home.activity.VoiceDetailActivity;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeLoginAdapter;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeUnLoginAdapter;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.inner.OnRecyclerViewItemClickListener;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeLoginFragment extends BaseFragment {


    @BindView(R.id.home_login_rv)
    RecyclerView homeLoginRv;

    public HomeLoginFragment() {
        // Required empty public constructor
    }

    @Override
    protected List<String> getParams() {
        return null;
    }

    @Override
    protected void initData(String content) {
        final HomeLoginAdapter mHomeLoginAdapter=new HomeLoginAdapter(getActivity());
        homeLoginRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeLoginRv.setAdapter(mHomeLoginAdapter);
        homeLoginRv.setItemAnimator(new DefaultItemAnimator());

        mHomeLoginAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i=new Intent(getActivity(), StateActivity.class);
                startActivity(i);
            }
        });
        //动态数据请求
        List params = new ArrayList<String>();
        params.add("2061");//2061  2803
        params.add("4");
        params.add("1");
        //params.add("15551675396");//15551675396
        HttpUtils.post(Api.COMMUNITY, Api.Community.GETDYNAMICLISTBYCOMMUNITY,params, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onSuccess(String response, int id) {

                ArrayList<MDate> dynamicListByCommunity = Resovle.getDynamicListByCommunity(response);
                mHomeLoginAdapter.setDates(dynamicListByCommunity);
                mHomeLoginAdapter.notifyDataSetChanged();
                Log.e("LISTB++++++", dynamicListByCommunity + "");
            }

            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_login;
    }

    @Override
    public String getC() {
        return null;
    }

    @Override
    public String getA() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
