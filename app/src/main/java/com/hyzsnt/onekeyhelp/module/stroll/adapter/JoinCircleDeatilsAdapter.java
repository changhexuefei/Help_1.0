package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/12.
 */

public class JoinCircleDeatilsAdapter extends RecyclerView.Adapter {
	//类型
	private final int ITEM_TYPE_ONE = 1;
	private final int ITEM_TYPE_TWO = 2;
	private Context mContext;
	private ArrayList<String> mList;
	private LayoutInflater mLayoutInflater;
	public JoinCircleDeatilsAdapter(Context context, ArrayList<String> list) {
		mContext = context;
		mList = list;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		//判断添加的样式
		if (viewType == ITEM_TYPE_ONE) {
			return new DetailsViewHolerOne(mLayoutInflater.inflate(R.layout.item_circle_details_header, parent, false));
		} else {
			return new DetailsViewHolertwo(mLayoutInflater.inflate(R.layout.item_circle_details, parent, false));
		}
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


	}


	class DetailsViewHolerOne extends RecyclerView.ViewHolder {


		//获取条目中的控件
		public DetailsViewHolerOne(View itemView) {
			super(itemView);

		}
	}

	class DetailsViewHolertwo extends RecyclerView.ViewHolder {


		public DetailsViewHolertwo(View itemView) {
			super(itemView);


		}
	}

	@Override
	public int getItemCount() {
		return 20;
	}

	@Override
	public int getItemViewType(int position) {
		if (position == 0) {
			return ITEM_TYPE_ONE;
		} else {
			return ITEM_TYPE_TWO;
		}

	}
	//define interface
	public static interface OnRecyclerViewItemClickListener {
		void onItemClick(View view , String data);
	}
}
