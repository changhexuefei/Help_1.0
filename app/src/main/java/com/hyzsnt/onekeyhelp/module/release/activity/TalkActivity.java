package com.hyzsnt.onekeyhelp.module.release.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.activity.StateActivity;
import com.hyzsnt.onekeyhelp.module.release.adapter.ChoosePhotoListAdapter;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import cn.finalteam.galleryfinal.widget.HorizontalListView;
import okhttp3.Call;


public class TalkActivity extends BaseActivity {

    private static final String PUBLISH = "publishDynamic";

    List<String> p = new ArrayList<>();

    private final int REQUEST_CODE_GALLERY = 1001;
    private final int REQUEST_CODE_CAMERA = 1000;

    @BindView(R.id.btn_return)
    ImageButton mBtnReturn;
    @BindView(R.id.tv_msg)
    TextView mTvMsg;
    @BindView(R.id.et_title)
    EditText mEtTitle;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.cbx)
    CheckBox mCbx;
    @BindView(R.id.btn_release)
    Button mBtnRelease;
    @BindView(R.id.horizontal)
    HorizontalListView horizontalListView;
    @BindView(R.id.add_icon)
    TextView mAddIcon;
    //checkBox默认选中
    boolean isChecked = true;

    private String lat;
    private String lon;
    private String mTitle;
    private String mContent;
    private List<PhotoInfo> photoList;
    private ChoosePhotoListAdapter adapter;
    String[] iconString = new String[3];
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
        //用户的经纬度
        lat = Double.toString(App.getLocation().getLatitude());
        Log.d("lat", lat);
        lon = Double.toString(App.getLocation().getLongitude());
        Log.d("lon", lon);

        //用户输入的标题信息
        mTitle = mEtTitle.getText().toString();
        //用户输入的内容信息
        mContent = mEtContent.getText().toString();

        photoList = new ArrayList<>();
        adapter = new ChoosePhotoListAdapter(this, photoList);
        horizontalListView.setAdapter(adapter);
        horizontalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(TalkActivity.this, "位置" + position, Toast.LENGTH_SHORT).show();

            }
        });

        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");
        if (tag.equals("iv_talk")) {
            mTvMsg.setText("发表说说");
        }
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
                //点击发布信息后，将文字信息和图片信息发送到详情页面
                mBtnRelease.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TalkActivity.this, StateActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("mTitle", mTitle);
                        bundle.putString("mContent", mContent);
                        bundle.putSerializable("icon", (Serializable) photoList);
                        intent.putExtras(bundle);
                        p.add("4");
//                        p.add("2803");
                        p.add(lat);
                        p.add(lon);
                        p.add(mTitle);
                        p.add("1");
                        p.add("");
                        HttpUtils.post("publish", "publishDynamic", p, new JsonResponseHandler() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                            }
                            @Override
                            public void onSuccess(String response, int id) {
                                Log.d("fabu", response);
                            }
                        });
                        startActivity(intent);
                    }
                });
                break;
        }
    }

    @OnClick(R.id.add_icon)
    public void onClick() {
        mAddIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionConfig functionConfig = new FunctionConfig.Builder()
                        .setEnableCamera(true)
                        .setMutiSelectMaxSize(3)
                        .build();

                int childCount = horizontalListView.getChildCount();
                if (childCount >= 1 && 2 > childCount) {
                    mAddIcon.setVisibility(View.VISIBLE);
                }
                if (childCount == 2) {
                    mAddIcon.setVisibility(View.GONE);
                }
                GalleryFinal.openGalleryMuti(REQUEST_CODE_GALLERY, functionConfig, mOnHanlderResultCallback);
            }
        });
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

    public String convertIconToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();// outputstream
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] appicon = baos.toByteArray();// 转为byte数组
        return Base64.encodeToString(appicon, Base64.DEFAULT);

    }
}
