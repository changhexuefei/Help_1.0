package com.hyzsnt.onekeyhelp.module.stroll.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CiecleDetailss;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;
import com.hyzsnt.onekeyhelp.utils.DbUtils;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/12.
 */

public class UnjoinCircleDetailsFragment extends BaseFragment {
	//背景图
	@BindView(R.id.im_unjoin_circle_cover)
	ImageView mImUnjoinCircleCover;
	//加入的成员数
	@BindView(R.id.tv_unjion_circle_num)
	TextView mTvUnjionCircleNum;
	//圈主头像
	@BindView(R.id.im_unjoin_circle_headportraid)
	CircleImageView mImUnjoinCircleHeadportraid;
	//性别
	@BindView(R.id.im_unjoin_circle_gender)
	ImageView mImUnjoinCirclegender;
	//昵称
	@BindView(R.id.tv_unjion_circle_nikename)
	TextView mTvUnjionCircleNikename;
	@BindView(R.id.tv_unjoin_circle_status)
	TextView mTvUnjoinCircleStatus;
	@BindView(R.id.tv_unjoin_circle_tag1)
	TextView mTvUnjoinCircleTag1;
	@BindView(R.id.tv_unjoin_circle_tag2)
	TextView mTvUnjoinCircleTag2;
	@BindView(R.id.tv_unjoin_circle_tag3)
	TextView mTvUnjoinCircleTag3;
	@BindView(R.id.linearLayout)
	LinearLayout mLinearLayout;
	@BindView(R.id.tv_unjoin_circle_summary)
	TextView mTvUnjoinCircleSummary;
	@BindView(R.id.linearLayout2)
	LinearLayout mLinearLayout2;
	@BindView(R.id.llayout_unjoin_circle_join)
	LinearLayout mLlayoutUnjoinCircleJoin;

	private CiecleDetailss mDetailss;
	ArrayList<CircleType.ListEntry> queryall;
	private String mIncommunitynum;
	private String mUid;
	private ArrayList<MDate> mUserInfo;

	@Override
	protected List<String> getParams() {

		return null;
	}

	@Override
	protected void initData(String content) {
		getUserInfo();
		DbUtils db = new DbUtils(mActivity);
		queryall = db.queryall();
		final CiecleDetailss.InfoEntry info = mDetailss.getInfo();
		//设置背景图
		Glide.with(mActivity).load(info.getCccover()).into(mImUnjoinCircleCover);
		mTvUnjionCircleNikename.setText(info.getNickname());
		mTvUnjionCircleNum.setText(info.getCurnum() + "人");
		mTvUnjoinCircleSummary.setText(info.getSummary());
		Glide.with(mActivity).load(info.getHeadportraid()).into(mImUnjoinCircleHeadportraid);
		String flags = info.getTags();
		String[] flist = flags.split("\\|");
		if (flist.length == 3) {
			CircleType.ListEntry query = null;
			for (int j = 0; j < queryall.size(); j++) {
				if (queryall.get(j).getTagid().equals(flist[2])) {
					query = queryall.get(j);
				}
			}
			mTvUnjoinCircleTag3.setText(query.getTagname());
			GradientDrawable myGrad = (GradientDrawable) mTvUnjoinCircleTag3.getBackground();
			myGrad.setColor(Color.parseColor(query.getTagdesc()));
			mTvUnjoinCircleTag3.setVisibility(View.VISIBLE);
		}
		if (flist.length >= 2) {
			CircleType.ListEntry query = null;
			for (int j = 0; j < queryall.size(); j++) {
				if (queryall.get(j).getTagid().equals(flist[1])) {
					query = queryall.get(j);
				}
			}
			mTvUnjoinCircleTag2.setText(query.getTagname());
			GradientDrawable myGrad = (GradientDrawable) mTvUnjoinCircleTag2.getBackground();
			myGrad.setColor(Color.parseColor(query.getTagdesc()));
			mTvUnjoinCircleTag2.setVisibility(View.VISIBLE);
		}
		if (flist.length >= 1) {
			CircleType.ListEntry query = null;
			for (int j = 0; j < queryall.size(); j++) {
				if (queryall.get(j).getTagid().equals(flist[0])) {
					query = queryall.get(j);
				}
			}
			mTvUnjoinCircleTag1.setText(query.getTagname());
			GradientDrawable myGrad = (GradientDrawable) mTvUnjoinCircleTag1.getBackground();

			myGrad.setColor(Color.parseColor(query.getTagdesc()));
			mTvUnjoinCircleTag1.setVisibility(View.VISIBLE);
		}
		if (info.getGender().equals("1")) {
			mImUnjoinCirclegender.setImageResource(R.mipmap.man);
		}
		/*mTvUnjionCircleNum.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mActivity, CircleMemberList.class);
				intent.putExtra("ishost", false);
				intent.putExtra("ccid", info.getCcid());
				startActivity(intent);
			}
		});*/
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

	@Override
	public void getArgs(Bundle bundle) {
		super.getArgs(bundle);
		mDetailss = bundle.getParcelable("details");

	}

	@OnClick(R.id.llayout_unjoin_circle_join)
	public void onClick() {
		ArrayList<String> list = new ArrayList<>();
		list.add(mUid);
		list.add(mDetailss.getInfo().getCcid());
		HttpUtils.post(Api.CIRCLE, Api.Circle.APPLYJOINCIRCLE, list, new ResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {

			}

			@Override
			public void onSuccess(String response, int id) {
				LogUtils.e(response);
				if (JsonUtils.isSuccess(response)) {
					try {
						JSONObject obj = new JSONObject(response);
						ToastUtils.showShort(mActivity, obj.getString("restr"));

					} catch (JSONException e) {
						e.printStackTrace();
					} finally {
						mActivity.finish();
					}

				} else {
					ToastUtils.showShort(mActivity, JsonUtils.getErrorMessage(response));
					Intent intent = new Intent(mActivity, MainActivity.class);
					App.code = 1;
					startActivity(intent);
				}
			}

			@Override
			public void inProgress(float progress, long total, int id) {

			}
		});
	}

	//获取用户信息以及小区的经纬度
	public void getUserInfo() {
		String userDetail = (String) SPUtils.get(mActivity, "userDetail", "");
		//解析用户信息
		mUserInfo = Resovle.getUserInfo(userDetail);
		//获取已加入的小区数
		mIncommunitynum = mUserInfo.get(0).getmInfo().getUserInfoInfo().getIncommunitynum();
		//获取用户id
		mUid = mUserInfo.get(0).getmInfo().getUserInfoInfo().getUid();
	}
}
