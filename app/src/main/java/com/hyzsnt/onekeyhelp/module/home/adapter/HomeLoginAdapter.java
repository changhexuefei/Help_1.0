package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;

/**
 * Created by hyzs on 2016/12/11.
 */

public class HomeLoginAdapter extends RecyclerView.Adapter {
    private Context mContext;

    public HomeLoginAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_head, parent, false);
            return new HomeUnLoginAdapter.HomeViewHolder1(v0);
        } else if(viewType == 1){
            View v1 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_2,parent, false);
            return new HomeUnLoginAdapter.HomeViewHolder2(v1);
        }else{
            View v2 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_2, parent, false);
            return new HomeUnLoginAdapter.HomeViewHolder2(v2);
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
    static class HomeLoginViewHolder0 extends RecyclerView.ViewHolder{
        public HomeLoginViewHolder0(View itemView) {
            super(itemView);
        }
    }
    static class HomeLoginViewHolder1 extends RecyclerView.ViewHolder{
        public HomeLoginViewHolder1(View itemView) {
            super(itemView);
        }
    }
    static class HomeLoginViewHolder2 extends RecyclerView.ViewHolder{
        public HomeLoginViewHolder2(View itemView) {
            super(itemView);
        }
    }
}
