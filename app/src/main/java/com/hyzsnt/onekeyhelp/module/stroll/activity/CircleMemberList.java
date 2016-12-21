package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.MemberHostAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleJoin;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleMember;
import com.hyzsnt.onekeyhelp.utils.LogUtils;

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
	@Override
	protected int getLayoutId() {
		return R.layout.activity_circle_member_list;
	}

	@Override
	protected void initData() {
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
		list.add("23");
		list.add(ccid);
		list.add("39.923263");
		list.add("116.539572");
		list.add("131****7888");
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


	@OnClick(R.id.im_circle_back)
	public void onClick() {
		finish();
	}
}
