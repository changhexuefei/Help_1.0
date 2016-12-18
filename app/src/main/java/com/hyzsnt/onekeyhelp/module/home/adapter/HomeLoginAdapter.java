package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.activity.VoiceDetailActivity;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.inner.OnRecyclerViewItemClickListener;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.index.activity.MyNeighborListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

/**
 * Created by hyzs on 2016/12/11.
 */

public class HomeLoginAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<MDate> dates = new ArrayList<>();

    public HomeLoginAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public ArrayList<MDate> getDates() {
        return dates;
    }

    public void setDates(ArrayList<MDate> dates) {
        this.dates = dates;
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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (position == 0) {
            if (holder instanceof HomeLoginViewHolder0) {

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

            }
        }

    }

    @Override
    public int getItemCount() {
        if (dates.size() > 0) {
            if (dates.get(0).getmList().getDynamicListByCommunityLists().size() > 0) {
                return dates.get(0).getmList().getDynamicListByCommunityLists().size();
            }
        }
        return 1;
    }

    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    static class HomeLoginViewHolder0 extends RecyclerView.ViewHolder {
        public HomeLoginViewHolder0(View itemView) {
            super(itemView);
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
