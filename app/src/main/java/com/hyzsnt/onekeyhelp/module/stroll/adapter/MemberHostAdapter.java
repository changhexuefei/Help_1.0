package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleJoin;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleMember;
import com.hyzsnt.onekeyhelp.module.stroll.widget.SwipeMenuView;

/**
 * Created by Administrator on 2016/12/16.
 */

public class MemberHostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private Context context;
	private CircleMember mCircleMember;
	private CircleJoin circlejoin;

	public MemberHostAdapter(Context activity) {
		this.context = activity;

	}

	public void setCircleMember(CircleMember circleMember) {
		mCircleMember = circleMember;
	}

	public void setCirclejoin(CircleJoin circlejoin) {
		this.circlejoin = circlejoin;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if (viewType == 0) {
			return new JoinViewHolder(LayoutInflater.from(context).inflate(R.layout.item_circle_member_host, parent, false));
		} else {
			return new MViewHolder(LayoutInflater.from(context).inflate(R.layout.item_circle_join_list, parent, false));
		}


	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if(circlejoin != null && !circlejoin.equals("")){
			if(holder instanceof JoinViewHolder){

				JoinViewHolder viewHolder = (JoinViewHolder) holder;
				//这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑
				((SwipeMenuView) viewHolder.itemView).setIos(false).setLeftSwipe(true);
				CircleJoin.ListEntry listEntry = circlejoin.getList().get(position);
				((JoinViewHolder) holder).nickname.setText(listEntry.getNickname());
				Glide.with(context).load(listEntry.getHeadportraid()).into(((JoinViewHolder) holder).headportraid);

			}
		}
		if(mCircleMember != null && !mCircleMember.equals("")){



			if(holder instanceof MViewHolder){


				if(circlejoin != null && !circlejoin.equals("")){
					position =position-circlejoin.getList().size();
				}
				CircleMember.ListEntry listEntry= mCircleMember.getList().get(position);

				((MViewHolder) holder).nickname.setText(listEntry.getNickname());
				Glide.with(context).load(listEntry.getHeadportraid()).into(((MViewHolder) holder).headportraid);
			}
		}


	}

	@Override
	public int getItemCount() {
		if (mCircleMember != null && !mCircleMember.equals("")) {
			if (circlejoin != null && !circlejoin.equals("")) {
				return circlejoin.getList().size() + mCircleMember.getList().size();
			}
			return mCircleMember.getList().size();
		}

		return 0;
	}

	//非管理者
	class MViewHolder extends RecyclerView.ViewHolder {
		ImageView headportraid;
		ImageView gender;
		ImageView tagone;
		ImageView tagtwo;
		ImageView tagthree;
		TextView nickname;
		TextView age;
		public MViewHolder(View itemView) {
			super(itemView);
			headportraid = (ImageView) itemView.findViewById(R.id.im_member_host_headportraid);
			gender = (ImageView) itemView.findViewById(R.id.im_member_host_gender);
			tagone = (ImageView) itemView.findViewById(R.id.im_member_tag_one);
			tagtwo = (ImageView) itemView.findViewById(R.id.im_member_tag_two);
			tagthree = (ImageView) itemView.findViewById(R.id.im_member_tag_three);
			nickname = (TextView) itemView.findViewById(R.id.tv_member_host_nickname);
			age = (TextView) itemView.findViewById(R.id.tv_member_host_age);
		}
	}

	//管理者
	class JoinViewHolder extends RecyclerView.ViewHolder {
		ImageView headportraid;
		ImageView gender;
		TextView agree;
		TextView unagree;
		TextView delete;
		TextView nickname;
		TextView age;
		SwipeMenuView swip;

		public JoinViewHolder(View itemView) {
			super(itemView);
			headportraid = (ImageView) itemView.findViewById(R.id.im_member_host_headportraid);
			gender = (ImageView) itemView.findViewById(R.id.im_member_host_gender);
			agree = (TextView) itemView.findViewById(R.id.tv_member_host_agree);
			unagree = (TextView) itemView.findViewById(R.id.tv_member_host_unagree);
			delete = (TextView) itemView.findViewById(R.id.tv_delete_btn);
			nickname = (TextView) itemView.findViewById(R.id.tv_member_host_nickname);
			age = (TextView) itemView.findViewById(R.id.tv_member_host_age);
//			swip = (SwipeMenuView) itemView.findViewById(R.id.swipe_delete);
//			swip.setSwipeEnable(true);
//			swip.setLeftSwipe(false);
		}
	}


	@Override
	public int getItemViewType(int position) {
		if (circlejoin != null && !circlejoin.equals("")) {
			if (position <= circlejoin.getList().size() - 1) {
				return 0;
			}
		}
		return 1;
	}
}
