package com.hyzsnt.onekeyhelp.module.user.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.user.activity.OrderDetailsActivity;
import com.hyzsnt.onekeyhelp.module.user.adapter.OrderItemAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/17.
 */

public class OderAllFragment extends BaseFragment {

    @BindView(R.id.re_order_all)
    RecyclerView mReOrderAll;
    private String mStr;

    @Override
    protected List<String> getParams() {
        return null;
    }

    @Override
    protected void initData(String content) {
        mReOrderAll.setLayoutManager(new LinearLayoutManager(mActivity));
        OrderItemAdapter adapter = new OrderItemAdapter(mActivity,mStr);
        mReOrderAll.setAdapter(adapter);
        adapter.setOnItemClickListener(new OrderItemAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int data) {
                startActivity(new Intent(mActivity, OrderDetailsActivity.class));
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_all;
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
    public void getArgs(Bundle bundle) {
        mStr = (String) bundle.get("title");
    }
}
