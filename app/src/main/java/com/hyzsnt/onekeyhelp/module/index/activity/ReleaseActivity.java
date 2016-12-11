package com.hyzsnt.onekeyhelp.module.index.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发布页面
 */

public class ReleaseActivity extends BaseActivity {

    @BindView(R.id.btn_cancel)
    Button mBtnCancel;
    @BindView(R.id.iv_talk)
    ImageView mIvTalk;
    @BindView(R.id.iv_unuse_goods)
    ImageView mIvUnuseGoods;
    @BindView(R.id.iv_house_lease)
    ImageView mIvHouseLease;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_release;
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


    @OnClick({R.id.iv_talk, R.id.iv_unuse_goods, R.id.iv_house_lease})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_talk:
                startActivity(new Intent(this, TalkActivity.class));
                break;
            case R.id.iv_unuse_goods:
                break;
            case R.id.iv_house_lease:
                break;
        }
    }
}
