package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.stroll.fragment.JoinCircleDetailsFragment;
import com.hyzsnt.onekeyhelp.module.stroll.fragment.UnjoinCircleDetailsFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class CircleDetailsActivity extends BaseActivity {

	public boolean isjoin =true;
	@BindView(R.id.im_circle_details_back)
	ImageView mImCircleDetailsBack;
	@BindView(R.id.frlayout_circle_dietails)
	FrameLayout mFrlayoutCircleDietails;
	private JoinCircleDetailsFragment mJoinCircleDetailsFragment;
	private UnjoinCircleDetailsFragment mUnjoinCircleDetailsFragment;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_circle_details;
	}

	@Override
	protected void initData() {
		hideFragments();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		if(isjoin){
			if (mJoinCircleDetailsFragment == null) {
				mJoinCircleDetailsFragment = new JoinCircleDetailsFragment();
				transaction.add(R.id.frlayout_circle_dietails, mJoinCircleDetailsFragment);
				transaction.show(mJoinCircleDetailsFragment);
			}else{
				transaction.show(mJoinCircleDetailsFragment);
			}
			isjoin = false;

		}else{
			if (mUnjoinCircleDetailsFragment == null) {
				mUnjoinCircleDetailsFragment = new UnjoinCircleDetailsFragment();
				transaction.add(R.id.frlayout_circle_dietails, mUnjoinCircleDetailsFragment);
				transaction.show(mUnjoinCircleDetailsFragment);
			}else{
				transaction.show(mUnjoinCircleDetailsFragment);
			}
			isjoin =true;
		}

		transaction.commit();
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
