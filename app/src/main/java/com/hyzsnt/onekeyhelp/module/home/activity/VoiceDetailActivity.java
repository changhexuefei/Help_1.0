package com.hyzsnt.onekeyhelp.module.home.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.home.adapter.VoiceDetailAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hyzs on 2016/12/12.
 */

public class VoiceDetailActivity extends BaseActivity {


    @BindView(R.id.home_voice_rlv)
    RecyclerView homeVoiceRlv;
    @BindView(R.id.voice_goback)
    ImageView voiceGoback;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_voice;
    }

    @Override
    protected void initData() {
        VoiceDetailAdapter mVoiceDetailAdapter = new VoiceDetailAdapter(this);
        homeVoiceRlv.setLayoutManager(new LinearLayoutManager(this));
        homeVoiceRlv.setAdapter(mVoiceDetailAdapter);
        homeVoiceRlv.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.voice_goback)
    public void onClick() {
        finish();
    }
}
