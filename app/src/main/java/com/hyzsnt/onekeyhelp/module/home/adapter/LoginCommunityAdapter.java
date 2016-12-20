package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.home.bean.DynamicKinds;
import com.hyzsnt.onekeyhelp.module.home.bean.LoginCommunity;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;

import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/17.
 */

public class LoginCommunityAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<MDate> dates = new ArrayList<>();

    public LoginCommunityAdapter(Context mContext, ArrayList<MDate> dates) {
        this.mContext = mContext;
        this.dates = dates;
    }

    public void setDates(ArrayList<MDate> dates) {
        this.dates = dates;
    }

    @Override
    public int getCount() {
        if (dates.size() > 0) {
            if (dates.get(0).getmList().getLoginCommunities().size() > 0) {
                return dates.get(0).getmList().getLoginCommunities().size();
            }
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return dates.get(0).getmList().getLoginCommunities().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_home_pop, parent, false);
        ArrayList<LoginCommunity> loginCommunities = dates.get(0).getmList().getLoginCommunities();
        TextView home_pop_tv= (TextView) v0.findViewById(R.id.pop_tv);
        home_pop_tv.setText(loginCommunities.get(position).getCmname());
        return v0;
    }
}
