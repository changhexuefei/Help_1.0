package com.hyzsnt.onekeyhelp.module.release.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.activity.StateActivity;
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class GeneralMessageActivity extends BaseActivity {
    private static final String PUBLISHDYNAMIC = "publishDynamic";
    @BindView(R.id.btn_return)
    ImageButton mBtnReturn;
    @BindView(R.id.tv_msg)
    TextView mTvMsg;
    @BindView(R.id.et_title)
    TextView mEtTitle;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.btn_release)
    Button mBtnRelease;
    private String mTitle;
    private String mContent;
    List<String> p;
    private String infomation = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_talk;
    }

    @Override
    protected void initData() {
        p = new ArrayList<>();
        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag1");
        if (tag.equals("iv_gener")) {
            mTvMsg.setText("发表综合信息");
        }
        mTitle = mEtTitle.getText().toString();
        mContent = mEtContent.getText().toString();


    }

    @OnClick({R.id.btn_return, R.id.btn_release})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_return:
                mBtnReturn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
                break;
            case R.id.btn_release:
                mBtnRelease.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mTitle != null && mContent != null) {
                            StringBuffer sb = new StringBuffer();
                            String result = sb.append(mTitle).append("|*|").append(mContent).toString();
                            if (infomation.equals("0")) {
                                p.add((String) SPUtils.get(GeneralMessageActivity.this, "uid", ""));
                                p.add(App.getLocation().getLatitude() + "");
                                p.add(App.getLocation().getLongitude() + "");
                                p.add(result);
                                p.add(infomation);
                                p.add("");
                            }
//                           else if(infomation.equals()){
//
//                            }
                            HttpUtils.post(Api.PUBLISH, PUBLISHDYNAMIC, p, new JsonResponseHandler() {
                                @Override
                                public void onError(Call call, Exception e, int id) {

                                }

                                @Override
                                public void onSuccess(String response, int id) {
                                    Log.d("綜合信息",response);
                                }
                            });


                            startActivity(new Intent(GeneralMessageActivity.this, StateActivity.class));
                        } else {
                            return;

                        }
                    }
                });
                break;
        }
    }
}
