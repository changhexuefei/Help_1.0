package com.hyzsnt.onekeyhelp.module.user.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.user.adapter.MessageAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity {


    @BindView(R.id.re_user_message)
    RecyclerView mReUserMessage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void initData() {
        mReUserMessage.setLayoutManager(new LinearLayoutManager(this));
        mReUserMessage.setAdapter(new MessageAdapter(this));

    }

    @OnClick({R.id.im_search_back, R.id.im_stroll_seek})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_search_back:
                finish();
                break;
            case R.id.im_stroll_seek:
                break;
        }
    }
}
