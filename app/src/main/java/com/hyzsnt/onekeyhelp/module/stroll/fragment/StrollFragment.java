package com.hyzsnt.onekeyhelp.module.stroll.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.module.stroll.activity.CircleDetailsActivity;
import com.hyzsnt.onekeyhelp.module.stroll.activity.CreateCircleActivity;
import com.hyzsnt.onekeyhelp.module.stroll.activity.SeekCircleActivity;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleFragmentAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.StrollHeaderAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleHotTag;
import com.hyzsnt.onekeyhelp.module.stroll.widget.CustomExpandaleListView;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

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
	@BindView(R.id.tv_stroll_gragment_round)
	TextView mTvStrollGragmentRound;
	@BindView(R.id.tv_stroll_fragment_me)
	TextView mTvStrollFragmentMe;
	@BindView(R.id.ex_circle_fragment)
	CustomExpandaleListView mExCircleFragment;


	@Nullable

	@Override
	protected List<String> getParams() {

		return null;
	}

	@Override
	protected void initData(String content) {
		CircleHotTag hotTagData = null;
		LogUtils.e(content);
		//添加数据到热门标签
		//设置Recycleview横向排布
		LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
		layoutManager.setOrientation(LinearLayout.HORIZONTAL);
		mReStrollHeaderList.setLayoutManager(layoutManager);
		//解析数据
        if(JsonUtils.isSuccess(content)){
	        Gson gson = new Gson();
	        hotTagData = gson.fromJson(content, CircleHotTag.class);
	        hotTagData.getList();
	        //添加适配器到Recycleview
	        mReStrollHeaderList.setAdapter(new StrollHeaderAdapter(mActivity,hotTagData.getList()));
        }else{
	        String err = JsonUtils.getErrorMessage(content);
	        LogUtils.e(err);
        }


		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();




		CircleFragmentAdapter mCircleFragmentAdapter = new CircleFragmentAdapter(mActivity, map);
		mExCircleFragment.setAdapter(new CircleFragmentAdapter(mActivity,map));
		for (int i = 0; i < mCircleFragmentAdapter.getGroupCount(); i++)
		{
			mExCircleFragment.expandGroup(i);// 关键步骤3,初始化时，将ExpandableListView以展开的方式呈现
		}
		mExCircleFragment.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				return true;
			}
		});
		mExCircleFragment.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				 startActivity(new Intent(mActivity, CircleDetailsActivity.class));
				return false;
			}
		});

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

	@OnClick({R.id.im_create_circle, R.id.im_stroll_seek})
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
			case R.id.tv_stroll_gragment_round:
				break;
			case R.id.tv_stroll_fragment_me:
				break;
		}
	}


}
