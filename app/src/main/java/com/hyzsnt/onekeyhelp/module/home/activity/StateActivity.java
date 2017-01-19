package com.hyzsnt.onekeyhelp.module.home.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.view.CommonHeader;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
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
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 动态详情
 */
public class StateActivity extends BaseActivity {
    @BindView(R.id.sate_activity_recyclerview)
    LRecyclerView stateRecyclerView;
    //回复的输入框
    @BindView(R.id.state_et_replay)
    EditText stateEtReplay;
    //返回
    @BindView(R.id.state_goback)
    ImageView stateGoback;
    //回复的按钮
    @BindView(R.id.state_tv_replay)
    TextView stateTvReplay;
    @BindView(R.id.sate_ll)
    LinearLayout sateLl;
    @BindView(R.id.home_tv_title)
    TextView mHomeTvTitle;
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
    //经度
    private String mLat;
    //纬度
    private String mLon;
    //加入小区的条目数
    private String mIncommunitynum;
    //用户id
    private String mUid;
    private ArrayList<MDate> mUserInfo;
    private TextView mStateDetailtopic;
    private LinearLayout mStateDtaeilgood;
    private ImageView mImageone;
    private ImageView mImageTwo;
    private ImageView mImageThree;
    private ImageView mImagevoice;
    private TextView mStateDtatailType;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_state;
    }

    @Override
    protected void initData() {
        Intent i = getIntent();
        bundle = i.getExtras();
        if (!bundle.isEmpty()) {
            tag = bundle.getString("tag");
        }
        //初始化控件
        initview();
        //初始化数据
        if (tag.equals(Api.COMMUNITY)) {
            initCommunity();
        } else if (tag.equals(Api.CIRCLE)) {
            initCircle();
        } else if (tag.equals("voice")) {

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
    //初始化视图
    private void initview() {
        mStateDetailAdapter = new StateDetailAdapter(this);
        final LRecyclerViewAdapter adapter = new LRecyclerViewAdapter(mStateDetailAdapter);
        stateRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        stateRecyclerView.setAdapter(adapter);
        stateRecyclerView.setItemAnimator(new DefaultItemAnimator());
        stateRecyclerView.setPullRefreshEnabled(false);
        //加入头布局
        CommonHeader header = new CommonHeader(this, R.layout.item_activity_state_detail_head);
        adapter.addHeaderView(header);
        //昵称
        stateDetailTvNickname = (TextView) header.findViewById(R.id.state_detail_tv_nickname);
        //距离
        stateDetailTvDistance = (TextView) header.findViewById(R.id.state_detail_tv_distance);
        //内容
        stateDetailTvContent = (TextView) header.findViewById(R.id.state_detail_tv_content);
        //点赞数
        stateDetailTvGoodnum = (TextView) header.findViewById(R.id.state_detail_tv_goodnum);
        //回复数
        stateDetailTvReplynum = (TextView) header.findViewById(R.id.state_detail_tv_replynum);
        stateDetailLlReplay = (LinearLayout) header.findViewById(R.id.state_detail_ll_replay);
        mStateDetailtopic = (TextView) header.findViewById(R.id.tv_state_details_toptic);
        mStateDtaeilgood = (LinearLayout) header.findViewById(R.id.llayout_state_detail_good);
        mImageone = (ImageView) header.findViewById(R.id.im_state_setail_content_one);
        mImageTwo = (ImageView) header.findViewById(R.id.im_state_setail_content_two);
        mImageThree = (ImageView) header.findViewById(R.id.im_state_setail_content_three);
        mImagevoice = (ImageView) header.findViewById(R.id.im_state_details_voice);
        mStateDtatailType = (TextView) header.findViewById(R.id.tv_state_details_type);
    }

    private void initCircle() {
        mHomeTvTitle.setText("话题详情");
        info = bundle.getParcelable("topicinfo");
        ArrayList<String> imags = bundle.getStringArrayList("imgs");
        stateDetailTvNickname.setText(info.getNickname());
        mStateDetailtopic.setText(info.getContent());
        stateDetailTvGoodnum.setText(info.getGoodnum());
        stateDetailTvReplynum.setText(info.getReplynum());
        if(!imags.isEmpty()){
            int size = imags.size();
            if(size>0){
                if(size>=1){
                    Glide.with(StateActivity.this).load(imags.get(0)).into(mImageone);
                    mImageone.setVisibility(View.VISIBLE);
                }if(size>=2){
                    Glide.with(StateActivity.this).load(imags.get(1)).into(mImageTwo);
                    mImageTwo.setVisibility(View.VISIBLE);
                } if (size==3) {
                    Glide.with(StateActivity.this).load(imags.get(2)).into(mImageThree);
                    mImageThree.setVisibility(View.VISIBLE);
                }

            }
        }

        //获取回复列表
        getreplay(info.getTid(), info.getCcid(), info.getUid());
    }

    private void initCommunity() {
        mHomeTvTitle.setText("动态详情");
        final DynamicListByCommunityList dynamicListByCommunity = (DynamicListByCommunityList) bundle.getSerializable("dynamicListByCommunity");
        stateDetailTvNickname.setText(dynamicListByCommunity.getNickname());
        //时间
        long time = Long.valueOf(dynamicListByCommunity.getPosttime());
        //获取当前时间
        long currenttime = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳
        String postTime = formatDuring(currenttime - time);
        //距离保留两位小数
        String distance = dynamicListByCommunity.getDistance();
        String result = "";
        if (!distance.equals("") && distance != null) {
            result = String.format("%.2f", Double.valueOf(distance));
        }
        stateDetailTvDistance.setText(postTime+"前  "+result+"米");
        if(!"".equals(dynamicListByCommunity.getGoodnum())){
            stateDetailTvGoodnum.setText(dynamicListByCommunity.getGoodnum());
        }
        if(!"".equals(dynamicListByCommunity.getReplynum())){
            stateDetailTvReplynum.setText(dynamicListByCommunity.getReplynum());
        }
        mStateDetailtopic.setText(dynamicListByCommunity.getContent());
        String contenttype = dynamicListByCommunity.getContenttype();
        //显示类型
        mStateDtatailType.setText(dynamicListByCommunity.getMtypeName());
        if("0".equals(contenttype)){
            stateDetailTvContent.setVisibility(View.GONE);
        }else if("1".equals(contenttype)){
            stateDetailTvContent.setVisibility(View.GONE);
            int size = dynamicListByCommunity.getImgs().size();
            if(size>0){
                if(size>=1){
                    Glide.with(StateActivity.this).load(dynamicListByCommunity.getImgs().get(0)).into(mImageone);
                    mImageone.setVisibility(View.VISIBLE);
                }if(size>=2){
                    Glide.with(StateActivity.this).load(dynamicListByCommunity.getImgs().get(1)).into(mImageTwo);
                    mImageTwo.setVisibility(View.VISIBLE);
                } if (size==3) {
                    Glide.with(StateActivity.this).load(dynamicListByCommunity.getImgs().get(2)).into(mImageThree);
                    mImageThree.setVisibility(View.VISIBLE);
                }
            }
        }else if("2".equals(contenttype)){
            mStateDetailtopic.setVisibility(View.GONE);
            mHomeTvTitle.setText("语音详情");
            stateDetailTvContent.setVisibility(View.GONE);
            //显示语音
            mImagevoice.setVisibility(View.VISIBLE);
            //播放地址
            final String voice = dynamicListByCommunity.getContent();
            //点击播放
            mImagevoice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mImagevoice.setImageResource(R.drawable.audio);
                    final AnimationDrawable animationDrawable = (AnimationDrawable) mImagevoice.getDrawable();
                    MediaPlayer mp = new MediaPlayer();
                    if(animationDrawable.isRunning()){
                        animationDrawable.stop();
                        mp.stop();
                    }else {
                        animationDrawable.start();
                    }

                    try {
                        mp.setDataSource(voice);
                        mp.prepare();
                        mp.start();
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                animationDrawable.stop();
                                mImagevoice.setImageResource(R.mipmap .audio_three);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
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
                if (tag.equals(Api.CIRCLE)) {
                    replay(info.getTid(), info.getCcid());
                    //获取列表
                    getreplay(info.getTid(), info.getCcid(), info.getUid());
                }
                sateLl.setVisibility(View.GONE);
                KeyBoardUtils.closeKeybord(stateEtReplay, this);
                break;
        }
    }

    private void getreplay(String tid, String ccid, String uid) {
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
                stateDetailTvReplynum.setText("" + commentListByTopic.get(0).getmList().getCommentListByTopics().size());
            }

            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });
    }

    private void replay(String tid, String ccid) {
        String userDetail = (String) SPUtils.get(this, "userDetail", "");
        ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
        UserInfoInfo userInfoInfo = userInfo.get(0).getmInfo().getUserInfoInfo();

        String trim = stateEtReplay.getText().toString().trim();
        List params = new ArrayList<String>();
        params.add(tid);
        params.add(ccid);
        params.add(userInfoInfo.getUid());//用户id
        params.add(mLat);
        params.add(mLon);
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

            }

            @Override
            public void inProgress(float progress, long total, int id) {
            }
        });
    }

    /**
     * 获取用户信息
     */
    public void getUserinfo() {
        String userDetail = (String) SPUtils.get(StateActivity.this, "userDetail", "");
        //解析用户信息
        mUserInfo = Resovle.getUserInfo(userDetail);
        //获取已加入的小区数
        mIncommunitynum = mUserInfo.get(0).getmInfo().getUserInfoInfo().getIncommunitynum();
        //获取用户id
        mUid = mUserInfo.get(0).getmInfo().getUserInfoInfo().getUid();
        //获取经度
        mLat = String.valueOf(App.getLocation().getLatitude());
        //获取纬度
        mLon = String.valueOf(App.getLocation().getLongitude());
    }

    //时间换算
    public static String formatDuring(long mss) {
        LogUtils.e("分钟" + mss);
        String time = "";
        long days = 0;
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        days = mss / (60 * 60 * 24);
        hours = (mss % (60 * 60 * 24)) / (60 * 60);
        minutes = (mss % (60 * 60)) / 60;
        seconds = (mss % (60));
        if (days > 0) {
            time = days + "天";
        }
        if (hours > 0) {
            time += hours + "时";
        }
        if (minutes > 0) {
            time += minutes + "分";
        }
        if (seconds > 0) {
            time += seconds + "秒";
        }
        return time;
    }
}
