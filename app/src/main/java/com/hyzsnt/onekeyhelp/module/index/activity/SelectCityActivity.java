package com.hyzsnt.onekeyhelp.module.index.activity;

import android.content.Intent;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.index.bean.ProvinceHasCityInfo;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

public class SelectCityActivity extends BaseActivity {
    @BindView(R.id.province_initial)
    TextView mProvinceInitial;
    @BindView(R.id.province_name)
    TextView mProvinceName;
    @BindView(R.id.city_list)
    LinearLayout myLayout;
    private List<String> parms;
    private static final String REGIONAL = "getRegional";

    private List<String> citys;
    List<ProvinceHasCityInfo> mInfos;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_city;
    }

    @Override
    protected void initData() {
        citys = new ArrayList<>();
        parms = new ArrayList<>();
        Intent intent = getIntent();
        String cityID = intent.getStringExtra("cityid");
        String initial = intent.getStringExtra("initial");
        String provinceName = intent.getStringExtra("provinceName");
        mProvinceInitial.setText(initial);
        mProvinceName.setText(provinceName);
        Toast.makeText(this, cityID, Toast.LENGTH_SHORT).show();
        getProvinceHasCityList(cityID);
    }

    private void getProvinceHasCityList(String cityID) {

        parms.add(cityID);

        HttpUtils.post(Api.PUBLIC, REGIONAL, parms, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.d("出错了", e.toString());
            }

            @Override
            public void onSuccess(String response, int id) {
                Log.d("城市", response);
                if (JsonUtils.isSuccess(response)) {
                    try {
                        JSONObject ct = new JSONObject(response);
                        int res = ct.optInt("res", 0);
                        if (res == 0) {
                            ToastUtils.showShort(SelectCityActivity.this, "失败！");

                        } else if (res == 1) {
                            JSONArray list = ct.getJSONArray("list");
                            mInfos = new ArrayList<ProvinceHasCityInfo>();
                            for (int i = 0; i < list.length(); i++) {
                                JSONObject jsonObject = list.getJSONObject(i);
                                ProvinceHasCityInfo info = new ProvinceHasCityInfo();
                                info.setcID(jsonObject.getString("regid"));
                                info.setcName(jsonObject.getString("regname"));
                                citys.add(jsonObject.getString("regname"));
                                mInfos.add(info);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    initAutoLL();

                } else {
                    String err = JsonUtils.getErrorMessage(response);
                    LogUtils.e(err);
                }
            }
        });
    }

    //    绘制自动换行的线性布局
    private void initAutoLL() {
//        每一行的布局，初始化第一行布局
        LinearLayout rowLL = new LinearLayout(this);
        LinearLayout.LayoutParams rowLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        float rowMargin = dipToPx(10);
        rowLP.setMargins(0, (int) rowMargin, 0, 0);
        rowLL.setLayoutParams(rowLP);
        boolean isNewLayout = false;
        float maxWidth = getScreenWidth() - dipToPx(30);
//        剩下的宽度
        float elseWidth = maxWidth;
        LinearLayout.LayoutParams textViewLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewLP.setMargins((int) dipToPx(8), 0, 0, 0);
        for (int i = 0; i < citys.size(); i++) {
            Log.d("++++++++++++++++++++", "" + citys.size());
//            若当前为新起的一行，先添加旧的那行
//            然后重新创建布局对象，设置参数，将isNewLayout判断重置为false
            if (isNewLayout) {
                myLayout.addView(rowLL);
                rowLL = new LinearLayout(this);
                rowLL.setLayoutParams(rowLP);
                isNewLayout = false;
            }
//            计算是否需要换行
            final TextView textView = (TextView) getLayoutInflater().inflate(R.layout.item_textview, null);
            textView.setText(citys.get(i));
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SelectCityActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(SelectCityActivity.this, "" + v.getId(), Toast.LENGTH_SHORT).show();
                }
            });
            textView.measure(0, 0);
//            若是一整行都放不下这个文本框，添加旧的那行，新起一行添加这个文本框
            if (maxWidth < textView.getMeasuredWidth()) {
                myLayout.addView(rowLL);
                rowLL = new LinearLayout(this);
                rowLL.setLayoutParams(rowLP);
                rowLL.addView(textView);
                isNewLayout = true;
                continue;
            }
//            若是剩下的宽度小于文本框的宽度（放不下了）
//            添加旧的那行，新起一行，但是i要-1，因为当前的文本框还未添加
            if (elseWidth < textView.getMeasuredWidth()) {
                isNewLayout = true;
                i--;
//                重置剩余宽度
                elseWidth = maxWidth;
                continue;
            } else {
//                剩余宽度减去文本框的宽度+间隔=新的剩余宽度
                elseWidth -= textView.getMeasuredWidth() + dipToPx(8);
                if (rowLL.getChildCount() == 0) {
                    rowLL.addView(textView);
                } else {
                    textView.setLayoutParams(textViewLP);
                    rowLL.addView(textView);
                }
            }
        }
//        添加最后一行，但要防止重复添加
        myLayout.removeView(rowLL);
        myLayout.addView(rowLL);
    }

    //    dp转px
    private float dipToPx(int dipValue) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dipValue,
                this.getResources().getDisplayMetrics());
    }

    //  获得屏幕宽度
    private float getScreenWidth() {
        return this.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
