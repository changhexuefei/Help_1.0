package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.home.activity.ShopDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 14369 on 2017/1/18.
 */
public class MoreShopListAdapter extends BaseAdapter {

    private Context context;

    public MoreShopListAdapter(Context context) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.more_shop_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShopDetailActivity.class);
                context.startActivity(intent);
            }
        });
        holder.mBtnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "加入购物车", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.btn_add_cart)
        Button mBtnAddCart;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
