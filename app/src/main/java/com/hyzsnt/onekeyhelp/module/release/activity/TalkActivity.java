package com.hyzsnt.onekeyhelp.module.release.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.release.adapter.ChoosePhotoListAdapter;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    private static final String PUBLISHDYNAMIC = "publishDynamic";
    List<String> p = new ArrayList<>();
    private final int REQUEST_CODE_GALLERY = 1001;
    private final int REQUEST_CODE_CAMERA = 1000;
    @BindView(R.id.btn_return)
    ImageButton mBtnReturn;
    @BindView(R.id.tv_msg)
    TextView mTvMsg;

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
    String mUid;
    @BindView(R.id.et_titile)
    EditText mEtTitile;
    @BindView(R.id.activity_talk)
    LinearLayout mActivityTalk;
    private String lat;
    private String lon;
    private String mTitle;
    private String mContent;
    private ArrayList<PhotoInfo> photoList;
    private ChoosePhotoListAdapter adapter;
    private int imageNums = 3;
    ArrayList<String> images;
    //发表的类别
    public int mTypeTag = 0;
    public String c = "";
    public String a = "";

    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            if (resultList != null) {
                switch (reqeustCode) {
                    case REQUEST_CODE_GALLERY:
                        if (photoList.size() < 3) {
                            photoList.addAll(resultList);
                            adapter.notifyDataSetChanged();
                        } else {
                            photoList.clear();
                            photoList.addAll(resultList);
                            adapter.notifyDataSetChanged();
                        }
                        images.clear();
                        for (int i = 0; i < photoList.size(); i++) {
                            String img_path = photoList.get(i).getPhotoPath();
                            Bitmap getimage = getimage(img_path);
                            images.add(bitmapToBase64(getimage));
                        }
                        break;
                    case REQUEST_CODE_CAMERA:
                        photoList.clear();
                        photoList.addAll(resultList);
                        adapter.notifyDataSetChanged();
                        images.clear();
                        for (int i = 0; i < photoList.size(); i++) {
                            String img_path = photoList.get(i).getPhotoPath();
                            Bitmap getimage = getimage(img_path);
                            images.add(bitmapToBase64(getimage));
                        }
                        break;
                }
            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {

        }
    };
    private String mCcid;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_talk;
    }

    @Override
    protected void initData() {
        images = new ArrayList<>();
        String userDetail = (String) SPUtils.get(this, "userDetail", "");
        ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
        mUid = userInfo.get(0).getmInfo().getUserInfoInfo().getUid();
        //用户的经纬度
        lat = Double.toString(App.getLocation().getLatitude());
        lon = Double.toString(App.getLocation().getLongitude());

        photoList = new ArrayList<>();
        adapter = new ChoosePhotoListAdapter(this, photoList);
        horizontalListView.setAdapter(adapter);
        Intent intent = getIntent();
        mCcid = intent.getStringExtra("ccid");
        String tag = intent.getStringExtra("tag");
        if (tag.equals("iv_talk")) {
            mTvMsg.setText("随便说说");
            mTypeTag = 1;
        } else if (tag.equals("发布话题")) {
            mTvMsg.setText("发布话题");
            mTypeTag = 2;
            mEtTitile.setVisibility(View.VISIBLE);
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
                //点击发布按钮后，将文字信息和图片信息发送到详情页面
                mBtnRelease.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mTypeTag == 1) {
                            //用户输入的内容信息
                            mContent = mEtContent.getText().toString();
                            if (mContent != null && !"".equals(mContent)) {
                                p.add(mUid);
                                p.add(lat);
                                p.add(lon);
                                p.add(mContent);
                                p.add(images.size() + "");
                                for (int i = 0; i < images.size(); i++) {
                                    p.add(images.get(i));
                                }

                                HttpUtils.post(Api.PUBLISH, Api.Publish.GETMTYPEDYNAMIC, p, new JsonResponseHandler() {
                                    @Override
                                    public void onError(Call call, Exception e, int id) {
                                        LogUtils.e("onError:" + e.getMessage());
                                        ToastUtils.showShort(TalkActivity.this, "发布失败！");
                                    }

                                    @Override
                                    public void onSuccess(String response, int id) {
                                        if (JsonUtils.isSuccess(response)) {
                                            ToastUtils.showShort(TalkActivity.this, "发布成功");
                                            mEtContent.setText("");
                                            photoList.clear();
                                            finish();
                                        } else {
                                            ToastUtils.showShort(TalkActivity.this, JsonUtils.getErrorMessage(response));
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(TalkActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
                            }
                        }
                        if (mTypeTag == 2) {
                            //用户输入的内容信息
                            mTitle = mEtTitile.getText().toString();
                            //用户输入的内容信息
                            mContent = mEtContent.getText().toString();
                            if (mContent != null && !"".equals(mContent)&&"".equals(mTitle)) {
                                p.add(mCcid);
                                p.add(mUid);
                                LogUtils.e(mCcid);
                                p.add(lat);
                                p.add(lon);
                                p.add(mTitle);
                                p.add(mContent);
                                if (mCbx.isChecked()) {
                                    p.add("1");
                                } else {
                                    p.add("0");
                                }
                                p.add(images.size() + "");
                                for (int i = 0; i < images.size(); i++) {
                                    p.add(images.get(i));
                                }

                                HttpUtils.post(Api.CIRCLE, Api.Circle.PUBLISHTOPIC, p, new JsonResponseHandler() {
                                    @Override
                                    public void onError(Call call, Exception e, int id) {
                                        LogUtils.e("onError:" + e.getMessage());
                                        ToastUtils.showShort(TalkActivity.this, "发布失败！");
                                    }

                                    @Override
                                    public void onSuccess(String response, int id) {
                                        if (JsonUtils.isSuccess(response)) {
                                            ToastUtils.showShort(TalkActivity.this, "发布成功");
                                            mEtContent.setText("");
                                            photoList.clear();
                                            finish();
                                        } else {
                                            ToastUtils.showShort(TalkActivity.this, JsonUtils.getErrorMessage(response));
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(TalkActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
                            }
                        }
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

                int childCount = horizontalListView.getChildCount();
                if (childCount == 3) {
                    ToastUtils.showShort(TalkActivity.this, "重新选择三张图片");
                    imageNums = 3;
                } else if (childCount == 1) {
                    ToastUtils.showShort(TalkActivity.this, "还可以选择两张图片");
                    imageNums = 2;
                } else if (childCount == 2) {
                    ToastUtils.showShort(TalkActivity.this, "还可以选择一张图片");
                    imageNums = 1;
                }
                FunctionConfig functionConfig = new FunctionConfig.Builder()
                        .setEnableCamera(true)
                        .setMutiSelectMaxSize(imageNums)
                        .build();
                GalleryFinal.openGalleryMuti(REQUEST_CODE_GALLERY, functionConfig, mOnHanlderResultCallback);
            }
        });
    }

    @Override
    protected void initListener() {
        super.initListener();

        mCbx.setChecked(isChecked);
    }

    /**
     * 将bitmap转换成base64字符串
     *
     * @param bitmap
     * @return base64 字符串
     */
    public static String bitmapToBase64(Bitmap bitmap) {

        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                baos.flush();
                baos.close();
                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 压缩
     *
     * @param image
     * @return
     */
    private Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    private Bitmap getimage(String srcPath) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);//此时返回bm为空
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;//这里设置高度为800f
        float ww = 480f;//这里设置宽度为480f
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;//设置缩放比例
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        return compressImage(bitmap);//压缩好比例大小后再进行质量压缩
    }

}
