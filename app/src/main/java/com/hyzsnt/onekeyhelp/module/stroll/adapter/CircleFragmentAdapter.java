package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/12.
 */

public class CircleFragmentAdapter extends BaseExpandableListAdapter {
	private Context mContext;
	HashMap<String,ArrayList<String>> list;

	public CircleFragmentAdapter(Context context,HashMap<String,ArrayList<String>> list) {
		mContext = context;
		this.list = list;
	}

	@Override
	public int getGroupCount() {
		return 5;
	}

	@Override
	public int getChildrenCount(int i) {
		return 5;
	}

	@Override
	public Object getGroup(int i) {
		return null;
	}

	@Override
	public Object getChild(int i, int i1) {
		return i1;
	}

	@Override
	public long getGroupId(int i) {
		return i;
	}

	@Override
	public long getChildId(int i, int i1) {
		return i1;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

		 if(view==null){
              view = View.inflate(mContext,android.R.layout.simple_list_item_1,null);
			 TextView tv1 = (TextView) view.findViewById(android.R.id.text1);
			 tv1.setText("朝阳小区");
		 }

		return view;
	}

	@Override
	public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
		return View.inflate(mContext, R.layout.item_stroll_two,null);
	}

	@Override
	public boolean isChildSelectable(int i, int i1) {
		return true;
	}
}
