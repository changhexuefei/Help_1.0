package com.hyzsnt.onekeyhelp.module.index.activity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;

/**
 * 发布页面
 */

public class ReleaseActivity extends BaseActivity {


    @BindView(R.id.house_lease)
    Button mHouseLease;
    @BindView(R.id.eave)
    Button mEave;
    @BindView(R.id.casual_comment)
    Button mCasualComment;
    @BindView(R.id.btn_cancel)
    Button mBtnCancel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_release;
    }

    @Override
    protected void initData() {
        //房屋出租按钮
        mHouseLease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ReleaseActivity.this,"view"+view.getId(),Toast.LENGTH_SHORT).show();
            }
        });

        //家中闲置
        mEave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ReleaseActivity.this,"view"+view.getId(),Toast.LENGTH_SHORT).show();

            }
        });
        //随便说说
        mCasualComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ReleaseActivity.this,"view"+view.getId(),Toast.LENGTH_SHORT).show();

            }
        });


        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
