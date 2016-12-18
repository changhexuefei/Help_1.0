package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;

/**
 * Created by hyzs on 2016/12/12.
 */

public class VoiceDetailAdapter extends RecyclerView.Adapter {
    private Context mContext;

    public VoiceDetailAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_activity_home_voice_0, parent, false);
            return new VoiceDetailAdapter.VoiceDetailViewHolder0(v0);
        } else if(viewType == 1){
            View v1 = LayoutInflater.from(mContext).inflate(R.layout.item_activity_home_voice_1,parent, false);
            return new VoiceDetailAdapter.VoiceDetailViewHolder1(v1);
        }else{
            View v2 = LayoutInflater.from(mContext).inflate(R.layout.item_activity_home_voice_2, parent, false);
            return new VoiceDetailAdapter.VoiceDetailViewHolder2(v2);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

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

    static class VoiceDetailViewHolder0 extends RecyclerView.ViewHolder{
        public VoiceDetailViewHolder0(View itemView) {
            super(itemView);
        }
    }
    static class VoiceDetailViewHolder1 extends RecyclerView.ViewHolder{
        public VoiceDetailViewHolder1(View itemView) {
            super(itemView);
        }
    }
    static class VoiceDetailViewHolder2 extends RecyclerView.ViewHolder{
        public VoiceDetailViewHolder2(View itemView) {
            super(itemView);
        }
    }
}
