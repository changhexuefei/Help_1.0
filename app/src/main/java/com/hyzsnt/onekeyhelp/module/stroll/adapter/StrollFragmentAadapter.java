package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/9.
 */

public class StrollFragmentAadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	//类型
	private final int ITEM_TYPE_ONE = 1;
	private final int ITEM_TYPE_TWO = 2;
	private Context mContext;
	private ArrayList<String> mList;
	private LayoutInflater mLayoutInflater;
	private OnRecyclerViewItemClickListener mOnItemClickListener = null;

	public StrollFragmentAadapter(Context context, ArrayList<String> list) {
		mContext = context;
		mList = list;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      //判断添加的样式
		if (viewType == ITEM_TYPE_ONE) {
			return new StrollViewHolerOne(mLayoutInflater.inflate(R.layout.item_stroll_one, parent, false));
		} else {
			return new StrollViewHolertwo(mLayoutInflater.inflate(R.layout.item_stroll_two, parent, false));
		}
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if(holder instanceof StrollViewHolerOne){
			((StrollViewHolerOne) holder).header_list.setAdapter(new StrollHeaderAdapter(mContext));
		}

	}


	class StrollViewHolerOne extends RecyclerView.ViewHolder {

		RecyclerView header_list;
		//获取条目中的控件
		public StrollViewHolerOne(View itemView) {
			super(itemView);
			header_list = (RecyclerView) itemView.findViewById(R.id.re_stroll_header_list);
			LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
			layoutManager.setOrientation(LinearLayout.HORIZONTAL);
			header_list.setLayoutManager(layoutManager);
		}
	}

	class StrollViewHolertwo extends RecyclerView.ViewHolder {
		TextView list_address;
		TextView list_typeone;
		TextView list_titile;
		ImageView list_isjoin;
		TextView list_num;
		public StrollViewHolertwo(View itemView) {
			super(itemView);
			list_address = (TextView) itemView.findViewById(R.id.tv_stroll_list_address);
			list_typeone = (TextView) itemView.findViewById(R.id.tv_stroll_list_typeone);
			list_num = (TextView) itemView.findViewById(R.id.tv_stroll_list_num);
			list_titile = (TextView) itemView.findViewById(R.id.tv_stroll_list_title);
			list_isjoin = (ImageView) itemView.findViewById(R.id.tv_stroll_list_isjoin);

		}
	}

	@Override
	public int getItemCount() {
		return mList.size();
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
