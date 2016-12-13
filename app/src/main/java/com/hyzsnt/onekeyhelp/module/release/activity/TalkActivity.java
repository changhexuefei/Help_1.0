package com.hyzsnt.onekeyhelp.module.release.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.home.activity.StateActivity;
import com.hyzsnt.onekeyhelp.module.release.view.MyEditText;

import butterknife.BindView;
import butterknife.OnClick;


public class TalkActivity extends BaseActivity {


    @BindView(R.id.btn_return)
    ImageButton mBtnReturn;
    @BindView(R.id.tv_msg)
    TextView mTvMsg;
    @BindView(R.id.et_title)
    MyEditText mEtTitle;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.cbx)
    CheckBox mCbx;
    @BindView(R.id.btn_release)
    Button mBtnRelease;
    //checkBox默认选中
    boolean isChecked = true;
    @BindView(R.id.add_icon)
    TextView mAddIcon;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_talk;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");
        if (tag.equals("iv_talk")) {
            mTvMsg.setText("发表说说");

        }
        mCbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //do something
                } else {
                    //do something else
                }
            }
        });
        mCbx.setChecked(isChecked);

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
                        startActivity(new Intent(TalkActivity.this, StateActivity.class));
                    }
                });
                break;
        }
    }

    @OnClick(R.id.add_icon)
    public void onClick() {
        mAddIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
