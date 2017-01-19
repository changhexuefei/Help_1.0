package com.hyzsnt.onekeyhelp.module.user.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hyzsnt.onekeyhelp.module.user.activity.OrderActivity;
import com.hyzsnt.onekeyhelp.module.user.fragment.OderAllFragment;

/**
 * Created by Administrator on 2017/1/17.
 */

public class OrderAdapter extends FragmentPagerAdapter{
    private String tabTitles[] = new String[]{"全部","待付款","待发货","待收货","待评价"};
    private OderAllFragment mOderAllFragment;

    public OrderAdapter(FragmentManager fm, OrderActivity orderActivity) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("title",tabTitles[position]);
        mOderAllFragment = new OderAllFragment();
        mOderAllFragment.setArguments(bundle);
        return mOderAllFragment;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
