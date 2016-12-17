package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.home.bean.DynamicKinds;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;

import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/17.
 */

public class DynamicKindsAdapter extends RecyclerView.Adapter{
    private Context mContext;
    private ArrayList<MDate> dates = new ArrayList<>();

    public DynamicKindsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDates(ArrayList<MDate> dates) {
        this.dates = dates;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v0 = LayoutInflater.from(mContext).inflate(R.layout.item_home_pop, parent, false);
        return new DynamicKindsViewHolder(v0);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ArrayList<DynamicKinds> kindses = dates.get(0).getmList().getDynamicKindses();
        if(holder instanceof DynamicKindsViewHolder){
            ((DynamicKindsViewHolder) holder).home_pop_tv.setText(kindses.get(position).getKind());
        }
    }

    @Override
    public int getItemCount() {
        if (dates.size() > 0) {
            if (dates.get(0).getmList().getDynamicKindses().size() > 0) {
                return dates.get(0).getmList().getDynamicKindses().size();
            }
        }
        return 0;
    }
    static class DynamicKindsViewHolder extends RecyclerView.ViewHolder {
        public TextView home_pop_tv;
        public DynamicKindsViewHolder(View itemView) {
            super(itemView);
            home_pop_tv= (TextView) itemView.findViewById(R.id.pop_tv);
        }
    }
}
