package com.hyzsnt.onekeyhelp.module.user.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.module.stroll.widget.SwipeMenuView;
import com.hyzsnt.onekeyhelp.module.user.bean.ContactInfoBean;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 14369 on 2016/12/21.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.MyViewHolder> {

	private Context mContext;
	private List<ContactInfoBean> mData;

	public ContactListAdapter(Context context, List<ContactInfoBean> data) {
		mContext = context;
		mData = data;
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(mContext).inflate(R.layout.item_contact_list, parent, false);
		return new MyViewHolder(view);
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		ContactInfoBean bean = mData.get(position);
		//这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑
		((SwipeMenuView) holder.itemView).setIos(false).setLeftSwipe(true);
		holder.tv_item_contact_name.setText(bean.getName());
		holder.tv_item_contact_phone.setText(bean.getPhone());

		holder.tv_item_contact_alter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ToastUtils.showShort(mContext, "修改");
			}
		});
		holder.tv_item_contact_delete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ToastUtils.showShort(mContext, "删除");
			}
		});
	}

	@Override
	public int getItemCount() {
		return mData == null ? 0 : mData.size();
	}


	static class MyViewHolder extends RecyclerView.ViewHolder {
		@BindView(R.id.iv_item_contact_icon)
		CircleImageView iv_item_contact_icon;
		@BindView(R.id.tv_item_contact_name)
		TextView tv_item_contact_name;
		@BindView(R.id.tv_item_contact_phone)
		TextView tv_item_contact_phone;
		@BindView(R.id.tv_item_contact_alter)
		TextView tv_item_contact_alter;
		@BindView(R.id.tv_item_contact_delete)
		TextView tv_item_contact_delete;

		public MyViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
