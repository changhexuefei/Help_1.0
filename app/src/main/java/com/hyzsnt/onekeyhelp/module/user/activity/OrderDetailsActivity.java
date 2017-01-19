package com.hyzsnt.onekeyhelp.module.user.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.home.adapter.ShopListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailsActivity extends BaseActivity {

    @BindView(R.id.lre_order_detailss)
    LRecyclerView mLreOrderDetails;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_details;
    }

    @Override
    protected void initData() {
        mLreOrderDetails.setPullRefreshEnabled(false);
        mLreOrderDetails.setLayoutManager(new GridLayoutManager(this, 2));

        ShopListAdapter adapters = new ShopListAdapter(this);
        LRecyclerViewAdapter mAdapter = new LRecyclerViewAdapter(adapters);
        mLreOrderDetails.setAdapter(mAdapter);
        mAdapter.addHeaderView(LayoutInflater.from(this).inflate(R.layout.activity_order_details_header, null));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.im_circle_details_back)
    public void onClick() {
        finish();
    }
}
