package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.activity.VoiceDetailActivity;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.inner.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

/**
 * Created by hyzs on 2016/12/11.
 */

public class HomeLoginAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private MainActivity activity;
    private OnRecyclerViewItemClickListener mOnItemClickListener;
    private ArrayList<MDate> dates = new ArrayList<>();

    public HomeLoginAdapter(Context mContext) {
        this.mContext = mContext;
        activity = (MainActivity) mContext;
    }

    public ArrayList<MDate> getDates() {
        return dates;
    }

    public void setDates(ArrayList<MDate> dates) {
        this.dates = dates;
    }

    //条目电击事件
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_head, parent, false);
            return new HomeLoginViewHolder0(v0);
        } else if (viewType == 1) {
            View v1 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_1, parent, false);
            return new HomeLoginViewHolder1(v1);
        } else {
            View v2 = LayoutInflater.from(mContext).inflate(R.layout.item_home_login_2, parent, false);
            return new HomeLoginViewHolder2(v2);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (position == 0) {
            if (holder instanceof HomeLoginViewHolder0) {
                HomeLoginHeadAdapter homeHeadAdapter = new HomeLoginHeadAdapter(mContext);
                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
                layoutManager.setOrientation(LinearLayout.HORIZONTAL);
                ((HomeLoginViewHolder0) holder).itemItemHeadRLV.setLayoutManager(layoutManager);
                ((HomeLoginViewHolder0) holder).itemItemHeadRLV.setAdapter(homeHeadAdapter);
                ((HomeLoginViewHolder0) holder).itemItemHeadRLV.setItemAnimator(new DefaultItemAnimator());

                //我的邻居
                List params = new ArrayList<String>();
                params.add(2061+"");//2061  2803
                params.add(5+"");
                params.add(1+"");
                params.add("155****5396");//15551675396
                HttpUtils.post(Api.COMMUNITY, Api.Community.GETMEMBERLISTBYCOMMUNITY, params, new ResponseHandler() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        Log.e("+++++++++++",response+"");
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {

                    }
                });
                ((HomeLoginViewHolder0) holder).homeLoginivNeighbor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        } else if (position == 1) {
            if (holder instanceof HomeLoginViewHolder1) {
                ((HomeLoginViewHolder1) holder).ivVoice.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(mContext, VoiceDetailActivity.class);
                        mContext.startActivity(i);
                    }
                });
            }
        } else if (position > 1) {
            if (holder instanceof HomeLoginViewHolder2) {
                ((HomeLoginViewHolder2) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onItemClick(v, position);
                    }
                });
            }
        }

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    static class HomeLoginViewHolder0 extends RecyclerView.ViewHolder {
        public RecyclerView itemItemHeadRLV;
        @BindView(R.id.home_loginiv_neighbor)
        ImageView homeLoginivNeighbor;
        public HomeLoginViewHolder0(View itemView) {
            super(itemView);
            itemItemHeadRLV = (RecyclerView) itemView.findViewById(R.id.item_homehead_rlv);

        }
    }

    static class HomeLoginViewHolder1 extends RecyclerView.ViewHolder {
        public ImageView ivVoice;

        public HomeLoginViewHolder1(View itemView) {
            super(itemView);
            ivVoice = (ImageView) itemView.findViewById(R.id.home_login_iv_voice);
        }
    }

    static class HomeLoginViewHolder2 extends RecyclerView.ViewHolder {
        public HomeLoginViewHolder2(View itemView) {
            super(itemView);
        }
    }
}
