package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/9.
 */

public class StrollFragmentAadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	//类型
	private final int ITEM_TYPE_ONE=1;
	private final int ITEM_TYPE_TWO=2;
	private Context mContext;
	private ArrayList<String> mList;
	private LayoutInflater mLayoutInflater;

	public StrollFragmentAadapter(Context context, ArrayList<String> list) {
		mContext = context;
		mList = list;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		if (viewType == ITEM_TYPE_ONE) {
			return new StrollViewHolerOne(mLayoutInflater.inflate(R.layout.item_stroll_one, parent, false));
		} else {
			return new StrollViewHolertwo(mLayoutInflater.inflate(R.layout.item_stroll_two, parent, false));
		}
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


	}
	 class StrollViewHolerOne extends RecyclerView.ViewHolder{

		 public StrollViewHolerOne(View itemView) {
			 super(itemView);
		 }
	 }
	class StrollViewHolertwo extends RecyclerView.ViewHolder{

		public StrollViewHolertwo(View itemView) {
			super(itemView);
		}
	}

	@Override
	public int getItemCount() {
		return mList.size();
	}

	@Override
	public int getItemViewType(int position) {
		if(position==0){
			return ITEM_TYPE_ONE;
		}else{
			return ITEM_TYPE_TWO;
		}

	}
}
