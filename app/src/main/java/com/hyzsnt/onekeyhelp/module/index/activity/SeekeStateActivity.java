package com.hyzsnt.onekeyhelp.module.index.activity;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.index.adapter.CommunityListAdapter;
import com.hyzsnt.onekeyhelp.module.index.bean.CommunityList;

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
    @BindView(R.id.community_list_rec)
    RecyclerView mCommunityListRec;
    //    private HotAreaInfo mHotAreaInfo;
    private List<CommunityList.ListBean> listBeen;
    private CommunityList mList = null;
    private CommunityListAdapter mAdapter;

    //获取行政区信息的接口 a
    private static final String REGIONAL = "getRegional";
    //获取热门地区的接口 a
    private static final String HOTAREA = "getHotArea";


//    List<String> p = new ArrayList<>();
//    SharedPreferences sp = App.getContext().getSharedPreferences("",Context.MODE_PRIVATE);

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seeke_state;
    }

    @Override
    protected void initData() {
        List<String> parms = new ArrayList<>();

        String lat = Double.toString(App.getLocation().getLatitude());
        Log.d("lat", lat);
        String lon = Double.toString(App.getLocation().getLongitude());
        Log.d("lon", lon);
        parms.add("1");
        parms.add("4");
        parms.add(lat);
        parms.add(lon);
        parms.add("110000");
//        parms.add("116.539995");
//        parms.add("110105");
//        parms.add("2");
        HttpUtils.post(Api.PUBLIC, HOTAREA, parms, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(SeekeStateActivity.this, "你输入的有误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String response, int id) {
                Log.d("111111111", "response" + response);
                Toast.makeText(SeekeStateActivity.this, "链接成功", Toast.LENGTH_SHORT).show();

//                mAdapter = new CommunityListAdapter();
//                LinearLayoutManager manager = new LinearLayoutManager(SeekeStateActivity.this, LinearLayoutManager.VERTICAL, false);
//                mCommunityListRec.setLayoutManager(manager);
//                mCommunityListRec.setHasFixedSize(true);
//                mCommunityListRec.setItemAnimator(new DefaultItemAnimator());
//                //添加分割线
//                mCommunityListRec.addItemDecoration(new MyDecoration(SeekeStateActivity.this, MyDecoration.VERTICAL_LIST));
//                listBeen = new ArrayList<CommunityList.ListBean>();
//                if (JsonUtils.isSuccess(response)) {
//                    Gson gson = new Gson();
//                    mList = gson.fromJson(response, CommunityList.class);
//                    listBeen = mList.getList();
//                    mAdapter.setCommunityLists(listBeen);
//                    mCommunityListRec.setAdapter(mAdapter);
//                } else {
//                    String err = JsonUtils.getErrorMessage(response);
//                    LogUtils.e(err);
//
//                }
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
    protected void initListener() {
        super.initListener();
        //点击取消按钮退出本页面，返回上一页面
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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

            }
        });


    }
}
