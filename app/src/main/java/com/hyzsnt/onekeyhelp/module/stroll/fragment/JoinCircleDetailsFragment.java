package com.hyzsnt.onekeyhelp.module.stroll.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.JoinCircleDeatilsAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CiecleDetailss;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleDetails;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/12.
 */

public class JoinCircleDetailsFragment extends BaseFragment {
	@BindView(R.id.re_circle_details)
	RecyclerView mReCircleDetails;
	//有话题
	private CircleDetails mDetails;
	//无话题
	private CiecleDetailss mDetailss;
	//判断是否有话题
	private Boolean iftotal;


	@Override
	protected List<String> getParams() {
       return null;
	}

	@Override
	protected void initData(String content) {
		mReCircleDetails.setLayoutManager(new LinearLayoutManager(mActivity));
		//根据是否有话题添加不同的适配器
		if(iftotal){
			mReCircleDetails.setAdapter(new JoinCircleDeatilsAdapter(mActivity,mDetails,iftotal));
		}else {
			mReCircleDetails.setAdapter(new JoinCircleDeatilsAdapter(mActivity,mDetailss,iftotal));
		}
		int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dp_13);
		mReCircleDetails.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
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

	@Override
	public void getArgs(Bundle bundle) {
		super.getArgs(bundle);
		iftotal = bundle.getBoolean("iftotal");
		if(iftotal){
			mDetails = bundle.getParcelable("details");
		}else{
			mDetailss= bundle.getParcelable("details");
		}

	}
	public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

		private int space;

		public SpaceItemDecoration(int space) {
			this.space = space;
		}

		@Override
		public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {


			outRect.bottom = space;



		}
	}
}
