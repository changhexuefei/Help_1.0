
package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/12/11.
 */


public class CircleTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
	private Context context;
	private ArrayList<CircleType.ListEntry> list;
	private OnRecyclerViewItemClickListener mOnItemClickListener = null;

	public CircleTypeAdapter(Context context, ArrayList<CircleType.ListEntry> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(context).inflate(R.layout.item_circle_tye, parent, false);
		view.setOnClickListener(this);
		return new CircleTypeViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if(holder instanceof CircleTypeViewHolder){


			((CircleTypeViewHolder) holder).typename.setText(list.get(position).getTagname());
			//设置shape颜色
			GradientDrawable myGrad = (GradientDrawable)((CircleTypeViewHolder) holder).mRelativeLayout.getBackground();
			myGrad.setColor(Color.parseColor(list.get(position).getTagdesc()));
			if(list.get(position).getIsselect()){
				((CircleTypeViewHolder) holder).mselect.setVisibility(View.VISIBLE);
			}else{
				((CircleTypeViewHolder) holder).mselect.setVisibility(View.GONE);
			}

		}
		//将数据保存在itemView的Tag中，以便点击时进行获取
		holder.itemView.setTag(position);

	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	@Override
	public void onClick(View v) {

		if (mOnItemClickListener != null) {
			//注意这里使用getTag方法获取数据
			mOnItemClickListener.onItemClick(v,(Integer) v.getTag());
		}
	}

	class CircleTypeViewHolder extends RecyclerView.ViewHolder {
		TextView typename;
		RelativeLayout mRelativeLayout;
		ImageView mselect;

		public CircleTypeViewHolder(View itemView) {
			super(itemView);
			typename = (TextView) itemView.findViewById(R.id.tv_circle_type_name);
			mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.relayout_circle_type);
			mselect = (ImageView) itemView.findViewById(R.id.im_circle_select);

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

