package com.hyzsnt.onekeyhelp.module.stroll.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.stroll.activity.CreateCircleActivity;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.StrollFragmentAadapter;

import java.util.ArrayList;
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
	@BindView(R.id.re_stroll_list)
	RecyclerView mReStrollList;
	@Nullable
	@Override
	protected List<String> getParams() {
		return null;
	}

	@Override
	protected void initData(String content) {
		//演示数据
		ArrayList<String> list = new ArrayList<>();
		list.add("hh1");
		list.add("hh1");
		list.add("hh1");
		list.add("hh1");
		list.add("hh1");
		list.add("hh1");

		mReStrollList.setLayoutManager(new LinearLayoutManager(mActivity));
		//实例化适配器
		mReStrollList.setAdapter(new StrollFragmentAadapter(mActivity, list));
	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_stroll;
	}

	@Override
	public String getC() {
		return null;
	}

	@Override
	public String getA() {
		return null;
	}

	@OnClick({R.id.im_create_circle, R.id.im_stroll_seek})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.im_create_circle:
				//跳转到创建圈子页面
                mActivity.startActivity(new Intent(mActivity, CreateCircleActivity.class));
				break;
			case R.id.im_stroll_seek:
				break;
		}
	}

}
