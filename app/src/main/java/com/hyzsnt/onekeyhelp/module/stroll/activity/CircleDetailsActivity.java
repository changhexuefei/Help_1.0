package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.release.activity.TalkActivity;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CiecleDetailss;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleDetails;
import com.hyzsnt.onekeyhelp.module.stroll.bean.JoinSuccess;
import com.hyzsnt.onekeyhelp.module.stroll.fragment.JoinCircleDetailsFragment;
import com.hyzsnt.onekeyhelp.module.stroll.fragment.UnjoinCircleDetailsFragment;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class CircleDetailsActivity extends BaseActivity {

	public String isjoin = "";
	//标题
	@BindView(R.id.tv_circle_details_titile)
	TextView mTvCircleDetailsTitile;
	//返回键
	@BindView(R.id.im_circle_details_back)
	ImageView mImCircleDetailsBack;
	//发布话题按钮
	@BindView(R.id.tv_publish_topic)
	TextView mTvPublishTopic;
	private CiecleDetailss mDetailss;
	@BindView(R.id.frlayout_circle_dietails)
	FrameLayout mFrlayoutCircleDietails;
	//加入圈子的fragment
	private JoinCircleDetailsFragment mJoinCircleDetailsFragment;
	//未加入圈子的fragment
	private UnjoinCircleDetailsFragment mUnjoinCircleDetailsFragment;
	private CircleDetails mDetails;
	private String mCcid;
	private String mIncommunitynum;
	private String mUid;
	private String mCid;
	private ArrayList<MDate> mUserInfo;
	private String mLat;
	private String mLon;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_circle_details;
	}

	@Override
	protected void initData() {
		getUserInfo();

		String response = getIntent().getStringExtra("response");

		if(response!=null&&!"".equals(response)){
			//显示发布话题按钮
			mTvPublishTopic.setVisibility(View.VISIBLE);
			mTvCircleDetailsTitile.setText(getIntent().getStringExtra("title"));
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				if (mJoinCircleDetailsFragment == null) {
					mJoinCircleDetailsFragment = new JoinCircleDetailsFragment();
					Gson gson = new Gson();
					JoinSuccess joinSuccess = gson.fromJson(response, JoinSuccess.class);
					//获取圈子id
					mCcid = String.valueOf(joinSuccess.getInfo().getCcid());
					//通过bundle传递数据
					Bundle bundle = new Bundle();
					bundle.putParcelable("joinsuccess",joinSuccess);
					mJoinCircleDetailsFragment.setArguments(bundle);
					transaction.add(R.id.frlayout_circle_dietails, mJoinCircleDetailsFragment);
					transaction.show(mJoinCircleDetailsFragment);
				} else {
					transaction.show(mJoinCircleDetailsFragment);
				}
			transaction.commit();
			return;
		}
		//获取圈子id
		mCcid = getIntent().getStringExtra("ccid");
		//获取数据
		List<String> list = new ArrayList<>();
		list.add(mUid);
		list.add(mCcid);
		list.add(mLat);
		list.add(mLon);

		HttpUtils.post(Api.CIRCLE, Api.Circle.CIRCLE_DETAILS, list, new ResponseHandler() {

			@Override
			public void onError(Call call, Exception e, int id) {

			}

			@Override
			public void onSuccess(String response, int id) {
				if (JsonUtils.isSuccess(response)) {
					LogUtils.e("数据" + response);
					try {

						//获取圈子详情
						JSONObject circleDetails = new JSONObject(response);
						JSONObject info = circleDetails.getJSONObject("info");
						//设置圈主标题
						mTvCircleDetailsTitile.setText(info.getString("ccname"));
						//获取是否加入圈子
						String ifjoin = info.getString("ifjoin");
						//获取话题集合
						JSONArray totallist = circleDetails.getJSONArray("list");
						//隐藏所有的fragment
						hideFragments();
						FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
						//判断是否加入圈子
						if (ifjoin.equals("1")) {
							//显示发布话题按钮
							mTvPublishTopic.setVisibility(View.VISIBLE);
							//显示话题列表
							if (mJoinCircleDetailsFragment == null) {
								mJoinCircleDetailsFragment = new JoinCircleDetailsFragment();
								//通过bundle传递数据
								Bundle bundle = new Bundle();
								//判断是否有话题
								if ("".equals(totallist)) {
									//没有话题完全解析
									Gson gson = new Gson();
									mDetailss = gson.fromJson(response, CiecleDetailss.class);
									bundle.putParcelable("details", mDetailss);
									bundle.putBoolean("iftotal", false);
								} else {
									//有话题完全解析
									Gson gson = new Gson();
									mDetails = gson.fromJson(response, CircleDetails.class);
									bundle.putParcelable("details", mDetails);
									bundle.putBoolean("iftotal", true);

								}
								mJoinCircleDetailsFragment.setArguments(bundle);
								transaction.add(R.id.frlayout_circle_dietails, mJoinCircleDetailsFragment);
								transaction.show(mJoinCircleDetailsFragment);
							} else {
								transaction.show(mJoinCircleDetailsFragment);
							}

						} else {
							//显示圈子介绍
							if (mUnjoinCircleDetailsFragment == null) {
								mUnjoinCircleDetailsFragment = new UnjoinCircleDetailsFragment();
								//没有话题完全解析
								Gson gson = new Gson();
								mDetailss = gson.fromJson(response, CiecleDetailss.class);
								Bundle bundle = new Bundle();
								LogUtils.e(mDetailss.toString());
								bundle.putParcelable("details", mDetailss);
								mUnjoinCircleDetailsFragment.setArguments(bundle);
								transaction.add(R.id.frlayout_circle_dietails, mUnjoinCircleDetailsFragment);
								transaction.show(mUnjoinCircleDetailsFragment);
							} else {
								transaction.show(mUnjoinCircleDetailsFragment);
							}

						}

						transaction.commit();


					} catch (JSONException e) {
						e.printStackTrace();
					}


				}
			}

			@Override
			public void inProgress(float progress, long total, int id) {

			}
		});


	}


	/**
	 * 隐藏所有fragment
	 */
	private void hideFragments() {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

		if (mUnjoinCircleDetailsFragment != null) {
			transaction.hide(mUnjoinCircleDetailsFragment);
		}
		if (mJoinCircleDetailsFragment != null) {
			transaction.hide(mJoinCircleDetailsFragment);
		}

		transaction.commit();
	}
	@OnClick({R.id.im_circle_details_back, R.id.tv_publish_topic})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.im_circle_details_back:
				finish();
				break;
			case R.id.tv_publish_topic:
				Intent intent = new Intent(CircleDetailsActivity.this, TalkActivity.class);
				intent.putExtra("ccid",mCcid);
				intent.putExtra("tag","发布话题");
				startActivity(intent);
				break;
		}
	}
	public void getUserInfo(){
		String userDetail = (String) SPUtils.get(this, "userDetail", "");
		//解析用户信息
		mUserInfo = Resovle.getUserInfo(userDetail);
		//获取已加入的小区数
		mIncommunitynum = mUserInfo.get(0).getmInfo().getUserInfoInfo().getIncommunitynum();
		//获取用户id
		mUid = mUserInfo.get(0).getmInfo().getUserInfoInfo().getUid();
		mLat = String.valueOf(App.getLocation().getLatitude());
		mLon = String.valueOf(App.getLocation().getLongitude());
	}
}
