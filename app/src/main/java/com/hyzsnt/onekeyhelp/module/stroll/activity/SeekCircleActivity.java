package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleTypeAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;
import com.hyzsnt.onekeyhelp.utils.DbUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class SeekCircleActivity extends BaseActivity {


	@BindView(R.id.search_seek_cricle)
	SearchView mSearchSeekCricle;
	@BindView(R.id.re_seek_circle)
	RecyclerView mReSeekCircle;
	@BindView(R.id.im_search_back)
	ImageView mImSearchBack;
	private ArrayList<CircleType.ListEntry> mtypelist;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_seek_circle;
	}

	@Override
	protected void initData() {
		//初始化标签数据
		initTags();
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
}
