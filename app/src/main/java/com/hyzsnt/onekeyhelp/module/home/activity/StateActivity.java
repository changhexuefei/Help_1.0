package com.hyzsnt.onekeyhelp.module.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.view.CommonHeader;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.adapter.StateDetailAdapter;
import com.hyzsnt.onekeyhelp.module.home.bean.DynamicListByCommunityList;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.bean.UserInfoInfo;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.stroll.bean.Topicinfo;
import com.hyzsnt.onekeyhelp.utils.KeyBoardUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class StateActivity extends BaseActivity {

    @BindView(R.id.sate_activity_recyclerview)
    LRecyclerView stateRecyclerView;
    @BindView(R.id.state_et_replay)
    EditText stateEtReplay;
    @BindView(R.id.state_goback)
    ImageView stateGoback;
    @BindView(R.id.state_tv_replay)
    TextView stateTvReplay;
    @BindView(R.id.sate_ll)
    LinearLayout sateLl;
    private InputMethodManager imm;
    private StateDetailAdapter mStateDetailAdapter;
    private Bundle bundle;
    private TextView stateDetailTvNickname;
    private TextView stateDetailTvDistance;
    private TextView stateDetailTvContent;
    private TextView stateDetailTvGoodnum;
    private TextView stateDetailTvReplynum;
    private LinearLayout stateDetailLlReplay;
    private String tag;
    private Topicinfo.InfoEntry info;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_state;
    }

    @Override
    protected void initData() {
        Intent i = getIntent();
        bundle = i.getExtras();
        tag = bundle.getString("tag");
        mStateDetailAdapter = new StateDetailAdapter(this);
        final LRecyclerViewAdapter adapter = new LRecyclerViewAdapter(mStateDetailAdapter);
        stateRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        stateRecyclerView.setAdapter(adapter);
        stateRecyclerView.setItemAnimator(new DefaultItemAnimator());
        stateRecyclerView.setPullRefreshEnabled(false);
        //加入头布局
        CommonHeader header = new CommonHeader(this, R.layout.item_activity_state_detail_head);
        adapter.addHeaderView(header);

        stateDetailTvNickname = (TextView) header.findViewById(R.id.state_detail_tv_nickname);
        stateDetailTvDistance = (TextView) header.findViewById(R.id.state_detail_tv_distance);
        stateDetailTvContent = (TextView) header.findViewById(R.id.state_detail_tv_content);
        stateDetailTvGoodnum = (TextView) header.findViewById(R.id.state_detail_tv_goodnum);
        stateDetailTvReplynum = (TextView) header.findViewById(R.id.state_detail_tv_replynum);
        stateDetailLlReplay = (LinearLayout) header.findViewById(R.id.state_detail_ll_replay);
        //初始化数据
        if(tag.equals(Api.COMMUNITY)){
            initCommunity();
        }else if(tag.equals(Api.CIRCLE)){
            initCircle();
        }
        //回复调出软件盘
        stateDetailLlReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sateLl.setVisibility(View.VISIBLE);
                KeyBoardUtils.openKeybord(stateEtReplay, StateActivity.this);
            }
        });
    }

    private void initCircle() {
        info = bundle.getParcelable("topicinfo");
        ArrayList<String> imags=bundle.getStringArrayList("imgs");
        stateDetailTvNickname.setText(info.getNickname());
        stateDetailTvContent.setText(info.getContent());
        stateDetailTvGoodnum.setText(info.getGoodnum());
        stateDetailTvReplynum.setText(info.getReplynum());
        //获取回复列表
        getreplay(info.getTid(),info.getCcid(),info.getUid());
    }
    private void initCommunity() {
        DynamicListByCommunityList dynamicListByCommunity = (DynamicListByCommunityList) bundle.getSerializable("dynamicListByCommunity");
        stateDetailTvNickname.setText(dynamicListByCommunity.getNickname());
        stateDetailTvDistance.setText(dynamicListByCommunity.getDistance());
        stateDetailTvContent.setText(dynamicListByCommunity.getContent());
        stateDetailTvGoodnum.setText(dynamicListByCommunity.getGoodnum());
        stateDetailTvReplynum.setText(dynamicListByCommunity.getReplynum());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.state_goback, R.id.state_tv_replay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.state_goback:
                KeyBoardUtils.closeKeybord(stateEtReplay, this);
                finish();
                break;
            case R.id.state_tv_replay:
                //发布话题回复
                if(tag.equals(Api.CIRCLE)){
                    replay(info.getTid(),info.getCcid());
                    //获取列表
                    getreplay(info.getTid(),info.getCcid(),info.getUid());
                }

                sateLl.setVisibility(View.GONE);
                KeyBoardUtils.closeKeybord(stateEtReplay, this);
                break;
        }
    }

    private void getreplay(String tid,String ccid,String uid) {
        List params = new ArrayList<String>();
        params.add(tid);
        params.add(ccid);
        params.add(uid);
        params.add("1");
        HttpUtils.post(Api.CIRCLE, Api.Circle.GETCOMMENTLISTBYTOPIC, params, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onSuccess(String response, int id) {
                ArrayList<MDate> commentListByTopic = Resovle.getCommentListByTopic(response);
                mStateDetailAdapter.setDates(commentListByTopic);
                mStateDetailAdapter.notifyDataSetChanged();
                stateDetailTvReplynum.setText(""+commentListByTopic.get(0).getmList().getCommentListByTopics().size());
            }
            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });
    }
    private void replay(String tid,String ccid) {
        String userDetail = (String) SPUtils.get(this, "userDetail", "");
        ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
        UserInfoInfo userInfoInfo = userInfo.get(0).getmInfo().getUserInfoInfo();

        String trim = stateEtReplay.getText().toString().trim();
        List params = new ArrayList<String>();
        params.add(tid);
        params.add(ccid);
        params.add(userInfoInfo.getUid());//用户id
        params.add("39.923594");
        params.add("116.539995");
        params.add(trim);
        params.add("");
        params.add("");
        stateEtReplay.setText("");
        HttpUtils.post(Api.CIRCLE, Api.Circle.PUBLISHTOPICREPLY, params, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onSuccess(String response, int id) {
                Log.e("444444444444444444",response+"");
            }
            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });
    }
}
