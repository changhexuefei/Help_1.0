package com.hyzsnt.onekeyhelp.module.login.activity;

import android.view.View;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

public class AgreementActivity extends BaseActivity {
	private ImageView mImageViewExit;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_agreement;
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initListener() {
		super.initListener();
		mImageViewExit = (ImageView) findViewById(R.id.iv_agreement_zuo);
		mImageViewExit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
