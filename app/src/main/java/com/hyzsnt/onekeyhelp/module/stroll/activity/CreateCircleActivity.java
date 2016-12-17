package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.adapter.LoginCommunityAdapter;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleTypeAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class CreateCircleActivity extends BaseActivity {


    @BindView(R.id.im_circle_back)
    ImageView mImCircleBack;
    @BindView(R.id.relayout_create_circle_two)
    RelativeLayout mRelayoutCreateCircleTwo;
    @BindView(R.id.im_upload_picture)
    ImageView mImUploadPicture;
    @BindView(R.id.et_create_circle_name)
    EditText mEtCreateCircleName;
    @BindView(R.id.et_create_circle_des)
    EditText mEtCreateCircleDes;
    @BindView(R.id.re_create_circle_type)
    RecyclerView mReCreateCircleType;

    @BindView(R.id.activity_create_circle)
    RelativeLayout mActivityCreateCircle;
    @BindView(R.id.ll_exchange_community)
    LinearLayout llExchangeCommunity;
    //圈子类型集合
    private ArrayList<CircleType> mtypelist;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_circle;
    }

    @Override
    protected void initData() {
        mtypelist = new ArrayList<CircleType>();
        mtypelist.add(new CircleType("美\n食", R.mipmap.circle_foods, R.drawable.circle_type_one));
        mtypelist.add(new CircleType("亲\n自", R.mipmap.circle_by_oneself, R.drawable.circle_type_two));
        mtypelist.add(new CircleType("健\n身", R.mipmap.circle_fitness, R.drawable.circle_type_three));
        mtypelist.add(new CircleType("聚\n会", R.mipmap.circle_meeting, R.drawable.circle_type_four));
        mtypelist.add(new CircleType("运\n动", R.mipmap.circle_sport, R.drawable.circle_type_five));
        mtypelist.add(new CircleType("音\n乐", R.mipmap.circle_music, R.drawable.circle_type_six));
        mtypelist.add(new CircleType("互\n助", R.mipmap.circle_help, R.drawable.circle_type_seven));
        mtypelist.add(new CircleType("宠\n物", R.mipmap.circle_peg, R.drawable.circle_type_eight));
        mtypelist.add(new CircleType("旅\n行", R.mipmap.circle_travel, R.drawable.circle_type_nine));
        mReCreateCircleType.setLayoutManager(new GridLayoutManager(this, 3));
        mReCreateCircleType.setAdapter(new CircleTypeAdapter(this, mtypelist));
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dp_13);
        mReCreateCircleType.addItemDecoration(new SpaceItemDecoration(spacingInPixels));

    }


    @OnClick({R.id.im_circle_back, R.id.relayout_create_circle_two, R.id.activity_create_circle})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_circle_back:
                finish();
                break;
            case R.id.relayout_create_circle_two:

                break;
            case R.id.activity_create_circle:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ll_exchange_community)
    public void onClick() {
        List params = new ArrayList<String>();
        params.add("8");
        //params.add("2061");//2061  2803
        HttpUtils.post(Api.USER, Api.User.GETUSERINFO, params, new ResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }
            @Override
            public void onSuccess(String response, int id) {
                Log.d("",response+"");
                View popupView = View.inflate(CreateCircleActivity.this, R.layout.item_item_home_login_head_pop, null);
                PopupWindow mPopupWindow = new PopupWindow(popupView  , LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                mPopupWindow.setTouchable(true);
                mPopupWindow.setOutsideTouchable(true);
                mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
                mPopupWindow.showAsDropDown(llExchangeCommunity);
                RecyclerView pop_rv= (RecyclerView) popupView.findViewById(R.id.item_item_head_pop_rlv);
                final LoginCommunityAdapter loginCommunityAdapter=new LoginCommunityAdapter(CreateCircleActivity.this);
                pop_rv.setLayoutManager(new LinearLayoutManager(CreateCircleActivity.this));
                pop_rv.setAdapter(loginCommunityAdapter);
                pop_rv.setItemAnimator(new DefaultItemAnimator());
                ArrayList<MDate> loginCommunities = Resovle.getUserInfo(response);
                loginCommunityAdapter.setDates(loginCommunities);
                loginCommunityAdapter.notifyDataSetChanged();

            }

            @Override
            public void inProgress(float progress, long total, int id) {

            }
        });

    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {


            outRect.top = space;

            outRect.left = space / 2;

        }
    }
}
