package com.hyzsnt.onekeyhelp.module.home.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.home.adapter.ShopMsgAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;




public class ShopDetailActivity extends BaseActivity {

    @BindView(R.id.lv_shop_msg)
    ListView mLvShopMsg;
    private View mView;
    private List<Integer> images = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_detail;
    }

    @Override
    protected void initData() {
        initHeaderView();
        mLvShopMsg.setAdapter(new ShopMsgAdapter(this));
        mLvShopMsg.addHeaderView(mView);
    }

    private void initHeaderView() {
        images.add(R.drawable.banner_0);
        images.add(R.drawable.banner_1);
        images.add(R.drawable.banner_2);
        images.add(R.drawable.banner_3);
        mView = View.inflate(this, R.layout.shop_detail_header, null);
        Banner banner = (Banner) mView.findViewById(R.id.banner);
        banner.setImages(images).setImageLoader(new GlideImageLoader()).start();
    }

    @OnClick({R.id.iv_detail_back, R.id.tv_detail_cart, R.id.tv_detail_buy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_detail_back:
                finish();
                break;
            case R.id.tv_detail_cart:
                Toast.makeText(ShopDetailActivity.this, "加入购物车", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_detail_buy:
                Toast.makeText(ShopDetailActivity.this, "立即购买", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
