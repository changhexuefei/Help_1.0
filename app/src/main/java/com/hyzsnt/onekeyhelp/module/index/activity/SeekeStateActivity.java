package com.hyzsnt.onekeyhelp.module.index.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;

import butterknife.BindView;

/**
 * 在主页面点击搜索图标进入到搜索页面
 */

public class SeekeStateActivity extends BaseActivity implements TextWatcher {

    @BindView(R.id.tv_cancel)
    TextView tv_cancel;
    @BindView(R.id.search_estate_bar)
    EditText mSearchEstateBar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seeke_state;
    }

    @Override
    protected void initData() {
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(SeekeStateActivity.this, "你点击的是取消文档", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.city:
                Toast.makeText(this, "你点击的是city", Toast.LENGTH_SHORT).show();
                break;
            case R.id.county:
                Toast.makeText(this, "你点击的是county", Toast.LENGTH_SHORT).show();

                break;
            case R.id.hot_pints:
                Toast.makeText(this, "你点击的是hot_pints", Toast.LENGTH_SHORT).show();

                break;
        }
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Toast.makeText(this, "您输入的是" + charSequence.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable editable) {
        Toast.makeText(this, "您输入的是" + editable.toString(), Toast.LENGTH_SHORT).show();

    }
}
