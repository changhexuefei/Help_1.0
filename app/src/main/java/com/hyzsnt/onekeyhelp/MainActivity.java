package com.hyzsnt.onekeyhelp;

import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


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


	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void initData() {

	}
}
