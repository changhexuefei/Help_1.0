package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleJoin;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleMember;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;
import com.hyzsnt.onekeyhelp.module.stroll.widget.SwipeMenuView;
import com.hyzsnt.onekeyhelp.utils.DbUtils;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/16.
 */

public class MemberHostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private Context context;
	private CircleMember mCircleMember;
	private CircleJoin circlejoin;
	private Boolean ishost =false;
	ArrayList<CircleType.ListEntry> queryall;

	public MemberHostAdapter(Context activity, Boolean ishost) {
		this.context = activity;
		this.ishost = ishost;
		DbUtils db = new DbUtils(context);
		queryall =  db.queryall();
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
		if (circlejoin != null && !circlejoin.equals("")) {
			if (holder instanceof JoinViewHolder) {
				final CircleJoin.ListEntry listEntry = circlejoin.getList().get(position);
				//昵称
				((JoinViewHolder) holder).nickname.setText(listEntry.getNickname());
				//头像
				Glide.with(context).load(listEntry.getHeadportraid()).into(((JoinViewHolder) holder).headportraid);
				//性别
				String gender = listEntry.getGender();
				if("0".equals(gender)){
					((JoinViewHolder) holder).gender.setVisibility(View.GONE);
				}else if("1".equals(gender)){
					((JoinViewHolder) holder).gender.setImageResource(R.mipmap.man);
				}else if("2".equals(gender)){
					((JoinViewHolder) holder).gender.setImageResource(R.mipmap.female);
				}
				//同意监听
				final int finalPosition = position;
				((JoinViewHolder) holder).agree.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						applyJoin("1", finalPosition,listEntry.getId());
					}
				});
				//拒绝监听
				((JoinViewHolder) holder).unagree.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						applyJoin("0",finalPosition,listEntry.getId());
					}
				});
			}
		}
		if (mCircleMember != null && !mCircleMember.equals("")) {
			if (holder instanceof MViewHolder) {
				MViewHolder viewHolder = (MViewHolder) holder;
				//这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑
					((SwipeMenuView) viewHolder.itemView).setIos(false).setLeftSwipe(true);
				if (circlejoin != null && !circlejoin.equals("")) {
					position = position - circlejoin.getList().size();
				}
				if (!ishost) {
					((SwipeMenuView) viewHolder.itemView).setSwipeEnable(false);
				}
				CircleMember.ListEntry listEntry = mCircleMember.getList().get(position);
				//昵称
				((MViewHolder) holder).nickname.setText(listEntry.getNickname());
				//头像
				Glide.with(context).load(listEntry.getHeadportraid()).into(((MViewHolder) holder).headportraid);
				//性别
				String gender = listEntry.getGender();
				if("0".equals(gender)){
					((MViewHolder) holder).gender.setVisibility(View.GONE);
				}else if("1".equals(gender)){
					((MViewHolder) holder).gender.setImageResource(R.mipmap.man);
				}else if("2".equals(gender)){
					((MViewHolder) holder).gender.setImageResource(R.mipmap.female);
				}
				String flags =listEntry.getHobbytags();
				String[] flist = flags.split("\\|");
				if(flist.length==3){
					CircleType.ListEntry query = null;
					for(int j=0;j<queryall.size();j++){
						if(queryall.get(j).getTagid().equals(flist[2])){
							query= queryall.get(j);
						}
					}
					((MViewHolder) holder).tagone.setText(query.getTagname());
					GradientDrawable myGrad = (GradientDrawable)((MViewHolder) holder).tagone.getBackground();
					myGrad.setColor(Color.parseColor(query.getTagdesc()));
					((MViewHolder) holder).tagone.setVisibility(View.VISIBLE);
				}
				if(flist.length>=2){
					CircleType.ListEntry query = null;
					for(int j=0;j<queryall.size();j++){
						if(queryall.get(j).getTagid().equals(flist[1])){
							query= queryall.get(j);
						}
					}
					((MViewHolder) holder).tagtwo.setText(query.getTagname());
					GradientDrawable myGrad = (GradientDrawable) ((MViewHolder) holder).tagtwo.getBackground();
					myGrad.setColor(Color.parseColor(query.getTagdesc()));
					((MViewHolder) holder).tagtwo.setVisibility(View.VISIBLE);
				} if(flist.length>=1){
					CircleType.ListEntry query = null;
					for(int j=0;j<queryall.size();j++){
						LogUtils.e(queryall.toString());
						if(queryall.get(j).getTagid().equals(flist[0])){
							query= queryall.get(j);
							LogUtils.e(query.toString());
						}
					}
					/*LogUtils.e(query.toString()+"hhh");
				   ((MViewHolder) holder).tagthree.setText(query.getTagname());
					GradientDrawable myGrad = (GradientDrawable) ((MViewHolder) holder).tagthree.getBackground();
					myGrad.setColor(Color.parseColor(query.getTagdesc()));
					((MViewHolder) holder).tagthree.setVisibility(View.VISIBLE);*/
				}


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
		TextView tagone;
		TextView tagtwo;
		TextView tagthree;
		TextView nickname;
		TextView age;
		TextView delete;

		public MViewHolder(View itemView) {
			super(itemView);
			headportraid = (ImageView) itemView.findViewById(R.id.im_member_host_headportraid);
			gender = (ImageView) itemView.findViewById(R.id.im_member_host_gender);
			tagone = (TextView) itemView.findViewById(R.id.im_member_tag_one);
			tagtwo = (TextView) itemView.findViewById(R.id.im_member_tag_two);
			tagthree = (TextView) itemView.findViewById(R.id.im_member_tag_three);
			nickname = (TextView) itemView.findViewById(R.id.tv_member_host_nickname);
			age = (TextView) itemView.findViewById(R.id.tv_member_host_age);
			delete = (TextView) itemView.findViewById(R.id.tv_delete_btn);
		}
	}

	//管理者
	class JoinViewHolder extends RecyclerView.ViewHolder {
		ImageView headportraid;
		ImageView gender;
		TextView agree;
		TextView unagree;
		TextView nickname;
		TextView age;


		public JoinViewHolder(View itemView) {
			super(itemView);
			headportraid = (ImageView) itemView.findViewById(R.id.im_member_host_headportraid);
			gender = (ImageView) itemView.findViewById(R.id.im_member_host_gender);
			agree = (TextView) itemView.findViewById(R.id.tv_member_host_agree);
			unagree = (TextView) itemView.findViewById(R.id.tv_member_host_unagree);
			nickname = (TextView) itemView.findViewById(R.id.tv_member_host_nickname);
			age = (TextView) itemView.findViewById(R.id.tv_member_host_age);

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
	//申请事件处理
	public void applyJoin(String resultcode, final int position,String id){
		ArrayList<String> list = new ArrayList<String>();
		list.add("23");
		list.add(id);
		list.add(resultcode);
		HttpUtils.post(Api.CIRCLE, Api.Circle.DOWITHJOINAPPLY, list, new ResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {

			}

			@Override
			public void onSuccess(String response, int id) {
				if(JsonUtils.isSuccess(response)){
					ToastUtils.showShort(context,"处理成功");
					circlejoin.getList().remove(position);
					notifyItemRemoved(position);
					notifyItemRangeChanged(position,circlejoin.getList().size());
				}else{
					LogUtils.e(JsonUtils.getErrorMessage(response));
				}
			}
			@Override
			public void inProgress(float progress, long total, int id) {

			}
		});
	}
}
