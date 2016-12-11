package com.hyzsnt.onekeyhelp.module.index.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.index.adapter.MyNeighborListAdapter;
import com.hyzsnt.onekeyhelp.module.index.bean.MyNeighborInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyNeighborListActivity extends BaseActivity implements TextWatcher {


    @BindView(R.id.btn_return)
    ImageButton mBtnReturn;
    @BindView(R.id.my_neighbor_list)
    RecyclerView mMyNeighborList;
    @BindView(R.id.et_search)
    EditText mEtSearch;

    private List<MyNeighborInfo> mInfoList = new ArrayList<>();
    private MyNeighborListAdapter mNeighborListAdapter;


    private int lastVisibleItemPosition;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:

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
        final LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mMyNeighborList.setLayoutManager(manager);
        mMyNeighborList.setHasFixedSize(true);
        //设置Item增加、移除动画
        mMyNeighborList.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        mMyNeighborList.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.HORIZONTAL));
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

        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyNeighborListActivity.this, "222222222", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Toast.makeText(this, charSequence, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Toast.makeText(this, charSequence, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable editable) {
        Log.d("TextChanged", "afterTextChanged: " + editable);
        Toast.makeText(this, "您输入的是：" + editable.toString(), Toast.LENGTH_SHORT).show();
    }
}
