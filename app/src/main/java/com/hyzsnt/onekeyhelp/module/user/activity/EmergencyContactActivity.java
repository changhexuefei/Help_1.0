package com.hyzsnt.onekeyhelp.module.user.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.user.adapter.ContactListAdapter;
import com.hyzsnt.onekeyhelp.module.user.bean.ContactInfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EmergencyContactActivity extends BaseActivity {
	
	@BindView(R.id.rl_contact_list)
	LRecyclerView mRlContactList;
	private LRecyclerViewAdapter mLRecyclerViewAdapter;
	private ContactListAdapter mAdapter;
	
	@Override
	protected int getLayoutId() {
		return R.layout.activity_emergency_contact;
	}
	
	@Override
	protected void initData() {
		List<ContactInfoBean> data = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			data.add(new ContactInfoBean("张燕燕", "170****5555", ""));
		}
		mAdapter = new ContactListAdapter(this, data);
		mLRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
		mRlContactList.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.VERTICAL, false));
		mRlContactList.setAdapter(mLRecyclerViewAdapter);
		mRlContactList.setPullRefreshEnabled(false);
	}
	
	@OnClick({R.id.iv_contact_back, R.id.tv_contact_add})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.iv_contact_back:
				finish();
				break;
			case R.id.tv_contact_add:
				Intent intent = new Intent(this, AddContactActivity.class);
				startActivity(intent);
				break;
		}
	}
}
