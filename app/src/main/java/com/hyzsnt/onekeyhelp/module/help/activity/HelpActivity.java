package com.hyzsnt.onekeyhelp.module.help.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.help.fragment.MapHelpFragment;
import com.hyzsnt.onekeyhelp.module.help.fragment.NearbyHelpFragment;
import com.hyzsnt.onekeyhelp.utils.DensityUtils;
import com.hyzsnt.onekeyhelp.utils.ScreenUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class HelpActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, Animator.AnimatorListener {

	private static final int TIME_DOWN = 1;
	@BindView(R.id.rg_help_title)
	RadioGroup rg_help_title;
	@BindView(R.id.fl_help_content)
	FrameLayout fl_help_content;
	@BindView(R.id.rg_help_bottom)
	RadioGroup rg_help_bottom;
	@BindView(R.id.rb_help_home)
	RadioButton rb_help_home;
	@BindView(R.id.rb_help_stroll)
	RadioButton rb_help_stroll;
	@BindView(R.id.rb_help_release)
	RadioButton rb_help_release;
	@BindView(R.id.rb_help_user)
	RadioButton rb_help_user;
	@BindView(R.id.btn_cancel)
	Button btn_cancel;
	@BindView(R.id.tv_help)
	TextView tv_help;

	private MapHelpFragment mMapHelpFragment;
	private NearbyHelpFragment mNearbyHelpFragment;
	private int time = 5;
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case TIME_DOWN:
					if (time == 0) {
						tv_help.setVisibility(View.GONE);
					} else {
						tv_help.setText("" + time);
						time--;
						sendEmptyMessageDelayed(TIME_DOWN, 1000);
					}
					break;
			}
		}
	};

	@Override
	protected int getLayoutId() {
		return R.layout.activity_help;
	}

	@Override
	protected void initData() {
		initAnimator();

	}

	/**
	 * 初始化动画
	 */
	private void initAnimator() {
		tv_help.setVisibility(View.VISIBLE);
		ObjectAnimator upAnima = ObjectAnimator.ofFloat(tv_help, "translationY", -ScreenUtils.getScreenHeight(this) / 2 + DensityUtils.dp2px(this, 8));
		upAnima.setDuration(1000).start();
		int height = btn_cancel.getHeight();
		ObjectAnimator downAnima = ObjectAnimator.ofFloat(btn_cancel, "translationY", height - DensityUtils.dp2px(this, 50));
		downAnima.setDuration(1000).start();
		upAnima.addListener(this);
	}

	@Override
	protected void initListener() {
		super.initListener();
		rg_help_bottom.setOnCheckedChangeListener(this);
		rg_help_title.setOnCheckedChangeListener(this);
		rg_help_title.check(R.id.rb_map);
		rg_help_bottom.clearCheck();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		switch (checkedId) {
			case R.id.rb_map:
				hideFragments();
				if (mMapHelpFragment == null) {
					mMapHelpFragment = new MapHelpFragment();
					transaction.add(R.id.fl_help_content, mMapHelpFragment);
					transaction.show(mMapHelpFragment);
				}
				transaction.show(mMapHelpFragment);
				break;
			case R.id.rb_near:
				hideFragments();
				if (mNearbyHelpFragment == null) {
					mNearbyHelpFragment = new NearbyHelpFragment();
					transaction.add(R.id.fl_help_content, mNearbyHelpFragment);
					transaction.show(mNearbyHelpFragment);
				}
				transaction.show(mNearbyHelpFragment);
				break;
			case R.id.rb_help_home:
				if (rb_help_home.isChecked()) {
					showDialog("1");
				}
				break;
			case R.id.rb_help_stroll:
				if (rb_help_stroll.isChecked()) {
					showDialog("2");
				}
				break;
			case R.id.rb_help_release:
				if (rb_help_release.isChecked()) {
					showDialog("3");
				}
				break;
			case R.id.rb_help_user:
				if (rb_help_user.isChecked()) {
					showDialog("4");
				}
				break;
		}
		transaction.commit();
	}

	/**
	 * 隐藏所有fragment
	 */
	private void hideFragments() {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		if (mMapHelpFragment != null) {
			transaction.hide(mMapHelpFragment);
		}
		if (mNearbyHelpFragment != null) {
			transaction.hide(mNearbyHelpFragment);
		}
		transaction.commit();
	}

	private void showDialog(final String data) {
		final AlertDialog create = new AlertDialog.Builder(this).setTitle("提示").setMessage("请确认您已安全，是否取消求救？")
				.setPositiveButton("我已安全", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (data != null) {
							Intent intent = new Intent();
							intent.putExtra("data", data);
							setResult(RESULT_OK, intent);
						}
						finish();
						overridePendingTransition(0, 0);
					}
				}).setNegativeButton("继续求救", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						rg_help_bottom.clearCheck();
					}
				}).create();
		create.setCancelable(false);
		create.show();
	}

	@OnClick(R.id.btn_cancel)
	public void cancel(View view) {
		showDialog(null);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacksAndMessages(TIME_DOWN);
	}

	@Override
	public void onBackPressed() {
		showDialog(null);
	}

	@Override
	public void onAnimationStart(Animator animation) {

	}

	@Override
	public void onAnimationEnd(Animator animation) {
		tv_help.setText("");
		tv_help.setBackgroundResource(R.drawable.shape_help_red);
		tv_help.setTextSize(DensityUtils.dp2px(this, 12));
		tv_help.setGravity(Gravity.CENTER);
		handler.sendEmptyMessage(TIME_DOWN);
	}

	@Override
	public void onAnimationCancel(Animator animation) {

	}

	@Override
	public void onAnimationRepeat(Animator animation) {

	}
}

