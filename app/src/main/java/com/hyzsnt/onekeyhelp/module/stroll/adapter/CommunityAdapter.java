package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/18.
 */

public class CommunityAdapter  extends BaseAdapter{
	private Context mContext;
	private ArrayList<String> mCommunityListLists;

	public CommunityAdapter(Context context) {
		mContext = context;
	}
    public void setdata(ArrayList<String> mCommunityListLists){
	    this.mCommunityListLists = mCommunityListLists;
    }
	@Override
	public int getCount() {
		return mCommunityListLists.size();
	}

	@Override
	public Object getItem(int position) {
		return mCommunityListLists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_create_circle_pop,null);
		TextView textView = (TextView) view.findViewById(R.id.tv_create_circle_community);
		textView.setText(mCommunityListLists.get(position));
		return view;
	}
}
