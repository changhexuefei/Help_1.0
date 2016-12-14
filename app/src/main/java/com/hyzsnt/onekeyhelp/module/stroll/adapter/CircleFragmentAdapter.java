package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.utils.BitmapUtils;

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
		return 2;
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
              view = View.inflate(mContext,R.layout.item_stroll_one,null);
			 TextView tv1 = (TextView) view.findViewById(R.id.tv_stroll_list_group);

		 }

		return view;
	}

	@Override
	public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
		ChildViewHolder childViewHolder = null;
		if(view==null){
			view=LayoutInflater.from(mContext).inflate(R.layout.item_stroll_two,null);
			childViewHolder = new ChildViewHolder();
			childViewHolder.child_icon = (ImageView) view.findViewById(R.id.im_Stroll_list_icon);
			childViewHolder.child_name = (TextView) view.findViewById(R.id.tv_stroll_list_title);
			childViewHolder.child_num = (TextView) view.findViewById(R.id.tv_stroll_list_num);
			childViewHolder.child_topic = (TextView) view.findViewById(R.id.tv_stroll_list_topic);
			childViewHolder.child_type_one = (TextView) view.findViewById(R.id.tv_stroll_list_typeone);
			childViewHolder.child_type_two = (TextView) view.findViewById(R.id.tv_stroll_list_typetwo);
			childViewHolder.child_type_three = (TextView) view.findViewById(R.id.tv_stroll_list_typethree);
			view.setTag(childViewHolder);
		}else{
			childViewHolder = (ChildViewHolder) view.getTag();
		}
		Bitmap bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.cc).getBitmap();

		Bitmap bit = BitmapUtils.toRoundBitmap(bitmap);
		childViewHolder.child_icon.setImageBitmap(bit);

		return view;
	}

	@Override
	public boolean isChildSelectable(int i, int i1) {
		return true;
	}
	//优化
	class GroupViewHolder{
		public TextView group_name;
	}

	class ChildViewHolder{
       public ImageView child_icon;
		public TextView child_name;
		public TextView child_type_one;
		public TextView child_type_two;
		public TextView child_type_three;
		public TextView child_num;
		public TextView child_topic;


	}
}
