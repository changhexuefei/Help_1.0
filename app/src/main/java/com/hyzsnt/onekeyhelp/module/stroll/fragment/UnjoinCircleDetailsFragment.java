package com.hyzsnt.onekeyhelp.module.stroll.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2016/12/12.
 */

public class UnjoinCircleDetailsFragment extends BaseFragment {
	@BindView(R.id.im_unjoin_circle_cover)
	ImageView mImUnjoinCircleCover;
	@BindView(R.id.tv_unjion_circle_num)
	TextView mTvUnjionCircleNum;
	@BindView(R.id.im_unjoin_circle_headportraid)
	CircleImageView mImUnjoinCircleHeadportraid;
	@BindView(R.id.im_unjoin_circle_gender)
	ImageView mImUnjoinCirclegender;
	@BindView(R.id.tv_unjion_circle_nikename)
	TextView mTvUnjionCircleNikename;
	@BindView(R.id.tv_unjoin_circle_status)
	TextView mTvUnjoinCircleStatus;
	@BindView(R.id.tv_unjoin_circle_tag1)
	TextView mTvUnjoinCircleTag1;
	@BindView(R.id.im_unjoin_circle_tag1)
	ImageView mImUnjoinCircleTag1;
	@BindView(R.id.llayout_unjoin_circle_tag1)
	LinearLayout mLlayoutUnjoinCircleTag1;
	@BindView(R.id.tv_unjoin_circle_tag2)
	TextView mTvUnjoinCircleTag2;
	@BindView(R.id.im_unjoin_circle_tag2)
	ImageView mImUnjoinCircleTag2;
	@BindView(R.id.llayout_unjoin_circle_tag2)
	LinearLayout mLlayoutUnjoinCircleTag2;
	@BindView(R.id.tv_unjoin_circle_tag3)
	TextView mTvUnjoinCircleTag3;
	@BindView(R.id.im_unjoin_circle_tag3)
	ImageView mImUnjoinCircleTag3;
	@BindView(R.id.llayout_unjoin_circle_tag3)
	LinearLayout mLlayoutUnjoinCircleTag3;
	@BindView(R.id.linearLayout)
	LinearLayout mLinearLayout;
	@BindView(R.id.tv_unjoin_circle_summary)
	TextView mTvUnjoinCircleSummary;
	@BindView(R.id.linearLayout2)
	LinearLayout mLinearLayout2;
	@BindView(R.id.llayout_unjoin_circle_join)
	LinearLayout mLlayoutUnjoinCircleJoin;

	@Override
	protected List<String> getParams() {

		return null;
	}

	@Override
	protected void initData(String content) {

	}

	@Override
	public int getLayoutId() {
		return R.layout.fragement_unjoin_circle_details;
	}

	@Override
	public String getC() {
		return null;
	}

	@Override
	public String getA() {
		return null;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO: inflate a fragment view
		View rootView = super.onCreateView(inflater, container, savedInstanceState);
		ButterKnife.bind(this, rootView);
		return rootView;
	}
}
