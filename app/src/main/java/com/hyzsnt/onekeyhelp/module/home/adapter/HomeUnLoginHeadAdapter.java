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

public class HomeUnLoginHeadAdapter extends RecyclerView.Adapter {
    private Context mHeadContext;

    public HomeUnLoginHeadAdapter(Context mHeadContext) {
        this.mHeadContext = mHeadContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mHeadContext).inflate(R.layout.item_home_star, parent, false);
        return new HomeHeadViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
    static class HomeHeadViewHolder extends RecyclerView.ViewHolder{
        public HomeHeadViewHolder(View itemView) {
            super(itemView);
        }
    }
}
