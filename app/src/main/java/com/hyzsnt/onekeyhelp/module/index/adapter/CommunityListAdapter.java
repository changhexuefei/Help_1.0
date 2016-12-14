package com.hyzsnt.onekeyhelp.module.index.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.index.bean.CommunityList;

import java.util.List;

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
//            Bitmap bitmap = BitmapDescriptorFactory.fromResource(R.drawable.test).getBitmap();
//            Bitmap bit = BitmapUtils.toRoundBitmap(bitmap);
            itemViewHolder.mSeekCurcumHeadportrait.setImageResource(R.drawable.test);
//            itemViewHolder.mSeekCurcumHeadportrait.setImageBitmap(bit);
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
        ImageView mSeekCurcumHeadportrait;
        TextView tv_community_name;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_community_name= (TextView) itemView.findViewById(R.id.community_name);
            ivDetail = (ImageView) itemView.findViewById(R.id.iv_detail);
            mSeekCurcumHeadportrait = (ImageView) itemView.findViewById(R.id.seek_curcum_headportrait);
        }
    }

}
