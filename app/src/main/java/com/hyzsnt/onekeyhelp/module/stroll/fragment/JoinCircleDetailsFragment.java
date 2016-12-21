package com.hyzsnt.onekeyhelp.module.stroll.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.activity.StateActivity;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.JoinCircleDeatilsAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CiecleDetailss;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleDetails;
import com.hyzsnt.onekeyhelp.module.stroll.bean.JoinSuccess;
import com.hyzsnt.onekeyhelp.module.stroll.bean.Topicinfo;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

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
	private JoinSuccess mJoinSuccess;
	@Override
	protected List<String> getParams() {
       return null;
	}

	@Override
	protected void initData(String content) {

		mReCircleDetails.setLayoutManager(new LinearLayoutManager(mActivity));
		if(mJoinSuccess !=null&&!"".equals(mJoinSuccess)){
			mReCircleDetails.setAdapter(new JoinCircleDeatilsAdapter(mActivity,mJoinSuccess));
			return;
		}
		//根据是否有话题添加不同的适配器
		if(iftotal){
			JoinCircleDeatilsAdapter joinCircleDeatilsAdapter = new JoinCircleDeatilsAdapter(mActivity, mDetails, iftotal);
			mReCircleDetails.setAdapter(joinCircleDeatilsAdapter);
			joinCircleDeatilsAdapter.setOnItemClickListener(new JoinCircleDeatilsAdapter.OnRecyclerViewItemClickListener() {
				@Override
				public void onItemClick(View view, int data) {
					if(data>0){

						String topicinfo = getTopicinfo(mDetails.getList().get(data - 1).getTid(), mDetails.getInfo().getCcid());

					}

				}
			});
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
		mJoinSuccess = bundle.getParcelable("joinsuccess");
		if(mJoinSuccess !=null&&!"".equals(mJoinSuccess)){
			return;
		}
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
	//获取话题详情
	public String getTopicinfo(String tid, String Ccid){
		final String[] result = {""};
		List<String> list = new ArrayList<>();
		list.add(tid);
		list.add(Ccid);
		list.add("23");
		HttpUtils.post(Api.CIRCLE, Api.Circle.GETTOPICINFO, list, new ResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {

			}
			@Override
			public void onSuccess(String response, int id) {
				if(JsonUtils.isSuccess(response)) {
					LogUtils.e(response);
					Intent intent = new Intent(mActivity, StateActivity.class);
					Bundle bundle = new Bundle();
					Gson gson = new Gson();
					Topicinfo topicinfo1 = gson.fromJson(response, Topicinfo.class);
					ArrayList<String> imags = new ArrayList<String>();
					try {
						JSONObject jsonObject = new JSONObject(response);
						JSONArray list = jsonObject.getJSONArray("list");
						if(!"".equals(list)&&list.length()>0){
							for(int i=0;i<list.length();i++){
								imags.add(list.getString(i));
							}
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
					bundle.putParcelable("topicinfo",topicinfo1.getInfo());
					bundle.putStringArrayList("imgs",imags);
					bundle.putString("tag", Api.CIRCLE);
					intent.putExtras(bundle);
					mActivity.startActivity(intent);
					result[0] = response;

				}else {
					LogUtils.e(JsonUtils.getErrorMessage(response));
				}
			}

			@Override
			public void inProgress(float progress, long total, int id) {

			}
		});
		return result[0];
	}
}
