package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hyzsnt.onekeyhelp.R;

/**
 * Created by 14369 on 2017/1/18.
 */
public class ShopMsgAdapter extends BaseAdapter {
    private Context context;

    public ShopMsgAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.more_shop_msg_item, null);
        return convertView;
    }
}
