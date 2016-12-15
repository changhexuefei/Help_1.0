package com.hyzsnt.onekeyhelp.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;

import com.baidu.mapapi.SDKInitializer;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.module.help.bean.LocationInfo;
import com.hyzsnt.onekeyhelp.module.release.loader.UILImageLoader;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import cn.finalteam.galleryfinal.BuildConfig;
import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;

/**
 * Created by 14369 on 2016/12/9.
 */

public class App extends Application {
	private static Context mContext;
	private static LocationInfo mLocationInfo;

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
		//初始化极光推送
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);

		ThemeConfig themeConfig = new ThemeConfig.Builder()
				.setTitleBarTextColor(Color.WHITE)
				.build();

		//配置功能
		FunctionConfig functionConfig = new FunctionConfig.Builder()
				.setEnableCamera(true)
				.setEnableEdit(true)
				.setEnableCrop(true)
				.setEnableRotate(true)
				.setCropSquare(true)
				.setEnablePreview(true)
				.build();

		//配置imageloader  import cn.finalteam.galleryfinal.ImageLoader;
		cn.finalteam.galleryfinal.ImageLoader imageloader = new UILImageLoader();

		//核心配置信息
		CoreConfig coreConfig = new CoreConfig.Builder(this, imageloader, themeConfig)
				.setDebug(BuildConfig.DEBUG)
				.setFunctionConfig(functionConfig)
				.build();


		GalleryFinal.init(coreConfig);

		initImageLoader(this);

	}

	/**
	 * 获取全局Context变量
	 *
	 * @return Context
	 */
	public static Context getContext() {
		return mContext;
	}

	/**
	 * 获取全局Location对象
	 *
	 * @return Location
	 */
	public static LocationInfo getLocation() {
		return mLocationInfo;
	}

	/**
	 * 设置Location
	 *
	 * @param locationInfo
	 */
	public static void setLocation(LocationInfo locationInfo) {
		mLocationInfo = locationInfo;
	}
	private void initImageLoader(Context context) {
		// This configuration tuning is custom. You can tune every option, you may tune some of them,
		// or you can create default configuration by
		//  ImageLoaderConfiguration.createDefault(this);
		// method.
		ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
		config.threadPriority(Thread.NORM_PRIORITY - 2);
		config.denyCacheImageMultipleSizesInMemory();
		config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
		config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
		config.tasksProcessingOrder(QueueProcessingType.LIFO);
		config.writeDebugLogs(); // Remove for release app

		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config.build());
	}

}
