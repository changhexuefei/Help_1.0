package com.hyzsnt.onekeyhelp.module.release.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.release.bean.Release;

import java.util.List;

/**
 * Created by gao on 2016/12/19.
 */

public class ReleaseListAdapter extends BaseAdapter {
    private static final String TALK = "3";
    private static final String GENERAL = "2";
    //    private static final String UNUSE = "家中闲置";
    //    private static final String RENT = "房屋出租";
    private Context mContext;
    private LayoutInflater mInflater;
    List<Release.ListBean> mListBeen;

    public ReleaseListAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public void setListBeen(List<Release.ListBean> listBeen) {
        mListBeen = listBeen;
    }

    @Override
    public int getCount() {
        if (mListBeen.size() != 0) {
            return mListBeen.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mListBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder itemViewHolder;
        if (convertView == null) {
            itemViewHolder = new ItemViewHolder();
            convertView = mInflater.inflate(R.layout.item_release, null);
            itemViewHolder.iv_release_icon = (ImageView) convertView.findViewById(R.id.item_icon);
            itemViewHolder.tv_realease_title = (TextView) convertView.findViewById(R.id.item_title);
            itemViewHolder.tv_release_remark = (TextView) convertView.findViewById(R.id.remark);
            convertView.setTag(itemViewHolder);
        } else {
            itemViewHolder = (ItemViewHolder) convertView.getTag();
        }
        if (mListBeen.get(position).getPkey() != null) {

            if (TALK.equals(mListBeen.get(position).getPkey())) {
                itemViewHolder.iv_release_icon.setImageResource(R.mipmap.talk);
            } else if (GENERAL.equals(mListBeen.get(position).getPkey())) {
                itemViewHolder.iv_release_icon.setImageResource(R.mipmap.general_message);
            }
            //            else if (UNUSE.equals(mListBeen.get(position).getPkey())) {
            //
            //                itemViewHolder.iv_release_icon.setImageResource(R.mipmap.unuse_goods);
            //
            //            } else if (RENT.equals(mListBeen.get(position).getPkey())) {
            //
            //                itemViewHolder.iv_release_icon.setImageResource(R.mipmap.house_lease);
            //            }
            itemViewHolder.tv_realease_title.setText(mListBeen.get(position).getPval());
            itemViewHolder.tv_release_remark.setText(mListBeen.get(position).getDesc());
        }
        return convertView;
    }

    class ItemViewHolder {
        ImageView iv_release_icon;
        TextView tv_realease_title, tv_release_remark;
    }
}
