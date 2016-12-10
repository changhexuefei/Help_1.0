package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;

/**
 * Created by Administrator on 2016/12/10.
 */

public class StrollHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private Context mContext;

	public StrollHeaderAdapter(Context context) {
		mContext = context;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		//引入视图
		View view =LayoutInflater.from(mContext).inflate(R.layout.item_stroll_header, parent, false);
		return new HeaderViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {
		return 5;
	}

	//复用控件
	class HeaderViewHolder extends RecyclerView.ViewHolder {

		public HeaderViewHolder(View itemView) {
			super(itemView);
		}
	}
}
