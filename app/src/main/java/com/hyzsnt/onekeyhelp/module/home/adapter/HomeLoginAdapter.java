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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (position == 0) {
            if (holder instanceof HomeLoginViewHolder0) {
                HomeLoginHeadAdapter homeHeadAdapter = new HomeLoginHeadAdapter(mContext);
                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
                layoutManager.setOrientation(LinearLayout.HORIZONTAL);
                ((HomeLoginViewHolder0) holder).homeLoginItemHomeheadRlv.setLayoutManager(layoutManager);
                ((HomeLoginViewHolder0) holder).homeLoginItemHomeheadRlv.setAdapter(homeHeadAdapter);
                ((HomeLoginViewHolder0) holder).homeLoginItemHomeheadRlv.setItemAnimator(new DefaultItemAnimator());

                //我的邻居
                List params = new ArrayList<String>();
                params.add("2803");//2061  2803
                params.add("8");
                params.add("1");
                //params.add("15551675396");//15551675396
                HttpUtils.post(Api.COMMUNITY, Api.Community.GETMEMBERLISTBYCOMMUNITY, params, new ResponseHandler() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onSuccess(String response, int id) {

                        final ArrayList<MDate> memberListByCommunity = Resovle.getMemberListByCommunity(response);
                        Log.e("+++++Login++++++", memberListByCommunity + "");
                        if (memberListByCommunity.size() > 0) {
                            int sum = Integer.valueOf(memberListByCommunity.get(0).getmInfo().getCommunityListInfo().getTotalnum());
                            ((HomeLoginViewHolder0) holder).homeLoginItemHeadTvNeighbor.setText(sum + "人");
                            //进入邻居详情页
                            ((HomeLoginViewHolder0) holder).homeLoginItemHeadIvNeighbor.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable("memberListByCommunity", memberListByCommunity);
                                    Intent i = new Intent(mContext, MyNeighborListActivity.class);
                                    i.putExtras(bundle);
                                    mContext.startActivity(i);
                                }
                            });
                        }
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {

                    }
                });

                //动态筛选
                ((HomeLoginViewHolder0) holder).homeLoginItemheadIvDynamicselect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View popupView = View.inflate(mContext,R.layout.item_item_home_login_head_pop, null);
                        PopupWindow mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT, true);
                        mPopupWindow.setTouchable(true);
                        mPopupWindow.setOutsideTouchable(true);
                        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(mContext.getResources(), (Bitmap) null));
                        int xView=((HomeLoginViewHolder0) holder).homeLoginItemheadIvDynamicselect.getHeight();
                        int yView=((HomeLoginViewHolder0) holder).homeLoginItemheadIvDynamicselect.getWidth();
                        mPopupWindow.showAsDropDown(((HomeLoginViewHolder0) holder).homeLoginItemheadIvDynamicselect);
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
        if (dates.size() > 0) {
            if (dates.get(0).getmList().getDynamicListByCommunityLists().size() > 0) {
                return dates.get(0).getmList().getDynamicListByCommunityLists().size();
            }
        }
        return 1;
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
        public RecyclerView homeLoginItemHomeheadRlv;
        public ImageView homeLoginItemHeadIvNeighbor;
        public TextView homeLoginItemHeadTvNeighbor;
        public ImageView homeLoginItemheadIvDynamicselect;
        public HomeLoginViewHolder0(View itemView) {
            super(itemView);
            homeLoginItemHomeheadRlv = (RecyclerView) itemView.findViewById(R.id.home_login_item_homehead_rlv);
            homeLoginItemHeadIvNeighbor = (ImageView) itemView.findViewById(R.id.home_login_item_head_iv_neighbor);
            homeLoginItemHeadTvNeighbor = (TextView) itemView.findViewById(R.id.home_login_item_head_tv_neighbor);
            homeLoginItemheadIvDynamicselect= (ImageView) itemView.findViewById(R.id.home_login_itemhead_iv_dynamicselect);
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
