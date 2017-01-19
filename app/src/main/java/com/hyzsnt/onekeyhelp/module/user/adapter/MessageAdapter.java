package com.hyzsnt.onekeyhelp.module.user.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.user.activity.MessageActivity;

/**
 * Created by Administrator on 2017/1/17.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MeViewholder>{

    private Context mContext;

    public MessageAdapter(MessageActivity activity) {
        mContext = activity;

    }

    @Override
    public MeViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MeViewholder(LayoutInflater.from(mContext).inflate(R.layout.item_user_message,parent,false));
    }

    @Override
    public void onBindViewHolder(MeViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    class MeViewholder extends RecyclerView.ViewHolder{

        public MeViewholder(View itemView) {
            super(itemView);
        }
    }
}
