package com.hyzsnt.onekeyhelp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by 14369 on 2016/12/9.
 */

public abstract class BaseActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		ButterKnife.bind(this);
		getSupportActionBar().hide();
		initData();
		initListener();
	}

	protected void initListener() {
	}

	protected abstract int getLayoutId();

	protected abstract void initData();
}
