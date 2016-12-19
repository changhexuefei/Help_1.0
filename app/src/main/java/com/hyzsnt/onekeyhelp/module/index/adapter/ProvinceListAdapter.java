package com.hyzsnt.onekeyhelp.module.index.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.index.bean.SortCity;

import java.util.List;

/**
 * Created by gao on 2016/12/18.
 */

public class ProvinceListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<SortCity> mList;

    private int currentItem = -1; //用于记录点击的 Item 的 position，是控制 item 展开的核心



    public void setList(List<SortCity> list) {
        mList = list;
    }

    public ProvinceListAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public void updateListView(List<SortCity> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mList != null)
            return mList.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_province, null);
            viewHolder.showArea = (LinearLayout) convertView.findViewById(R.id.showArea);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.province_title);
            viewHolder.tvLetter = (TextView) convertView.findViewById(R.id.tv_catalog);
           viewHolder.hideArea = (LinearLayout) convertView.findViewById(R.id.hideArea);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 注意：我们在此给响应点击事件的区域（我的例子里是 showArea 的线性布局）添加Tag，为了记录点击的 position，我们正好用 position 设置 Tag
        viewHolder.showArea.setTag(position);

//        根据position获取分类的首字母的Char ascii值
        int section = getSectionForPosition(position);

//        如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
        if (position == getPositionForSection(section)) {
            viewHolder.tvLetter.setVisibility(View.VISIBLE);
            viewHolder.tvLetter.setText(mList.get(position).getSortLetters());
        } else {
            viewHolder.tvLetter.setVisibility(View.GONE);
        }
        viewHolder.tvTitle.setText(mList.get(position).getName());

        //根据 currentItem 记录的点击位置来设置"对应Item"的可见性（在list依次加载列表数据时，每加载一个时都看一下是不是需改变可见性的那一条）
        if (currentItem == position) {
            viewHolder.hideArea.setVisibility(View.VISIBLE);
        } else {
            viewHolder.hideArea.setVisibility(View.GONE);
        }

        viewHolder.showArea.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //用 currentItem 记录点击位置
                int tag = (Integer) view.getTag();
                if (tag == currentItem) { //再次点击
                    currentItem = -1; //给 currentItem 一个无效值
                } else {
                    currentItem = tag;
                }
                //通知adapter数据改变需要重新加载
                notifyDataSetChanged(); //必须有的一步
            }
        });



        return convertView;
    }

    class ViewHolder {
        private LinearLayout showArea;
        private LinearLayout hideArea;
        TextView tvLetter;
        TextView tvTitle;
    }

    /**
     * 根据ListView的当前位置获取分类的首字母的Char ascii值
     */
    public int getSectionForPosition(int position) {
        return mList.get(position).getSortLetters().charAt(0);
    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    public int getPositionForSection(int section) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = mList.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 提取英文的首字母，非英文字母用#代替。
     *
     * @param str
     * @return
     */
    private String getAlpha(String str) {
        String sortStr = str.trim().substring(0, 1).toUpperCase();
        // 正则表达式，判断首字母是否是英文字母
        if (sortStr.matches("[A-Z]")) {
            return sortStr;
        } else {
            return "#";
        }
    }

    public Object[] getSections() {
        return null;
    }


}
