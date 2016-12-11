package com.hyzsnt.onekeyhelp.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;

import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.login.activity.LoginActivity;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import butterknife.BindView;
import cn.jpush.android.api.JPushInterface;


/**
 * Created by Marshon.Chen on 2016/6/1.
 * DESC:
 */
public class SplashActivity extends BaseActivity {
	@BindView(R.id.rl_splash_root)
	RelativeLayout mRlSplashRoot;

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case 1001:
					switchPage();
					break;
			}
		}
	};

	@Override
	protected int getLayoutId() {
		return R.layout.activity_splash;
	}

	@Override
	protected void initData() {
		AlphaAnimation animation = new AlphaAnimation(0, 1);
		animation.setDuration(2000);
		animation.setFillAfter(true);
		mRlSplashRoot.startAnimation(animation);
		handler.sendEmptyMessageDelayed(1001, 2000);
	}

	private void switchPage() {
		if (SPUtils.isLogin(this)) {
			LogUtils.e("已经登录...");
			startActivity(new Intent(this, MainActivity.class));
			finish();
		} else {
			LogUtils.e("没有登录...");
			boolean isStartGuide = (boolean) SPUtils.get(App.getContext(), "isStartGuide", false);
			if (isStartGuide) {
				//				startWithPop(LoginFragment.newInstance());
				startActivity(new Intent(this, LoginActivity.class));
				finish();
				SPUtils.put(App.getContext(), "isStartGuide", true);
			} else {
				//				startWithPop(GuideFragment.newInstance());
				startActivity(new Intent(this, GuideActivity.class));
				finish();
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		JPushInterface.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		JPushInterface.onPause(this);
	}
}
