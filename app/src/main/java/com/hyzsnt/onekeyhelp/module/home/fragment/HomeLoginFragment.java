package com.hyzsnt.onekeyhelp.module.home.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeLoginAdapter;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeUnLoginAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        HomeLoginAdapter mHomeLoginAdapter=new HomeLoginAdapter(getActivity());
        homeLoginRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeLoginRv.setAdapter(mHomeLoginAdapter);
        homeLoginRv.setItemAnimator(new DefaultItemAnimator());
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
