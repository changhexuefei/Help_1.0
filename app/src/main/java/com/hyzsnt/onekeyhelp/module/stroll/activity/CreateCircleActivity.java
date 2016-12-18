package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleTypeAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;
import com.hyzsnt.onekeyhelp.utils.DbUtils;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import okhttp3.Call;

public class CreateCircleActivity extends BaseActivity {


	@BindView(R.id.im_circle_back)
	ImageView mImCircleBack;
	@BindView(R.id.relayout_create_circle_two)
	RelativeLayout mRelayoutCreateCircleTwo;
	@BindView(R.id.im_upload_picture)
	ImageView mImUploadPicture;
	@BindView(R.id.et_create_circle_name)
	EditText mEtCreateCircleName;
	@BindView(R.id.et_create_circle_des)
	EditText mEtCreateCircleDes;
	@BindView(R.id.re_create_circle_type)
	RecyclerView mReCreateCircleType;
	@BindView(R.id.activity_create_circle)
	TextView mActivityCreateCircle;
	@BindView(R.id.tv_create_circle_address)
	TextView mTvCreateCircleAddress;
	@BindView(R.id.ll_exchange_community)
	LinearLayout mLlExchangeCommunity;
	//圈子类型集合
	private ArrayList<CircleType.ListEntry> mtypelist;
	private int count = 0;
	String result;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_create_circle;
	}

	@Override
	protected void initData() {
		ArrayList<CircleType.ListEntry> list = new ArrayList<CircleType.ListEntry>();
		mtypelist = new ArrayList<CircleType.ListEntry>();
		//从数据库中取出数据
		DbUtils dbUtils = new DbUtils(CreateCircleActivity.this);
		list = dbUtils.queryall();
		for (int i = 0; i < list.size(); i++) {
			mtypelist.add(new CircleType.ListEntry(list.get(i).getTagdesc(), list.get(i).getTagid(), list.get(i).getTagname(), false));
		}
		mReCreateCircleType.setLayoutManager(new GridLayoutManager(this, 3));
		final CircleTypeAdapter adapter = new CircleTypeAdapter(this, mtypelist);
		mReCreateCircleType.setAdapter(adapter);
		int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dp_13);
		mReCreateCircleType.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
		adapter.setOnItemClickListener(new CircleTypeAdapter.OnRecyclerViewItemClickListener() {
			@Override
			public void onItemClick(View view, int data) {
				count = 0;
				for (int i = 0; i < mtypelist.size(); i++) {
					if (mtypelist.get(i).getIsselect()) {
						count++;
					}
				}
				if (count < 3 || mtypelist.get(data).getIsselect()) {
					if (mtypelist.get(data).getIsselect()) {
						mtypelist.get(data).setIsselect(false);
					} else {
						mtypelist.get(data).setIsselect(true);
					}
					adapter.notifyItemChanged(data);
				} else {
					ToastUtils.showShort(CreateCircleActivity.this, "最多只能选中三个");
				}


			}
		});

	}


	@OnClick({R.id.im_circle_back, R.id.relayout_create_circle_two, R.id.activity_create_circle, R.id.ll_exchange_community})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.im_circle_back:
				finish();
				break;
			case R.id.relayout_create_circle_two: {

				GalleryFinal.openGallerySingle(1, new GalleryFinal.OnHanlderResultCallback() {
					@Override
					public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
						String img_path = resultList.get(0).getPhotoPath();
						Bitmap bmp = BitmapFactory.decodeFile(img_path);
						mImUploadPicture.setVisibility(View.VISIBLE);
						mImUploadPicture.setImageBitmap(bmp);
						result = bitmapToBase64(bmp);
					}

					@Override
					public void onHanlderFailure(int requestCode, String errorMsg) {

					}
				});
			}

			break;
			case R.id.activity_create_circle: {
				List<String> list = new ArrayList<>();
				list.add("23");
				list.add("2803");
				list.add(mEtCreateCircleName.getText().toString());
				String str = "";
				for (int i = 0; i < mtypelist.size(); i++) {
					if (mtypelist.get(i).getIsselect()) {
						str += mtypelist.get(i).getTagid();
						if (i < mtypelist.size() - 1) {
							str += "|";
						}
					}
				}
				list.add(str.substring(0, str.length() - 1));
				list.add(mEtCreateCircleDes.getText().toString());
				list.add(result);
				HttpUtils.post(Api.CIRCLE, Api.Circle.CREATE_CIRCLE, list, new ResponseHandler() {
					@Override
					public void onError(Call call, Exception e, int id) {

					}

					@Override
					public void onSuccess(String response, int id) {
						if (JsonUtils.isSuccess(response)) {
							LogUtils.e("成功");
							LogUtils.e(response);
						} else {
							LogUtils.e("失败" + JsonUtils.getErrorMessage(response));
						}
					}

					@Override
					public void inProgress(float progress, long total, int id) {

					}
				});
			}
			break;
			case R.id.ll_exchange_community: {
				View popupView = View.inflate(CreateCircleActivity.this, R.layout.pop_create_circle_community, null);
				PopupWindow mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
				mPopupWindow.setTouchable(true);
				mPopupWindow.setOutsideTouchable(true);
				mPopupWindow.setBackgroundDrawable(new BitmapDrawable(CreateCircleActivity.this.getResources(), (Bitmap) null));
				mPopupWindow.showAsDropDown(mLlExchangeCommunity);
				ArrayList<String> alist = new ArrayList<>();
				alist.add("旺达小区");
				alist.add("一航小区");
			}
			break;
		}
	}


	public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

		private int space;

		public SpaceItemDecoration(int space) {
			this.space = space;
		}

		@Override
		public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
			outRect.top = space;

			outRect.left = space / 2;

		}
	}

	/**
	 * 将bitmap转换成base64字符串
	 *
	 * @param bitmap
	 * @return base64 字符串
	 */
	public static String bitmapToBase64(Bitmap bitmap) {

		String result = null;
		ByteArrayOutputStream baos = null;
		try {
			if (bitmap != null) {
				baos = new ByteArrayOutputStream();
				bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
				baos.flush();
				baos.close();
				byte[] bitmapBytes = baos.toByteArray();
				result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (baos != null) {
					baos.flush();
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
