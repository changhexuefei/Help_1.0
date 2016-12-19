package com.hyzsnt.onekeyhelp.module.home.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.view.CommonHeader;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.activity.StateActivity;
import com.hyzsnt.onekeyhelp.module.home.adapter.DynamicKindsAdapter;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeLoginAdapter;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeLoginHeadAdapter;
import com.hyzsnt.onekeyhelp.module.home.adapter.LoginCommunityAdapter;
import com.hyzsnt.onekeyhelp.module.home.bean.DynamicListByCommunityList;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.index.activity.CompoundInfoActivity;
import com.hyzsnt.onekeyhelp.module.index.activity.MyNeighborListActivity;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeLoginFragment extends BaseFragment {
    @BindView(R.id.home_login_iv_swich)
    ImageView homeLoginIvSwich;
    @BindView(R.id.home_login_lrv)
    LRecyclerView homeLoginLrv;

    private RecyclerView homeLoginItemHomeheadRlv;
    private ImageView homeLoginItemHeadIvNeighbor;
    private TextView homeLoginItemHeadTvNeighbor;
    private ImageView homeLoginItemheadIvDynamicselect;
    private ArrayList<MDate> dynamicListByCommunitys;
    private HomeLoginAdapter mHomeLoginAdapter;
    public HomeLoginFragment() {
        // Required empty public constructor
    }

    @Override
    protected List<String> getParams() {
        return null;
    }

    @Override
    protected void initData(String content) {
        //切换小区
        List params0 = new ArrayList<String>();
        params0.add("8");
        //params.add("2061");//2061  2803
        HttpUtils.post(Api.USER, Api.User.GETUSERINFO, params0, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onSuccess(String response, int id) {
                final ArrayList<MDate> loginCommunities = Resovle.getUserInfo(response);
                homeLoginIvSwich.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View popupView = View.inflate(getActivity(), R.layout.item_item_home_login_head_pop, null);
                        final PopupWindow mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                        mPopupWindow.setTouchable(true);
                        mPopupWindow.setOutsideTouchable(true);
                        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getActivity().getResources(), (Bitmap) null));
                        mPopupWindow.showAsDropDown(homeLoginIvSwich);
                        LRecyclerView pop_rv = (LRecyclerView) popupView.findViewById(R.id.item_item_head_pop_rlv);
                        final LoginCommunityAdapter loginCommunityAdapter = new LoginCommunityAdapter(getActivity());
                        pop_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                        LRecyclerViewAdapter adapter=new LRecyclerViewAdapter(loginCommunityAdapter);
                        pop_rv.setAdapter(adapter);
                        pop_rv.setItemAnimator(new DefaultItemAnimator());
                        loginCommunityAdapter.setDates(loginCommunities);
                        loginCommunityAdapter.notifyDataSetChanged();
                        adapter.setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                List paramsSwich = new ArrayList<String>();
                                paramsSwich.add("8");
                                String cmid = loginCommunities.get(0).getmList().getLoginCommunities().get(position).getCmid();
                                paramsSwich.add(cmid);//2061  2803
                                HttpUtils.post(Api.USER, Api.User.SWITCHCOMMUNITY, paramsSwich, new ResponseHandler() {
                                    @Override
                                    public void onError(Call call, Exception e, int id) {

                                    }

                                    @Override
                                    public void onSuccess(String response, int id) {
                                        ToastUtils.showShort(getActivity(),response);
                                        dynamicListByCommunitys = Resovle.getDynamicListByCommunity(response);
                                        mHomeLoginAdapter.setDates(dynamicListByCommunitys);
                                        mHomeLoginAdapter.notifyDataSetChanged();
                                        mPopupWindow.dismiss();
                                    }

                                    @Override
                                    public void inProgress(float progress, long total, int id) {

                                    }
                                });
                            }
                        });

                    }
                });

            }
            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });


        //加入小区后
        mHomeLoginAdapter = new HomeLoginAdapter(getActivity());
        homeLoginLrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        final LRecyclerViewAdapter adapter = new LRecyclerViewAdapter(mHomeLoginAdapter);
        homeLoginLrv.setAdapter(adapter);
        homeLoginLrv.setItemAnimator(new DefaultItemAnimator());
        //加入头布局
        CommonHeader header = new CommonHeader(getActivity(), R.layout.item_home_login_head);
        adapter.addHeaderView(header);
        final ImageView homeLoginCommunityDetail= (ImageView) header.findViewById(R.id.home_login_community_detail);
        List paramshead = new ArrayList<String>();
        paramshead.add(2061 + "");//2061  2803
        paramshead.add(5 + "");
        HttpUtils.post(Api.COMMUNITY, Api.Community.GETCOMMUNITYINFO, paramshead, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onSuccess(String response, int id) {
                ArrayList<MDate> communityInfoList = Resovle.getCommunityInfo(response);
                final Bundle bundle = new Bundle();
                bundle.putSerializable("communityInfoList", communityInfoList);
                homeLoginCommunityDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), CompoundInfoActivity.class);
                        i.putExtras(bundle);
                        startActivity(i);
                    }
                });

            }

            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });

        //初始化控件
        homeLoginItemHomeheadRlv = (RecyclerView) header.findViewById(R.id.home_login_item_homehead_rlv);
        homeLoginItemHeadIvNeighbor = (ImageView) header.findViewById(R.id.home_login_item_head_iv_neighbor);
        homeLoginItemHeadTvNeighbor = (TextView) header.findViewById(R.id.home_login_item_head_tv_neighbor);
        homeLoginItemheadIvDynamicselect = (ImageView) header.findViewById(R.id.home_login_itemhead_iv_dynamicselect);
        //动态title
        HomeLoginHeadAdapter homeHeadAdapter = new HomeLoginHeadAdapter(getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        homeLoginItemHomeheadRlv.setLayoutManager(layoutManager);
        homeLoginItemHomeheadRlv.setAdapter(homeHeadAdapter);
        homeLoginItemHomeheadRlv.setItemAnimator(new DefaultItemAnimator());

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
                if (memberListByCommunity.size() > 0) {
                    int sum = Integer.valueOf(memberListByCommunity.get(0).getmInfo().getCommunityListInfo().getTotalnum());
                    homeLoginItemHeadTvNeighbor.setText(sum + "人");
                    //进入邻居详情页
                    homeLoginItemHeadIvNeighbor.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("memberListByCommunity", memberListByCommunity);
                            Intent i = new Intent(getActivity(), MyNeighborListActivity.class);
                            i.putExtras(bundle);
                            startActivity(i);
                        }
                    });
                }
            }
            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });
        //动态筛选
        HttpUtils.post(Api.PUBLIC, Api.Public.GETDYNAMICKINDS, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onSuccess(String response, int id) {

                final ArrayList<MDate> dynamicKinds = Resovle.getDynamicKinds(response);
                homeLoginItemheadIvDynamicselect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View popupView = View.inflate(getActivity(), R.layout.item_item_home_login_head_pop, null);
                        PopupWindow mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                        mPopupWindow.setTouchable(true);
                        mPopupWindow.setOutsideTouchable(true);
                        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                        mPopupWindow.showAsDropDown(homeLoginItemheadIvDynamicselect);
                        RecyclerView pop_rv = (RecyclerView) popupView.findViewById(R.id.item_item_head_pop_rlv);
                        final DynamicKindsAdapter dynamicKindsAdapter = new DynamicKindsAdapter(getActivity());
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
                        pop_rv.setLayoutManager(gridLayoutManager);
                        pop_rv.setAdapter(dynamicKindsAdapter);
                        pop_rv.setItemAnimator(new DefaultItemAnimator());
                        dynamicKindsAdapter.setDates(dynamicKinds);
                        dynamicKindsAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });
        //条目点击事件
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                DynamicListByCommunityList dynamicListByCommunity = dynamicListByCommunitys.get(0).getmList().getDynamicListByCommunityLists().get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("dynamicListByCommunity", dynamicListByCommunity);
                Intent i = new Intent(getActivity(), StateActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        //动态数据请求
        List params1 = new ArrayList<String>();
        params1.add("2803");//2061  2803
        params1.add("all");
        params1.add("1");
        //params.add("15551675396");//15551675396
        HttpUtils.post(Api.COMMUNITY, Api.Community.GETDYNAMICLISTBYCOMMUNITY, params1, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onSuccess(String response, int id) {
                Log.e("8888888888888----", response);
                dynamicListByCommunitys = Resovle.getDynamicListByCommunity(response);
                mHomeLoginAdapter.setDates(dynamicListByCommunitys);
                mHomeLoginAdapter.notifyDataSetChanged();
            }

            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_login;
    }

    @Override
    public String getC() {
        return null;
    }

    @Override
    public String getA() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
