package com.hyzsnt.onekeyhelp.module.login.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ResetPasswordActivity extends BaseActivity {

	@BindView(R.id.iv_reset_back)
	ImageView mIvResetBack;
	@BindView(R.id.zhong)
	TextView mZhong;
	@BindView(R.id.rl_reset1)
	RelativeLayout mRlReset1;
	@BindView(R.id.img)
	ImageView mImg;
	@BindView(R.id.et_reset_phone)
	EditText mEtResetPhone;
	@BindView(R.id.re1)
	LinearLayout mRe1;
	@BindView(R.id.img2)
	ImageView mImg2;
	@BindView(R.id.et_reset_new_pass)
	EditText mEtResetNewPass;
	@BindView(R.id.re2)
	LinearLayout mRe2;
	@BindView(R.id.img3)
	ImageView mImg3;
	@BindView(R.id.et_reset_agin_pass)
	EditText mEtResetAginPass;
	@BindView(R.id.re3)
	LinearLayout mRe3;
	@BindView(R.id.img9)
	ImageView mImg9;
	@BindView(R.id.et_reset_code)
	EditText mEtResetCode;
	@BindView(R.id.tv_reset_get_code)
	TextView mTvResetGetCode;
	@BindView(R.id.re4)
	LinearLayout mRe4;
	@BindView(R.id.iv_reset_submit)
	Button mIvResetSubmit;
	@BindView(R.id.tv_reset_service)
	TextView mTvResetService;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_reset_password;
	}

	@Override
	protected void initData() {

	}

	@OnClick({R.id.iv_reset_back, R.id.tv_reset_service, R.id.tv_reset_get_code, R.id.iv_reset_submit})
	public void onClick(View v) {
		if (v != null) {
			switch (v.getId()) {
				case R.id.iv_reset_back:// 返回
					finish();
					break;
				case R.id.tv_reset_service:// 客服
					String service_phone = "400-628-7198";
					Intent intent = new Intent();
					intent.setAction("android.intent.action.CALL");
					intent.addCategory("android.intent.category.DEFAULT");
					intent.setData(Uri.parse("tel:" + service_phone));
					// 开启系统拨号器
					startActivity(intent);
					break;
				case R.id.tv_reset_get_code:// 验证码

					break;
				case R.id.iv_reset_submit:// 提交
					ToastUtils.showShort(this, "重置密码成功");
					finish();
					break;
				default:
					break;
			}
		}
	}
}
