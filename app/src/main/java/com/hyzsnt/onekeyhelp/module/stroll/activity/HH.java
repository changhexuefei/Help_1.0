package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleFragmentAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;

public class HH extends BaseActivity {

	@BindView(R.id.re_stroll_header_list)
	RecyclerView mReStrollHeaderList;
	@BindView(R.id.ex_circle_fragment)
	ExpandableListView mExCircleFragment;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_hh;
	}

	@Override
	protected void initData() {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> list = new ArrayList<>();
		list.add("fgf");
		list.add("fgf");
		list.add("fgf");
		list.add("fgf");
		map.put("hh", list);
		map.put("hh", list);
		map.put("hh", list);
		map.put("hh", list);
		map.put("hh", list);
		map.put("hh", list);
		map.put("hh", list);
		map.put("hh", list);
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		layoutManager.setOrientation(LinearLayout.HORIZONTAL);
		mReStrollHeaderList.setLayoutManager(layoutManager);
		mExCircleFragment.setAdapter(new CircleFragmentAdapter(this,map));
	}


}
