package com.hyzsnt.onekeyhelp.module.index.activity;

import android.support.v7.widget.DefaultItemAnimator;
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
import com.hyzsnt.onekeyhelp.module.index.bean.MyDecoration;
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

    private List<MyNeighborInfo> mInfoList;
    private MyNeighborListAdapter mNeighborListAdapter;

    private int lastVisibleItemPosition;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_my_neighbor_list;

    }


    @Override
    protected void initData() {
        mInfoList = new ArrayList<>();
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));
        mInfoList.add(new MyNeighborInfo(R.drawable.test, "张三", R.mipmap.man, "12"));


        mNeighborListAdapter = new MyNeighborListAdapter();
        final LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mMyNeighborList.setLayoutManager(manager);
        mMyNeighborList.setHasFixedSize(true);
        //设置Item增加、移除动画
        mMyNeighborList.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        mMyNeighborList.addItemDecoration(new MyDecoration(
                this, MyDecoration.VERTICAL_LIST));
        mNeighborListAdapter.setNeighborInfos(mInfoList);
        mMyNeighborList.setAdapter(mNeighborListAdapter);
        mMyNeighborList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

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
//                Toast.makeText(MyNeighborListActivity.this, "222222222", Toast.LENGTH_SHORT).show();
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
