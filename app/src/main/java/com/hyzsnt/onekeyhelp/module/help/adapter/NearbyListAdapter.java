package com.hyzsnt.onekeyhelp.module.help.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.help.bean.NearbyBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 14369 on 2016/12/27.
 */

public class NearbyListAdapter extends RecyclerView.Adapter<NearbyListAdapter.MyViewHolder> {

    private Context context;
    private NearbyBean nearbyBean;

    public NearbyListAdapter(Context context, NearbyBean nearbyBean) {
        this.context = context;
        this.nearbyBean = nearbyBean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fragment_help, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final NearbyBean.ListBean bean = nearbyBean.getList().get(position);

        holder.mTvItemHelpNick.setText(bean.getNickname());
        holder.mTvItemHelpPhone.setText(bean.getNickname());
        Glide.with(context).load(bean.getHeadportraid()).into(holder.mIvItemHelpIcon);
        holder.mBtnItemHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + bean.getPhoneno()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        List<NearbyBean.ListBean> list = nearbyBean.getList();
        return list == null ? 0 : list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_item_help_icon)
        CircleImageView mIvItemHelpIcon;
        @BindView(R.id.tv_item_help_nick)
        TextView mTvItemHelpNick;
        @BindView(R.id.tv_item_help_phone)
        TextView mTvItemHelpPhone;
        @BindView(R.id.btn_item_help)
        Button mBtnItemHelp;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
