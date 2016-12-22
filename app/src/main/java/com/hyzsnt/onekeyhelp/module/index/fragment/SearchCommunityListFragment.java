package com.hyzsnt.onekeyhelp.module.index.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.index.adapter.CommunityListAdapter;
import com.hyzsnt.onekeyhelp.module.index.bean.CommunityList;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

import static com.hyzsnt.onekeyhelp.app.App.getLocation;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchCommunityListFragment extends BaseFragment {
    List<CommunityList.ListBean> mCommunityLists;
    private CommunityListAdapter mAdapter;

    @BindView(R.id.com_list)
    LRecyclerView mComList;
    List<String> parms = new ArrayList<>();
    private String lat;
    private String lon;
    private String comID;

    @Override
    protected List<String> getParams() {
        return null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            comID = bundle.getString("comID");
            Log.d(">>>>>>>>>", comID);
            getCommunityList(comID);
        }
    }

    @Override
    protected void initData(String content) {
        mAdapter = new CommunityListAdapter();
        lat = Double.toString(getLocation().getLatitude());
        Log.d("lat", lat);
        lon = Double.toString(getLocation().getLongitude());
        Log.d("lon", lon);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search_community_list;
    }

    @Override
    public String getC() {
        return null;
    }

    @Override
    public String getA() {
        return null;
    }

    private void getCommunityList(String comID) {
        parms.clear();
        parms.add("1");
        parms.add("10");
        parms.add("1");
        parms.add("4");
        parms.add(lat);
        parms.add(lon);
        parms.add("110105");
        parms.add(comID);
        parms.add("");

        HttpUtils.post(Api.COMMUNITY, "getCommunityList", parms, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onSuccess(String response, int id) {
                Log.d("小区", response);
                if (JsonUtils.isSuccess(response)) {
                    mCommunityLists = new ArrayList<CommunityList.ListBean>();
                    Gson gson = new Gson();
                    CommunityList communityList = gson.fromJson(response, CommunityList.class);

                    mCommunityLists = communityList.getList();
                    mAdapter.setCommunityLists(mCommunityLists);
                    LinearLayoutManager manager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
                    mComList.setLayoutManager(manager);
                    mComList.setHasFixedSize(true);
                    mComList.setItemAnimator(new DefaultItemAnimator());
                    LRecyclerViewAdapter adapter = new LRecyclerViewAdapter(mAdapter);
                    mComList.setAdapter(adapter);
                    //行点击事件

                } else {

                }
            }
        });

    }
}
