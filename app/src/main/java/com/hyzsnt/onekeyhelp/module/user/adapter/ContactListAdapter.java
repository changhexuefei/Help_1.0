package com.hyzsnt.onekeyhelp.module.user.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.stroll.widget.SwipeMenuView;
import com.hyzsnt.onekeyhelp.module.user.bean.ContactInfoBean;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;

/**
 * Created by 14369 on 2016/12/21.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.MyViewHolder> {

	private Context mContext;
	private List<ContactInfoBean.ListBean> mData;

	public ContactListAdapter(Context context, List<ContactInfoBean.ListBean> data) {
		mContext = context;
		mData = data;
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(mContext).inflate(R.layout.item_contact_list, parent, false);
		return new MyViewHolder(view);
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, final int position) {
		final ContactInfoBean.ListBean bean = mData.get(position);
		//这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑
		((SwipeMenuView) holder.itemView).setIos(false).setLeftSwipe(true);
		if (!TextUtils.isEmpty(bean.getLinkerdesc())) {
			holder.tv_item_contact_name.setText(bean.getLinkername() + "（" + bean.getLinkerdesc() + "）");
		} else {
			holder.tv_item_contact_name.setText(bean.getLinkername());
		}
		holder.tv_item_contact_phone.setText(bean.getLinkerphoneno());
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
				deleteContacts(bean.getUid(), bean.getEmlid(), position);
			}
		});
	}

	private void deleteContacts(String uid, String emlid, final int position) {

		List<String> params = new ArrayList<>();
		params.add(uid);
		params.add(emlid);
		HttpUtils.post(Api.USER, Api.User.DELEMERGLINKER, params, new JsonResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {
				Toast.makeText(mContext, "网络连接失败！", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onSuccess(String response, int id) {
				LogUtils.e("onSuccess:" + response);
				if (JsonUtils.isSuccess(response)) {
					try {
						JSONObject object = new JSONObject(response);
						String res = object.getString("res");
						if ("1".equals(res)) {
							Toast.makeText(mContext, "删除成功！", Toast.LENGTH_SHORT).show();
							mData.remove(position);
							notifyDataSetChanged();
							notifyItemChanged(position);
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}

				} else {
					Toast.makeText(mContext, "请求错误：" + JsonUtils.getErrorMessage(response), Toast.LENGTH_SHORT).show();
				}
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
