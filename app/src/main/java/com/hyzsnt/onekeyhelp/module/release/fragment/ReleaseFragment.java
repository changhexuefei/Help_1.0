package com.hyzsnt.onekeyhelp.module.release.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.release.activity.TalkActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReleaseFragment extends BaseFragment {


    @BindView(R.id.iv_talk)
    ImageView mIvTalk;
    @BindView(R.id.iv_unuse_goods)
    ImageView mIvUnuseGoods;
    @BindView(R.id.iv_house_lease)
    ImageView mIvHouseLease;
    @BindView(R.id.btn_cancel)
    Button mBtnCancel;

    public ReleaseFragment() {
        // Required empty public constructor
    }

    @Override
    protected List<String> getParams() {
        return null;
    }

    @Override
    protected void initData(String content) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_release;
    }

    @Override
    public String getC() {
        return null;
    }

    @Override
    public String getA() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.iv_talk, R.id.iv_unuse_goods, R.id.iv_house_lease, R.id.btn_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_talk:
                startActivity(new Intent(mActivity, TalkActivity.class));
                break;
            case R.id.iv_unuse_goods:
                break;
            case R.id.iv_house_lease:
                break;
            case R.id.btn_cancel:
                break;
        }
    }
}
