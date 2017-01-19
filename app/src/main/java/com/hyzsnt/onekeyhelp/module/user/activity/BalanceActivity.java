package com.hyzsnt.onekeyhelp.module.user.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CommunityAdapter;
import com.hyzsnt.onekeyhelp.module.user.adapter.BalanceAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BalanceActivity extends BaseActivity {


    @BindView(R.id.re_balance)
    RecyclerView mReBalance;
    @BindView(R.id.tv_balance_filtrate)
    TextView mTvBalanceFiltrate;
    private ArrayList<String> mAlist;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_balance;
    }

    @Override
    protected void initData() {
        mReBalance.setLayoutManager(new LinearLayoutManager(this));
        BalanceAdapter adapter = new BalanceAdapter(this);
        mReBalance.setAdapter(adapter);
        mAlist = new ArrayList<>();
        mAlist.add("全部");
        mAlist.add("支出");
        mAlist.add("收入");
    }


    @OnClick({R.id.im_balace_back, R.id.tv_balance_filtrate})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_balace_back:
                finish();
                break;
            case R.id.tv_balance_filtrate: {
                View popupView = View.inflate(BalanceActivity.this, R.layout.pop_create_circle_community, null);
                ListView lv = (ListView) popupView.findViewById(R.id.ll_create_circle_community);
                PopupWindow mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                mPopupWindow.setTouchable(true);
                mPopupWindow.setOutsideTouchable(true);
                mPopupWindow.setBackgroundDrawable(new BitmapDrawable(BalanceActivity.this.getResources(), (Bitmap) null));
                mPopupWindow.showAsDropDown(mTvBalanceFiltrate);
                CommunityAdapter communityAdapter = new CommunityAdapter(BalanceActivity.this);
                communityAdapter.setdata(mAlist);
                lv.setAdapter(communityAdapter);
            }
            break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
