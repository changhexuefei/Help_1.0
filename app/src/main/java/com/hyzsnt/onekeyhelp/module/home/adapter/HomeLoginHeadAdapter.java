package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;

import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/13.
 */

public class HomeLoginHeadAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<Integer> homeLoginTitleList;
    public HomeLoginHeadAdapter(Context mContext) {
        this.mContext = mContext;
        homeLoginTitleList=new ArrayList<>();
        homeLoginTitleList.add(R.drawable.home_login_synthesize);
        homeLoginTitleList.add(R.drawable.home_login_exchange_house);
        homeLoginTitleList.add(R.drawable.home_login_exchange_goods);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_item_home_login_head, parent, false);
        return new HomeLoginHeadAdapter.HomeItemHeadViewHolder(v0);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HomeItemHeadViewHolder){
            ((HomeItemHeadViewHolder) holder).iv.setImageResource(homeLoginTitleList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return homeLoginTitleList.size();
    }

    static class HomeItemHeadViewHolder extends RecyclerView.ViewHolder{
        public ImageView iv;
        public HomeItemHeadViewHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.item_item_head_img);
        }
    }
}
