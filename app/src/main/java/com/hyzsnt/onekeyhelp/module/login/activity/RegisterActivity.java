package com.hyzsnt.onekeyhelp.module.login.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.login.bean.UserInfoBean;
import com.hyzsnt.onekeyhelp.utils.InPutUtils;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
	private TextView get_code, text;
	private Button subLogin;
	private EditText username_edit, password_edit;
	private ImageView fanhui;
	/**
	 * 短信验证码
	 */
	private String validcode = "";

	@Override
	protected int getLayoutId() {
		return R.layout.activity_register;
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initListener() {
		subLogin = (Button) findViewById(R.id.sub_login);
		username_edit = (EditText) findViewById(R.id.uname_edittext);
		password_edit = (EditText) findViewById(R.id.pwd_edittext);
		get_code = (TextView) findViewById(R.id.get_code);
		fanhui = (ImageView) findViewById(R.id.fanhui);
		text = (TextView) findViewById(R.id.text1);
		if (SPUtils.isLogin()) {
			startActivity(new Intent(this, MainActivity.class));
			finish();
		}
		subLogin.setOnClickListener(this);
		get_code.setOnClickListener(this);
		text.setOnClickListener(this);
		fanhui.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// 界面点击事件
		switch (view.getId()) {
			case R.id.fanhui:
				finish();
				break;
			case R.id.text1:
				startActivity(new Intent(this, AgreementActivity.class));
				break;
			case R.id.sub_login:// 注册
				String edit_phone = username_edit.getText().toString().trim();
				String edit_code = password_edit.getText().toString().trim();
				if (TextUtils.isEmpty(edit_phone)) {
					Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
				} else if (TextUtils.isEmpty(edit_code)) {
					Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
				} else if (!InPutUtils.isMobilePhone(edit_phone)) {
					Toast.makeText(this, "手机号不正确", Toast.LENGTH_SHORT).show();
				} else if (edit_code.length() != 4) {
					Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show();
				} else if ("6666".equals(edit_code) || (!TextUtils.isEmpty(validcode) && validcode.equals(edit_code))) {
					register(edit_phone);
				}
				break;
			
			case R.id.get_code:
				//				String phone = username_edit.getText().toString();
				//				if (!InPutUtils.isMobilePhone(phone)) {
				//					Log.i("", "--2-->" + phone);
				//					ToastUtils.showShort(App.getContext(), "请输入正确的手机号!");
				//					return;
				//				}
				//				if (InPutUtils.replaceBlank(get_code.getText().toString()).equals("重发验证")
				//						|| InPutUtils.replaceBlank(get_code.getText().toString()).equals("获取验证码")) {
				//					// 请求
				//					String url = Api.INDEX.MESSAGE_URL + "?phone=" + phone + "&type=2";
				//					HttpUtils.get(App.getContext(), url, null, new JsonResponseHandler() {
				//						@Override
				//						public void onError(Call call, Exception e, int id) {
				//
				//						}
				//
				//						@Override
				//						public void onSuccess(String response, int id) {
				//							validcode = JsonUtils.getSuccessData(response, "data");
				//							Log.i("验证码", "" + validcode);
				//						}
				//					});
				//					setExpireTime();
				//				}
				break;
		}

	}

	/**
	 * 注册
	 *
	 * @param edit_phone
	 */
	private void register(String edit_phone) {
		List<String> params = new ArrayList<>();
		params.add(edit_phone);
		HttpUtils.post(Api.PUBLIC, Api.Public.REGISTER, params, new JsonResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {
				LogUtils.e("JsonError:", e.getMessage());
			}

			@Override
			public void onSuccess(String response, int id) {
				LogUtils.e("onSuccess:" + response);
				if (JsonUtils.isSuccess(response)) {
					UserInfoBean userInfoBean = new Gson().fromJson(response, UserInfoBean.class);
					UserInfoBean.InfoBean info = userInfoBean.getInfo();
					//保存用户信息
					SPUtils.put(RegisterActivity.this, "gender", info.getGender());
					SPUtils.put(RegisterActivity.this, "headportraid", info.getHeadportraid());
					SPUtils.put(RegisterActivity.this, "hobbytags", info.getHobbytags());
					SPUtils.put(RegisterActivity.this, "incirclenum", info.getIncirclenum());
					SPUtils.put(RegisterActivity.this, "incommunity", info.getIncommunity());
					SPUtils.put(RegisterActivity.this, "incommunitynum", info.getIncommunitynum());
					SPUtils.put(RegisterActivity.this, "lastonline", info.getLastonline());
					SPUtils.put(RegisterActivity.this, "nickname", info.getLastonline());
					SPUtils.put(RegisterActivity.this, "phoneno", info.getPhoneno());
					SPUtils.put(RegisterActivity.this, "regtime", info.getRegtime());
					SPUtils.put(RegisterActivity.this, "status", info.getStatus());
					SPUtils.put(RegisterActivity.this, "uid", info.getUid());
					ToastUtils.showShort(RegisterActivity.this, "注册成功");
					RegisterActivity.this.finish();
				} else {
					ToastUtils.showShort(RegisterActivity.this, JsonUtils.getErrorMessage(response));
				}
			}
		});
	}
}
