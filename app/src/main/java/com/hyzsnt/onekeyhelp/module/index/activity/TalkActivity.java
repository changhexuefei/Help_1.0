package com.hyzsnt.onekeyhelp.module.index.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TalkActivity extends BaseActivity {
    @BindView(R.id.ibtn_press_talk)
    ImageButton mIbtnPressTalk;
    @BindView(R.id.btn_release)
    Button mBtnRelease;
    @BindView(R.id.btn_del_record)
    Button mBtnDelRecord;
    @BindView(R.id.talker_icon)
    ImageView mTalkerIcon;
    @BindView(R.id.btn_cancel)
    Button mBtnCancel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_talk;
    }

    @Override
    protected void initData() {
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


    @OnClick({R.id.ibtn_press_talk, R.id.btn_release, R.id.btn_del_record})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibtn_press_talk:
                break;
            case R.id.btn_release:
                break;
            case R.id.btn_del_record:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
