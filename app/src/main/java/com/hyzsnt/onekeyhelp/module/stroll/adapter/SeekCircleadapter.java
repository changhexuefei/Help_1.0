package com.hyzsnt.onekeyhelp.module.stroll.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.stroll.activity.SeekCircleActivity;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleRound;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */

public class SeekCircleadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	Context mactivity;
	List<CircleRound.ListEntry> list;

	public SeekCircleadapter(SeekCircleActivity seekCircleActivity, List<CircleRound.ListEntry> list) {
		this.mactivity = mactivity;
		this.list = list;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		return new SeekCircleViewhold(LayoutInflater.from(mactivity).inflate(R.layout.item_stroll_two, null));
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
          if(holder instanceof  SeekCircleViewhold){
	       /*   if(position==0){
		          ((SeekCircleViewhold) holder).view1.setVisibility(View.GONE);
	          }
	          CircleRound.ListEntry.CircleEntry circles = list.get()
	          //Glide.with(mactivity).load(circles.getCccover()).into(childViewHolder.child_icon);
	          childViewHolder.child_num.setText(circles.getCurnum()+"人");
	          childViewHolder.child_name.setText(circles.getCcname());
	          if(circles.getTopicnum()!=null){
		          childViewHolder.child_topic.setText(circles.getTopicnum()+"条话题");
	          }

	          String flags =circles.getTags();
	          String[] flist = flags.split("\\|");
	          DbUtils db = new DbUtils(mactivity);

	          for(int j=0;j<flist.length;j++){

		          if(flist.length==3){
			          CircleType.ListEntry query = db.query(flist[2]);
			          childViewHolder.child_type_three.setText(query.getTagname());
			          GradientDrawable myGrad = (GradientDrawable) childViewHolder.child_type_three.getBackground();
			          myGrad.setColor(Color.parseColor(query.getTagdesc()));
			          childViewHolder.child_type_three.setVisibility(View.VISIBLE);
		          }
		          if(flist.length>=2){
			          CircleType.ListEntry query = db.query(flist[1]);
			          childViewHolder.child_type_two.setText(query.getTagname());
			          GradientDrawable myGrad = (GradientDrawable) childViewHolder.child_type_two.getBackground();
			          myGrad.setColor(Color.parseColor(query.getTagdesc()));
			          childViewHolder.child_type_two.setVisibility(View.VISIBLE);
		          } if(flist.length>=1){
			          CircleType.ListEntry query = db.query(flist[0]);
			          childViewHolder.child_type_one.setText(query.getTagname());
			          GradientDrawable myGrad = (GradientDrawable) childViewHolder.child_type_one.getBackground();
			          myGrad.setColor(Color.parseColor(query.getTagdesc()));
			          childViewHolder.child_type_one.setVisibility(View.VISIBLE);
		          }
	          }*/
          }
	}


	@Override
	public int getItemCount() {
		return 0;
	}
	public class SeekCircleViewhold extends RecyclerView.ViewHolder{
		public View view1;
		public ImageView child_icon;
		public TextView child_name;
		public TextView child_type_one;
		public TextView child_type_two;
		public TextView child_type_three;
		public TextView child_num;
		public TextView child_topic;
		public SeekCircleViewhold(View itemView) {
			super(itemView);
			view1 =itemView.findViewById(R.id.view1);
			child_icon = (ImageView) itemView.findViewById(R.id.im_Stroll_list_icon);
			child_name = (TextView) itemView.findViewById(R.id.tv_stroll_list_title);
			child_num = (TextView) itemView.findViewById(R.id.tv_stroll_list_num);
			child_topic = (TextView) itemView.findViewById(R.id.tv_stroll_list_topic);
			child_type_one = (TextView) itemView.findViewById(R.id.tv_stroll_list_typeone);
			child_type_two = (TextView) itemView.findViewById(R.id.tv_stroll_list_typetwo);
			child_type_three = (TextView) itemView.findViewById(R.id.tv_stroll_list_typethree);
		}
	}
}
