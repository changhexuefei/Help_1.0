package com.hyzsnt.onekeyhelp.module.index.fragment;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.index.bean.HotAreaInfo;
import com.hyzsnt.onekeyhelp.module.index.bean.MyHotAreaInfo;
import com.hyzsnt.onekeyhelp.module.index.bean.MyHotAreaList;
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
 * A simple {@link Fragment} subclass.
 */
public class SearchHotAreaFragment extends BaseFragment  {
    @BindView(R.id.classify)
    LinearLayout mLayout;
    List<String> parms = new ArrayList<>();
    private String lat;
    private String lon;
    List<HotAreaInfo> mHotAreaInfos;
    HotAreaInfo mHotAreaInfo;
    MyHotAreaInfo mMyHotAreaInfo;
    MyHotAreaList mMyHotAreaList;
    private String comID;
    private String comName;
    CallBackValue callBackValue;


    @Override
    protected List<String> getParams() {
        return null;
    }
    /**
     * fragment与activity产生关联是  回调这个方法
     */
    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        //当前fragment从activity重写了回调接口  得到接口的实例化对象
        callBackValue =(CallBackValue) getActivity();
    }


    @Override
    protected void initData(String content) {
        lat = Double.toString(getLocation().getLatitude());
        Log.d("lat", lat);
        lon = Double.toString(getLocation().getLongitude());
        Log.d("lon", lon);
        getCurrentLocation();

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_hot_area;
    }

    @Override
    public String getC() {
        return null;
    }

    @Override
    public String getA() {
        return null;
    }

    //    绘制自动换行的线性布局
    private void initAutoLL() {
//        每一行的布局，初始化第一行布局
        LinearLayout rowLL = new LinearLayout(mActivity);
        LinearLayout.LayoutParams rowLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        float rowMargin = dipToPx(10);
        rowLP.setMargins(0, (int) rowMargin, 0, 0);
        rowLL.setLayoutParams(rowLP);
        boolean isNewLayout = false;
        final float maxWidth = getScreenWidth() - dipToPx(30);
//        剩下的宽度
        float elseWidth = maxWidth;
        LinearLayout.LayoutParams textViewLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewLP.setMargins((int) dipToPx(8), 0, 0, 0);
        for (int i = 0; i < mHotAreaInfos.size(); i++) {
            Log.d("++++++++++++++++++++", "" + mHotAreaInfos.size());
//            若当前为新起的一行，先添加旧的那行
//            然后重新创建布局对象，设置参数，将isNewLayout判断重置为false
            if (isNewLayout) {
                mLayout.addView(rowLL);
                rowLL = new LinearLayout(mActivity);
                rowLL.setLayoutParams(rowLP);
                isNewLayout = false;
            }
//            计算是否需要换行
            final TextView textView = (TextView) mActivity.getLayoutInflater().inflate(R.layout.item_textview, null);
            textView.setText(mHotAreaInfos.get(i).getList().getHotName());
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comID = mHotAreaInfos.get(finalI).getList().getHotID().trim();
                    Log.d("comID", comID);
                    comName = mHotAreaInfos.get(finalI).getList().getHotName().trim();
                    Log.d("comName", comName);
                    callBackValue.SendMessageValue(comID,comName);
                    Toast.makeText(mActivity, "" + v.getId(), Toast.LENGTH_SHORT).show();
                }
            });
            textView.measure(0, 0);
//            若是一整行都放不下这个文本框，添加旧的那行，新起一行添加这个文本框
            if (maxWidth < textView.getMeasuredWidth()) {
                mLayout.addView(rowLL);
                rowLL = new LinearLayout(mActivity);
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


    private void getCurrentLocation() {
        lat = Double.toString(getLocation().getLatitude());
        Log.d("lat", lat);
        lon = Double.toString(getLocation().getLongitude());
        Log.d("lon", lon);

        parms.add("0");
        parms.add("4");
        parms.add(lat);
        parms.add(lon);
        parms.add("110000");

        HttpUtils.post(Api.PUBLIC, "getHotArea", parms, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onSuccess(String response, int id) {
                Log.d("我的位置是：", response);
                if (JsonUtils.isSuccess(response)) {
                    try {
                        mMyHotAreaInfo = new MyHotAreaInfo();
                        JSONObject object = new JSONObject(response);
                        JSONObject info = object.getJSONObject("info");
                        String regname = info.getString("regname");
                        mMyHotAreaInfo.setRegname(regname);
                        String regid = info.getString("regid");
                        mMyHotAreaInfo.setRegid(regid);
                        String position = info.getString("position");
                        mMyHotAreaInfo.setPosition(position);

                        Log.d("12345678", regname);
                        if ("".equals(mMyHotAreaInfo.getRegname())) {
//                        tv_cityName.setVisibility(View.GONE);
                        } else {
//                        tv_cityName.setText(mMyHotAreaInfo.getRegname());
                        }
                        JSONObject list = object.getJSONObject("list");
                        Log.d("list", "" + list);
                        Iterator<String> iterator = list.keys();
                        mHotAreaInfos = new ArrayList<HotAreaInfo>();

                        while (iterator.hasNext()) {
                            mHotAreaInfo = new HotAreaInfo();
                            mMyHotAreaList = new MyHotAreaList();
                            String key = iterator.next();
                            Log.d("key+++++++", key);
                            mMyHotAreaList.setHotID(key);
                            String value = list.getString(key);
                            Log.d("value+++++", value);
                            mMyHotAreaList.setHotName(value);
                            mHotAreaInfo.setList(mMyHotAreaList);
//                        area.add(value);
                            mHotAreaInfos.add(mHotAreaInfo);
                        }
                        Log.d("============", "" + mHotAreaInfos);
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
    //定义一个回调接口
    public interface CallBackValue{
        void SendMessageValue(String comID,String comName);
    }


}
