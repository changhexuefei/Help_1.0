package com.hyzsnt.onekeyhelp.module.release.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.release.activity.GeneralMessageActivity;
import com.hyzsnt.onekeyhelp.module.release.activity.TalkActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReleaseFragment extends BaseFragment {


    @BindView(R.id.btn_cancel)
    Button mBtnCancel;
    @BindView(R.id.iv_talk)
    LinearLayout mIvTalk;
    @BindView(R.id.iv_general_message)
    LinearLayout mIvGeneralMessage;
    @BindView(R.id.iv_unuse_goods)
    LinearLayout mIvUnuseGoods;
    @BindView(R.id.iv_house_lease)
    LinearLayout mIvHouseLease;


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


    @OnClick({R.id.iv_talk, R.id.iv_unuse_goods, R.id.iv_house_lease, R.id.btn_cancel, R.id.iv_general_message})
    public void onClick(View view) {
        switch (view.getId()) {
            //点击随便说说页面，跳转到发表说说页面
            case R.id.iv_talk:
                Intent i = new Intent(mActivity, TalkActivity.class);
                i.putExtra("tag", "iv_talk");
                startActivity(i);
                break;
            case R.id.iv_unuse_goods:
                break;
            case R.id.iv_house_lease:
                break;
            case R.id.btn_cancel:

                break;
            case R.id.iv_general_message:
                Intent i1 = new Intent(mActivity, GeneralMessageActivity.class);
                i1.putExtra("tag1", "iv_gener");
                startActivity(i1);
                break;

        }
    }

}
