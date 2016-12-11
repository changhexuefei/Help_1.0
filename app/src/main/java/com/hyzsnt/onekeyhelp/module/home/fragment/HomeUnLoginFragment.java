package com.hyzsnt.onekeyhelp.module.home.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeUnLoginFragment extends BaseFragment {


	@BindView(R.id.home_image_location)
	ImageView homeImageLocation;
	@BindView(R.id.home_tv_title)
	TextView homeTvTitle;
	@BindView(R.id.homeimage_search)
	ImageView homeimageSearch;
	@BindView(R.id.home_ll_title)
	LinearLayout homeLlTitle;
	@BindView(R.id.home_lrv)
	RecyclerView homeLrv;

	public HomeUnLoginFragment() {
		// Required empty public constructor
	}

	@Override
	protected List<String> getParams() {
		return null;
	}

	@Override
	protected void initData(String content) {
		Log.e("+++++++++++", "");
		HomeAdapter mHomeAdapter = new HomeAdapter(getActivity());
		//LRecyclerViewAdapter adapter = new LRecyclerViewAdapter(mHomeAdapter);
		//homeLrv.setAdapter(adapter);
		homeLrv.setLayoutManager(new LinearLayoutManager(getActivity()));
		homeLrv.setAdapter(mHomeAdapter);
		homeLrv.setItemAnimator(new DefaultItemAnimator());
	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_home_un_login;
	}

	@Override
	public String getC() {
		return null;
	}

	@Override
	public String getA() {
		return null;
	}

	@OnClick({R.id.home_image_location, R.id.homeimage_search})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.home_image_location:
				break;
			case R.id.homeimage_search:
				break;
		}
	}

	@Override
	protected void initView(View contentView) {
		super.initView(contentView);
		Log.e("----------", "");


	}
}
