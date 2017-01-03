package com.hyzsnt.onekeyhelp;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.help.activity.HelpActivity;
import com.hyzsnt.onekeyhelp.module.help.bean.HelpBean;
import com.hyzsnt.onekeyhelp.module.help.bean.LocationInfo;
import com.hyzsnt.onekeyhelp.module.help.service.LocationService;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.fragment.HomeLoginFragment;
import com.hyzsnt.onekeyhelp.module.home.fragment.HomeUnLoginFragment;
import com.hyzsnt.onekeyhelp.module.home.inner.IjoinCommunnity;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.index.bean.LocationBean;
import com.hyzsnt.onekeyhelp.module.release.fragment.ReleaseFragment;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;
import com.hyzsnt.onekeyhelp.module.stroll.fragment.StrollFragment;
import com.hyzsnt.onekeyhelp.module.user.fragment.UserFragment;
import com.hyzsnt.onekeyhelp.utils.DbUtils;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import okhttp3.Call;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, BDLocationListener, IjoinCommunnity, Serializable {
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
	private boolean isHome = true;
	private boolean isJoinCommunity = false;

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
	private String mUid;
	private LocalBroadcastManager mBroadcastManager;
	private LocalBroadcastReceiver mReceiver;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void initData() {
		String userDetail = (String) SPUtils.get(this, "userDetail", "");
		ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
		mUid = userInfo.get(0).getmInfo().getUserInfoInfo().getUid();
		initBroadcast();
		if (isHome) {
			checkJoinComunnity();
			isHome = false;
		}
		MainActivityPermissionsDispatcher.initLocationWithCheck(this);
		initLocation();
		SharedPreferences sp = getSharedPreferences("tags", Context.MODE_PRIVATE);
		Boolean isfirst = sp.getBoolean("isfirst", true);
		if (isfirst) {
			//请求标签数据
			HttpUtils.post(Api.PUBLIC, Api.Public.GETCIRCLETAGS, new ResponseHandler() {
				@Override
				public void onError(Call call, Exception e, int id) {

				}

				@Override
				public void onSuccess(String response, int id) {
					if (JsonUtils.isSuccess(response)) {
						Gson gson = new Gson();
						CircleType circleType = gson.fromJson(response, CircleType.class);
						List<CircleType.ListEntry> list = circleType.getList();
						DbUtils db = new DbUtils(MainActivity.this);
						for (int i = 0; i < list.size(); i++) {
							Boolean insert = db.insert(list.get(i));
							LogUtils.e("插入标签数据：" + insert);
						}
					} else {
						LogUtils.e("插入标签数据：失败！");
					}

				}

				@Override
				public void inProgress(float progress, long total, int id) {

				}
			});
			SharedPreferences.Editor edit = sp.edit();
			edit.putBoolean("isfirst", false);
			edit.commit();
		}

	}

	private void initBroadcast() {
		mBroadcastManager = LocalBroadcastManager.getInstance(this);
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("com.hyzsnt.onekeyhelp.SELF_HELPING");
		intentFilter.addAction("com.hyzsnt.onekeyhelp.SURROUND_HELPING");
		mReceiver = new LocalBroadcastReceiver();
		mBroadcastManager.registerReceiver(mReceiver, intentFilter);
	}


	@NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE})
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
				if (isJoinCommunity) {
					if (mHomeLoginFragment == null) {
						mHomeLoginFragment = new HomeLoginFragment();
						transaction.add(R.id.fl_main_content, mHomeLoginFragment);
						transaction.show(mHomeLoginFragment);
					}
					transaction.show(mHomeLoginFragment);
				} else {
					if (mHomeUnLoginFragment == null) {
						mHomeUnLoginFragment = new HomeUnLoginFragment();
						transaction.add(R.id.fl_main_content, mHomeUnLoginFragment);
						transaction.show(mHomeUnLoginFragment);
					}
					transaction.show(mHomeUnLoginFragment);
				}
				//isHome=true;
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
		List<String> params = new ArrayList<>();
		params.add(mUid);
		LogUtils.e("params-id:" + mUid);
		HttpUtils.post(Api.RESCUE, Api.Rescue.SPONSORHELP, params, new JsonResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {
				LogUtils.e("Exception:" + e.getMessage());
			}

			@Override
			public void onSuccess(String response, int id) {
				LogUtils.e(response);
				if (JsonUtils.isSuccess(response)) {
					HelpBean helpBean = new Gson().fromJson(response, HelpBean.class);
					HelpBean.InfoBean helpBeanInfo = helpBean.getInfo();
					Intent intent = new Intent(MainActivity.this, HelpActivity.class);
					intent.putExtra("helpInfo", helpBeanInfo);
					startActivityForResult(intent, START_HELP);
					overridePendingTransition(0, 0);
				} else {
					LogUtils.e("Error:" + JsonUtils.getErrorMessage(response));
				}
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();

		if (App.code == 1) {
			mRgMainBottom.check(R.id.rb_main_home);
			App.code = 0;
			checkJoinComunnity();
		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mBroadcastManager.unregisterReceiver(mReceiver);
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
	public void onReceiveLocation(final BDLocation bdLocation) {
		final LocationInfo location;
		if (App.getLocation() != null) {
			location = App.getLocation();
		} else {
			location = new LocationInfo();
		}
		double latitude = bdLocation.getLatitude();
		double longitude = bdLocation.getLongitude();
		if ((latitude + "").contains("E") || (latitude + "").contains("E")) {
			return;
		}
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		location.setLocType(bdLocation.getLocType());
		location.setTime(bdLocation.getTime());
		location.setAddrStr(bdLocation.getAddrStr());
		List<String> params = new ArrayList<>();
		params.add(mUid);
		params.add(bdLocation.getLatitude() + "");
		params.add(bdLocation.getLongitude() + "");
		params.add(bdLocation.getAddrStr());
		params.add(JPushInterface.getRegistrationID(this));
		HttpUtils.post(Api.PUBLIC, Api.Public.SUBMITCOORDINATE, params, new JsonResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {
				Toast.makeText(MainActivity.this, "网络连接失败！", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onSuccess(String response, int id) {
				LogUtils.e("List_onSuccess:" + response);
				if (JsonUtils.isSuccess(response)) {
					Log.e("TAG", "上报位置成功！");
					LocationBean bean = new Gson().fromJson(response, LocationBean.class);
					location.setRegid(bean.getInfo().getRegid());
					location.setRegname(bean.getInfo().getRegname());
					if (bean.getInfo().getSelfemerg() > 0) {
						Intent intent = new Intent("com.hyzsnt.onekeyhelp.SELF_HELPING");
						intent.putExtra("selfemerg", bean.getInfo().getSelfemerg());
						mBroadcastManager.sendBroadcast(intent);
					}
					Intent intent = new Intent("com.hyzsnt.onekeyhelp.SURROUND_HELPING");
					intent.putExtra("surroundingemerg", bean.getInfo().getSurroundingemerg());
					mBroadcastManager.sendBroadcast(intent);
				} else {
					Toast.makeText(MainActivity.this, "请求错误：" + JsonUtils.getErrorMessage(response), Toast.LENGTH_SHORT).show();
				}
			}
		});
		App.setLocation(location);
		mHomeUnLoginFragment.setTitle(location.getAddrStr());
	}

	/**
	 * 查询用户信息，核对是否加入小区
	 */
	@Override
	public void checkJoinComunnity() {
		String userDetail = (String) SPUtils.get(this, "userDetail", "");
		ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
		String uid = userInfo.get(0).getmInfo().getUserInfoInfo().getUid();
		List<String> params = new ArrayList();
		params.add(uid);
		HttpUtils.post(Api.USER, Api.User.GETUSERINFO, params, new ResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {
			}

			@Override
			public void onSuccess(String response, int id) {
				SPUtils.put(MainActivity.this, "userDetail", response);
				final ArrayList<MDate> loginCommunities = Resovle.getUserInfo(response);
				String incommunitystr = loginCommunities.get(0).getmInfo().getUserInfoInfo().getIncommunity();
				String incommunitynumstr = loginCommunities.get(0).getmInfo().getUserInfoInfo().getIncommunitynum();
				int incommunitynum = Integer.valueOf(incommunitynumstr);
				//核对是否加入小区
				if (incommunitystr != null && incommunitynum > 0) {
					isJoinCommunity = true;
				} else {
					isJoinCommunity = false;
				}
				hideFragments();
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				if (isJoinCommunity) {
					if (mHomeLoginFragment == null) {
						mHomeLoginFragment = new HomeLoginFragment();
						transaction.add(R.id.fl_main_content, mHomeLoginFragment);
						transaction.show(mHomeLoginFragment);
					}
					transaction.show(mHomeLoginFragment);
				} else {
					if (mHomeUnLoginFragment == null) {
						mHomeUnLoginFragment = new HomeUnLoginFragment();
						transaction.add(R.id.fl_main_content, mHomeUnLoginFragment);
						transaction.show(mHomeUnLoginFragment);
					}
					transaction.show(mHomeUnLoginFragment);
				}
				transaction.commit();
			}

			@Override
			public void inProgress(float progress, long total, int id) {
			}
		});
	}


	class LocalBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			switch (action) {
				case "com.hyzsnt.onekeyhelp.SELF_HELPING":
					Intent helpIntent = new Intent(context, HelpActivity.class);
					helpIntent.putExtra("emid", intent.getIntExtra("selfemerg", 0));
					startActivity(helpIntent);
					overridePendingTransition(0, 0);
					break;
				case "com.hyzsnt.onekeyhelp.SURROUND_HELPING":
					if (mHomeLoginFragment != null) {
						int surroundingemerg = intent.getIntExtra("surroundingemerg", 0);
						mHomeLoginFragment.helpHelp(surroundingemerg);
					}
					break;
			}
		}
	}
}
