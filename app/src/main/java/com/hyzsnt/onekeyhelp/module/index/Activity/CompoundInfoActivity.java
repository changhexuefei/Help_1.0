package com.hyzsnt.onekeyhelp.module.index.activity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;

/**
 * 点击主页面的小区简介进入
 */

public class CompoundInfoActivity extends BaseActivity {
    //初始化EditText,小区名称，人数，小区简介信息，物业电话，小区地址
    @BindView(R.id.btn_return)
    ImageButton mBtnReturn;
    @BindView(R.id.compound_icon)
    ImageView mCompoundIcon;
    @BindView(R.id.compound_name)
    TextView mCompoundName;
    @BindView(R.id.compound_people_num)
    TextView mCompoundPeopleNum;
    @BindView(R.id.compound_info)
    TextView mCompoundInfo;
    @BindView(R.id.estate_phone)
    TextView mEstatePhone;
    @BindView(R.id.subdistrict_name)
    TextView mSubdistrictName;
    @BindView(R.id.subdistrict_phone)
    TextView mSubdistrictPhone;
    @BindView(R.id.subdistrict_address)
    TextView mSubdistrictAddress;
    @BindView(R.id.estate_name)
    TextView mEstateName;
    @BindView(R.id.estate_address)
    TextView mEstateAddress;
    @BindView(R.id.estate_info)
    TextView mEstateInfo;
    @BindView(R.id.other_name)
    TextView mOtherName;
    @BindView(R.id.other_address)
    TextView mOtherAddress;
    @BindView(R.id.other_phone)
    TextView mOtherPhone;
    @BindView(R.id.other_info)
    TextView mOtherInfo;


    public void initListener() {
        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_compound_info;
    }

    @Override
    protected void initData() {
        mCompoundName.setText("兴隆小区");
        mCompoundInfo.setText("兴隆小区位于北京，为高层建筑住宅，占地面积达7593.93平方米。");
        mCompoundIcon.setImageResource(R.mipmap.ic_launcher);
        mCompoundPeopleNum.setText("1000人");

        mSubdistrictName.setText("好哦哦你扭扭捏捏");
        mSubdistrictAddress.setText("北京市");
        mSubdistrictPhone.setText("12345678");

        mEstateAddress.setText("北京市");
        mEstateInfo.setText("高层建筑住宅，占地面积达7593.93平方米。高层建筑住宅，占地面积达7593.93平方米。" +
                "高层建筑住宅，占地面积达7593.93平方米。高层建筑住宅，占地面积达7593.93平方米。高层建筑住宅，" +
                "占地面积达7593.93平方米。");
       mEstateName.setText("神舟物业");
        mEstatePhone.setText("12345678");

        mOtherAddress.setText("qwqwqwqw");
        mOtherName.setText("gagagaga");
        mOtherPhone.setText("12345678");
        mOtherInfo.setText("高层建筑住宅，占地面积达7593.93平方米。" +
                "高层建筑住宅，占地面积达7593.93平方米。" +
                "高层建筑住宅，占地面积达7593.93平方米。" +
                "高层建筑住宅，占地面积达7593.93平方米。");

    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // 按下键盘上返回按钮
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//
//            new AlertDialog.Builder(this)
//                    .setMessage("确定退出系统吗？")
//                    .setNegativeButton("取消",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//                                }
//                            })
//                    .setPositiveButton("确定",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog,
//                                                    int whichButton) {
//                                    finish();
//                                }
//                            }).show();
//
//            return true;
//        } else {
//            return super.onKeyDown(keyCode, event);
//        }


//    }


}
