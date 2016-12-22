package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleRound;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;
import com.hyzsnt.onekeyhelp.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */

public class CircleFragmentAdapter extends BaseExpandableListAdapter {

	Context mactivity;
	List<CircleRound.ListEntry> list;
	ArrayList<CircleType.ListEntry> queryall;

	public CircleFragmentAdapter(Context mactivity) {
		this.mactivity = mactivity;
		DbUtils db = new DbUtils(mactivity);
        queryall =  db.queryall();

	}
    public void setdata(List<CircleRound.ListEntry> list){
	    this.list = list;
    }
	@Override
	public int getGroupCount() {
		return list.size();
	}

	@Override
	public int getChildrenCount(int i) {
		return list.get(i).getCircle().size();
	}

	@Override
	public Object getGroup(int i) {
		return list.get(i).getCommunity().getCmname();
	}

	@Override
	public Object getChild(int i, int i1) {
		return list.get(i).getCircle().get(i1);
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
		GroupViewHolder group = null;
		if (view == null) {
			group = new GroupViewHolder();
			view = View.inflate(mactivity, R.layout.item_stroll_one, null);
			group.group_name = (TextView) view.findViewById(R.id.tv_stroll_list_group);
			view.setTag(group);
		} else {
			group = (GroupViewHolder) view.getTag();
		}
		group.group_name.setText(list.get(i).getCommunity().getCmname());
		return view;
	}

	@Override
	public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
		ChildViewHolder childViewHolder = null;
		if (view == null) {
			view = LayoutInflater.from(mactivity).inflate(R.layout.item_stroll_two, null);
			childViewHolder = new ChildViewHolder();
			childViewHolder.view1 =view.findViewById(R.id.view1);
			childViewHolder.child_icon = (ImageView) view.findViewById(R.id.im_Stroll_list_icon);
			childViewHolder.child_name = (TextView) view.findViewById(R.id.tv_stroll_list_title);
			childViewHolder.child_num = (TextView) view.findViewById(R.id.tv_stroll_list_num);
			childViewHolder.child_topic = (TextView) view.findViewById(R.id.tv_stroll_list_topic);
			childViewHolder.child_type_one = (TextView) view.findViewById(R.id.tv_stroll_list_typeone);
			childViewHolder.child_type_two = (TextView) view.findViewById(R.id.tv_stroll_list_typetwo);
			childViewHolder.child_type_three = (TextView) view.findViewById(R.id.tv_stroll_list_typethree);
			view.setTag(childViewHolder);
		} else {
			childViewHolder = (ChildViewHolder) view.getTag();
		}
		if(i1==0){
			childViewHolder.view1.setVisibility(View.GONE);
		}
		CircleRound.ListEntry.CircleEntry circles = list.get(i).getCircle().get(i1);
		//Glide.with(mactivity).load(circles.getCccover()).into(childViewHolder.child_icon);
		childViewHolder.child_num.setText(circles.getCurnum()+"人");
		childViewHolder.child_name.setText(circles.getCcname());
		if(circles.getTopicnum()!=null){
			childViewHolder.child_topic.setText(circles.getTopicnum()+"条话题");
		}

		String flags =circles.getTags();
		String[] flist = flags.split("\\|");
           if(flist.length>=3){
	           CircleType.ListEntry query = null;
	           for(int j=0;j<queryall.size();j++){
		           if(queryall.get(j).getTagid().equals(flist[2])){
			           query= queryall.get(j);
		           }
	           }
	           childViewHolder.child_type_three.setText(query.getTagname());
	           GradientDrawable myGrad = (GradientDrawable) childViewHolder.child_type_three.getBackground();
	           myGrad.setColor(Color.parseColor(query.getTagdesc()));
	           childViewHolder.child_type_three.setVisibility(View.VISIBLE);
           }
			if(flist.length>=2){
				CircleType.ListEntry query = null;
				for(int j=0;j<queryall.size();j++){
					if(queryall.get(j).getTagid().equals(flist[1])){
					}
				}
				childViewHolder.child_type_two.setText(query.getTagname());
				GradientDrawable myGrad = (GradientDrawable) childViewHolder.child_type_two.getBackground();
				myGrad.setColor(Color.parseColor(query.getTagdesc()));
				childViewHolder.child_type_two.setVisibility(View.VISIBLE);
			} if(flist.length>=1){
			CircleType.ListEntry query = null;
			for(int j=0;j<queryall.size();j++){
				if(queryall.get(j).getTagid().equals(flist[0])){
					query= queryall.get(j);
				}
			}
				childViewHolder.child_type_one.setText(query.getTagname());
				GradientDrawable myGrad = (GradientDrawable) childViewHolder.child_type_one.getBackground();
				myGrad.setColor(Color.parseColor(query.getTagdesc()));
				childViewHolder.child_type_one.setVisibility(View.VISIBLE);
			}
		return view;
	}

	@Override
	public boolean isChildSelectable(int i, int i1) {
		return true;
	}

	//优化
	class GroupViewHolder {
		public TextView group_name;

	}

	class ChildViewHolder {
		public View view1;
		public ImageView child_icon;
		public TextView child_name;
		public TextView child_type_one;
		public TextView child_type_two;
		public TextView child_type_three;
		public TextView child_num;
		public TextView child_topic;
	}
}
