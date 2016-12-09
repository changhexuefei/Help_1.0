package com.hyzsnt.onekeyhelp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		List<String> params = new ArrayList<>();
		params.add("param1");
		params.add("param2");
		params.add("param3");
		params.add("param4");
		params.add("param5");
		params.add("param6");
		HttpUtils.post(Api.PUBLIC, Api.Public.TEST, params, new JsonResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {

				LogUtils.e("Error:" + e.getMessage());
				Toast.makeText(MainActivity.this, "连接失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onSuccess(String response, int id) {
				LogUtils.e(response);
				Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
			}
		});
	}
}
