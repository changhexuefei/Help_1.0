package com.hyzsnt.onekeyhelp.module.search.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.search.bean.CommunityResultBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;



public class CommunityListAdapter extends RecyclerView.Adapter<CommunityListAdapter.MyViewHolder> {

    private Context mContext;
    private CommunityResultBean mResultBean;


    public CommunityListAdapter(Context context, CommunityResultBean communityResultBean) {
        mContext = context;
        mResultBean = communityResultBean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_community, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CommunityResultBean.ListBean bean = mResultBean.getList().get(position);
        holder.mSearchCommunityName.setText(bean.getCmname());
        holder.mSearchCommunityNumber.setText(bean.getCurnum() + "人");
    }

    @Override
    public int getItemCount() {
        List<CommunityResultBean.ListBean> list = mResultBean.getList();
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.search_community_icon)
        CircleImageView mSearchCommunityIcon;
        @BindView(R.id.search_community_name)
        TextView mSearchCommunityName;
        @BindView(R.id.search_community_number)
        TextView mSearchCommunityNumber;
        @BindView(R.id.search_community_join)
        Button mSearchCommunityJoin;
        @BindView(R.id.search_community_abs)
        TextView mSearchCommunityAbs;
        @BindView(R.id.search_community_circle)
        TextView mSearchCommunityCircle;
        @BindView(R.id.search_community_circle1_type)
        TextView mSearchCommunityCircle1Type;
        @BindView(R.id.search_community_circle1_number)
        TextView mSearchCommunityCircle1Number;
        @BindView(R.id.search_community_circle1_bac)
        ImageView mSearchCommunityCircle1Bac;
        @BindView(R.id.search_community_circle2_bac)
        ImageView mSearchCommunityCircle2Bac;
        @BindView(R.id.search_community_circle2_type)
        TextView mSearchCommunityCircle2Type;
        @BindView(R.id.search_community_circle2_number)
        TextView mSearchCommunityCircle2Number;
        @BindView(R.id.search_community_circle3_bac)
        ImageView mSearchCommunityCircle3Bac;
        @BindView(R.id.search_community_circle3_type)
        TextView mSearchCommunityCircle3Type;
        @BindView(R.id.search_community_circle3_number)
        TextView mSearchCommunityCircle3Number;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
