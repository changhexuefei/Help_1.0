package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hyzsnt.onekeyhelp.R;

import butterknife.BindView;

/**
 * Created by hyzs on 2016/12/10.
 */

public class HomeAdapter extends RecyclerView.Adapter {
    RecyclerView homeLrvHead;
    private Context mContext;
    private View v1;

    public HomeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            v1 = LayoutInflater.from(mContext).inflate(R.layout.item_home_lrv_head, parent, false);
            return new HomeViewHolder(v1);
        } else {
            View v2 = LayoutInflater.from(mContext).inflate(R.layout.item_home_circum, parent, false);
            return new HomeViewHolder(v2);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==0){
            homeLrvHead= (RecyclerView) v1.findViewById(R.id.home_lrv_head);
            HomeHeadAdapter homeHeadAdapter=new HomeHeadAdapter(mContext);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
            layoutManager.setOrientation(LinearLayout.HORIZONTAL);
            homeLrvHead.setLayoutManager(layoutManager);
            homeLrvHead.setAdapter(homeHeadAdapter);
            homeLrvHead.setItemAnimator(new DefaultItemAnimator());
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class HomeViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rv;
        public HomeViewHolder(View itemView) {
            super(itemView);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
