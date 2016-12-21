package com.hyzsnt.onekeyhelp.module.stroll.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.stroll.activity.CircleDetailsActivity;
import com.hyzsnt.onekeyhelp.module.stroll.activity.CreateCircleActivity;
import com.hyzsnt.onekeyhelp.module.stroll.activity.SeekCircleActivity;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleFragmentAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.StrollHeaderAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleHotTag;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleRound;
import com.hyzsnt.onekeyhelp.module.stroll.widget.CustomExpandaleListView;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

import static com.hyzsnt.onekeyhelp.utils.JsonUtils.isSuccess;

/**
 * Created by Administrator on 2016/12/9.
 */

public class StrollFragment extends BaseFragment {

	@BindView(R.id.im_create_circle)
	ImageView mImCreateCircle;
	@BindView(R.id.im_stroll_seek)
	ImageView mImStrollSeek;
	@BindView(R.id.re_stroll_header_list)
	RecyclerView mReStrollHeaderList;
	@BindView(R.id.tv_stroll_fragment_round)
	TextView mTvStrollFragmentRound;
	@BindView(R.id.tv_stroll_fragment_me)
	TextView mTvStrollFragmentMe;
	@BindView(R.id.ex_circle_fragment)
	CustomExpandaleListView mExCircleFragment;
	@BindView(R.id.scrollView)
	ScrollView mScrollView;
	//实例化热门圈子类
	CircleHotTag hotTagData = null;
	private StrollHeaderAdapter mAdapter;
	private CircleFragmentAdapter mMCircleFragmentAdapter;
	private CircleRound mRound;

	private String mLat;
	private String mLon;
	private String mIncommunitynum;
	private String mUid;
	private ArrayList<MDate> mUserInfo;


	@Nullable

	@Override
	protected List<String> getParams() {

		return null;
	}

	@Override
	protected void initData(String content) {
		//获取用户信息
		getUserinfo();

		//热门圈子
		HotTags(content);
		//获取周边信息
		CircleRound();
		mScrollView.smoothScrollTo(0,20);

	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_stroll;
	}

	@Override
	public String getC() {
		return Api.CIRCLE;
	}

	@Override
	public String getA() {
		return Api.Circle.CIRCLE_HOTTAG;
	}

	@OnClick({R.id.im_create_circle, R.id.im_stroll_seek, R.id.tv_stroll_fragment_round, R.id.tv_stroll_fragment_me})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.im_create_circle:
				//跳转到创建圈子页面
				mActivity.startActivity(new Intent(mActivity, CreateCircleActivity.class));
				break;
			case R.id.im_stroll_seek:
				//跳转到创建圈子页面
				mActivity.startActivity(new Intent(mActivity, SeekCircleActivity.class));
				break;
			case R.id.tv_stroll_fragment_round:
				mTvStrollFragmentRound.setBackgroundResource(R.drawable.skip_btn_on_bg);
				mTvStrollFragmentMe.setBackgroundResource(R.drawable.skip_btn_nomal_bg);
				CircleRound();
				break;
			case R.id.tv_stroll_fragment_me:

