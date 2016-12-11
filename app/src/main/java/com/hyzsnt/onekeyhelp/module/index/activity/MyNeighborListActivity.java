package com.hyzsnt.onekeyhelp.module.index.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.index.adapter.MyNeighborListAdapter;
import com.hyzsnt.onekeyhelp.module.index.bean.MyNeighborInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyNeighborListActivity extends BaseActivity implements SearchView.OnQueryTextListener {


    @BindView(R.id.btn_return)
    ImageButton mBtnReturn;
    @BindView(R.id.my_neighbor_list)
    RecyclerView mMyNeighborList;
    @BindView(R.id.search_bar)
    SearchView mSearchBar;
    private List<MyNeighborInfo> mInfoList = new ArrayList<>();
    private MyNeighborListAdapter mNeighborListAdapter;


    private int lastVisibleItemPosition;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    getData();
                    mNeighborListAdapter.notifyDataSetChanged();
                    break;

            }
        }
    };
//    private LRecyclerViewAdapter mAdapter;


    @Override
    protected int getLayoutId() {

        return R.layout.activity_my_neighbor_list;

    }


    @Override
    protected void initData() {
        mNeighborListAdapter = new MyNeighborListAdapter();
//        mAdapter = new LRecyclerViewAdapter(mNeighborListAdapter);
        // 设置该SearchView内默认显示的提示文本
        mSearchBar.setQueryHint("搜索");
//        // 为该SearchView组件设置事件监听器
        mSearchBar.setOnQueryTextListener(this);

        final LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mMyNeighborList.setLayoutManager(manager);
        mMyNeighborList.setHasFixedSize(true);
//        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        mSwipeRefreshLayout.setRefreshing(false);
//                        mNeighborListAdapter.notifyDataSetChanged();
//                    }
//                },2000);
//            }
//        });
        mMyNeighborList.setItemAnimator(new DefaultItemAnimator());
        mNeighborListAdapter.setNeighborInfos(mInfoList);
        mMyNeighborList.setAdapter(mNeighborListAdapter);
        mMyNeighborList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && mNeighborListAdapter.getItemCount() == lastVisibleItemPosition + 1) {
//                    mSwipeRefreshLayout.setRefreshing(false);
                    //进行网络加载数据显示
                    handler.sendEmptyMessageDelayed(0, 3000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition = manager.findLastVisibleItemPosition();
            }
        });


    }

    public void getData() {

        MyNeighborInfo info1 = new MyNeighborInfo(R.mipmap.ic_launcher, "张三", R.mipmap.ic_empty, "12");
        mInfoList.add(info1);
        MyNeighborInfo info2 = new MyNeighborInfo(R.mipmap.ic_launcher, "张三", R.mipmap.ic_empty, "12");
        mInfoList.add(info2);
        MyNeighborInfo info3 = new MyNeighborInfo(R.mipmap.ic_launcher, "张三", R.mipmap.ic_empty, "12");
        mInfoList.add(info3);
        MyNeighborInfo info4 = new MyNeighborInfo(R.mipmap.ic_launcher, "张三", R.mipmap.ic_empty, "12");
        mInfoList.add(info4);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        Toast.makeText(this, "TextSubmit--->" + s, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        Toast.makeText(this, "textChange--->" + s, Toast.LENGTH_SHORT).show();
        return true;
    }


}
