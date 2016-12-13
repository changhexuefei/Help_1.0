package com.hyzsnt.onekeyhelp.module.home.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeUnLoginAdapter;
import com.hyzsnt.onekeyhelp.module.index.activity.SeekeStateActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

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
		List params=new ArrayList<String>();
		params.add(1+"");
		params.add(21+"");
		params.add(1+"");
		params.add("兴隆区");
		String str=HttpUtils.post(Api.COMMUNITY, Api.Community.GETCOMMUNITYLIST, params,new ResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {
				Log.e("+++++++++++","失败"+call+"----"+e+"@@@@@"+id);
			}

			@Override
			public void onSuccess(String response, int id) {
				Log.e("+++++++++++",response+"米西米西"+id);
			}

			@Override
			public void inProgress(float progress, long total, int id) {
				Log.e("+++++++++++",progress+"过程中"+total+"很爱很爱"+id);
			}
		});
		Log.e("+++++++++++",str);
		HomeUnLoginAdapter mHomeAdapter = new HomeUnLoginAdapter(getActivity());
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
				Intent i=new Intent(getActivity(), SeekeStateActivity.class);
				startActivity(i);
				break;
		}
	}

	@Override
	protected void initView(View contentView) {
		super.initView(contentView);
		Log.e("----------", "");
	}
}
