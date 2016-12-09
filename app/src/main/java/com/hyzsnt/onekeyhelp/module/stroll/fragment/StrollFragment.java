package com.hyzsnt.onekeyhelp.module.stroll.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.StrollFragmentAadapter;
import com.hyzsnt.onekeyhelp.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/9.
 */

public class StrollFragment extends BaseFragment {
	private Context context;
	@BindView(R.id.im_create_circle)
	ImageView mImCreateCircle;
	@BindView(R.id.im_stroll_seek)
	ImageView mImStrollSeek;
	@BindView(R.id.re_stroll_list)
	RecyclerView mReStrollList;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		//获取视图
		View view = null;
		//判断网络状态
		if (NetUtils.isConnected(this.mActivity)) {
			view = inflater.inflate(R.layout.fragment_stroll, container, false);
		} else {
			view = inflater.inflate(R.layout.loading_no_network_view, container, false);
		}
		ButterKnife.bind(this, view);
		return view;
	}

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

		mReStrollList.setLayoutManager(new LinearLayoutManager(context));
		//实例化适配器
		mReStrollList.setAdapter(new StrollFragmentAadapter(context, list));
	}

	@Override
	public int getLayoutId() {
		return 0;
	}

	@Override
	public String c() {
		return null;
	}

	@Override
	public String a() {
		return null;
	}


	@OnClick({R.id.im_create_circle, R.id.im_stroll_seek})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.im_create_circle:

				break;
			case R.id.im_stroll_seek:
				break;
		}
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		this.context = context;

	}
}
