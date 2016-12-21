package com.hyzsnt.onekeyhelp.module.release.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.release.adapter.ChoosePhotoListAdapter;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
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
    @BindView(R.id.cbx)
    CheckBox mCbx;
    private String mTitle;
    private String mContent;
    //checkBox默认选中
    boolean isChecked = true;
    private final int REQUEST_CODE_GALLERY = 1001;
    private final int REQUEST_CODE_CAMERA = 1000;
    List<String> p;
    //    private String infomation = "";
    private ArrayList<PhotoInfo> photoList;
    private ChoosePhotoListAdapter adapter;

    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            if (resultList != null) {
                switch (reqeustCode) {
                    case REQUEST_CODE_GALLERY:
                        photoList.clear();
                        photoList.addAll(resultList);
                        adapter.notifyDataSetChanged();
                        break;
                    case REQUEST_CODE_CAMERA:
                        photoList.clear();
                        photoList.addAll(resultList);
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {

        }
    };


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
                            final String result = sb.append(mTitle).append("|*|").append(mContent).toString();
                            p.add((String) SPUtils.get(GeneralMessageActivity.this, "uid", ""));
                            p.add(App.getLocation().getLatitude() + "");
                            p.add(App.getLocation().getLongitude() + "");
                            p.add(result);
                            p.add("0");
                            p.add("");
                            HttpUtils.post(Api.PUBLISH, PUBLISHDYNAMIC, p, new JsonResponseHandler() {
                                @Override
                                public void onError(Call call, Exception e, int id) {
                                    LogUtils.e("onError:" + e.getMessage());
                                    ToastUtils.showShort(GeneralMessageActivity.this, "发布失败！");
                                }

                                @Override
                                public void onSuccess(String response, int id) {
                                    Log.d("綜合信息", response);
                                    if (JsonUtils.isSuccess(response)) {
                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            int res = jsonObject.optInt("res", 0);
                                            if (res == 0) {
                                                ToastUtils.showShort(GeneralMessageActivity.this, "发布失败！");
                                            } else if (res == 1) {
                                                Toast.makeText(GeneralMessageActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                                                mEtTitle.setText("");
                                                mEtContent.setText("");
                                                photoList.clear();
                                                finish();

                                            } else {
                                                ToastUtils.showShort(GeneralMessageActivity.this, "未知错误！请重试。");
                                            }

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            });
//                            startActivity(new Intent(GeneralMessageActivity.this, StateActivity.class));
                        } else {
                            Toast.makeText(GeneralMessageActivity.this, "请输入标题和内容", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        mCbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //do something
                } else {
                    //do something else
                }
            }
        });
        mCbx.setChecked(isChecked);
    }


}
