package com.hyzsnt.onekeyhelp.module.index.activity;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.index.adapter.CommunityListAdapter;
import com.hyzsnt.onekeyhelp.module.index.bean.CommunityList;
import com.hyzsnt.onekeyhelp.module.index.bean.HotAreaInfo;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

import static com.hyzsnt.onekeyhelp.app.App.getLocation;

/**
 * 在主页面点击搜索图标进入到搜索页面
 */

public class SeekeStateActivity extends BaseActivity {

    @BindView(R.id.tv_delete_text)
    TextView tv_delete_text;
    @BindView(R.id.btn_return)
    ImageView btn_return;
    @BindView(R.id.search_estate_bar)
    EditText mSearchEstateBar;

    @BindView(R.id.classify)
    LinearLayout mLayout;
    @BindView(R.id.city_name)
    TextView tv_cityName;
    @BindView(R.id.btn_change)
    Button btn_change;
    @BindView(R.id.city)
    LinearLayout linCity;
    @BindView(R.id.hotArea)
    TextView tv_hotArea;
    @BindView(R.id.com_list)
    LRecyclerView comList;
    List<HotAreaInfo> mHotAreaInfos;
    List<String> area;
    List<CommunityList.ListBean> mCommunityLists;
    private CommunityListAdapter mAdapter;


    //获取行政区信息的接口 a
    private static final String REGIONAL = "getRegional";
    //获取热门地区的接口 a
    private static final String HOTAREA = "getHotArea";
    //每次展现数量
    private static final String NUM = "1";
    //获取页数，初次检索默认1
    private static final String PAGENUM = "1";
    //检索条件
    private String searchCondition = "";

    //定位检索
    private static final String ORIENTATION = "0";
    //区域检索
    private static final String AREA = "1";
    //用户ID
    private String userid = "4";
    //上级行政区域ID
    private String regid = "100000";
    //条件集合
    List<String> parms = new ArrayList<>();
    private String lat;
    private String lon;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seeke_state;
    }

    @Override
    protected void initData() {
        area = new ArrayList<>();
        mAdapter = new CommunityListAdapter();
        getCurrentLocation();
    }

    /**
     * 得到当前位置的方法
     */
    private void getCurrentLocation() {
        lat = Double.toString(getLocation().getLatitude());
        Log.d("lat", lat);
        lon = Double.toString(getLocation().getLongitude());
        Log.d("lon", lon);

//        parms.add("");
        parms.add("0");
        parms.add(userid);
        parms.add(lat);
        parms.add(lon);
        parms.add("110000");

        HttpUtils.post(Api.PUBLIC, HOTAREA, parms, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onSuccess(String response, int id) {
                Log.d("我的位置是：", response);
                if (JsonUtils.isSuccess(response)) {
                    try {
                        JSONObject object = new JSONObject(response);
                        JSONObject info = object.getJSONObject("info");
                        String regname = info.getString("regname");
                        Log.d("12345678", regname);
                        if ("".equals(regname)) {
                            tv_cityName.setVisibility(View.GONE);
                        } else {
                            tv_cityName.setText(regname);
                        }
                        JSONObject list = object.getJSONObject("list");
                        Log.d("list", "" + list);
                        Iterator<String> iterator = list.keys();
                        mHotAreaInfos = new ArrayList<HotAreaInfo>();
                        while (iterator.hasNext()) {
                            String key = iterator.next();
                            Log.d("key+++++++", key);
                            HotAreaInfo hotAreaInfo = new HotAreaInfo();
                            hotAreaInfo.setComID(key);
                            String value = list.getString(key);
                            Log.d("value+++++", value);
                            hotAreaInfo.setComName(value);
                            area.add(value);
                            Log.d("============", "" + area.size());
                            mHotAreaInfos.add(hotAreaInfo);
                        }

                        initAutoLL();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    String err = JsonUtils.getErrorMessage(response);
                    LogUtils.e(err);
                }
            }
        });
    }

    @Override
    protected void initListener() {
        super.initListener();
        //点击左上角图标退出本页面，返回上一页面
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //点击取消，清空搜索框中的文字
        tv_delete_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchEstateBar.setText("");
                mLayout.removeAllViews();
            }
        });

        //搜索框的监听事件
        mSearchEstateBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//                search();
            }
        });
        //显示省份列表
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SeekeStateActivity.this, ProvinceListActivity.class);
                intent.putExtra("regid", regid);
                startActivity(intent);
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
        for (int i = 0; i < area.size(); i++) {
            Log.d("++++++++++++++++++++", "" + area.size());
//            若当前为新起的一行，先添加旧的那行
//            然后重新创建布局对象，设置参数，将isNewLayout判断重置为false
            if (isNewLayout) {
                mLayout.addView(rowLL);
                rowLL = new LinearLayout(this);
                rowLL.setLayoutParams(rowLP);
                isNewLayout = false;
            }
//            计算是否需要换行
            final TextView textView = (TextView) getLayoutInflater().inflate(R.layout.item_textview, null);
            textView.setText(area.get(i));
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CharSequence hrtext = textView.getText();
                    getCommunityInfo(hrtext);
//
                    Toast.makeText(SeekeStateActivity.this, "" + v.getId(), Toast.LENGTH_SHORT).show();
                }
            });
            textView.measure(0, 0);
//            若是一整行都放不下这个文本框，添加旧的那行，新起一行添加这个文本框
            if (maxWidth < textView.getMeasuredWidth()) {
                mLayout.addView(rowLL);
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
        mLayout.removeView(rowLL);
        mLayout.addView(rowLL);
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

    private void getCommunityInfo(CharSequence hrtext) {
        if (hrtext != null) {
            tv_hotArea.setVisibility(View.VISIBLE);
            tv_hotArea.setText(hrtext);
            hrtext.toString();
            btn_change.setVisibility(View.GONE);
            mLayout.removeAllViews();
//            parms.clear();
            parms.add("1");
            parms.add("10");
            parms.add("1");
            parms.add("4");
            parms.add(lat);
            parms.add(lon);
            parms.add("");
            parms.add("");
            parms.add(hrtext.toString());

            HttpUtils.post(Api.COMMUNITY, "getCommunityList", parms, new JsonResponseHandler() {
                @Override
                public void onError(Call call, Exception e, int id) {

                }

                @Override
                public void onSuccess(String response, int id) {
                    Log.d("小区", response);
                    if (JsonUtils.isSuccess(response)) {
                        mCommunityLists = new ArrayList<CommunityList.ListBean>();
                        Gson gson = new Gson();
                        CommunityList communityList = gson.fromJson(response, CommunityList.class);

                        mCommunityLists = communityList.getList();
                        mAdapter.setCommunityLists(mCommunityLists);
                        LinearLayoutManager manager = new LinearLayoutManager(SeekeStateActivity.this, LinearLayoutManager.VERTICAL, false);
                        comList.setLayoutManager(manager);
                        comList.setHasFixedSize(true);
                        comList.setItemAnimator(new DefaultItemAnimator());
                        LRecyclerViewAdapter adapter = new LRecyclerViewAdapter(mAdapter);
                        comList.setAdapter(adapter);
                        //行点击事件

                    } else {


                    }
                }
            });

        } else {
            tv_hotArea.setVisibility(View.GONE);
        }


    }


}
