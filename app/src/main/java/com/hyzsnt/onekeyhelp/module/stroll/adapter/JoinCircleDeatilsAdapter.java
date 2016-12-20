package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.stroll.activity.CircleMemberList;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CiecleDetailss;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleDetails;
import com.hyzsnt.onekeyhelp.module.stroll.bean.JoinSuccess;

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
	CircleDetails detals;
	CiecleDetailss mDetailss;
	Boolean mBoolean;
	JoinSuccess joinSuccess;

	public JoinCircleDeatilsAdapter(Context context, CircleDetails mdetails, Boolean iftotal) {
		mContext = context;
		detals = mdetails;
		mBoolean = iftotal;
		mLayoutInflater = LayoutInflater.from(context);
	}

	public JoinCircleDeatilsAdapter(Activity context, CiecleDetailss detailss, Boolean iftotal) {
		mContext = context;
		mDetailss = detailss;
		mBoolean = iftotal;
	}

	public JoinCircleDeatilsAdapter(Context context, JoinSuccess joinSuccess) {
		mContext = context;
	    this.joinSuccess = joinSuccess;

	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		mLayoutInflater = LayoutInflater.from(mContext);
		//判断添加的样式
		if (viewType == ITEM_TYPE_ONE) {
			return new DetailsViewHolerOne(mLayoutInflater.inflate(R.layout.item_circle_details_header, parent, false));
		} else {
			return new DetailsViewHolertwo(mLayoutInflater.inflate(R.layout.item_circle_details, parent, false));
		}
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if(joinSuccess!=null&&!"".equals(joinSuccess)){
			if (holder instanceof DetailsViewHolerOne) {
				Glide.with(mContext).load(joinSuccess.getInfo().getCccover()).into(((DetailsViewHolerOne) holder).cccover);
				((DetailsViewHolerOne) holder).topicnum.setText(joinSuccess.getInfo().getTopicnum() + "人");
				((DetailsViewHolerOne) holder).topicnum.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(mContext, CircleMemberList.class);
						intent.putExtra("ishost",true);
						intent.putExtra("ccid", joinSuccess.getInfo().getCcid());
						mContext.startActivity(intent);
					}
				});
			}
			return;
		}
		if(mBoolean){
			if (holder instanceof DetailsViewHolerOne) {
				Glide.with(mContext).load(detals.getInfo().getCccover()).into(((DetailsViewHolerOne) holder).cccover);
				((DetailsViewHolerOne) holder).topicnum.setText(detals.getInfo().getCurnum() + "人");
				((DetailsViewHolerOne) holder).topicnum.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//判断是否是管理人
						boolean ishost = false;
						if (detals.getInfo().getUid().equals("23") && Integer.parseInt(detals.getInfo().getApplynum()) > 0) {
							ishost = true;
						}
						Intent intent = new Intent(mContext, CircleMemberList.class);
						intent.putExtra("ishost", ishost);
						intent.putExtra("ccid", detals.getInfo().getCcid());
						mContext.startActivity(intent);
					}
				});

			}
			if (holder instanceof DetailsViewHolertwo) {
				CircleDetails.ListEntry listEntry = detals.getList().get(position - 1);
				((DetailsViewHolertwo) holder).distance.setText(listEntry.getDistance() + "米");
				((DetailsViewHolertwo) holder).nickname.setText(listEntry.getNickname());
				((DetailsViewHolertwo) holder).posttime.setText(listEntry.getPosttime());
				((DetailsViewHolertwo) holder).title.setText(listEntry.getTitle());
				Glide.with(mContext).load(listEntry.getHeadportraid()).into(((DetailsViewHolertwo) holder).headportraid);
				if (listEntry.getGender().equals("1")) {
					((DetailsViewHolertwo) holder).gender.setImageResource(R.mipmap.woman);
				}
			}
		}else{
			if (holder instanceof DetailsViewHolerOne) {
				Glide.with(mContext).load(mDetailss.getInfo().getCccover()).into(((DetailsViewHolerOne) holder).cccover);
				((DetailsViewHolerOne) holder).topicnum.setText(mDetailss.getInfo().getCurnum() + "人");
				((DetailsViewHolerOne) holder).topicnum.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//判断是否是管理人
						boolean ishost = false;
						if (mDetailss.getInfo().getUid().equals("23") && Integer.parseInt(mDetailss.getInfo().getApplynum()) > 0) {
							ishost = true;
						}
						Intent intent = new Intent(mContext, CircleMemberList.class);
						intent.putExtra("ishost", ishost);
						intent.putExtra("ccid", mDetailss.getInfo().getCcid());
						mContext.startActivity(intent);
					}
				});

			}

		}

	}


	class DetailsViewHolerOne extends RecyclerView.ViewHolder {

		TextView topicnum;
		ImageView cccover;
		//获取条目中的控件
		public DetailsViewHolerOne(View itemView) {
			super(itemView);
			topicnum = (TextView) itemView.findViewById(R.id.tv_circle_details_num);
			cccover = (ImageView) itemView.findViewById(R.id.im_circle_details_header);

		}
	}

	class DetailsViewHolertwo extends RecyclerView.ViewHolder {
		ImageView headportraid;
		TextView nickname;
		TextView posttime;
		TextView distance;
		ImageView gender;
		TextView title;
		TextView age;

		public DetailsViewHolertwo(View itemView) {
			super(itemView);
			headportraid = (ImageView) itemView.findViewById(R.id.im_circle_details_item_photo);
			nickname = (TextView) itemView.findViewById(R.id.tv_circle_details_name);
			posttime = (TextView) itemView.findViewById(R.id.tv_circle_details_time);
			distance = (TextView) itemView.findViewById(R.id.tv_circle_details_distance);
			title = (TextView) itemView.findViewById(R.id.tv_circle_details_about);
			age = (TextView) itemView.findViewById(R.id.tv_circle_details_age);
			gender = (ImageView) itemView.findViewById(R.id.im_circle_details_sex);
		}
	}

	@Override
	public int getItemCount() {
		if(joinSuccess!=null&&!"".equals(joinSuccess)){
			return 1;
		}else {
			return detals.getList().size() + 1;
		}

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
		void onItemClick(View view, String data);
	}


}
