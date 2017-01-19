package com.hyzsnt.onekeyhelp.module.user.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;

/**
 * Created by Administrator on 2017/1/5.
 */

public class BalanceAdapter extends RecyclerView.Adapter<BalanceAdapter.BalanceViewHolder>{
    Context mContext;

    public BalanceAdapter(Activity activity) {
        mContext=activity;
    }

    @Override
    public BalanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BalanceViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_balance_list,null));
    }

    @Override
    public void onBindViewHolder(BalanceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class BalanceViewHolder extends RecyclerView.ViewHolder{

        public BalanceViewHolder(View itemView) {
            super(itemView);
        }
    }
}
