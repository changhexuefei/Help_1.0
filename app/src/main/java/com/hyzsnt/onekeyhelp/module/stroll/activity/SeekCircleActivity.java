package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleTypeAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.SeekCircleadapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleRound;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;
import com.hyzsnt.onekeyhelp.utils.DbUtils;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class SeekCircleActivity extends BaseActivity {


	@BindView(R.id.re_seek_circle)
	RecyclerView mReSeekCircle;
	@BindView(R.id.im_search_back)
	ImageView mImSearchBack;
	@BindView(R.id.et_seek_circle)
	EditText mEtSeekCircle;
	@BindView(R.id.activity_seek_circle)
	LinearLayout mActivitySeekCircle;
	private ArrayList<CircleType.ListEntry> mtypelist;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_seek_circle;
	}

	@Override
	protected void initData() {
		String tag = getIntent().getStringExtra("tag");
		//初始化标签数据
		if (tag != null && !"".equals(tag)) {
			Circlelist("亲子", 1);
			mEtSeekCircle.setText(tag);
			mReSeekCircle.setLayoutManager(new GridLayoutManager(this, 3));
		} else {
			//initTags();
			Circlelist("ce", 0);
			mEtSeekCircle.setText(tag);
			mReSeekCircle.setLayoutManager(new GridLayoutManager(this, 3));
		}

	}

	/**
	 * 展示标签
	 */
	private void initTags() {
		//用于存储带标签状态的集合
		mtypelist = new ArrayList<CircleType.ListEntry>();
		//从数据库中取出数据
		DbUtils dbUtils = new DbUtils(SeekCircleActivity.this);
		ArrayList<CircleType.ListEntry> list = new ArrayList<CircleType.ListEntry>();
		list = dbUtils.queryall();
		for (int i = 0; i < list.size(); i++) {
			mtypelist.add(new CircleType.ListEntry(list.get(i).getTagdesc(), list.get(i).getTagid(), list.get(i).getTagname(), false));
		}
		//设置排布及列数
		mReSeekCircle.setLayoutManager(new GridLayoutManager(this, 3));
		mReSeekCircle.setAdapter(new CircleTypeAdapter(this, mtypelist));
		//设置条目间距
		int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dp_13);
		mReSeekCircle.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
	}

	@OnClick(R.id.im_search_back)
	public void onClick() {
		finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO: add setContentView(...) invocation
		ButterKnife.bind(this);
	}

	public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

		private int space;

		public SpaceItemDecoration(int space) {
			this.space = space;
		}

		@Override
		public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

			outRect.top = space;

			outRect.left = space / 2;

		}
	}

	/**
	 * 获取已加入圈子信息
	 */
	public void Circlelist(String tag, int id) {
		//参数p
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("23");
		list1.add("39.923263");
		list1.add("116.539572");
		if (id == 1) {
			list1.add(tag);
			list1.add("");
		} else {
			list1.add("");
			list1.add(tag);
		}

		//网络请求
		HttpUtils.post(Api.CIRCLE, Api.Circle.ROUNDLIST, list1, new ResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {

			}

			@Override
			public void onSuccess(String response, int id) {
				getdata(response);
				if(JsonUtils.isSuccess(response)){
					LogUtils.e(response);
				}else {
					LogUtils.e("失败"+JsonUtils.getErrorMessage(response));
				}

			}

			@Override
			public void inProgress(float progress, long total, int id) {

			}
		});
	}

	/**
	 * 解析json数据
	 */
	public void getdata(String response) {
		//解析数据
		if (JsonUtils.isSuccess(response)) {
			try {
				//获取圈子对象
				JSONObject circleround = new JSONObject(response);
				//或去信息
				JSONObject info = (JSONObject) circleround.get("info");
				//获取圈子数
				int circlenum = info.getInt("circlenum");
				//获取小区数
				int communitynum = info.getInt("communitynum");
				//判断小区数和圈子数是否为空
				if (circlenum > 0) {
					//解析全部的数据
					Gson gson = new Gson();
					final CircleRound round = gson.fromJson(response, CircleRound.class);
					//添加适配器
					SeekCircleadapter mCircleFragmentAdapter = new SeekCircleadapter(SeekCircleActivity.this,round.getList());

				} else {
					ToastUtils.showShort(SeekCircleActivity.this, "暂时没有圈子");
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}


		} else {

		}
	}

}
