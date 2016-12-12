package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleTypeAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateCircleActivity extends BaseActivity {


	@BindView(R.id.im_circle_back)
	ImageView mImCircleBack;
	@BindView(R.id.relayout_create_circle_two)
	RelativeLayout mRelayoutCreateCircleTwo;
	@BindView(R.id.im_upload_picture)
	ImageView mImUploadPicture;
	@BindView(R.id.et_create_circle_name)
	EditText mEtCreateCircleName;
	@BindView(R.id.et_create_circle_des)
	EditText mEtCreateCircleDes;
	@BindView(R.id.re_create_circle_type)
	RecyclerView mReCreateCircleType;
	@BindView(R.id.im_circle_create)
	ImageView mImCircleCreate;
	@BindView(R.id.activity_create_circle)
	RelativeLayout mActivityCreateCircle;
	//圈子类型集合
	private ArrayList<CircleType> mtypelist;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_create_circle;
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
		mReCreateCircleType.setLayoutManager(new GridLayoutManager(this,3));
		mReCreateCircleType.setAdapter(new CircleTypeAdapter(this,mtypelist));

	}


	@OnClick({R.id.im_circle_back, R.id.relayout_create_circle_two, R.id.activity_create_circle})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.im_circle_back:
				finish();
				break;
			case R.id.relayout_create_circle_two:
				break;
			case R.id.activity_create_circle:
				break;
		}
	}
}
