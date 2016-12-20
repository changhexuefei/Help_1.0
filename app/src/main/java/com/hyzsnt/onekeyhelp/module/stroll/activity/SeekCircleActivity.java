package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleFragmentAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleTypeAdapter;
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
	@BindView(R.id.ex_seek_circle)
	ExpandableListView mExSeekCircle;
	private ArrayList<CircleType.ListEntry> mtypelist;
	private CircleRound mRound;
	private CircleFragmentAdapter mMCircleFragmentAdapter;
	private DbUtils mDb;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_seek_circle;
	}

	@Override
	protected void initData() {
		initview();
		String tag = getIntent().getStringExtra("tag");
		mDb = new DbUtils(SeekCircleActivity.this);

		//初始化标签数据
		mReSeekCircle.setLayoutManager(new GridLayoutManager(this, 3));
		if (tag != null && !"".equals(tag)) {
			CircleRound(tag, 1);
		} else {
			initTags();
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
		CircleTypeAdapter adapter = new CircleTypeAdapter(this, mtypelist);
		mReSeekCircle.setAdapter(adapter);
		adapter.setOnItemClickListener(new CircleTypeAdapter.OnRecyclerViewItemClickListener() {
			@Override
			public void onItemClick(View view, int data) {
				CircleRound(mtypelist.get(data).getTagname(), 1);
			}
		});
		//设置条目间距
		int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dp_13);
		mReSeekCircle.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
	}

	@OnClick(R.id.im_search_back)
	public void onClick() {
		finish();
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
	 * 获取查询信息
	 */
	public void CircleRound(String tag, int id) {
		mExSeekCircle.setVisibility(View.VISIBLE);
		mReSeekCircle.setVisibility(View.GONE);
		mEtSeekCircle.setText(tag);
		//参数p
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("23");
		list1.add("39.923263");
		list1.add("116.539572");
		if (id == 1) {
			list1.add(mDb.querybyname(tag).getTagid());
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
				LogUtils.e(response);
				getdata(response);
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
					mRound = gson.fromJson(response, CircleRound.class);
					//给适配器添加数据
					mMCircleFragmentAdapter.setdata(mRound.getList());
					mExSeekCircle.setAdapter(mMCircleFragmentAdapter);
					//设置将ExpandableListView以展开的方式呈现
					for (int i = 0; i < mMCircleFragmentAdapter.getGroupCount(); i++) {
						mExSeekCircle.expandGroup(i);
					}

				} else {
					ToastUtils.showShort(SeekCircleActivity.this, "暂时没有圈子");
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

		} else {
			LogUtils.e("圈子列表请求数据失败");
		}
	}
	public void initview(){
		//设置edittext监听
		mEtSeekCircle.setOnEditorActionListener(new TextView.OnEditorActionListener() {

			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

				if (actionId == EditorInfo.IME_ACTION_SEND || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
				{
					CircleRound(v.getText().toString(),0);
					return true;

				}

				return false;

			}

		});
		//添加适配器
		mMCircleFragmentAdapter = new CircleFragmentAdapter(SeekCircleActivity.this);

		//设置group不能点击收缩
		mExSeekCircle.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				return true;
			}
		});
		//子条目点击跳转
		mExSeekCircle.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				Intent intent = new Intent(SeekCircleActivity.this, CircleDetailsActivity.class);
				intent.putExtra("ccid", mRound.getList().get(groupPosition).getCircle().get(childPosition).getCcid());
				startActivity(intent);
				return false;
			}
		});
	}

}