				mTvStrollFragmentRound.setBackgroundResource(R.drawable.skip_btn_nomal_bg);
				mTvStrollFragmentMe.setBackgroundResource(R.drawable.skip_btn_on_bg);
				CircleMe();
				break;
		}
	}

	/**
	 * 添加数据到热门标签
	 */
	public void HotTags(String content) {
		//设置Recycleview横向排布
		LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
		layoutManager.setOrientation(LinearLayout.HORIZONTAL);
		mReStrollHeaderList.setLayoutManager(layoutManager);
		//解析数据
		if (isSuccess(content)) {
			Gson gson = new Gson();
			hotTagData = gson.fromJson(content, CircleHotTag.class);
			mAdapter.setdata(hotTagData.getList());
			mReStrollHeaderList.setAdapter(mAdapter);

		} else {
			String err = JsonUtils.getErrorMessage(content);
			LogUtils.e(err);
		}
		//设置点击监听

	}

	/**
	 * 获取周边信息
	 */
	public void CircleRound() {
		//参数p
		ArrayList<String> list1 = new ArrayList<>();
		list1.add(mUid);
		list1.add(mLat);
		list1.add(mLon);
		list1.add("");
		list1.add("");
		//网络请求
		HttpUtils.post(Api.CIRCLE, Api.Circle.ROUNDLIST, list1, new ResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {

			}

			@Override
			public void onSuccess(String response, int id) {

				LogUtils.e("圈子"+response);

				getdata(response);

			}

			@Override
			public void inProgress(float progress, long total, int id) {

			}
		});
	}

	/**
	 * 获取已加入圈子信息
	 */
	public void CircleMe() {
		//参数p
		ArrayList<String> list1 = new ArrayList<>();
		list1.add(mUid);
		list1.add(mLat);
		list1.add(mLon);
		//请求数据
		HttpUtils.post(Api.CIRCLE, Api.Circle.MELIST, list1, new ResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {

			}

			@Override
			public void onSuccess(String response, int id) {

                LogUtils.e("我的"+response);
				getdata(response);


			}

			@Override
			public void inProgress(float progress, long total, int id) {

			}
		});
	}

	/**
	 * 解析json数据
	 */
	public void getdata(String response) {
		//解析数据
		if (JsonUtils.isSuccess(response)) {
			try {
				//获取圈子对象
				JSONObject circleround = new JSONObject(response);
				//或去信息
				JSONObject info = (JSONObject) circleround.get("info");
				//获取圈子数
				int circlenum = info.getInt("circlenum");
				//获取小区数
				int communitynum = info.getInt("communitynum");
				//判断小区数和圈子数是否为空
				if (circlenum > 0) {
					//解析全部的数据
					Gson gson = new Gson();
					mRound = gson.fromJson(response, CircleRound.class);
					mMCircleFragmentAdapter.setdata(mRound.getList());
					mExCircleFragment.setAdapter(mMCircleFragmentAdapter);
					//设置将ExpandableListView以展开的方式呈现
					for (int i = 0; i < mMCircleFragmentAdapter.getGroupCount(); i++) {
						mExCircleFragment.expandGroup(i);
					}
				} else {
					ToastUtils.showShort(mActivity, "暂时没有圈子");
					mRound.getList().clear();
					mMCircleFragmentAdapter.notifyDataSetChanged();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}


		} else {
			LogUtils.e("圈子列表请求数据失败");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO: inflate a fragment view
		View rootView = super.onCreateView(inflater, container, savedInstanceState);
		ButterKnife.bind(this, rootView);
		return rootView;
	}

	@Override
	protected void initView(View contentView) {
		super.initView(contentView);
		//添加适配器到Recycleview
		mAdapter = new StrollHeaderAdapter(mActivity);

		mAdapter.setOnItemClickListener(new StrollHeaderAdapter.OnRecyclerViewItemClickListener() {
			@Override
			public void onItemClick(View view, int data) {
				Intent intent = new Intent(mActivity, SeekCircleActivity.class);
				intent.putExtra("tag", hotTagData.getList().get(data).getTagname());
				startActivity(intent);
			}
		});
		//添加适配器
		mMCircleFragmentAdapter = new CircleFragmentAdapter(mActivity);

		//设置group不能点击收缩
		mExCircleFragment.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				return true;
			}
		});
		//子条目点击跳转
		mExCircleFragment.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				Intent intent = new Intent(mActivity, CircleDetailsActivity.class);
				intent.putExtra("ccid", mRound.getList().get(groupPosition).getCircle().get(childPosition).getCcid());
				startActivity(intent);
				return false;
			}
		});
	}

	/**
	 * 获取用户信息
	 */

	public void getUserinfo(){
		String userDetail = (String) SPUtils.get(mActivity, "userDetail", "");
		//解析用户信息
		mUserInfo = Resovle.getUserInfo(userDetail);
		//获取已加入的小区数
		mIncommunitynum = mUserInfo.get(0).getmInfo().getUserInfoInfo().getIncommunitynum();
		//获取用户id
		mUid = mUserInfo.get(0).getmInfo().getUserInfoInfo().getUid();
		//获取经度
		mLat = String.valueOf(App.getLocation().getLatitude());
		//获取维度
		mLon = String.valueOf(App.getLocation().getLongitude());
	}
}
