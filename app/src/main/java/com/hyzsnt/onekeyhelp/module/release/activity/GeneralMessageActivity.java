package com.hyzsnt.onekeyhelp.module.release.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.home.activity.StateActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class GeneralMessageActivity extends BaseActivity {

    @BindView(R.id.btn_return)
    ImageButton mBtnReturn;
    @BindView(R.id.tv_msg)
    TextView mTvMsg;
    @BindView(R.id.et_title)
    EditText mEtTitle;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.btn_release)
    Button mBtnRelease;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_talk;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag1");
        if (tag.equals("iv_gener")) {
            mTvMsg.setText("发表综合信息");
        }
    }

    @OnClick({R.id.btn_return, R.id.btn_release})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_return:
                mBtnReturn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
                break;
            case R.id.btn_release:
                mBtnRelease.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(GeneralMessageActivity.this, StateActivity.class));
                    }
                });
                break;
        }
    }
}
