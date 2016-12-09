package com.hyzsnt.onekeyhelp.module.home.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeLoginFragment extends BaseFragment {


    public HomeLoginFragment() {
        // Required empty public constructor
    }
    @Override
    protected List<String> getParams() {
        return null;
    }

    @Override
    protected void initData(String content) {

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
}
