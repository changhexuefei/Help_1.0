package com.hyzsnt.onekeyhelp.module.user.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.user.activity.EmergencyContactActivity;
import com.hyzsnt.onekeyhelp.module.user.activity.MessageActivity;
import com.hyzsnt.onekeyhelp.module.user.activity.OrderActivity;
import com.hyzsnt.onekeyhelp.module.user.activity.WalletActivity;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends BaseFragment {


	@BindView(R.id.iv_user_icon)
	CircleImageView mIvUserIcon;
	@BindView(R.id.tv_user_name)
	TextView mTvUserName;

	public UserFragment() {
	}

	@Override
	protected List<String> getParams() {
		return null;
	}

	@Override
	protected void initData(String content) {

	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_user;
	}

	@Override
	public String getC() {
		return null;
	}

	@Override
	public String getA() {
		return null;
	}

	@OnClick({
			R.id.tv_user_used,
			R.id.tv_user_my_help,
			R.id.tv_user_lease,
			R.id.tv_user_circle,
			R.id.tv_user_purse,
			R.id.tv_user_release,
			R.id.tv_user_help,
			R.id.tv_user_msg,
			R.id.tv_user_contacts,
	})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.tv_user_used:
				ToastUtils.showShort(mActivity, "我的闲置");
				break;
			case R.id.tv_user_my_help:
				ToastUtils.showShort(mActivity, "我的求助");
				break;
			case R.id.tv_user_lease:
				startActivity(new Intent(mActivity, OrderActivity.class));
				break;
			case R.id.tv_user_circle:
				ToastUtils.showShort(mActivity, "我的圈子");
				break;
			case R.id.tv_user_purse:
				Intent intent_wallet = new Intent(mActivity, WalletActivity.class);
				startActivity(intent_wallet);
				break;
			case R.id.tv_user_release:
				ToastUtils.showShort(mActivity, "我的发布");
				break;
			case R.id.tv_user_help:
				ToastUtils.showShort(mActivity, "我的求助");
				break;
			case R.id.tv_user_msg:
				//ToastUtils.showShort(mActivity, "系统消息");
				startActivity(new Intent(mActivity, MessageActivity.class));
				break;
			case R.id.tv_user_contacts:
				Intent intent = new Intent(mActivity, EmergencyContactActivity.class);
				startActivity(intent);
				break;
		}
	}
}
