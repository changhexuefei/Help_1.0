package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.MemberHostAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleJoin;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleMember;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class CircleMemberList extends BaseActivity {


	@BindView(R.id.re_member_host)
	LRecyclerView mReMemberHost;
	@BindView(R.id.im_circle_back)
	ImageView mImCircleBack;
	private String mIncommunitynum;
	private String mUid;
	private String mCid;
	private ArrayList<MDate> mUserInfo;
	private String mLat;
	private String mLon;
	private String mMnickname;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_circle_member_list;
	}

	@Override
	protected void initData() {
		getUserInfo();
		//获取是否是管理员
		Boolean ishost = getIntent().getBooleanExtra("ishost", true);
		String ccid = getIntent().getStringExtra("ccid");
		//添加适配器
		mReMemberHost.setLayoutManager(new LinearLayoutManager(CircleMemberList.this));
		final MemberHostAdapter adapter = new MemberHostAdapter(CircleMemberList.this,ishost);
		LRecyclerViewAdapter lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
		mReMemberHost.setAdapter(lRecyclerViewAdapter);
		mReMemberHost.setPullRefreshEnabled(false);

		//获取成员数据
		List<String> list = new ArrayList<>();
		list.add(mUid);
		list.add(ccid);
		list.add(mLat);
		list.add(mLon);
		list.add(mMnickname);
		HttpUtils.post(Api.CIRCLE, Api.Circle.CIRCLE_MEMBER, list, new ResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {

			}

			@Override
			public void onSuccess(String response, int id) {
				Gson gson = new Gson();
				CircleMember circleMember = gson.fromJson(response, CircleMember.class);
              if(circleMember.getInfo().getTotalnum()>0){
	              adapter.setCircleMember(circleMember);
              }
				LogUtils.e(response);
			}

			@Override
			public void inProgress(float progress, long total, int id) {

			}
		});
		if(ishost){
			List<String> slist =new ArrayList<>();
			slist.add("23");
			slist.add(ccid);
			HttpUtils.post(Api.CIRCLE, Api.Circle.CIRCLE_join, slist, new ResponseHandler() {
				@Override
				public void onError(Call call, Exception e, int id) {

				}

				@Override
				public void onSuccess(String response, int id) {

					Gson gson = new Gson();
					CircleJoin circleJoin = gson.fromJson(response, CircleJoin.class);
					adapter.setCirclejoin(circleJoin);
				}

				@Override
				public void inProgress(float progress, long total, int id) {

				}
			});
		}



	}
	public void getUserInfo(){
		String userDetail = (String) SPUtils.get(this, "userDetail", "");
		//解析用户信息
		mUserInfo = Resovle.getUserInfo(userDetail);
		//获取已加入的小区数
		mIncommunitynum = mUserInfo.get(0).getmInfo().getUserInfoInfo().getIncommunitynum();
		mMnickname = mUserInfo.get(0).getmInfo().getUserInfoInfo().getNickname();
		//获取用户id
		mUid = mUserInfo.get(0).getmInfo().getUserInfoInfo().getUid();
		mLat = String.valueOf(App.getLocation().getLatitude());
		mLon = String.valueOf(App.getLocation().getLongitude());
	}

	@OnClick(R.id.im_circle_back)
	public void onClick() {
		finish();
	}
}
