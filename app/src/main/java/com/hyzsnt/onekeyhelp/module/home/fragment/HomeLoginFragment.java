package com.hyzsnt.onekeyhelp.module.home.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
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
import com.hyzsnt.onekeyhelp.module.home.activity.HelpListActivity;
import com.hyzsnt.onekeyhelp.module.home.activity.StateActivity;
import com.hyzsnt.onekeyhelp.module.home.adapter.DynamicKindsAdapter;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeLoginAdapter;
import com.hyzsnt.onekeyhelp.module.home.adapter.HomeLoginHeadAdapter;
import com.hyzsnt.onekeyhelp.module.home.adapter.LoginCommunityAdapter;
import com.hyzsnt.onekeyhelp.module.home.bean.DynamicListByCommunityList;
import com.hyzsnt.onekeyhelp.module.home.bean.LoginCommunity;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.bean.UserInfoInfo;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.index.activity.CompoundInfoActivity;
import com.hyzsnt.onekeyhelp.module.index.activity.MyNeighborListActivity;
import com.hyzsnt.onekeyhelp.module.search.SearchCommunityActivity;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeLoginFragment extends BaseFragment {
    //切换小区
    @BindView(R.id.home_login_iv_swich)
    ImageView homeLoginIvSwich;
    //展示小区动态
    @BindView(R.id.home_login_lrv)
    LRecyclerView homeLoginLrv;
    //搜索
    @BindView(R.id.homeimage_search)
    ImageView homeimageSearch;
    //当前小区名称
    @BindView(R.id.home_tv_title)
    TextView homeTvTitle;

    private RecyclerView homeLoginItemHomeheadRlv;
    private ImageView homeLoginItemHeadIvNeighbor;
    private TextView homeLoginItemHeadTvNeighbor;
    private LinearLayout homeLoginItemheadIvDynamicselect;
    private ArrayList<MDate> dynamicListByCommunitys = new ArrayList<>();
    private HomeLoginAdapter mHomeLoginAdapter;
    private LRecyclerViewAdapter adapter;
    private String uid;
    private String incommunity;
    private TextView mHelpping;

    public HomeLoginFragment() {
        // Required empty public constructor
    }

    @Override
    protected List<String> getParams() {
        return null;
    }

    @Override
    protected void initData(String content) {
        //获取用户信息
        getUserInfo();
        //初始化数据
        initCommunity();
        //切换小区
        switchCommunity();
    }

    private void initCommunity() {
        //加入小区后
        mHomeLoginAdapter = new HomeLoginAdapter(getActivity(), dynamicListByCommunitys);
        homeLoginLrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new LRecyclerViewAdapter(mHomeLoginAdapter);
        homeLoginLrv.setAdapter(adapter);
        homeLoginLrv.setItemAnimator(new DefaultItemAnimator());
        homeLoginLrv.setPullRefreshEnabled(false);
        //加入头布局
        CommonHeader header = new CommonHeader(getActivity(), R.layout.item_home_login_head);
        adapter.addHeaderView(header);
        //初始化控件
        mHelpping = (TextView) header.findViewById(R.id.tv_help);
        homeLoginItemHomeheadRlv = (RecyclerView) header.findViewById(R.id.home_login_item_homehead_rlv);
        homeLoginItemHeadIvNeighbor = (ImageView) header.findViewById(R.id.home_login_item_head_iv_neighbor);
        homeLoginItemHeadTvNeighbor = (TextView) header.findViewById(R.id.home_login_item_head_tv_neighbor);
        homeLoginItemheadIvDynamicselect = (LinearLayout) header.findViewById(R.id.home_login_itemhead_iv_dynamicselect);
        final ImageView homeLoginCommunityDetail = (ImageView) header.findViewById(R.id.home_login_community_detail);
        List paramshead = new ArrayList<String>();
        paramshead.add(incommunity + "");//2061  2803
        paramshead.add(uid + "");
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

        //动态title
        HomeLoginHeadAdapter homeHeadAdapter = new HomeLoginHeadAdapter(getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        homeLoginItemHomeheadRlv.setLayoutManager(layoutManager);
        homeLoginItemHomeheadRlv.setAdapter(homeHeadAdapter);
        homeLoginItemHomeheadRlv.setItemAnimator(new DefaultItemAnimator());
        //我的邻居
        List params = new ArrayList<String>();
        params.add(incommunity);//2061  2803
        params.add(uid);
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
                        final PopupWindow mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                        mPopupWindow.setTouchable(true);
                        mPopupWindow.setOutsideTouchable(true);
                        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                        mPopupWindow.showAsDropDown(homeLoginItemheadIvDynamicselect);
                        GridView gv = (GridView) popupView.findViewById(R.id.item_item_head_pop_gv);
                        gv.setNumColumns(5);
                        DynamicKindsAdapter dynamicKindsAdapter = new DynamicKindsAdapter(getActivity(), dynamicKinds);
                        gv.setAdapter(dynamicKindsAdapter);
                        //筛选动态
                        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String id1 = dynamicKinds.get(0).getmList().getDynamicKindses().get(position).getId();
                                dinamicGet(null, id1);
                                mPopupWindow.dismiss();
                            }
                        });
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
                bundle.putString("tag", Api.COMMUNITY);
                bundle.putSerializable("dynamicListByCommunity", dynamicListByCommunity);
                Intent i = new Intent(getActivity(), StateActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        dinamicGet(incommunity, "all");
    }

    String communityMemery;
    String swichMemery;

    private void dinamicGet(String community, String swich) {
        //动态数据请求
        List params1 = new ArrayList<String>();
        if (community == null) {
            params1.add(communityMemery);
        } else {
            params1.add(community);//2061  2803
            communityMemery = community;
        }
        if (swich == null) {
            params1.add(swichMemery);
        } else {
            params1.add(swich);
            swichMemery = swich;
        }
        params1.add("1");
        //params.add("15551675396");//15551675396
        HttpUtils.post(Api.COMMUNITY, Api.Community.GETDYNAMICLISTBYCOMMUNITY, params1, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onSuccess(String response, int id) {
                ArrayList<MDate> dynamicListByCommunitys0 = Resovle.getDynamicListByCommunity(response);
                dynamicListByCommunitys.clear();
                dynamicListByCommunitys.addAll(dynamicListByCommunitys0);
                mHomeLoginAdapter.setDates(dynamicListByCommunitys);
                LogUtils.e("___" + response);
                mHomeLoginAdapter.notifyDataSetChanged();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });
    }

    private void switchCommunity() {
        List params0 = new ArrayList<String>();
        params0.add(uid);
        //params.add("2061");//2061  2803
        HttpUtils.post(Api.USER, Api.User.GETUSERINFO, params0, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onSuccess(String response, int id) {
                final ArrayList<MDate> loginCommunities = Resovle.getUserInfo(response);
                if (loginCommunities.get(0).getmList() != null) {
                    ArrayList<LoginCommunity> loginCommunities1 = loginCommunities.get(0).getmList().getLoginCommunities();
                    for (int i = 0; i < loginCommunities1.size(); i++) {
                        LoginCommunity loginCommunity = loginCommunities1.get(i);
                        String ifcur = loginCommunity.getIfcur();
                        if ("1".equals(ifcur)) {
                            homeTvTitle.setText(loginCommunity.getCmname());
                        }
                    }
                }


                homeLoginIvSwich.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View popupView = View.inflate(getActivity(), R.layout.item_item_home_login_head_pop, null);
                        final PopupWindow mPopupWindow = new PopupWindow(popupView, 215, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                        mPopupWindow.setTouchable(true);
                        mPopupWindow.setOutsideTouchable(true);
                        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getActivity().getResources(), (Bitmap) null));
                        mPopupWindow.showAsDropDown(homeLoginIvSwich);
                        GridView gv = (GridView) popupView.findViewById(R.id.item_item_head_pop_gv);
                        gv.setNumColumns(1);
                        final LoginCommunityAdapter loginCommunityAdapter = new LoginCommunityAdapter(getActivity(), loginCommunities);
                        gv.setAdapter(loginCommunityAdapter);
                        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                List paramsSwich = new ArrayList<String>();
                                paramsSwich.add(uid);
                                final String cmid = loginCommunities.get(0).getmList().getLoginCommunities().get(position).getCmid();
                                paramsSwich.add(cmid);//2061  2803
                                HttpUtils.post(Api.USER, Api.User.SWITCHCOMMUNITY, paramsSwich, new ResponseHandler() {
                                    @Override
                                    public void onError(Call call, Exception e, int id) {

                                    }

                                    @Override
                                    public void onSuccess(String response, int id) {
                                        dynamicListByCommunitys = Resovle.getDynamicListByCommunity(response);
                                        dinamicGet(cmid, null);
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

    @OnClick(R.id.homeimage_search)
    public void onClick() {
        Intent i = new Intent(mActivity, SearchCommunityActivity.class);
        startActivity(i);
    }

    /**
     * 获取用户信息
     */
    public void getUserInfo() {
        String userDetail = (String) SPUtils.get(getActivity(), "userDetail", "");
        ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
        UserInfoInfo userInfoInfo = userInfo.get(0).getmInfo().getUserInfoInfo();
        uid = userInfoInfo.getUid();
        incommunity = userInfoInfo.getIncommunity();
    }

    public void helpHelp(int surroundingemerg) {
        if (surroundingemerg > 0) {
            mHelpping.setText("附近有" + surroundingemerg + "人求救");
            mHelpping.setVisibility(View.VISIBLE);
            mHelpping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity, HelpListActivity.class);
                    intent.putExtra("uid", uid);
                    startActivity(intent);
                }
            });
        } else {
            mHelpping.setVisibility(View.GONE);
        }

    }
}
