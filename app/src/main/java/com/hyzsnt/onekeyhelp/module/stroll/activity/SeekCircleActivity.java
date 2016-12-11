package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleTypeAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeekCircleActivity extends BaseActivity {


	@BindView(R.id.search_seek_cricle)
	SearchView mSearchSeekCricle;
	@BindView(R.id.re_seek_circle)
	RecyclerView mReSeekCircle;
	@BindView(R.id.im_search_back)
	ImageView mImSearchBack;
	private ArrayList<CircleType> mtypelist;
	@Override
	protected int getLayoutId() {
		return R.layout.activity_seek_circle;
	}

	@Override
	protected void initData() {
		mtypelist = new ArrayList<CircleType>();
		mtypelist.add(new CircleType("美食",R.mipmap.circle_foods,R.drawable.circle_type_one));
		mtypelist.add(new CircleType("亲自",R.mipmap.circle_by_oneself,R.drawable.circle_type_two));
		mtypelist.add(new CircleType("健身",R.mipmap.circle_fitness,R.drawable.circle_type_three));
		mtypelist.add(new CircleType("聚会",R.mipmap.circle_meeting,R.drawable.circle_type_four));
		mtypelist.add(new CircleType("运动",R.mipmap.circle_sport,R.drawable.circle_type_five));
		mtypelist.add(new CircleType("音乐",R.mipmap.circle_music,R.drawable.circle_type_six));
		mtypelist.add(new CircleType("互助",R.mipmap.circle_help,R.drawable.circle_type_seven));
		mtypelist.add(new CircleType("宠物",R.mipmap.circle_peg,R.drawable.circle_type_eight));
		mtypelist.add(new CircleType("旅行",R.mipmap.circle_travel,R.drawable.circle_type_nine));
		mReSeekCircle.setLayoutManager(new GridLayoutManager(this,3));
		mReSeekCircle.setAdapter(new CircleTypeAdapter(this,mtypelist));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO: add setContentView(...) invocation
		ButterKnife.bind(this);
	}

	@OnClick(R.id.im_search_back)
	public void onClick() {
		finish();
	}
}
