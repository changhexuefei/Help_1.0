package com.hyzsnt.onekeyhelp.module.index.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

    private CharSequence temp;//监听前的文本
    private int editStart;//光标开始位置
    private int editEnd;//光标结束位置

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seeke_state;
    }

    @Override
    protected void initData() {
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
    public void beforeTextChanged(CharSequence c, int i, int i1, int i2) {

        Log.i("TAG", "输入文本之前的状态");
        temp = c;
    }

    @Override
    public void onTextChanged(CharSequence c, int i, int i1, int i2) {

        Log.i("TAG", "输入文字中的状态，count是一次性输入字符数");
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.i("TAG", "输入文字后的状态");
        editStart = mSearchEstateBar.getSelectionStart();
        editEnd = mSearchEstateBar.getSelectionEnd();

    }
}
