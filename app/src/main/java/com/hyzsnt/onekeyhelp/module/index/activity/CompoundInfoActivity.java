package com.hyzsnt.onekeyhelp.module.index.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityInfoInfo;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityInfoList;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;

import java.util.ArrayList;

import butterknife.BindView;

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
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            ArrayList<MDate> mDate = (ArrayList<MDate>) bundle.get("communityInfoList");

            //小区的名字，简介，小区人数
            CommunityInfoInfo Compound = mDate.get(0).getmInfo().getCommunityInfoInfo();
            mCompoundName.setText(Compound.getCmname());
            mCompoundInfo.setText(Compound.getSummary());
            mCompoundIcon.setImageResource(R.drawable.img);
            mCompoundPeopleNum.setText(Compound.getCurnum() + " 人");

            if (mDate.get(0).getmList().getCommunityInfoLists().size() == 3) {

                //街道办信息
                CommunityInfoList mSubdistrict = mDate.get(0).getmList().getCommunityInfoLists().get(0);
                mSubdistrictName.setText(mSubdistrict.getName());
                mSubdistrictAddress.setText(mSubdistrict.getAddress());
                mSubdistrictPhone.setText(mSubdistrict.getTelno());

                //物业公司信息
                CommunityInfoList mEstate = mDate.get(0).getmList().getCommunityInfoLists().get(1);
                mEstateAddress.setText(mEstate.getAddress());
                mEstateInfo.setText(mEstate.getSummary());
                mEstateName.setText(mEstate.getName());
                mEstatePhone.setText(mEstate.getTelno());

                //其他机构信息
                CommunityInfoList mOther = mDate.get(0).getmList().getCommunityInfoLists().get(2);
                mOtherAddress.setText(mOther.getAddress());
                mOtherName.setText(mOther.getName());
                mOtherPhone.setText(mOther.getTelno());
                mOtherInfo.setText(mOther.getSummary());
            } else {
                //街道办信息
                CommunityInfoList mSubdistrict = mDate.get(0).getmList().getCommunityInfoLists().get(0);
                mSubdistrictName.setText(mSubdistrict.getName());
                mSubdistrictAddress.setText(mSubdistrict.getAddress());
                mSubdistrictPhone.setText(mSubdistrict.getTelno());

            }
        }


        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
