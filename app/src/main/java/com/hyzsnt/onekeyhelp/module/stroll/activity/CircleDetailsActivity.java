package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CiecleDetailss;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleDetails;
import com.hyzsnt.onekeyhelp.module.stroll.fragment.JoinCircleDetailsFragment;
import com.hyzsnt.onekeyhelp.module.stroll.fragment.UnjoinCircleDetailsFragment;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class CircleDetailsActivity extends BaseActivity {

	public String isjoin = "";
	@BindView(R.id.tv_circle_details_titile)
	TextView mTvCircleDetailsTitile;
	@BindView(R.id.im_circle_details_back)
	ImageView mImCircleDetailsBack;
	@BindView(R.id.tv_publish_topic)
	TextView mTvPublishTopic;

	private CiecleDetailss mDetailss;

	@BindView(R.id.frlayout_circle_dietails)
	FrameLayout mFrlayoutCircleDietails;
	private JoinCircleDetailsFragment mJoinCircleDetailsFragment;
	private UnjoinCircleDetailsFragment mUnjoinCircleDetailsFragment;
	private CircleDetails mDetails;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_circle_details;
	}

	@Override
	protected void initData() {
		//获取圈子id
		String ccid = getIntent().getStringExtra("ccid");
		//获取数据
		List<String> list = new ArrayList<>();
		list.add("23");
		list.add(ccid);
		list.add("39.923263");
		list.add("116.539572");

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO: add setContentView(...) invocation
		ButterKnife.bind(this);
	}


	@OnClick({R.id.im_circle_details_back, R.id.tv_publish_topic})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.im_circle_details_back:
				finish();
				break;
			case R.id.tv_publish_topic:

				break;
		}
	}
}
