package com.hyzsnt.onekeyhelp.module.index.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.index.adapter.ProvinceListAdapter;
import com.hyzsnt.onekeyhelp.module.index.bean.PinyinComparator;
import com.hyzsnt.onekeyhelp.module.index.bean.SortCity;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.PinyinUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

public class ProvinceListActivity extends BaseActivity {

    @BindView(R.id.province_listView)
    ListView mProvinceListView;
    private static final String REGIONAL = "getRegional";
    private List<SortCity> mSortCities;
    private ProvinceListAdapter mAdapter;
    private PinyinComparator pinyinComparator;
    List<String> province;
    List<String> parms = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_province_list;
    }

    @Override
    protected void initData() {
        province = new ArrayList<>();
        pinyinComparator = new PinyinComparator();
        Intent intent = getIntent();
        String regid = intent.getStringExtra("regid");
        getProvinceList(regid);
    }

    private void getProvinceList(String regid) {
        parms.add(regid);
        HttpUtils.post(Api.PUBLIC, REGIONAL, parms, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onSuccess(String response, int id) {
                Toast.makeText(ProvinceListActivity.this, "成功了", Toast.LENGTH_SHORT).show();
                Log.d("0000000000", response);

                if (JsonUtils.isSuccess(response)) {
                    try {
                        JSONObject object = new JSONObject(response);
//                        final JSONObject list = object.getJSONObject("list");
                        JSONArray list = object.getJSONArray("list");
                        mSortCities = new ArrayList<SortCity>();
                        for (int i = 0; i <list.length() ; i++) {
                            JSONObject jsonObject = list.getJSONObject(i);
                            SortCity city = new SortCity();
                            city.setId(jsonObject.getString("regid"));
                            city.setName(jsonObject.getString("regname"));
                            province.add(jsonObject.getString("regname"));
                            for (int j = 0; j < province.size(); j++) {
                                String firstSpell1 = PinyinUtils.getFirstSpell(province.get(i));
                                String sortString = firstSpell1.substring(0, 1).toUpperCase();
                                // 正则表达式，判断首字母是否是英文字母
                                if (sortString.matches("[A-Z]")) {
                                    city.setSortLetters(sortString.toUpperCase());
                                } else {
                                    city.setSortLetters("#");
                                }
                            }
                            Log.d("999999", "" + province);

                            mSortCities.add(city);
                        }
//
                        mProvinceListView.setVisibility(View.VISIBLE);
                        Collections.sort(mSortCities, pinyinComparator);
                        mAdapter = new ProvinceListAdapter(ProvinceListActivity.this);
                        mAdapter.setList(mSortCities);
                        mProvinceListView.setAdapter(mAdapter);
                        //点击省份的每一行出现省份下辖市
                        mProvinceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String cityID = mSortCities.get(position).getId();
                                ToastUtils.showLong(ProvinceListActivity.this, cityID);
                                Intent intent = new Intent(ProvinceListActivity.this, SelectCityActivity.class);
                                intent.putExtra("cityid", cityID);
                                intent.putExtra("initial", mSortCities.get(position).getSortLetters());
                                intent.putExtra("provinceName", mSortCities.get(position).getName());
                                startActivity(intent);
                            }
                        });
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
    protected void onDestroy() {
        super.onDestroy();
    }
}
