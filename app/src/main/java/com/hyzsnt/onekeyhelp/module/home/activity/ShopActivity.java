package com.hyzsnt.onekeyhelp.module.home.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.home.adapter.ShopListAdapter;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.OnClick;


public class ShopActivity extends BaseActivity {

    @BindView(R.id.lrv_shop_list)
    LRecyclerView mLrvShopList;
    private LRecyclerViewAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop;
    }

    @Override
    protected void initData() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.red_shop));
        mAdapter = new LRecyclerViewAdapter(new ShopListAdapter(this));
        View view = View.inflate(this, R.layout.shop_header, null);
        view.findViewById(R.id.tv_shop_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopActivity.this, MoreShopActivity.class);
                startActivity(intent);
            }
        });
        mAdapter.addHeaderView(view);
        mLrvShopList.setPullRefreshEnabled(false);
        mLrvShopList.setLayoutManager(new GridLayoutManager(this, 2));
        mLrvShopList.setAdapter(mAdapter);
    }

    @OnClick({R.id.iv_shop_back, R.id.fl_shop_cart})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_shop_back:
                finish();
                break;
            case R.id.fl_shop_cart:
                startActivity(new Intent(this,ShoppingCarActivity.class));
                break;
        }
    }
}
