package com.hyzsnt.onekeyhelp.module.home.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.google.gson.Gson;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.help.adapter.HelpListAdapter;
import com.hyzsnt.onekeyhelp.module.help.bean.HelpList;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;


@RuntimePermissions
public class HelpListActivity extends BaseActivity {

    @BindView(R.id.re_help_list)
    RecyclerView mReHelpList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_help_list;
    }

    @Override
    protected void initData() {
        HelpListActivityPermissionsDispatcher.requestCallPhonePermissionWithCheck(this);
        requestCallPhonePermission();
        final HelpListAdapter adapter = new HelpListAdapter(HelpListActivity.this);
        mReHelpList.setLayoutManager(new LinearLayoutManager(HelpListActivity.this));
        mReHelpList.setAdapter(adapter);
        //获得用户id
        String uid = getIntent().getStringExtra("uid");
        //请求数据
        final List<String> list = new ArrayList<>();
        list.add(uid);
        LogUtils.e(uid);
        HttpUtils.post(Api.RESCUE, Api.Rescue.GETHELPCALLERLIST, list, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }
            @Override
            public void onSuccess(String response, int id) {

                if (JsonUtils.isSuccess(response)) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        Object list1 = jsonObject.get("list");
                        if (list1 != null && !list.equals("")) {
                            Gson gson = new Gson();
                            final HelpList helpList = gson.fromJson(response, HelpList.class);
                            adapter.setData(helpList.getList());
                            adapter.notifyDataSetChanged();
                            adapter.setOnItemCallClickListener(new HelpListAdapter.OnItemCallClickListener() {
                                @Override
                                public void onItemClick(View view, int data) {

                                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + helpList.getList().get(data).getPhoneno()));
                                    LogUtils.e(data+helpList.getList().get(data).getPhoneno());
                                    startActivity(intent);
                                }
                            });
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    LogUtils.e(JsonUtils.getErrorMessage(response));
                }

            }

            @Override
            public void inProgress(float progress, long total, int id) {

            }
        });
    }

    @NeedsPermission(android.Manifest.permission.CALL_PHONE)
    public void requestCallPhonePermission() {

    }

    @OnClick(R.id.im_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        HelpListActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
