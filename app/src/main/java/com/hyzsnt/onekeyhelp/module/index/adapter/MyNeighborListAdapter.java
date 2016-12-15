package com.hyzsnt.onekeyhelp.module.index.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.module.index.bean.MyNeighborInfo;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by gao on 2016/12/10.
 */

public class MyNeighborListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<MyNeighborInfo.ListBean> mNeighborInfos;
//    private static final int TYPE_ITEM = 1;
//    private static final int TYPE_FOOTER = 2;


    public void setNeighborInfos(List<MyNeighborInfo.ListBean> neighborInfos) {
        mNeighborInfos = neighborInfos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if (viewType == TYPE_ITEM) {

        View view = View.inflate(parent.getContext(), R.layout.item_neighbor, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ItemViewHolder(view);
//        }
//        if (viewType == TYPE_FOOTER) {
//            View view = View.inflate(parent.getContext(), R.layout.neighbor_list_footer_view, null);
//            view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
//                    RecyclerView.LayoutParams.WRAP_CONTENT));
//            return new FooterViewHolder(view);
//
//        }
//        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            Glide.with(App.getContext()).load(mNeighborInfos.get(position).getHeadportraid())
                    .into(itemViewHolder.iv_neighbor_icon);
            itemViewHolder.tv_neighbor_name.setText(mNeighborInfos.get(position).getNickname());
            itemViewHolder.tv_neighbor_age.setText(mNeighborInfos.get(position).getPhoneno());
            if (mNeighborInfos.get(position).getGender().equals("0")) {
                itemViewHolder.iv_neighbor_sex_icon.setImageResource(R.mipmap.man);
            } else {
                itemViewHolder.iv_neighbor_sex_icon.setImageResource(R.mipmap.woman);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mNeighborInfos.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_neighbor_name, tv_neighbor_age;
        CircleImageView iv_neighbor_icon;
        ImageView iv_neighbor_sex_icon;


        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_neighbor_name = (TextView) itemView.findViewById(R.id.neighbor_name);
            tv_neighbor_age = (TextView) itemView.findViewById(R.id.neighbor_age);
            iv_neighbor_icon = (CircleImageView) itemView.findViewById(R.id.neighbor_icon);
            iv_neighbor_sex_icon = (ImageView) itemView.findViewById(R.id.neighbor_sex_icon);


        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_footer;

        public FooterViewHolder(View itemView) {
            super(itemView);
            tv_footer = (TextView) itemView.findViewById(R.id.tv_footer);
        }
    }


}


