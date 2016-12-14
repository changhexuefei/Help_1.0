package com.hyzsnt.onekeyhelp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.help.activity.HelpActivity;
import com.hyzsnt.onekeyhelp.module.help.bean.LocationInfo;
import com.hyzsnt.onekeyhelp.module.help.service.LocationService;
import com.hyzsnt.onekeyhelp.module.home.fragment.HomeLoginFragment;
import com.hyzsnt.onekeyhelp.module.home.fragment.HomeUnLoginFragment;
import com.hyzsnt.onekeyhelp.module.release.fragment.ReleaseFragment;
import com.hyzsnt.onekeyhelp.module.stroll.fragment.StrollFragment;
import com.hyzsnt.onekeyhelp.module.user.fragment.UserFragment;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
@RuntimePermissions
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, BDLocationListener {


	public static final int START_HELP = 1;
	@BindView(R.id.rb_main_home)
	RadioButton mRbMainHome;
	@BindView(R.id.rb_main_stroll)
	RadioButton mRbMainStroll;
	@BindView(R.id.rb_main_release)
	RadioButton mRbMainRelease;
	@BindView(R.id.rb_main_user)
	RadioButton mRbMainUser;
	@BindView(R.id.rg_main_bottom)
	RadioGroup mRgMainBottom;
	@BindView(R.id.fl_main_content)
	FrameLayout mFlMainContent;
	@BindView(R.id.btn_sos)
	Button mBtnSos;

	private boolean isLogin = true;

	/**
	 * 首页
	 */
	private HomeLoginFragment mHomeLoginFragment;//登陆状态
	private HomeUnLoginFragment mHomeUnLoginFragment;//未登录状态
	/**
	 * 闲逛
	 */
	private StrollFragment mStrollFragment;
	/**
	 * 发布
	 */
	private ReleaseFragment mReleaseFragment;
	/**
	 * 我的
	 */
	private UserFragment mUserFragment;
	private LocationService mLocationService;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void initData() {
		MainActivityPermissionsDispatcher.initLocationWithCheck(this);
		initLocation();
	}

	@NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,})
	public void initLocation() {
		mLocationService = new LocationService(this);
		mLocationService.registerListener(this);
	}

	@OnShowRationale({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,})
	public void showRationaleForLocation(final PermissionRequest request) {
		new AlertDialog.Builder(this)
				.setMessage("一键帮助需要定位权限，否则将无法正常运行！")//(dialog, button) -> request.proceed()
				.setPositiveButton("允许", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						request.proceed();
					}
				})
				.setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						request.cancel();
					}
				})
				.show();
	}

	@OnPermissionDenied({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,})
	public void showDeniedForLocation() {
		ToastUtils.showShort(this, "您已经拒绝一键帮助获取定位权限，部分功能将无法正常使用！");
	}

	@OnNeverAskAgain({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,})
	public void showNeverAskForLocation() {
		ToastUtils.showShort(this, "您已经拒绝一键帮助获取定位权限，部分功能将无法正常使用！");
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
	}

	@Override
	protected void onStart() {
		super.onStart();
		mLocationService.start();
	}

	@Override
	protected void onStop() {
		super.onStop();
		mLocationService.stop();
	}

	@Override
	protected void initListener() {
		super.initListener();
		/**
		 * 首页
		 */
		mRgMainBottom.setOnCheckedChangeListener(this);
		mRgMainBottom.check(R.id.rb_main_home);
	}

	@Override
	public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
		hideFragments();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		switch (checkedId) {
			case R.id.rb_main_home:

				if (isLogin) {
					if (mHomeLoginFragment == null) {
						mHomeLoginFragment = new HomeLoginFragment();
						transaction.add(R.id.fl_main_content, mHomeLoginFragment);
						transaction.show(mHomeLoginFragment);
					}
					transaction.show(mHomeLoginFragment);
					isLogin = false;
				} else {
					if (mHomeUnLoginFragment == null) {
						mHomeUnLoginFragment = new HomeUnLoginFragment();
						transaction.add(R.id.fl_main_content, mHomeUnLoginFragment);
						transaction.show(mHomeUnLoginFragment);
					}
					transaction.show(mHomeUnLoginFragment);
					isLogin = true;
				}
				break;
			case R.id.rb_main_stroll:
				if (mStrollFragment == null) {
					mStrollFragment = new StrollFragment();
					transaction.add(R.id.fl_main_content, mStrollFragment);
					transaction.show(mStrollFragment);
				}
				transaction.show(mStrollFragment);
				break;
			case R.id.rb_main_release:
				if (mReleaseFragment == null) {
					mReleaseFragment = new ReleaseFragment();
					transaction.add(R.id.fl_main_content, mReleaseFragment);
					transaction.show(mReleaseFragment);
				}
				transaction.show(mReleaseFragment);
				break;
			case R.id.rb_main_user:
				if (mUserFragment == null) {
					mUserFragment = new UserFragment();
					transaction.add(R.id.fl_main_content, mUserFragment);
					transaction.show(mUserFragment);
				}
				transaction.show(mUserFragment);
				break;
		}
		transaction.commit();


	}

	/**
	 * 隐藏所有fragment
	 */
	private void hideFragments() {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

		if (mHomeLoginFragment != null) {
			transaction.hide(mHomeLoginFragment);
		}
		if (mHomeUnLoginFragment != null) {
			transaction.hide(mHomeUnLoginFragment);
		}
		if (mReleaseFragment != null) {
			transaction.hide(mReleaseFragment);
		}
		if (mUserFragment != null) {
			transaction.hide(mUserFragment);
		}
		if (mStrollFragment != null) {
			transaction.hide(mStrollFragment);
		}
		transaction.commit();
	}

	/**
	 * 开始求救
	 *
	 * @param view
	 */
	@OnClick(R.id.btn_sos)
	public void startHelp(View view) {
		Intent intent = new Intent(this, HelpActivity.class);
		startActivityForResult(intent, START_HELP);
		overridePendingTransition(0, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == MainActivity.START_HELP && resultCode == RESULT_OK) {
			String inx = data.getStringExtra("data");
			int i = R.id.rb_main_home;
			switch (inx) {
				case "1":
					i = R.id.rb_main_home;
					break;
				case "2":
					i = R.id.rb_main_stroll;
					break;
				case "3":
					i = R.id.rb_main_release;
					break;
				case "4":
					i = R.id.rb_main_user;
					break;
			}
			mRgMainBottom.check(i);
		}
	}

	@Override
	public void onReceiveLocation(BDLocation bdLocation) {
		LocationInfo location;
		if (App.getLocation() != null) {
			location = App.getLocation();

		} else {
			location = new LocationInfo();
		}
		location.setLatitude(bdLocation.getLatitude());
		location.setLongitude(bdLocation.getLongitude());
		location.setLocType(bdLocation.getLocType());
		location.setTime(bdLocation.getTime());
		location.setAddrStr(bdLocation.getAddrStr());
		App.setLocation(location);
	}
}
