package com.hyzsnt.onekeyhelp.module.index.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompoundInfoActivity extends BaseActivity {


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
    @BindView(R.id.estate_phone)
    TextView mEstatePhone;
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
        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
