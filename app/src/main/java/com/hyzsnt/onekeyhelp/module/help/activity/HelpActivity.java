package com.hyzsnt.onekeyhelp.module.help.activity;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
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
import com.hyzsnt.onekeyhelp.utils.ScreenUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class HelpActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

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

	@Override
	protected int getLayoutId() {
		return R.layout.activity_help;
	}

	@Override
	protected void initData() {
		tv_help.setVisibility(View.VISIBLE);
		ObjectAnimator upAnima = ObjectAnimator.ofFloat(tv_help, "translationY", ScreenUtils.getScreenHeight(this)-1100, -ScreenUtils.getScreenHeight(this) / 2);
		Log.d("高--------",ScreenUtils.getScreenHeight(this)+"");
		upAnima.setDuration(1200).start();
		float translationY = btn_cancel.getTranslationY();
		ObjectAnimator downAnima = ObjectAnimator.ofFloat(btn_cancel, "translationY",-100, -translationY);
		downAnima.setDuration(1200).start();
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

}

