package com.hyzsnt.onekeyhelp.module.login.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.utils.InPutUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

	@BindView(R.id.et_login_phone)
	EditText phone_edit;
	@BindView(R.id.et_login_pass)
	EditText password_edit;
	@BindView(R.id.btn_login)
	Button login;
	@BindView(R.id.tv_login_reset)
	TextView reset;
	@BindView(R.id.tv_login_register)
	TextView regist;
	private String validcode = "";

	@Override
	protected int getLayoutId() {
		return R.layout.activity_login;
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initListener() {
		super.initListener();
		if (SPUtils.isLogin(App.getContext())) {
			startActivity(new Intent(this, MainActivity.class));
			finish();
		}
		login.setOnClickListener(this);
		reset.setOnClickListener(this);
		regist.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v != null) {
			switch (v.getId()) {
				case R.id.tv_login_reset:// 忘记密码
					startActivity(new Intent(this, ResetPasswordActivity.class));
					//					start(ResetPasswordFragment.newInstance());
					break;
				case R.id.tv_login_register:// 注册
					startActivity(new Intent(this, RegisterActivity.class));
					//					start(RegisterFragment.newInstance());
					break;
				case R.id.btn_login:// 登录
					String user_phone = phone_edit.getText().toString();
					String user_pass = password_edit.getText().toString();
					if ("".equals(user_phone) && user_phone.length() != 11) {
						Toast.makeText(this, "电话号码有误", Toast.LENGTH_SHORT).show();
					} else if (!InPutUtils.isMobilePhone(user_phone)) {
						Toast.makeText(this, "手机号不正确", Toast.LENGTH_SHORT).show();
					} else if ("".equals(user_pass)) {
						Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
					} else if (user_pass.length() >= 16) {
						Toast.makeText(this, "密码不能超过16位", Toast.LENGTH_SHORT).show();
					} else if (user_pass.length() < 6) {
						Toast.makeText(this, "密码不能低于6位", Toast.LENGTH_SHORT).show();
					} else {
						login(user_phone, user_pass);
					}
					break;
				default:
					break;
			}
		}
	}
	
	/**
	 * 登录
	 *
	 * @param user_phone
	 * @param user_pass
	 */
	private void login(String user_phone, String user_pass) {
		startActivity(new Intent(this, MainActivity.class));
		finish();
		SPUtils.put(App.getContext(), "islogin", true);
	}
}
