package com.hyzsnt.onekeyhelp.module.home.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hyzs on 2016/12/12.
 */

public class VoiceDetailActivity extends BaseActivity {
    @BindView(R.id.home_voice_rlv)
    RecyclerView homeVoiceRlv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_voice;
    }

    @Override
    protected void initData() {

    }
}
