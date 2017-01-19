package com.hyzsnt.onekeyhelp.module.home.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.home.bean.NewsTypeBean;
import com.hyzsnt.onekeyhelp.module.home.fragment.NewsListFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

public class NewsActivity extends BaseActivity {

    @BindView(R.id.iv_news_back)
    ImageView iv_news_back;
    @BindView(R.id.tab_news)
    TabLayout tab_news;
    @BindView(R.id.vp_news_pager)
    ViewPager vp_news_pager;

    private List<NewsTypeBean.DataBean> title;
    private List<Fragment> mFragments;
    private NewsTypeBean mNewsTypeBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    protected void initData() {
        iv_news_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title = new ArrayList<>();
        mFragments = new ArrayList<>();
        OkHttpUtils.get().url("http://appserver.hy-bb.cn/News/getlistbypid").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(NewsActivity.this, "网络异常!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(String response, int id) {
                mNewsTypeBean = new Gson().fromJson(response, NewsTypeBean.class);
                title.addAll(mNewsTypeBean.getData());
                for (NewsTypeBean.DataBean dataBean : title) {
                    mFragments.add(NewsListFragment.newInstance(dataBean.getId()));
                }
                setPager();
            }
        });
    }
    private void setPager() {
        vp_news_pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position).getName();
            }
        });
        tab_news.setupWithViewPager(vp_news_pager);
    }
}
