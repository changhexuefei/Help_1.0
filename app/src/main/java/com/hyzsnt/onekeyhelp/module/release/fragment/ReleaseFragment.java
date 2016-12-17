package com.hyzsnt.onekeyhelp.module.release.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.hss01248.dialog.StyledDialog;
import com.hss01248.dialog.interfaces.MyItemDialogListener;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.release.activity.GeneralMessageActivity;
import com.hyzsnt.onekeyhelp.module.release.activity.TalkActivity;
import com.hyzsnt.onekeyhelp.module.release.activity.VoiceReleaseActivity;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static com.hyzsnt.onekeyhelp.utils.SPUtils.getAll;
import static com.hyzsnt.onekeyhelp.utils.SPUtils.isLogin;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReleaseFragment extends BaseFragment {


    //    @BindView(R.id.btn_cancel)
//    Button mBtnCancel;
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
        Map<String, ?> map = getAll(getContext());


        Log.d("登录", isLogin() + "");
        //登录状态下，可以看到综合信息一栏，未登录状态，不能看到综合信息
        if (isLogin()) {
            mIvGeneralMessage.setVisibility(View.GONE);
        } else {
            mIvGeneralMessage.setVisibility(View.VISIBLE);
        }
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
                final List<String> strings = new ArrayList<>();
                strings.add("文字发布");
                strings.add("语音发布");

                StyledDialog.buildIosSingleChoose(mActivity, strings, new MyItemDialogListener() {


                    @Override
                    public void onItemClick(CharSequence charSequence, int i) {
                        ToastUtils.showShort(mActivity,charSequence);
                        if (i == 0){
                            Intent i2 = new Intent(mActivity, TalkActivity.class);
                            i2.putExtra("tag", "iv_talk");
                            startActivity(i2);
                        }
                        if(i==1){
                            Intent i3 = new Intent(mActivity, VoiceReleaseActivity.class);
                            i3.putExtra("tag2", "iv_voice");
                            startActivity(i3);

                        }

                    }
                }).show();

//
//                Intent i = new Intent(mActivity, TalkActivity.class);
//                i.putExtra("tag", "iv_talk");
//                startActivity(i);
                break;
            case R.id.iv_unuse_goods:
                break;
            case R.id.iv_house_lease:
                break;
//            case R.id.btn_cancel:
//
//                break;
            case R.id.iv_general_message:
                Intent i1 = new Intent(mActivity, GeneralMessageActivity.class);
                i1.putExtra("tag1", "iv_gener");
                startActivity(i1);
                break;

        }
    }

}
