package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.home.activity.VoiceDetailActivity;
import com.hyzsnt.onekeyhelp.module.home.bean.DynamicListByCommunityList;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by hyzs on 2016/12/11.
 */

public class HomeLoginAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<MDate> dates;

    public HomeLoginAdapter(Context mContext, ArrayList<MDate> dates) {
        this.mContext = mContext;
        this.dates = dates;
    }

    public void setDates(ArrayList<MDate> dates) {
        this.dates = dates;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View v1 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_1, parent, false);
            return new HomeLoginViewHolder0(v1);
        } else {
            View v2 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_2, parent, false);
            return new HomeLoginViewHolder1(v2);
        }
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        DynamicListByCommunityList dynamicListByCommunityList=null;
        if(dates.size() > 0){
            if(dates.get(0).getmList().getDynamicListByCommunityLists().size()>0){
                dynamicListByCommunityList = dates.get(0).getmList().getDynamicListByCommunityLists().get(position);
            }
        }
        if (position == 0) {
            if (holder instanceof HomeLoginViewHolder0) {

            }
        } else if (position == 1) {
            if (holder instanceof HomeLoginViewHolder0) {
                ((HomeLoginViewHolder0) holder).ivVoice.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //语音
                        //Intent i = new Intent(mContext, VoiceDetailActivity.class);
                        //mContext.startActivity(i);
                    }
                });
            }
        } else if (getItemViewType(position)==2) {
            if (holder instanceof HomeLoginViewHolder1) {
                if(dynamicListByCommunityList!=null){
                    ((HomeLoginViewHolder1) holder).homeLoginDynamicTvNickname.setText(dynamicListByCommunityList.getNickname());
                    ((HomeLoginViewHolder1) holder).homeLoginDynamicTvDistance.setText("一分钟前"+dynamicListByCommunityList.getDistance()+"千米");
                    ((HomeLoginViewHolder1) holder).homeLoginDynamicTvContent.setText("    "+dynamicListByCommunityList.getContent());
                    ((HomeLoginViewHolder1) holder).homeLoginDynamicTvGoodnum.setText(dynamicListByCommunityList.getGoodnum());
                    ((HomeLoginViewHolder1) holder).homeLoginDynamicTvReplynum.setText(dynamicListByCommunityList.getReplynum());
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        if (dates.size() > 0) {
            if (dates.get(0).getmList().getDynamicListByCommunityLists().size() > 0) {
                return dates.get(0).getmList().getDynamicListByCommunityLists().size();
            }
        }
        return 0;
    }
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }


    static class HomeLoginViewHolder0 extends RecyclerView.ViewHolder {
        public ImageView ivVoice;
        public HomeLoginViewHolder0(View itemView) {
            super(itemView);
            ivVoice = (ImageView) itemView.findViewById(R.id.home_login_iv_voice);

        }
    }

    static class HomeLoginViewHolder1 extends RecyclerView.ViewHolder {
        TextView homeLoginDynamicTvNickname;
        TextView homeLoginDynamicTvDistance;
        TextView homeLoginDynamicTvContent;
        TextView homeLoginDynamicTvGoodnum;
        TextView homeLoginDynamicTvReplynum;
        public HomeLoginViewHolder1(View itemView) {
            super(itemView);
            homeLoginDynamicTvNickname= (TextView) itemView.findViewById(R.id.home_login_dynamic_tv_nickname);
            homeLoginDynamicTvDistance= (TextView) itemView.findViewById(R.id.home_login_dynamic_tv_distance);
            homeLoginDynamicTvContent= (TextView) itemView.findViewById(R.id.home_login_dynamic_tv_content);
            homeLoginDynamicTvGoodnum= (TextView) itemView.findViewById(R.id.home_login_dynamic_tv_goodnum);
            homeLoginDynamicTvReplynum= (TextView) itemView.findViewById(R.id.home_login_dynamic_tv_replynum);
        }
    }
}
