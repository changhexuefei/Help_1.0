package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.HomeCircle;
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
    private ArrayList<MDate> dates = new ArrayList<>();

    public HomeUnLoginAdapter(Context mContext) {
        this.mContext = mContext;

    }

    public ArrayList<MDate> getDates() {
        return dates;
    }

    public void setDates(ArrayList<MDate> dates) {
        this.dates = dates;
        Log.e("3333333333333", dates.toString());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_home_circum, parent, false);
            return new HomeViewHolder1(v0);
        } else {

            return null;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CommunityListList communityListList = dates.get(0).getmList().getCommunityListLists().get(position);
        if (getItemViewType(position) == 0) {
            if (holder instanceof HomeViewHolder1) {
                ((HomeViewHolder1) holder).homeUnListTvCmanem.setText(communityListList.getCmname());

                Bitmap bit = BitmapDescriptorFactory.fromResource(R.drawable.img).getBitmap();
                Bitmap bitmap1 = BitmapUtils.toRoundBitmap(bit);
                ((HomeViewHolder1) holder).mHomeCurcumHeadportrait.setImageBitmap(bitmap1);
                ((HomeViewHolder1) holder).homeUnListTvCurnum.setText(communityListList.getCurnum() + "人");
                //热门圈子
                ArrayList<HomeCircle> homeCircleList = communityListList.getHomeCircleList();
                if(homeCircleList !=null){
                    if(homeCircleList.size()==0){
                        ((HomeViewHolder1) holder).rl0.setVisibility(View.GONE);
                        ((HomeViewHolder1) holder).rl1.setVisibility(View.GONE);
                        ((HomeViewHolder1) holder).rl2.setVisibility(View.GONE);
                    }else if(homeCircleList.size()==1){
                        ((HomeViewHolder1) holder).rl1.setVisibility(View.GONE);
                        ((HomeViewHolder1) holder).rl2.setVisibility(View.GONE);
                    }else if(homeCircleList.size()==2){
                        ((HomeViewHolder1) holder).rl2.setVisibility(View.GONE);
                    }else {

                    }
                    for(int i = 0; i< homeCircleList.size(); i++){
                        HomeCircle homeCircle = homeCircleList.get(i);
                        if(i==0){
                            ((HomeViewHolder1) holder).homeCircleTvCcname0.setText(homeCircle.getCcname()+"");
                            ((HomeViewHolder1) holder).homeCircleTvCurnum0.setText(homeCircle.getCurnum()+"人");
                        }else if(i==1){
                            ((HomeViewHolder1) holder).homeCircleTvCcname1.setText(homeCircle.getCcname()+"");
                            ((HomeViewHolder1) holder).homeCircleTvCurnum1.setText(homeCircle.getCurnum()+"人");
                        }else if(i==2){
                            ((HomeViewHolder1) holder).homeCircleTvCcname2.setText(homeCircle.getCcname()+"");
                            ((HomeViewHolder1) holder).homeCircleTvCurnum2.setText(homeCircle.getCurnum()+"人");
                        }
                    }
                }


                ((HomeViewHolder1) holder).homeIvDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        List params = new ArrayList<String>();
                        params.add(2061 + "");//2061  2803
                        params.add(5 + "");
                        HttpUtils.post(Api.COMMUNITY, Api.Community.GETCOMMUNITYINFO, params, new ResponseHandler() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                            }

                            @Override
                            public void onSuccess(String response, int id) {
                                ArrayList<MDate> communityInfoList = Resovle.getCommunityInfo(response);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("communityInfoList", communityInfoList);
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
        } else {

        }
    }

    @Override
    public int getItemCount() {
        if (dates.size() > 0) {
            if (dates.get(0).getmList().getCommunityListLists().size() > 0) {
                return dates.get(0).getmList().getCommunityListLists().size();
            }
        }
        return 0;
    }

    static class HomeViewHolder1 extends RecyclerView.ViewHolder {
        public ImageView homeIvDetail;
        public ImageView mHomeCurcumHeadportrait;
        public TextView homeUnListTvCmanem;
        public TextView homeUnListTvCurnum;
        ImageView homeCircleIvCccover0;
        TextView homeCircleTvCcname0;
        TextView homeCircleTvCurnum0;
        ImageView homeCircleIvCccover1;
        TextView homeCircleTvCcname1;
        TextView homeCircleTvCurnum1;
        ImageView homeCircleIvCccover2;
        TextView homeCircleTvCcname2;
        TextView homeCircleTvCurnum2;
        RelativeLayout rl0;
        RelativeLayout rl1;
        RelativeLayout rl2;

        public HomeViewHolder1(View itemView) {
            super(itemView);
            homeIvDetail = (ImageView) itemView.findViewById(R.id.home_iv_detail);
            mHomeCurcumHeadportrait = (ImageView) itemView.findViewById(R.id.home_un_list_iv_cmcover);
            homeUnListTvCmanem = (TextView) itemView.findViewById(R.id.home_un_list_tv_cmanem);
            homeUnListTvCurnum = (TextView) itemView.findViewById(R.id.home_un_list_tv_curnum);

            homeCircleIvCccover0 = (ImageView) itemView.findViewById(R.id.home_circle_iv_cccover0);
            homeCircleTvCcname0 = (TextView) itemView.findViewById(R.id.home_circle_tv_ccname0);
            homeCircleTvCurnum0 = (TextView) itemView.findViewById(R.id.home_circle_tv_curnum0);

            homeCircleIvCccover1 = (ImageView) itemView.findViewById(R.id.home_circle_iv_cccover1);
            homeCircleTvCcname1 = (TextView) itemView.findViewById(R.id.home_circle_tv_ccname1);
            homeCircleTvCurnum1 = (TextView) itemView.findViewById(R.id.home_circle_tv_curnum1);

            homeCircleIvCccover2 = (ImageView) itemView.findViewById(R.id.home_circle_iv_cccover2);
            homeCircleTvCcname2 = (TextView) itemView.findViewById(R.id.home_circle_tv_ccname2);
            homeCircleTvCurnum2 = (TextView) itemView.findViewById(R.id.home_circle_tv_curnum2);

            rl0= (RelativeLayout) itemView.findViewById(R.id.rl0);
            rl1= (RelativeLayout) itemView.findViewById(R.id.rl1);
            rl2= (RelativeLayout) itemView.findViewById(R.id.rl2);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 0;
        }
    }
}
