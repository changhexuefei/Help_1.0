package com.hyzsnt.onekeyhelp.module.home.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.home.adapter.StateDetailAdapter;
import com.hyzsnt.onekeyhelp.module.home.adapter.VoiceDetailAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StateActivity extends BaseActivity {

    @BindView(R.id.sate_activity_recyclerview)
    RecyclerView stateRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_state;
    }

    @Override
    protected void initData() {
        StateDetailAdapter mStateDetailAdapter = new StateDetailAdapter(this);
        stateRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        stateRecyclerView.setAdapter(mStateDetailAdapter);
        stateRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
