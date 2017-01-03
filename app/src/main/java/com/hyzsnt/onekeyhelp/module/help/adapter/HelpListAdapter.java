package com.hyzsnt.onekeyhelp.module.help.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.help.bean.HelpList;
import com.hyzsnt.onekeyhelp.module.home.activity.HelpListActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/1/3.
 */

public class HelpListAdapter extends RecyclerView.Adapter<HelpListAdapter.HelpListHolder> {
    List<HelpList.ListEntry> data = new ArrayList<>();
    Context mContext;

    public HelpListAdapter(HelpListActivity helpListActivity) {
        mContext = helpListActivity;
    }

    public List<HelpList.ListEntry> getData() {
        return data;
    }

    public void setData(List<HelpList.ListEntry> data) {
        this.data = data;
    }


    @Override
    public HelpListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new HelpListHolder(LayoutInflater.from(mContext).inflate(R.layout.item_help_list, null));
    }

    @Override
    public void onBindViewHolder(HelpListHolder holder, final int position) {
        if (!data.isEmpty()) {
            //方式一 替换
            String phoneno = data.get(position).getPhoneno();
            phoneno = phoneno.replace(phoneno.substring(3, 7), "****");

            holder.phoneno.setText(phoneno);
            holder.objectname.setText(data.get(position).getObjcmname());
            if (data.get(position).getFlag().equals("0")) {
                holder.content.setText("求救未确认");
                holder.content.setTextColor(Color.parseColor("#FF0000"));
            } else if (data.get(position).getFlag().equals("1")) {
                holder.content.setText("求救完结");
            } else if (data.get(position).getFlag().equals("2")) {
                holder.content.setText("求救终止");
            } else if (data.get(position).getFlag().equals("3")) {
                holder.content.setText("求救过程中");
                holder.content.setTextColor(Color.parseColor("#FF0000"));
            }
            holder.nickname.setText(data.get(position).getNickname());
            holder.phonecall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri call = Uri.parse(data.get(position).getPhoneno());
                    Intent intent = new Intent(Intent.ACTION_CALL, call);
                    mContext.startActivity(intent);
                }
            });

        } else {

        }


    }

    @Override
    public int getItemCount() {
        if (!data.isEmpty()) {
            return data.size();
        }
        return 0;
    }

    class HelpListHolder extends RecyclerView.ViewHolder {
        ImageView mheadportaid;
        TextView phoneno;
        TextView objectname;
        TextView content;
        TextView nickname;
        ImageView phonecall;

        public HelpListHolder(View itemView) {
            super(itemView);
            mheadportaid = (ImageView) itemView.findViewById(R.id.help_list_headportraid);
            nickname = (TextView) itemView.findViewById(R.id.tv_help_list_nickname);
            content = (TextView) itemView.findViewById(R.id.tv_help_list_content);
            objectname = (TextView) itemView.findViewById(R.id.tv_help_list_objectname);
            phoneno = (TextView) itemView.findViewById(R.id.tv_help_list_phoneno);
            phonecall = (ImageView) itemView.findViewById(R.id.im_phone_call);
        }
    }
}
