package com.hyzsnt.onekeyhelp.module.release.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.hss01248.dialog.StyledDialog;
import com.hss01248.dialog.interfaces.MyItemDialogListener;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.release.activity.GeneralMessageActivity;
import com.hyzsnt.onekeyhelp.module.release.activity.TalkActivity;
import com.hyzsnt.onekeyhelp.module.release.activity.VoiceReleaseActivity;
import com.hyzsnt.onekeyhelp.module.release.adapter.ReleaseListAdapter;
import com.hyzsnt.onekeyhelp.module.release.bean.Release;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReleaseFragment extends BaseFragment {

    List<String> parms;
    private static final String MTYPE = "getMTypeDynamic";
    @BindView(R.id.release_list)
    ListView mReleaseList;
    private ReleaseListAdapter mAdapter;
    List<Release.ListBean> releaseList;


    public ReleaseFragment() {
        // Required empty public constructor

    }

    @Override
    protected List<String> getParams() {
        return null;
    }

    @Override
    protected void initData(String content) {
        getReleaseListInfo();

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_release;
    }

    @Override
    public String getC() {
        return null;
    }

    @Override
    public String getA() {
        return null;
    }

    /**
     * 进入发布页面，首先获得动态的信息列表，动态显示
     */
    public void getReleaseListInfo() {
        parms = new ArrayList<>();
        parms.add("");
        HttpUtils.post(Api.PUBLISH, MTYPE, parms, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onSuccess(String response, int id) {
                if (JsonUtils.isSuccess(response)) {
                     releaseList = new ArrayList<Release.ListBean>();
                    Log.d("发布动态", response);
                    Gson gson = new Gson();
                    Release release = gson.fromJson(response, Release.class);
                    Log.d("release", release + "");
                    releaseList = release.getList();
                    mAdapter = new ReleaseListAdapter(mActivity);
                    mAdapter.setListBeen(releaseList);
                    mReleaseList.setAdapter(mAdapter);
                    mReleaseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            if(releaseList.get(position).getPkey()!=null){
                                if(releaseList.get(position).getPkey().equals("3")){
                                    popupDialog();
                                }else if(releaseList.get(position).getPkey().equals("2")){
                                    Intent i1 = new Intent(mActivity, GeneralMessageActivity.class);
                                    i1.putExtra("tag1", "iv_gener");
                                    startActivity(i1);
                                }
//                                else if(){
//                                         房屋出租
//
//                                }else if(){
//                                          闲置物品
//
//                                }
                            }
                        }
                    });

                } else {
                    JsonUtils.getErrorMessage(response);
                }

            }
        });
    }

    public void popupDialog(){
        final List<String> strings = new ArrayList<>();
                strings.add("文字发布");
                strings.add("语音发布");
                StyledDialog.buildBottomItemDialog(mActivity, strings, "取消", new MyItemDialogListener() {

                    @Override
                    public void onItemClick(CharSequence charSequence, int i) {
                        ToastUtils.showShort(mActivity, charSequence);
                        if (i == 0) {
                            Intent i2 = new Intent(mActivity, TalkActivity.class);
                            i2.putExtra("tag", "iv_talk");
                            startActivity(i2);
                        }
                        if (i == 1) {
                            Intent i3 = new Intent(mActivity, VoiceReleaseActivity.class);
                            i3.putExtra("tag2", "iv_voice");
                            startActivity(i3);
                        }
                    }
                    @Override
                    public void onBottomBtnClick() {
                    }
                }).show();

    }


}
