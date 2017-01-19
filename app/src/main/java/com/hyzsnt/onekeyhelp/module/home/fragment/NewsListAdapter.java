package com.hyzsnt.onekeyhelp.module.home.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.home.bean.NewsListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by 14369 on 2017/1/18.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {
    private List<NewsListBean.DataBean> data;
    private Context context;
    private OnNewsItemClickListener mNewsItemClickListener;

    public NewsListAdapter(Context context, List<NewsListBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_index_news, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        NewsListBean.DataBean bean = data.get(position);
        holder.tv_news_title.setText(bean.getTitle());
        holder.tv_news_num.setText(bean.getViewnum() + "");
        holder.tv_news_res.setText(bean.getResource());
        holder.tv_news_time.setText(bean.getSj());
        Glide.with(context).load(bean.getImgURL()).placeholder(R.drawable.tp_loading).error(R.drawable.tp_loading).into(holder.iv_news_icon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewsItemClickListener.onClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_news_icon)
        ImageView iv_news_icon;
        @BindView(R.id.tv_news_title)
        TextView tv_news_title;
        @BindView(R.id.tv_news_res)
        TextView tv_news_res;
        @BindView(R.id.tv_news_num)
        TextView tv_news_num;
        @BindView(R.id.tv_news_time)
        TextView tv_news_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnNewsItemClickListener(OnNewsItemClickListener newsItemClickListener) {
        mNewsItemClickListener = newsItemClickListener;
    }

    public interface OnNewsItemClickListener {
        void onClick(View view, int position);
    }
}
