package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.index.activity.CompoundInfoActivity;
import com.hyzsnt.onekeyhelp.utils.BitmapUtils;

/**
 * Created by hyzs on 2016/12/10.
 */

public class HomeUnLoginAdapter extends RecyclerView.Adapter {
    private RecyclerView homeLrvHead;
    private Context mContext;
    private MainActivity activity;
    private View v1;
    private View v2;

    public HomeUnLoginAdapter(Context mContext) {
        this.mContext = mContext;
        activity = (MainActivity) mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            v1 = LayoutInflater.from(mContext).inflate(R.layout.item_home_lrv_head, parent, false);
            return new HomeViewHolder1(v1);
        } else {
            v2 = LayoutInflater.from(mContext).inflate(R.layout.item_home_circum, parent, false);
            return new HomeViewHolder2(v2);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            homeLrvHead = (RecyclerView) v1.findViewById(R.id.home_lrv_head);
            HomeUnLoginHeadAdapter homeHeadAdapter = new HomeUnLoginHeadAdapter(mContext);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
            layoutManager.setOrientation(LinearLayout.HORIZONTAL);
            homeLrvHead.setLayoutManager(layoutManager);
            homeLrvHead.setAdapter(homeHeadAdapter);
            homeLrvHead.setItemAnimator(new DefaultItemAnimator());
        } else {
            if (holder instanceof HomeViewHolder2) {
                Bitmap bit= BitmapDescriptorFactory.fromResource(R.drawable.img).getBitmap();
                Bitmap bitmap1=BitmapUtils.toRoundBitmap(bit);
                ((HomeViewHolder2) holder).mHomeCurcumHeadportrait.setImageBitmap(bitmap1);
                ((HomeViewHolder2) holder).homeIvDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(mContext, CompoundInfoActivity.class);
                        activity.startActivity(i);
                    }
                });
            }
        }
    }


    @Override
    public int getItemCount() {
        return 20;
    }

    static class HomeViewHolder1 extends RecyclerView.ViewHolder {
        private RecyclerView rv;

        public HomeViewHolder1(View itemView) {
            super(itemView);

        }
    }

    static class HomeViewHolder2 extends RecyclerView.ViewHolder {
        public ImageView homeIvDetail;
        public ImageView mHomeCurcumHeadportrait;
        public HomeViewHolder2(View itemView) {
            super(itemView);

            homeIvDetail = (ImageView) itemView.findViewById(R.id.home_iv_detail);
            mHomeCurcumHeadportrait= (ImageView) itemView.findViewById(R.id.home_curcum_headportrait);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
