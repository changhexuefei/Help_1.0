package com.hyzsnt.onekeyhelp.module.user.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.user.adapter.OrderAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity {


    @BindView(R.id.tab_user_order)
    TabLayout mTabUserOrder;
    @BindView(R.id.vp_user_order)
    ViewPager mVpUserOrder;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void initData() {
        mVpUserOrder.setAdapter(new OrderAdapter(getSupportFragmentManager(),this));
        mTabUserOrder.setupWithViewPager(mVpUserOrder);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.im_search_back, R.id.im_stroll_seek})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_search_back:
                finish();
                break;
            case R.id.im_stroll_seek:
                break;
        }
    }
}
