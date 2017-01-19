package com.hyzsnt.onekeyhelp.module.user.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;

/**
 * Created by Administrator on 2017/1/17.
 */

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.OrderitemViewholder> implements View.OnClickListener{
    private Context mContext;
    String str;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public OrderItemAdapter(Activity activity, String str) {
        mContext =activity;
        this.str = str;
    }

    @Override
    public OrderitemViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(mContext).inflate(R.layout.item_user_order,parent,false);
        view.setOnClickListener(this);
        return new OrderitemViewholder(view);
    }
    @Override
    public void onBindViewHolder(OrderitemViewholder holder, int position) {
        if(str.equals("全部")){
            if(position%5==0){
                holder.bt_state2.setText("提醒发货");
                holder.tv_state.setText("等待发货");
            }else if(position%5==1){
                holder.bt_state2.setText("确认收货");
                holder.bt_state1.setText("查看物流");
                holder.bt_state1.setVisibility(View.VISIBLE);
                holder.tv_state.setText("卖家已发货");
            }else if(position%5==2){
                holder.bt_state2.setText("付款");
                holder.bt_state1.setText("取消订单");
                holder.bt_state1.setVisibility(View.VISIBLE);
                holder.tv_state.setText("等待买家付款");
            }else if(position%5==3){
                holder.bt_state2.setText("评价");
                holder.tv_state.setText("交易成功");
            }else if(position%5==4){
                holder.bt_state2.setText("删除订单");
                holder.tv_state.setText("交易关闭");
            }
        }else if(str.equals("待付款")){
            holder.bt_state2.setText("付款");
            holder.bt_state1.setText("取消订单");
            holder.bt_state1.setVisibility(View.VISIBLE);
            holder.tv_state.setText("等待买家付款");
        }else if(str.equals("待发货")){
            holder.bt_state2.setText("提醒发货");
            holder.tv_state.setText("等待发货");
        }else if(str.equals("待收货")){
            holder.bt_state2.setText("确认收货");
            holder.bt_state1.setText("查看物流");
            holder.bt_state1.setVisibility(View.VISIBLE);
            holder.tv_state.setText("卖家已发货");
        }else if(str.equals("待评价")){
            holder.bt_state2.setText("评价");
            holder.tv_state.setText("交易成功");
        }
        holder.itemView.setTag(position);
    }
    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(Integer) v.getTag());
        }
    }

    class OrderitemViewholder extends RecyclerView.ViewHolder{
        TextView tv_state;
        TextView bt_state1;
        TextView bt_state2;
        public OrderitemViewholder(View itemView) {
            super(itemView);
            tv_state= (TextView) itemView.findViewById(R.id.tv_user_order_state);
            bt_state1= (TextView) itemView.findViewById(R.id.bt1_user_order);
            bt_state2 = (TextView) itemView.findViewById(R.id.bt2_user_order);
        }
    }
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , int data);

    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
