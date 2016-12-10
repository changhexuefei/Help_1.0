package com.hyzsnt.onekeyhelp.module.index.activity;


import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;

public class CompoundInfoActivity extends BaseActivity {
    //初始化EditText,小区名称，人数，小区简介信息，物业电话，小区地址
    @BindView(R.id.compound_name)
    EditText tv_compound_name;
    @BindView(R.id.compound_people_num)
    EditText tv_compound_people_num;
    @BindView(R.id.compound_info)
    EditText tv_compound_info;
    @BindView(R.id.estate_phone)
    EditText tv_estate_phone;
    @BindView(R.id.compound_address)
    EditText tv_compound_address;

    //初始化小区简介图片
    @BindView(R.id.compound_icon)
    ImageView iv_compound_icon;
    //初始化打开popupWindow的ImageButton
    @BindView(R.id.btn_return)
    ImageButton ibtn_return;



    public void initListener() {
        ibtn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }


    @Override
    protected int getLayoutId() {
        return R.id.activity_compound_info;
    }

    @Override
    protected void initData() {
        tv_compound_name.setText("兴隆小区");
        tv_compound_info.setText("12222222");
        tv_compound_address.setText("高碑店");
        tv_compound_people_num.setText("1000人");
        tv_estate_phone.setText("12345678");
        iv_compound_icon.setImageResource(R.mipmap.ic_launcher);

    }
}
