package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.home.activity.VoiceDetailActivity;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.inner.OnRecyclerViewItemClickListener;

import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/11.
 */

public class HomeLoginAdapter extends RecyclerView.Adapter{
    private Context mContext;
    private MainActivity activity;
    private OnRecyclerViewItemClickListener mOnItemClickListener;
    private ArrayList<MDate> dates=new ArrayList<>();
    public HomeLoginAdapter(Context mContext) {
        this.mContext = mContext;
        activity=(MainActivity)mContext;
    }

    public ArrayList<MDate> getDates() {
        return dates;
    }

    public void setDates(ArrayList<MDate> dates) {
        this.dates = dates;
    }

    //条目电击事件
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_head, parent, false);
            return new HomeLoginAdapter.HomeLoginViewHolder0(v0);
        } else if(viewType == 1){
            View v1 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_1,parent, false);
            return new HomeLoginAdapter.HomeLoginViewHolder1(v1);
        }else{
            View v2 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_2, parent, false);
            return new HomeLoginAdapter.HomeLoginViewHolder2(v2);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(position==0){
            if(holder instanceof HomeLoginAdapter.HomeLoginViewHolder0){
                HomeLoginHeadAdapter homeHeadAdapter = new HomeLoginHeadAdapter(mContext);
                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
                layoutManager.setOrientation(LinearLayout.HORIZONTAL);
                ((HomeLoginAdapter.HomeLoginViewHolder0) holder).itemItemHeadRLV.setLayoutManager(layoutManager);
                ((HomeLoginAdapter.HomeLoginViewHolder0) holder).itemItemHeadRLV.setAdapter(homeHeadAdapter);
                ((HomeLoginAdapter.HomeLoginViewHolder0) holder).itemItemHeadRLV.setItemAnimator(new DefaultItemAnimator());
            }
        }else if(position==1){
            if(holder instanceof HomeLoginAdapter.HomeLoginViewHolder1){
                ((HomeLoginAdapter.HomeLoginViewHolder1) holder).ivVoice.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i=new Intent(mContext, VoiceDetailActivity.class);
                        mContext.startActivity(i);
                    }
                });
            }
        }else if(position>1){
            if(holder instanceof HomeLoginAdapter.HomeLoginViewHolder2){
                ((HomeLoginViewHolder2) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onItemClick(v,position);
                    }
                });
            }
        }

    }

    @Override
    public int getItemCount() {
        return 20;
    }
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if(position == 1){
            return 1;
        }else{
            return 2;
        }
    }
    static class HomeLoginViewHolder0 extends RecyclerView.ViewHolder{
        public RecyclerView itemItemHeadRLV;
        public HomeLoginViewHolder0(View itemView) {
            super(itemView);
            itemItemHeadRLV= (RecyclerView) itemView.findViewById(R.id.item_homehead_rlv);
        }
    }
    static class HomeLoginViewHolder1 extends RecyclerView.ViewHolder{
        public ImageView ivVoice;
        public HomeLoginViewHolder1(View itemView) {
            super(itemView);
            ivVoice= (ImageView) itemView.findViewById(R.id.home_login_iv_voice);
        }
    }
    static class HomeLoginViewHolder2 extends RecyclerView.ViewHolder{
        public HomeLoginViewHolder2(View itemView) {
            super(itemView);
        }
    }
}
