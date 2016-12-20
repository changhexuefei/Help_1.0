package com.hyzsnt.onekeyhelp.module.index.adapter;

/**
 * Created by gao on 2016/12/18.
 */

public class ProvinceHasCityListAdapter {
//
//    private Context mContext;
//    private LayoutInflater mInflater;
//    private List<ProvinceHasCityInfo> mList;
//
//
//    public void setList(List<ProvinceHasCityInfo> list) {
//        mList = list;
//    }
//
//    public ProvinceHasCityListAdapter(Context context) {
//        this.mInflater = LayoutInflater.from(context);
//    }
//
//    public void updateListView(List<ProvinceHasCityInfo> mList) {
//        this.mList = mList;
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public int getCount() {
//        if (mList != null)
//            return mList.size();
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder = null;
//
//        if (convertView == null) {
//            viewHolder = new ViewHolder();
//            convertView = mInflater.inflate(R.layout.item_province, null);
//            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.province_title);
//            viewHolder.tvLetter = (TextView) convertView.findViewById(R.id.tv_catalog);
//
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        // 注意：我们在此给响应点击事件的区域（我的例子里是 showArea 的线性布局）添加Tag，为了记录点击的 position，我们正好用 position 设置 Tag
//
//
////        根据position获取分类的首字母的Char ascii值
//        int section = getSectionForPosition(position);
//
////        如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
//        if (position == getPositionForSection(section)) {
//            viewHolder.tvLetter.setVisibility(View.VISIBLE);
//            viewHolder.tvLetter.setText(mList.get(position).getSortLetters());
//        } else {
//            viewHolder.tvLetter.setVisibility(View.GONE);
//        }
//        viewHolder.tvTitle.setText(mList.get(position).getName());
//
//
//        return convertView;
//    }
//
//    class ViewHolder {
//
//        TextView tvLetter;
//        TextView tvTitle;
//    }

//    /**
//     * 根据ListView的当前位置获取分类的首字母的Char ascii值
//     */
//    public int getSectionForPosition(int position) {
//        return mList.get(position).getSortLetters().charAt(0);
//    }
//
//    /**
//     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
//     */
//    public int getPositionForSection(int section) {
//        for (int i = 0; i < getCount(); i++) {
//            String sortStr = mList.get(i).getSortLetters();
//            char firstChar = sortStr.toUpperCase().charAt(0);
//            if (firstChar == section) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    /**
//     * 提取英文的首字母，非英文字母用#代替。
//     *
//     * @param str
//     * @return
//     */
//    private String getAlpha(String str) {
//        String sortStr = str.trim().substring(0, 1).toUpperCase();
//        // 正则表达式，判断首字母是否是英文字母
//        if (sortStr.matches("[A-Z]")) {
//            return sortStr;
//        } else {
//            return "#";
//        }
//    }
//
//    public Object[] getSections() {
//        return null;
//    }


}
