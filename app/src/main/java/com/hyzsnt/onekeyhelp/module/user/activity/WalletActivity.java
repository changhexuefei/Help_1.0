package com.hyzsnt.onekeyhelp.module.user.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class WalletActivity extends BaseActivity {

    @BindView(R.id.tv_wallet_balance)
    TextView mTvWalletBalance;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wallet;
    }

    @Override
    protected void initData() {
        mTvWalletBalance.setText("￥0.00");
    }

    @OnClick({R.id.iv_wallet_back, R.id.tv_wallet_balance_detail, R.id.btn_wallet_pay, R.id.btn_wallet_draw})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_wallet_back:
                finish();
                break;
            case R.id.tv_wallet_balance_detail:
                Toast.makeText(WalletActivity.this, "余额明细", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wallet_pay:
                Intent intent = new Intent(this, RechargeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_wallet_draw:
                Toast.makeText(WalletActivity.this, "提现功能暂未开通！", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
