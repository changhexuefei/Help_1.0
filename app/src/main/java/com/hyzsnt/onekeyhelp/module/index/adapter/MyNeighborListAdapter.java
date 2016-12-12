package com.hyzsnt.onekeyhelp.module.index.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.index.bean.MyNeighborInfo;

import java.util.List;

/**
 * Created by gao on 2016/12/10.
 */

public class MyNeighborListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MyNeighborInfo> mNeighborInfos;
//    private static final int TYPE_ITEM = 1;
//    private static final int TYPE_FOOTER = 2;

    public void setNeighborInfos(List<MyNeighborInfo> neighborInfos) {
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
            itemViewHolder.iv_neighbor_icon.setImageResource(mNeighborInfos.get(position).getNeighborIcon());
            itemViewHolder.tv_neighbor_name.setText(mNeighborInfos.get(position).getNeighborName());
            itemViewHolder.tv_neighbor_age.setText(mNeighborInfos.get(position).getNeighborAge());
            itemViewHolder.iv_neighbor_sex_icon.setImageResource(mNeighborInfos.get(position).getNeighborSexIcon());
        }
    }

    @Override
    public int getItemCount() {
        return mNeighborInfos.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_neighbor_name, tv_neighbor_age;
        ImageView iv_neighbor_icon, iv_neighbor_sex_icon;


        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_neighbor_name = (TextView) itemView.findViewById(R.id.neighbor_name);
            tv_neighbor_age = (TextView) itemView.findViewById(R.id.neighbor_age);
            iv_neighbor_icon = (ImageView) itemView.findViewById(R.id.neighbor_icon);
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


