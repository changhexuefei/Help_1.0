package com.hyzsnt.onekeyhelp.module.index.activity;

import android.view.View;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

/**
 * 在主页面点击搜索图标进入到搜索页面
 */

public class SeekeStateActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seeke_state;
    }

    @Override
    protected void initData() {

    }
    public void click(View view){
        switch (view.getId()){
            case R.id.city:

                break;
            case R.id.county:

                break;
            case R.id.hot_pints:

                break;


        }



    }


}
