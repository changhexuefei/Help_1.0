package com.hyzsnt.onekeyhelp.module.index.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hyzsnt.onekeyhelp.R;

/**
 * Created by gao on 2016/12/10.
 */

public class MyNeighborListAdapter extends LRecyclerViewAdapter {



    public MyNeighborListAdapter(RecyclerView.Adapter innerAdapter) {
        super(innerAdapter);
    }






    public class ViewHolder extends LRecyclerViewAdapter.ViewHolder{
        TextView tv_neighbor_name,tv_neighbor_age;
        ImageView iv_neighbor_icon,iv_neighbor_sex_icon;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_neighbor_name = (TextView) itemView.findViewById(R.id.neighbor_name);
            tv_neighbor_age = (TextView) itemView.findViewById(R.id.neighbor_age);
            iv_neighbor_icon = (ImageView) itemView.findViewById(R.id.neighbor_icon);
            iv_neighbor_sex_icon = (ImageView) itemView.findViewById(R.id.neighbor_sex_icon);


        }
    }

}
