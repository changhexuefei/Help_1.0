package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.home.activity.VoiceDetailActivity;
import com.hyzsnt.onekeyhelp.module.index.activity.CompoundInfoActivity;

/**
 * Created by hyzs on 2016/12/11.
 */

public class HomeLoginAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private MainActivity activity;
    public HomeLoginAdapter(Context mContext) {
        this.mContext = mContext;
        activity=(MainActivity)mContext;
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==1){
            if(holder instanceof HomeLoginAdapter.HomeLoginViewHolder1){
                ((HomeLoginAdapter.HomeLoginViewHolder1) holder).ivVoice.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i=new Intent(mContext, VoiceDetailActivity.class);
                        mContext.startActivity(i);
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
        public HomeLoginViewHolder0(View itemView) {
            super(itemView);
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
