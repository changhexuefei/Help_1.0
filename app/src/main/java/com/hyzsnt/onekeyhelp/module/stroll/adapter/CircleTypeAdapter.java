package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/11.
 */

public class CircleTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private Context context;
	private ArrayList<CircleType> list;

	public CircleTypeAdapter(Context context, ArrayList<CircleType> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		return new CircleTypeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_circle_tye, parent, false));
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if(holder instanceof CircleTypeViewHolder){

		   ((CircleTypeViewHolder) holder).ic_type.setImageResource(list.get(position).getIcon());
			((CircleTypeViewHolder) holder).typename.setText(list.get(position).getName());
			((CircleTypeViewHolder) holder).mLinearLayout.setBackgroundResource(list.get(position).getBackgroundcolor());
		}

	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	class CircleTypeViewHolder extends RecyclerView.ViewHolder {
		TextView typename;
		ImageView ic_type;
		LinearLayout mLinearLayout;

		public CircleTypeViewHolder(View itemView) {
			super(itemView);
			typename = (TextView) itemView.findViewById(R.id.tv_circle_type_name);
			ic_type= (ImageView) itemView.findViewById(R.id.im_circle_type);
			mLinearLayout= (LinearLayout) itemView.findViewById(R.id.llayout_circle_type);

		}
	}
}
