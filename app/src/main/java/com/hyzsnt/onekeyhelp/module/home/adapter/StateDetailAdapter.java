package com.hyzsnt.onekeyhelp.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.home.bean.CommentListByTopic;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by hyzs on 2016/12/13.
 */

public class StateDetailAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<MDate> dates = new ArrayList<>();

    public StateDetailAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDates(ArrayList<MDate> dates) {
        this.dates = dates;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View v1 = LayoutInflater.from(mContext).inflate(R.layout.item_activity_state_detail_1, parent, false);
            return new StateDetailViewHolder1(v1);
        } else {
            View v2 = LayoutInflater.from(mContext).inflate(R.layout.item_activity_state_detail_2, parent, false);
            return new StateDetailViewHolder2(v2);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CommentListByTopic commentListByTopic = dates.get(0).getmList().getCommentListByTopics().get(position);
        if(getItemViewType(position)==1){
            if(holder instanceof StateDetailViewHolder1){
                ((StateDetailViewHolder1) holder).item1StateNickname.setText(commentListByTopic.getNickname());
                ((StateDetailViewHolder1) holder).item1StateContent.setText(commentListByTopic.getContent());
                ((StateDetailViewHolder1) holder).item1StatePosttime.setText(commentListByTopic.getPosttime()+"分钟前");
            }
        }
    }

    @Override
    public int getItemCount() {
        if (dates.size() > 0) {
            if (dates.get(0).getmList().getCommentListByTopics().size() > 0) {
                return dates.get(0).getmList().getCommentListByTopics().size();
            }
        }
        return 0;
    }

    public int getItemViewType(int position) {
        if (position >= 0) {
            return 1;
        } else {
            return 2;
        }
    }

    static class StateDetailViewHolder1 extends RecyclerView.ViewHolder {
        TextView item1StateNickname;
        TextView item1StateContent;
        TextView item1StatePosttime;

        public StateDetailViewHolder1(View itemView) {
            super(itemView);
            item1StateNickname= (TextView) itemView.findViewById(R.id.item1_state_nickname);
            item1StateContent=(TextView) itemView.findViewById(R.id.item1_state_content);
            item1StatePosttime=(TextView) itemView.findViewById(R.id.item1_state_posttime);

        }
    }
    static class StateDetailViewHolder2 extends RecyclerView.ViewHolder {
        TextView item2StateNickname;
        TextView item2StateContent;
        public StateDetailViewHolder2(View itemView) {
            super(itemView);
            item2StateNickname= (TextView) itemView.findViewById(R.id.item2_state_nickname);
            item2StateContent=(TextView) itemView.findViewById(R.id.item2_state_content);
        }
    }
}
