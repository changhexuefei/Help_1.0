package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class CircleDetailsActivity extends BaseActivity {

	public String isjoin ="";
	private CiecleDetailss mDetailss;
	@BindView(R.id.im_circle_details_back)
	ImageView mImCircleDetailsBack;
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
				if(JsonUtils.isSuccess(response)){

					Gson gson =new Gson();
					mDetailss = gson.fromJson(response, CiecleDetailss.class);
					isjoin =mDetailss.getInfo().getIfjoin();

					if(isjoin.equals("1")){

						mDetails = gson.fromJson(response, CircleDetails.class);
					}
					hideFragments();
					FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
					if(isjoin.equals("1")){
						if (mJoinCircleDetailsFragment == null) {

							mJoinCircleDetailsFragment = new JoinCircleDetailsFragment();
							Bundle bundle = new Bundle();
							bundle.putParcelable("details",mDetails);
							mJoinCircleDetailsFragment.setArguments(bundle);
							transaction.add(R.id.frlayout_circle_dietails, mJoinCircleDetailsFragment);
							transaction.show(mJoinCircleDetailsFragment);
						}else{
							transaction.show(mJoinCircleDetailsFragment);
						}

					}else{
						if (mUnjoinCircleDetailsFragment == null) {
							mUnjoinCircleDetailsFragment = new UnjoinCircleDetailsFragment();
							Bundle bundle = new Bundle();
							bundle.putParcelable("details",mDetailss);
							mUnjoinCircleDetailsFragment.setArguments(bundle);
							transaction.add(R.id.frlayout_circle_dietails, mUnjoinCircleDetailsFragment);
							transaction.show(mUnjoinCircleDetailsFragment);
						}else{
							transaction.show(mUnjoinCircleDetailsFragment);
						}

					}

					transaction.commit();

				}
			}

			@Override
			public void inProgress(float progress, long total, int id) {

			}
		});



	}

	@OnClick(R.id.im_circle_details_back)
	public void onClick() {
		finish();
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
}
