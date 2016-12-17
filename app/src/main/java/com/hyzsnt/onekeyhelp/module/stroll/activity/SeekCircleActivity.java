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
	private ArrayList<CircleType> mtypelist;
	@Override
	protected int getLayoutId() {
		return R.layout.activity_seek_circle;
	}

	@Override
	protected void initData() {
		mtypelist = new ArrayList<CircleType>();
		mtypelist.add(new CircleType("美食",R.mipmap.circle_foods,R.drawable.circle_type_one,false));
		mtypelist.add(new CircleType("亲自",R.mipmap.circle_by_oneself,R.drawable.circle_type_two,false));
		mtypelist.add(new CircleType("健身",R.mipmap.circle_fitness,R.drawable.circle_type_three,false));
		mtypelist.add(new CircleType("聚会",R.mipmap.circle_meeting,R.drawable.circle_type_four,false));
		mtypelist.add(new CircleType("运动",R.mipmap.circle_sport,R.drawable.circle_type_five,false));
		mtypelist.add(new CircleType("音乐",R.mipmap.circle_music,R.drawable.circle_type_six,false));
		mtypelist.add(new CircleType("互助",R.mipmap.circle_help,R.drawable.circle_type_seven,false));
		mtypelist.add(new CircleType("宠物",R.mipmap.circle_peg,R.drawable.circle_type_eight,false));
		mtypelist.add(new CircleType("旅行",R.mipmap.circle_travel,R.drawable.circle_type_nine,false));
		mReSeekCircle.setLayoutManager(new GridLayoutManager(this,3));
		mReSeekCircle.setAdapter(new CircleTypeAdapter(this,mtypelist));
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

			outRect.left = space/2;

		}
	}
}
