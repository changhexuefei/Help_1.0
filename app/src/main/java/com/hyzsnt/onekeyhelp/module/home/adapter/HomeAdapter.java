package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.hyzsnt.onekeyhelp.R;

/**
 * Created by hyzs on 2016/12/10.
 */

public class HomeAdapter extends RecyclerView.Adapter {
    private Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_home_circum,parent,false);
        View view = View.inflate(context, R.layout.item_home_circum, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    //    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(context).inflate(R.layout.item_home_circum,parent,false);
//        return new HomeViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if(holder instanceof HomeViewHolder){
//            HomeViewHolder mHomeViewHolder= (HomeViewHolder)holder;
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return 10;
//    }
//    public static class HomeViewHolder extends RecyclerViewAdapter.ViewHolder{
//
//        public HomeViewHolder(View itemView) {
//            super(itemView);
//        }
//    }
}
