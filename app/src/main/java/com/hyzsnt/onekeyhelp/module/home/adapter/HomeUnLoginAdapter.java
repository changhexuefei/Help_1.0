package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityListList;
import com.hyzsnt.onekeyhelp.module.home.bean.HomeCircle;
import com.hyzsnt.onekeyhelp.module.home.bean.LoginCommunity;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.bean.UserInfoInfo;
import com.hyzsnt.onekeyhelp.module.home.fragment.HomeLoginFragment;
import com.hyzsnt.onekeyhelp.module.home.fragment.HomeUnLoginFragment;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.index.activity.CompoundInfoActivity;
import com.hyzsnt.onekeyhelp.utils.BitmapUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

/**
 * Created by hyzs on 2016/12/10.
 */

public class HomeUnLoginAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<MDate> dates = new ArrayList<>();
    private String uid;
    private MainActivity activity;
    public HomeUnLoginAdapter(Context mContext) {
        this.mContext = mContext;
        activity = (MainActivity) mContext;

        String userDetail = (String) SPUtils.get(mContext, "userDetail", "");
        ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
        UserInfoInfo userInfoInfo = userInfo.get(0).getmInfo().getUserInfoInfo();
        uid = userInfoInfo.getUid();

    }

    public ArrayList<MDate> getDates() {
        return dates;
    }

    public void setDates(ArrayList<MDate> dates) {
        this.dates = dates;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_home_circum, parent, false);
            return new HomeViewHolder1(v0);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CommunityListList communityListList = dates.get(0).getmList().getCommunityListLists().get(position);
        final String cmid = communityListList.getCmid();
        if (getItemViewType(position) == 1) {
            if (holder instanceof HomeViewHolder1) {
                ((HomeViewHolder1) holder).homeUnListTvCmanem.setText(communityListList.getCmname());
                //加入小区
                ((HomeViewHolder1) holder).homeUnBtJoin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent i = new Intent(mContext, CompoundInfoActivity.class);
//                        mContext.startActivity(i);
                        List params = new ArrayList<String>();
                        params.add(uid);
                        params.add(cmid);//2061  2803
                        HttpUtils.post(Api.USER, Api.User.JOINCOMMUNITY,params, new ResponseHandler() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                            }
                            @Override
                            public void onSuccess(String response, int id) {
                                ArrayList<MDate> joinCommunity = Resovle.getJoinCommunity(response);
                                String res = joinCommunity.get(0).getRes();
                                if("0".equals(res)){
                                    ToastUtils.showLong(mContext,"加入失败" );
                                }else if("1".equals(res)){
                                    //修改用户信息
                                    writeUser();
                                    //activity.checkJoinComunnity();
                                    //查询小区信息
                                    List paramsDetail = new ArrayList<String>();
                                    paramsDetail.add(cmid);//2061  2803
                                    paramsDetail.add(uid);
                                    HttpUtils.post(Api.COMMUNITY, Api.Community.GETCOMMUNITYINFO, paramsDetail, new ResponseHandler() {
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

                            }

                            @Override
                            public void inProgress(float progress, long total, int id) {

                            }
                        });
                    }
                });
                Bitmap bit = BitmapDescriptorFactory.fromResource(R.drawable.img).getBitmap();
                Bitmap bitmap1 = BitmapUtils.toRoundBitmap(bit);
                ((HomeViewHolder1) holder).mHomeCurcumHeadportrait.setImageBitmap(bitmap1);
                ((HomeViewHolder1) holder).homeUnListTvCurnum.setText(communityListList.getCurnum() + "人");
                //热门圈子
                ArrayList<HomeCircle> homeCircleList = communityListList.getHomeCircleList();
                if (homeCircleList != null) {
                    if (homeCircleList.size() == 0) {
                        ((HomeViewHolder1) holder).rl0.setVisibility(View.GONE);
                        ((HomeViewHolder1) holder).rl1.setVisibility(View.GONE);
                        ((HomeViewHolder1) holder).rl2.setVisibility(View.GONE);
                    } else if (homeCircleList.size() == 1) {
                        ((HomeViewHolder1) holder).rl1.setVisibility(View.GONE);
                        ((HomeViewHolder1) holder).rl2.setVisibility(View.GONE);
                    } else if (homeCircleList.size() == 2) {
                        ((HomeViewHolder1) holder).rl2.setVisibility(View.GONE);
                    } else {

                    }
                    for (int i = 0; i < homeCircleList.size(); i++) {
                        HomeCircle homeCircle = homeCircleList.get(i);
                        if (i == 0) {
                            ((HomeViewHolder1) holder).homeCircleTvCcname0.setText(homeCircle.getCcname() + "");
                            ((HomeViewHolder1) holder).homeCircleTvCurnum0.setText(homeCircle.getCurnum() + "人");
                        } else if (i == 1) {
                            ((HomeViewHolder1) holder).homeCircleTvCcname1.setText(homeCircle.getCcname() + "");
                            ((HomeViewHolder1) holder).homeCircleTvCurnum1.setText(homeCircle.getCurnum() + "人");
                        } else if (i == 2) {
                            ((HomeViewHolder1) holder).homeCircleTvCcname2.setText(homeCircle.getCcname() + "");
                            ((HomeViewHolder1) holder).homeCircleTvCurnum2.setText(homeCircle.getCurnum() + "人");
                        }
                    }
                } else {
                    ((HomeViewHolder1) holder).rl0.setVisibility(View.GONE);
                    ((HomeViewHolder1) holder).rl1.setVisibility(View.GONE);
                    ((HomeViewHolder1) holder).rl2.setVisibility(View.GONE);
                }
                ((HomeViewHolder1) holder).homeIvDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //查询小区信息
                        List params = new ArrayList<String>();
                        params.add(cmid);//2061  2803
                        params.add(uid);
                        Log.e("44444444444-------",cmid+"--"+uid);
                        HttpUtils.post(Api.COMMUNITY, Api.Community.GETCOMMUNITYINFO, params, new ResponseHandler() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                            }
                            @Override
                            public void onSuccess(String response, int id) {
                                Log.e("44444444444-------","--"+response);
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

    private void writeUser() {
        String userDetail = (String) SPUtils.get(mContext,"userDetail","");
        ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
        String uid = userInfo.get(0).getmInfo().getUserInfoInfo().getUid();
        List params0 = new ArrayList<String>();
        params0.add(uid);
        HttpUtils.post(Api.USER, Api.User.GETUSERINFO, params0, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onSuccess(String response, int id) {
                SPUtils.put(mContext, "userDetail", response);

            }

            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });

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
        Button homeUnBtJoin;
        public HomeViewHolder1(View itemView) {
            super(itemView);
            homeIvDetail = (ImageView) itemView.findViewById(R.id.home_iv_detail);
            mHomeCurcumHeadportrait = (ImageView) itemView.findViewById(R.id.home_un_list_iv_cmcover);
            homeUnListTvCmanem = (TextView) itemView.findViewById(R.id.home_un_list_tv_cmanem);
            homeUnListTvCurnum = (TextView) itemView.findViewById(R.id.home_un_list_tv_curnum);
            homeUnBtJoin= (Button) itemView.findViewById(R.id.home_un_bt_join);

            homeCircleIvCccover0 = (ImageView) itemView.findViewById(R.id.home_circle_iv_cccover0);
            homeCircleTvCcname0 = (TextView) itemView.findViewById(R.id.home_circle_tv_ccname0);
            homeCircleTvCurnum0 = (TextView) itemView.findViewById(R.id.home_circle_tv_curnum0);

            homeCircleIvCccover1 = (ImageView) itemView.findViewById(R.id.home_circle_iv_cccover1);
            homeCircleTvCcname1 = (TextView) itemView.findViewById(R.id.home_circle_tv_ccname1);
            homeCircleTvCurnum1 = (TextView) itemView.findViewById(R.id.home_circle_tv_curnum1);

            homeCircleIvCccover2 = (ImageView) itemView.findViewById(R.id.home_circle_iv_cccover2);
            homeCircleTvCcname2 = (TextView) itemView.findViewById(R.id.home_circle_tv_ccname2);
            homeCircleTvCurnum2 = (TextView) itemView.findViewById(R.id.home_circle_tv_curnum2);

            rl0 = (RelativeLayout) itemView.findViewById(R.id.rl0);
            rl1 = (RelativeLayout) itemView.findViewById(R.id.rl1);
            rl2 = (RelativeLayout) itemView.findViewById(R.id.rl2);
        }
    }
    @Override
    public int getItemViewType(int position) {
        if(position>=0){
            return 1;
        }else{
            return -1;
        }

    }
}
