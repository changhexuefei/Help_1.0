package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleHotTag;

import java.util.List;

import static com.hyzsnt.onekeyhelp.R.id.tv_stroll_header_title;

/**
 * Created by Administrator on 2016/12/10.
 */

public class StrollHeaderAdapter extends RecyclerView.Adapter<StrollHeaderAdapter.HeaderViewHolder> implements View.OnClickListener{
	private  List<CircleHotTag.ListEntry> list;
	private Context mContext;
	private OnRecyclerViewItemClickListener mOnItemClickListener = null;
	public StrollHeaderAdapter(Activity activity) {

		mContext = activity;
	}
   public void setdata( List<CircleHotTag.ListEntry> list){
	   this.list = list;
   }

	@Override
	public StrollHeaderAdapter.HeaderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		//引入视图
		View view = LayoutInflater.from(mContext).inflate(R.layout.item_stroll_header, parent, false);
		//将创建的View注册点击事件
		view.setOnClickListener(this);
		return new HeaderViewHolder(view);
	}


	@Override
	public void onBindViewHolder(StrollHeaderAdapter.HeaderViewHolder holder, int position) {
		CircleHotTag.ListEntry entry = list.get(position);
		holder.circlenum.setText(entry.getCirclenum());
		holder.tagname.setText(entry.getTagname());
		Glide.with(mContext).load(entry.getTagpic()).into(holder.tagic);
		holder.itemView.setTag(position);
	}

	@Override
	public int getItemCount() {
		return list == null ? 0 : list.size();
	}

	@Override
	public void onClick(View v) {
		if (mOnItemClickListener != null) {
			//注意这里使用getTag方法获取数据
			mOnItemClickListener.onItemClick(v,(Integer)v.getTag());
		}
	}

	//复用控件
	class HeaderViewHolder extends RecyclerView.ViewHolder {
		ImageView tagic;
		TextView tagname;
		TextView circlenum;

		public HeaderViewHolder(View itemView) {
			super(itemView);
			tagname = (TextView) itemView.findViewById(tv_stroll_header_title);
			tagic = (ImageView) itemView.findViewById(R.id.im_stroll_header);
			circlenum = (TextView) itemView.findViewById(R.id.tv_stroll_header_num);
		}
	}
	//define interface
	public static interface OnRecyclerViewItemClickListener {
		void onItemClick(View view , int data);
	}
	public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
		this.mOnItemClickListener = listener;
	}

}
