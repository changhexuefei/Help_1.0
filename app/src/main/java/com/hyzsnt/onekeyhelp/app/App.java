package com.hyzsnt.onekeyhelp.app;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by 14369 on 2016/12/9.
 */

public class App extends Application {
	private static Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
		//初始化OkHttp
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.addInterceptor(new LoggerInterceptor("HttpUtils"))
				.connectTimeout(10000L, TimeUnit.MILLISECONDS)
				.readTimeout(10000L, TimeUnit.MILLISECONDS)
				.build();
		HttpUtils.init(okHttpClient);
		//初始化百度地图
		SDKInitializer.initialize(mContext);
	}

	/**
	 * 获取全局Context变量
	 *
	 * @return Context
	 */
	public static Context getContext() {
		return mContext;
	}
}
