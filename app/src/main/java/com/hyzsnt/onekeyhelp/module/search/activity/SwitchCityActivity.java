package com.hyzsnt.onekeyhelp.module.search.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.search.bean.IndexCityBean;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableLayout;
import okhttp3.Call;


public class SwitchCityActivity extends BaseActivity {

    @BindView(R.id.index_list)
    IndexableLayout mIndexList;
    private IndexCityBean mIndexCityBean;
    private CityAdapter mAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_switch_city;
    }

    @Override
    protected void initData() {
        List<String> params = new ArrayList<>();
        params.add("100000");
        HttpUtils.post(Api.PUBLIC, Api.Public.GETREGIONAL, params, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
                LogUtils.e("SwitchCityActivity onError:" + e.getMessage());
            }

            @Override
            public void onSuccess(String response, int id) {
                LogUtils.e("SwitchCityActivity onSuccess:" + response);
                if (JsonUtils.isSuccess(response)) {
                    mIndexCityBean = new Gson().fromJson(response, IndexCityBean.class);
                    mAdapter = new CityAdapter(SwitchCityActivity.this);
                    mIndexList.setAdapter(mAdapter);
                    Log.e("TAG", "mIndexCityBean:" + mIndexCityBean.toString());
                    mAdapter.setDatas(mIndexCityBean.getList());
                    mIndexList.setCompareMode(IndexableLayout.MODE_FAST);
                    mIndexList.setOverlayStyle_Center();
                    mAdapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<IndexCityBean.ListBean>() {
                        @Override
                        public void onItemClick(View v, int originalPosition, int currentPosition, final IndexCityBean.ListBean entity) {
                            List<String> kidsParams = new ArrayList<>();
                            kidsParams.add(entity.getRegid());
                            HttpUtils.post(Api.PUBLIC, Api.Public.GETREGIONAL, kidsParams, new JsonResponseHandler() {
                                @Override
                                public void onError(Call call, Exception e, int id) {
                                    LogUtils.e("onError:" + e.getMessage());
                                }

                                @Override
                                public void onSuccess(String response, int id) {
                                    LogUtils.e("city:" + response);
                                    if (JsonUtils.isSuccess(response)) {
                                        IndexCityBean bean = new Gson().fromJson(response, IndexCityBean.class);
                                        List<IndexCityBean.ListBean> list = bean.getList();
                                        if (list != null && !list.isEmpty()) {
                                            mAdapter.setDatas(list);
                                            mIndexList.setCompareMode(IndexableLayout.MODE_ALL_LETTERS);
                                        } else {
                                            Intent data = new Intent();
                                            data.putExtra("Regname", entity.getRegname());
                                            data.putExtra("Regid", entity.getRegid());
                                            setResult(RESULT_OK, data);
                                            finish();
                                        }
                                    } else {
                                        Toast.makeText(SwitchCityActivity.this, "联网失败：" + JsonUtils.getErrorMessage(response), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });
                } else {
                    Toast.makeText(SwitchCityActivity.this, "错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.iv_swi_back)
    public void back(View view) {
        finish();
    }

    class CityAdapter extends IndexableAdapter<IndexCityBean.ListBean> {

        private LayoutInflater mInflater;

        public CityAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup parent) {
            View view = mInflater.inflate(R.layout.item_index_city, parent, false);
            return new IndexVH(view);
        }

        @Override
        public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
            View view = mInflater.inflate(R.layout.item_city, parent, false);
            return new ContentVH(view);
        }

        @Override
        public void onBindTitleViewHolder(RecyclerView.ViewHolder holder, String indexTitle) {
            IndexVH vh = (IndexVH) holder;
            vh.tv.setText(indexTitle);
        }

        @Override
        public void onBindContentViewHolder(RecyclerView.ViewHolder holder, IndexCityBean.ListBean entity) {
            ContentVH vh = (ContentVH) holder;
            vh.tv.setText(entity.getRegname());
        }

        private class IndexVH extends RecyclerView.ViewHolder {
            TextView tv;

            public IndexVH(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv_index);
            }
        }

        private class ContentVH extends RecyclerView.ViewHolder {
            TextView tv;

            public ContentVH(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv_name);
            }
        }
    }
}
