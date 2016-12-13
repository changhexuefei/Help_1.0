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

public class HomeLoginHeadAdapter extends RecyclerView.Adapter {
    private Context mContext;

    public HomeLoginHeadAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_item_home_login_head, parent, false);
        return new HomeUnLoginAdapter.HomeViewHolder1(v0);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class HomeItemHeadViewHolder extends RecyclerView.ViewHolder{
        public HomeItemHeadViewHolder(View itemView) {
            super(itemView);
        }
    }
}
