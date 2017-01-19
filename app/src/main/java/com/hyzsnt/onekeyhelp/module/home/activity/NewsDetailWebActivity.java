package com.hyzsnt.onekeyhelp.module.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailWebActivity extends BaseActivity {

    @BindView(R.id.wv_news_detail)
    WebView wv_news_detail;
    @BindView(R.id.iv_web_back)
    ImageView mIvWebBack;
    private String mUrl;
    private String substring;//id
    private String title;//分享标题
    private String img;//分享图片的路径

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail_web;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        img = intent.getStringExtra("img");
        int type = intent.getIntExtra("type", 2);
        int id = intent.getIntExtra("id", 0);
        if (type == 0) {
            mUrl = intent.getStringExtra("url");
        } else if (type == 1) {
            mUrl = String.format("http://www.hy-bb.cn/appweb/newscontent.aspx?id=%d", id);
        } else if (type == 2) {//社区新闻详情
            mUrl = String.format("http://www.hy-bb.cn/appweb/sqnewscontent.aspx?id=%d", id);
        }
        int indexOf = mUrl.indexOf("=");
        substring = mUrl.substring(indexOf + 1);
        WebSettings webSettings = wv_news_detail.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setTextSize(WebSettings.TextSize.LARGER);
        // 设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        // 设置可以访问文件
        webSettings.setAllowFileAccess(true);
        // 设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        wv_news_detail.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
        wv_news_detail.loadUrl(mUrl);
        mIvWebBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
