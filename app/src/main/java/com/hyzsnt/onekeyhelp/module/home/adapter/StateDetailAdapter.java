package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;

/**
 * Created by hyzs on 2016/12/13.
 */

public class StateDetailAdapter extends RecyclerView.Adapter {
    private Context mContext;

    public StateDetailAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_activity_state_detail_head, parent, false);
            return new StateDetailAdapter.StateDetailViewHolder0(v0);
        } else if(viewType == 1){
            View v1 = LayoutInflater.from(mContext).inflate(R.layout.item_activity_state_detail_1,parent, false);
            return new StateDetailAdapter.StateDetailViewHolder1(v1);
        }else{
            View v2 = LayoutInflater.from(mContext).inflate(R.layout.item_activity_state_detail_2, parent, false);
            return new StateDetailAdapter.StateDetailViewHolder2(v2);
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
    static class StateDetailViewHolder0 extends RecyclerView.ViewHolder{
        public StateDetailViewHolder0(View itemView) {
            super(itemView);
        }
    }
    static class StateDetailViewHolder1 extends RecyclerView.ViewHolder{
        public StateDetailViewHolder1(View itemView) {
            super(itemView);
        }
    }
    static class StateDetailViewHolder2 extends RecyclerView.ViewHolder {
        public StateDetailViewHolder2(View itemView) {
            super(itemView);
        }
    }
}
