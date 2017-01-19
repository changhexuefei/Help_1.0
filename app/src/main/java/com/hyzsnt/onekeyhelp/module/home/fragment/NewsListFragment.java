package com.hyzsnt.onekeyhelp.module.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.home.activity.NewsDetailWebActivity;
import com.hyzsnt.onekeyhelp.module.home.bean.NewsListBean;
import com.hyzsnt.onekeyhelp.module.home.listener.EndlessRecyclerOnScrollListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by msi on 2016/9/29.
 */

public class NewsListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    /**
     * 新闻类型id
     */
    private int typeId;
    private List<NewsListBean.DataBean> mData;
    private NewsListAdapter mAdapter;
    private int pindex = 1;

    public static NewsListFragment newInstance(int typeId) {
        NewsListFragment newsListFragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("typeId", typeId);
        newsListFragment.setArguments(bundle);
        return newsListFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            typeId = bundle.getInt("typeId", 0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_news_list, null);
        ButterKnife.bind(this, view);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setRefreshing(true);
        initData();
        return view;
    }

    private void initData() {
        Map<String, String> params = new HashMap<>();
        params.put("id", typeId + "");
        params.put("pindex", "1");
        params.put("psize", "15");
        OkHttpUtils.get().url("http://appserver.hy-bb.cn/News/appnewslist").params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(getActivity(), "网络异常!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String response, int id) {
                NewsListBean newsListBean = new Gson().fromJson(response, NewsListBean.class);
                mData = newsListBean.getData();
                setData(mData);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void setData(final List<NewsListBean.DataBean> data) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new NewsListAdapter(getActivity(), data);
        mRecyclerView.setAdapter(mAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMore();
            }
        });
        mAdapter.setOnNewsItemClickListener(new NewsListAdapter.OnNewsItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                NewsListBean.DataBean bean = data.get(position);
                Intent intent = new Intent(getActivity(), NewsDetailWebActivity.class);
                intent.putExtra("type", 1);
                intent.putExtra("id", bean.getId());
                intent.putExtra("title", bean.getTitle());
                intent.putExtra("img", bean.getImgURL());
                startActivity(intent);
            }
        });
    }

    private void loadMore() {
        Map<String, String> params = new HashMap<>();
        params.put("id", typeId + "");
        params.put("pindex", "1" + pindex);
        params.put("psize", "15");
        OkHttpUtils.get().url("http://appserver.hy-bb.cn/News/appnewslist").params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(getActivity(), "网络异常!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String response, int id) {
                NewsListBean newsListBean = new Gson().fromJson(response, NewsListBean.class);
                mData = newsListBean.getData();
                if (mAdapter != null) {
                    mSwipeRefreshLayout.setRefreshing(false);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        Map<String, String> params = new HashMap<>();
        params.put("id", typeId + "");
        params.put("pindex", "1");
        params.put("psize", "15");
        OkHttpUtils.get().url("http://appserver.hy-bb.cn/News/appnewslist").params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(getActivity(), "网络异常!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String response, int id) {
                NewsListBean newsListBean = new Gson().fromJson(response, NewsListBean.class);
                mData = newsListBean.getData();
                if (mAdapter != null) {
                    mSwipeRefreshLayout.setRefreshing(false);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
