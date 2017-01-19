package com.hyzsnt.onekeyhelp.module.home.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.home.adapter.MoreShopListAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class MoreShopActivity extends BaseActivity {

    @BindView(R.id.shop_list)
    ListView mShopList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_more_shop;
    }

    @Override
    protected void initData() {
        mShopList.setAdapter(new MoreShopListAdapter(this));
    }

    @OnClick({R.id.iv_more_back, R.id.tv_more_swi, R.id.fl_more_cart})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_more_back:
                finish();
                break;
            case R.id.tv_more_swi:
                Toast.makeText(MoreShopActivity.this, "筛选", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_more_cart:
                Toast.makeText(MoreShopActivity.this, "购物车", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
