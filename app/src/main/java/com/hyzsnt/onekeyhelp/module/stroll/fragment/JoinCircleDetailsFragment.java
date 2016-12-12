package com.hyzsnt.onekeyhelp.module.stroll.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.JoinCircleDeatilsAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/12.
 */

public class JoinCircleDetailsFragment extends BaseFragment {
	@BindView(R.id.re_circle_details)
	RecyclerView mReCircleDetails;

	@Override
	protected List<String> getParams() {
		return null;
	}

	@Override
	protected void initData(String content) {
    mReCircleDetails.setLayoutManager(new LinearLayoutManager(mActivity));

		mReCircleDetails.setAdapter(new JoinCircleDeatilsAdapter(mActivity,null));
	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_join_circle_details;
	}

	@Override
	public String getC() {
		return null;
	}

	@Override
	public String getA() {
		return null;
	}


}
