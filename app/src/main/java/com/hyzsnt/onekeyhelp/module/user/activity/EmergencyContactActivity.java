package com.hyzsnt.onekeyhelp.module.user.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.widget.Toast;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.user.adapter.ContactListAdapter;
import com.hyzsnt.onekeyhelp.module.user.bean.ContactInfoBean;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class EmergencyContactActivity extends BaseActivity {
	
	@BindView(R.id.rl_contact_list)
	LRecyclerView mRlContactList;
	private LRecyclerViewAdapter mLRecyclerViewAdapter;
	private ContactListAdapter mAdapter;
	private String mUid;
	private List<ContactInfoBean.ListBean> mList;
	
	@Override
	protected int getLayoutId() {
		return R.layout.activity_emergency_contact;
	}
	
	@Override
	protected void initData() {
		String userDetail = (String) SPUtils.get(this, "userDetail", "");
		ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
		mUid = userInfo.get(0).getmInfo().getUserInfoInfo().getUid();
		List<String> params = new ArrayList<>();
		params.add(mUid);
		HttpUtils.post(Api.USER, Api.User.GETENERGLINKERLIST, params, new JsonResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {
				Toast.makeText(EmergencyContactActivity.this, "网络连接失败！", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onSuccess(String response, int id) {
				LogUtils.e("List_onSuccess:" + response);
				if (JsonUtils.isSuccess(response)) {
					ContactInfoBean contactInfoBean = new Gson().fromJson(response, ContactInfoBean.class);
					mList = contactInfoBean.getList();
					mAdapter = new ContactListAdapter(EmergencyContactActivity.this,mList);
					mLRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
					mRlContactList.setLayoutManager(new LinearLayoutManager(EmergencyContactActivity.this, OrientationHelper.VERTICAL, false));
					mRlContactList.setAdapter(mLRecyclerViewAdapter);
					mRlContactList.setPullRefreshEnabled(false);
				} else {
					Toast.makeText(EmergencyContactActivity.this, "请求错误：" + JsonUtils.getErrorMessage(response), Toast.LENGTH_SHORT).show();
				}
			}
		});

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
