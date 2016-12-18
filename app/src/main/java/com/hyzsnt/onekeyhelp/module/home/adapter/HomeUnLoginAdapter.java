package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityListList;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.index.activity.CompoundInfoActivity;
import com.hyzsnt.onekeyhelp.utils.BitmapUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by hyzs on 2016/12/10.
 */

public class HomeUnLoginAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private View v1;
    private View v2;
    private ArrayList<MDate> dates=new ArrayList<>();
    public HomeUnLoginAdapter(Context mContext) {
        this.mContext = mContext;

    }

    public ArrayList<MDate> getDates() {
        return dates;
    }

    public void setDates(ArrayList<MDate> dates) {
        this.dates = dates;
        //Log.e("3333333333333", dates.toString());
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
        CommunityListList communityListList = dates.get(0).getmList().getCommunityListLists().get(position);
        if (getItemViewType(position) == 0) {

        } else {
            if (holder instanceof HomeViewHolder2) {
                ((HomeViewHolder2) holder).homeUnListTvCmanem.setText(communityListList.getCmname());

                Bitmap bit= BitmapDescriptorFactory.fromResource(R.drawable.img).getBitmap();
                Bitmap bitmap1=BitmapUtils.toRoundBitmap(bit);
                ((HomeViewHolder2) holder).mHomeCurcumHeadportrait.setImageBitmap(bitmap1);

                ((HomeViewHolder2) holder).homeIvDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        List params = new ArrayList<String>();
                        params.add(2061+"");//2061  2803
                        params.add(5+"");
                        HttpUtils.post(Api.COMMUNITY, Api.Community.GETCOMMUNITYINFO, params, new ResponseHandler() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                            }

                            @Override
                            public void onSuccess(String response, int id) {
                                ArrayList<MDate> communityInfoList = Resovle.getCommunityInfo(response);
                                Bundle bundle=new Bundle();
                                bundle.putSerializable("communityInfoList",communityInfoList);
                                Intent i = new Intent(mContext, CompoundInfoActivity.class);
                                i.putExtras(bundle);
                                mContext.startActivity(i);
                            }
                            @Override
                            public void inProgress(float progress, long total, int id) {
                            }
                        });


                    }
                });

            }
        }
    }


    @Override
    public int getItemCount() {
        if(dates.size()>0){
            if(dates.get(0).getmList().getCommunityListLists().size()>0){
                return dates.get(0).getmList().getCommunityListLists().size();
            }
        }
        return 0;
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
        public TextView homeUnListTvCmanem;
        public HomeViewHolder2(View itemView) {
            super(itemView);
            homeIvDetail = (ImageView) itemView.findViewById(R.id.home_iv_detail);
            mHomeCurcumHeadportrait= (ImageView) itemView.findViewById(R.id.home_curcum_headportrait);
            homeUnListTvCmanem= (TextView) itemView.findViewById(R.id.home_un_list_tv_cmanem);
        }
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return 1;
        }
    }
}
