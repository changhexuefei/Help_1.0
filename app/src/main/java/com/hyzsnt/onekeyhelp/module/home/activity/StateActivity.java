package com.hyzsnt.onekeyhelp.module.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
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
import com.hyzsnt.onekeyhelp.module.home.adapter.StateDetailAdapter;
import com.hyzsnt.onekeyhelp.module.home.bean.DynamicListByCommunityList;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StateActivity extends BaseActivity {

    @BindView(R.id.sate_activity_recyclerview)
    LRecyclerView stateRecyclerView;
    @BindView(R.id.state_goback)
    ImageView stateGoback;
    @BindView(R.id.state_et_replay)
    EditText stateEtReplay;
    private InputMethodManager imm;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_state;
    }

    @Override
    protected void initData() {
        //得到InputMethodManager的实例
        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        DynamicListByCommunityList dynamicListByCommunity = (DynamicListByCommunityList) bundle.getSerializable("dynamicListByCommunity");

        StateDetailAdapter mStateDetailAdapter = new StateDetailAdapter(this);
        final LRecyclerViewAdapter adapter = new LRecyclerViewAdapter(mStateDetailAdapter);
        stateRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        stateRecyclerView.setAdapter(adapter);
        stateRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //加入头布局
        CommonHeader header = new CommonHeader(this, R.layout.item_activity_state_detail_head);
        adapter.addHeaderView(header);

        TextView stateDetailTvNickname = (TextView) header.findViewById(R.id.state_detail_tv_nickname);
        TextView stateDetailTvDistance = (TextView) header.findViewById(R.id.state_detail_tv_distance);
        TextView stateDetailTvContent = (TextView) header.findViewById(R.id.state_detail_tv_content);
        TextView stateDetailTvGoodnum = (TextView) header.findViewById(R.id.state_detail_tv_goodnum);
        TextView stateDetailTvReplynum = (TextView) header.findViewById(R.id.state_detail_tv_replynum);
        LinearLayout stateDetailLlReplay = (LinearLayout) header.findViewById(R.id.state_detail_ll_replay);

        stateDetailTvNickname.setText(dynamicListByCommunity.getNickname());
        stateDetailTvDistance.setText(dynamicListByCommunity.getDistance());
        stateDetailTvContent.setText(dynamicListByCommunity.getContent());
        stateDetailTvGoodnum.setText(dynamicListByCommunity.getGoodnum());
        stateDetailTvReplynum.setText(dynamicListByCommunity.getReplynum());

        //回复
        stateDetailLlReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(StateActivity.this, "mixixi");
                //if (!imm.isActive()) {
                //imm.toggleSoftInput(0, InputMethodManager.RESULT_SHOWN);
                //imm.showSoftInput(stateEtReplay,InputMethodManager.RESULT_SHOWN);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                //}
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.state_goback)
    public void onClick() {
        finish();
    }
}
