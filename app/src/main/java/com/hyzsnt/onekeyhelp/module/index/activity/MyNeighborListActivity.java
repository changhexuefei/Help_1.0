package com.hyzsnt.onekeyhelp.module.index.activity;

import android.widget.SearchView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;

public class MyNeighborListActivity extends BaseActivity {




    @BindView(R.id.search_bar)
    SearchView search_bar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_neighbor_list;
    }

    @Override
    protected void initData() {

    }
}
