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
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.index.bean.HotAreaInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

/**
 * 在主页面点击搜索图标进入到搜索页面
 */

public class SeekeStateActivity extends BaseActivity {

    @BindView(R.id.tv_cancel)
    TextView tv_cancel;
    @BindView(R.id.search_estate_bar)
    EditText mSearchEstateBar;
    private HotAreaInfo mHotAreaInfo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seeke_state;
    }

    @Override
    protected void initData() {
        List<String> parms = new ArrayList<>();
        parms.add("110000");
//        parms.add("2");



        HttpUtils.post("public", "getRegional", parms, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(SeekeStateActivity.this, "你输入的有误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String response, int id) {
                Log.d("111111111","response"+ response);
                Toast.makeText(SeekeStateActivity.this, "链接成功", Toast.LENGTH_SHORT).show();


            }
        });



        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mSearchEstateBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

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

}
