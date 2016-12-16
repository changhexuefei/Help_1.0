package com.hyzsnt.onekeyhelp.module.index.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.module.index.bean.CommunityList;

import java.text.DecimalFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.R.attr.format;

/**
 * Created by gao on 2016/12/14.
 */

public class CommunityListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CommunityList.ListBean> mCommunityLists;

    public void setCommunityLists(List<CommunityList.ListBean> communityLists) {
        mCommunityLists = communityLists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_seek, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            Glide.with(App.getContext()).load(R.drawable.test).into(itemViewHolder.mSeekCurcumHeadportrait);
            itemViewHolder.mSeekCurcumHeadportrait.setImageResource(R.drawable.test);
            double dis = Double.parseDouble(mCommunityLists.get(position).getDistance());
            DecimalFormat df = new DecimalFormat("######0"); //四色五入转换成整数
            String distance = df.format(dis);
            itemViewHolder.tv_community_distance.setText(distance+" 米");

            itemViewHolder.tv_community_name.setText(mCommunityLists.get(position).getCmname());
//            itemViewHolder.homeIvDetail.setImageResource(mCommunityLists.get(position).getNeighborSexIcon());
        }
    }

    @Override
    public int getItemCount() {
        return mCommunityLists.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView ivDetail;
        CircleImageView mSeekCurcumHeadportrait;
        TextView tv_community_distance,tv_community_name;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_community_name = (TextView) itemView.findViewById(R.id.community_name);
            tv_community_distance = (TextView) itemView.findViewById(R.id.community_distance);
            ivDetail = (ImageView) itemView.findViewById(R.id.iv_detail);
            mSeekCurcumHeadportrait = (CircleImageView) itemView.findViewById(R.id.seek_curcum_headportrait);
        }
    }

}
