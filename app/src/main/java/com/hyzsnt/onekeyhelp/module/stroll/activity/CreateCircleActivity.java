package com.hyzsnt.onekeyhelp.module.stroll.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hyzsnt.onekeyhelp.MainActivity;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.ResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.LoginCommunity;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CircleTypeAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.adapter.CommunityAdapter;
import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;
import com.hyzsnt.onekeyhelp.utils.DbUtils;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

import java.io.ByteArrayInputStream;
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
	//标识选中的标签数
	private int count = 0;
	String result;
	private String mIncommunitynum;
	private String mUid;
	private String mCid;
	private ArrayList<MDate> mUserInfo;
	private ArrayList<String> mAlist;
	private ArrayList<LoginCommunity> mLoginCommunities;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_create_circle;
	}

	@Override
	protected void initData() {
		//获取用户信息
		getUserInfo();


		//用于获取标签
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
						Bitmap getimage = getimage(img_path);
						mImUploadPicture.setVisibility(View.VISIBLE);
						mImUploadPicture.setImageBitmap(getimage);
						result = bitmapToBase64(getimage);
					}

					@Override
					public void onHanlderFailure(int requestCode, String errorMsg) {

					}
				});
			}

			break;
			case R.id.activity_create_circle: {
				if ("".equals(mCid)) {
					//添加p参数
					List<String> list = new ArrayList<>();
					list.add(mUid);
					list.add(mCid);
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
								Intent intent = new Intent(CreateCircleActivity.this, CircleDetailsActivity.class);
								intent.putExtra("response", response);
								intent.putExtra("title", mEtCreateCircleName.getText().toString());
								startActivity(intent);
								ToastUtils.showShort(CreateCircleActivity.this, "创建成功");
								finish();
							} else {
								LogUtils.e("失败" + JsonUtils.getErrorMessage(response));
							}
						}

						@Override
						public void inProgress(float progress, long total, int id) {

						}
					});
				} else {
					ToastUtils.showShort(CreateCircleActivity.this, "请先加入一个小区");
					Intent intent = new Intent(this, MainActivity.class);
					App.code = 1;
					startActivity(intent);
				}

			}
			break;
			case R.id.ll_exchange_community: {
				if (mAlist.size() > 0 && !"".equals(mAlist)) {
					View popupView = View.inflate(CreateCircleActivity.this, R.layout.pop_create_circle_community, null);
					ListView lv = (ListView) popupView.findViewById(R.id.ll_create_circle_community);
					PopupWindow mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
					mPopupWindow.setTouchable(true);
					mPopupWindow.setOutsideTouchable(true);
					mPopupWindow.setBackgroundDrawable(new BitmapDrawable(CreateCircleActivity.this.getResources(), (Bitmap) null));
					mPopupWindow.showAsDropDown(mLlExchangeCommunity);
					CommunityAdapter communityAdapter = new CommunityAdapter(CreateCircleActivity.this);
					communityAdapter.setdata(mAlist);
					lv.setAdapter(communityAdapter);
					lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
							mTvCreateCircleAddress.setText(mAlist.get(position));
							for (int i = 0; i < mLoginCommunities.size(); i++) {
								if (mAlist.get(position).equals(mLoginCommunities.get(i).getCmname())) {
									mCid = mLoginCommunities.get(i).getCmid();
								}
							}
						}
					});
				} else {
					ToastUtils.showShort(CreateCircleActivity.this, "暂时没有加入其它小区");
				}
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

	/**
	 * 压缩
	 *
	 * @param image
	 * @return
	 */
	private Bitmap compressImage(Bitmap image) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
		int options = 100;
		while (baos.toByteArray().length / 1024 > 100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
			baos.reset();//重置baos即清空baos
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
			options -= 10;//每次都减少10
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
		return bitmap;
	}

	private Bitmap getimage(String srcPath) {
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		//开始读入图片，此时把options.inJustDecodeBounds 设回true了
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);//此时返回bm为空
		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		//现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
		float hh = 800f;//这里设置高度为800f
		float ww = 480f;//这里设置宽度为480f
		//缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
		int be = 1;//be=1表示不缩放
		if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;//设置缩放比例
		//重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
		bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
		return compressImage(bitmap);//压缩好比例大小后再进行质量压缩
	}

	//获取用户信息以及小区的经纬度
	public void getUserInfo() {
		String userDetail = (String) SPUtils.get(this, "userDetail", "");
		//解析用户信息
		mUserInfo = Resovle.getUserInfo(userDetail);
		//获取已加入的小区数
		mIncommunitynum = mUserInfo.get(0).getmInfo().getUserInfoInfo().getIncommunitynum();
		//获取用户id
		mUid = mUserInfo.get(0).getmInfo().getUserInfoInfo().getUid();
		mAlist = new ArrayList<>();
		//修改小区
		if (Integer.parseInt(mIncommunitynum) > 0) {

			mLoginCommunities = mUserInfo.get(0).getmList().getLoginCommunities();
			LogUtils.e(mLoginCommunities.toString());
			for (int i = 0; i < mAlist.size(); i++) {
				if (mUserInfo.get(0).getmList().getCommunityListLists().get(i).getIfcur() == "0") {
					mAlist.add(mLoginCommunities.get(i).getCmname());
				} else {
					mTvCreateCircleAddress.setText(mLoginCommunities.get(i).getCmname());
					mCid = mLoginCommunities.get(i).getCmid();
				}
			}
		}

	}
}
