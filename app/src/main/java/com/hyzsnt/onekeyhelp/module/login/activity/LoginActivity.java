package com.hyzsnt.onekeyhelp.module.login.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.utils.InPutUtils;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.jpush.android.api.JPushInterface;
import okhttp3.Call;

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
		if (SPUtils.isLogin()) {
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
					break;
				case R.id.tv_login_register:// 注册
					startActivity(new Intent(this, RegisterActivity.class));
					break;
				case R.id.btn_login:// 登录
					String user_phone = phone_edit.getText().toString();
					String user_pass = password_edit.getText().toString();
					user_phone="13161117888";
					user_pass="123456";
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
		List<String> params = new ArrayList<>();
		params.add(user_phone);
		params.add("39.923594");
		params.add("116.539995");
		String registrationID = JPushInterface.getRegistrationID(this);
		params.add(registrationID);
		HttpUtils.post(Api.PUBLIC, Api.Public.LOGIN, params, new JsonResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {
				LogUtils.e("onError:" + e.getMessage());
				ToastUtils.showShort(LoginActivity.this, "录登失败，网络异常！");
			}

			@Override
			public void onSuccess(String response, int id) {
				//LogUtils.e("onSuccess:" + response);
				Intent i=new Intent();
				i.putExtra("response",response);
				setResult(200,i);
				finish();
//				if (JsonUtils.isSuccess(response)) {
//					try {
//						JSONObject jsonObject = new JSONObject(response);
//						int res = jsonObject.optInt("res", 0);
//						if (res == 0) {
//							ToastUtils.showShort(LoginActivity.this, "录登失败！");
//						} else if (res == 1) {
//							startActivity(new Intent(LoginActivity.this, MainActivity.class));
//							finish();
//							SPUtils.put(App.getContext(), "islogin", true);
//						} else {
//							ToastUtils.showShort(LoginActivity.this, "未知错误！请重试。");
//						}
//					} catch (JSONException e) {
//						e.printStackTrace();
//						ToastUtils.showShort(LoginActivity.this, "录登失败，系统数据异常！");
//					}
//				} else {
//					ToastUtils.showShort(LoginActivity.this, JsonUtils.getErrorMessage(response));
//				}
			}
		});
	}
}
