package com.hyzsnt.onekeyhelp.module.user.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class RechargeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.iv_recharge_back)
    ImageView mIvRechargeBack;
    @BindView(R.id.rg_rec_rg1)
    RadioGroup mRgRecRg1;
    @BindView(R.id.rg_rec_rg2)
    RadioGroup mRgRecRg2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recharge;
    }

    @Override
    protected void initData() {
        mRgRecRg1.setOnCheckedChangeListener(this);
        mRgRecRg2.setOnCheckedChangeListener(this);
    }

    @OnClick({R.id.iv_recharge_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_recharge_back:
                finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_rg1_10:
                mRgRecRg2.clearCheck();
                group.check(R.id.rb_rg1_10);
                break;
            case R.id.rb_rg1_20:
                mRgRecRg2.clearCheck();
                group.check(R.id.rb_rg1_20);
                break;
            case R.id.rb_rg1_50:
                mRgRecRg2.clearCheck();
                group.check(R.id.rb_rg1_50);
                break;
            case R.id.rb_rg2_100:
                mRgRecRg1.clearCheck();
                group.check(R.id.rb_rg2_100);
                break;
            case R.id.rb_rg2_500:
                mRgRecRg1.clearCheck();
                group.check(R.id.rb_rg2_500);
                break;
            case R.id.rb_rg2_1000:
                mRgRecRg1.clearCheck();
                group.check(R.id.rb_rg2_1000);
                break;
        }
    }
}
