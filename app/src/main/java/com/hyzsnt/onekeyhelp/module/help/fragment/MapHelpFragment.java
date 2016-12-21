package com.hyzsnt.onekeyhelp.module.help.fragment;

import android.view.View;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseFragment;
import com.hyzsnt.onekeyhelp.module.help.service.LocationService;
import com.hyzsnt.onekeyhelp.module.help.listener.MyOrientationListener;
import com.hyzsnt.onekeyhelp.utils.LogUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 14369 on 2016/12/12.
 */

public class MapHelpFragment extends BaseFragment implements BDLocationListener {
	@BindView(R.id.help_map)
	MapView mHelpMap;
	private LocationService mLocationService;
	private BaiduMap mBaiduMap;
	// 自定义定位图标
	private BitmapDescriptor mIconLocation;
	private MyOrientationListener myOrientationListener;
	private float mCurrentX;
	private double mLatitude;
	private double mLongtitude;
	private boolean isFirstIn = true;

	@Override
	protected List<String> getParams() {
		return null;
	}

	@Override
	protected void initData(String content) {
		mBaiduMap = mHelpMap.getMap();
		// 初始化图标
		mIconLocation = BitmapDescriptorFactory
				.fromResource(R.drawable.navi_map_gps_locked);
		myOrientationListener = new MyOrientationListener(mActivity);

		myOrientationListener
				.setOnOrientationListener(new MyOrientationListener.OnOrientationListener() {
					@Override
					public void onOrientationChanged(float x) {
						mCurrentX = x;
					}
				});

		mLocationService = new LocationService(mActivity);
		mLocationService.registerListener(this);
	}


	@OnClick(R.id.btn_my_location)
	public void toMyLocation(View view) {
		centerToMyLocation();
	}

	/**
	 * 定位到我的位置
	 */
	private void centerToMyLocation() {
		LatLng latLng = new LatLng(mLatitude, mLongtitude);
		MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
		MapStatusUpdate mapMsu = MapStatusUpdateFactory.zoomTo(15.0f);
		mBaiduMap.setMapStatus(mapMsu);
		mBaiduMap.animateMapStatus(msu);
	}

	@Override
	public void onStart() {
		super.onStart();
		mBaiduMap.setMyLocationEnabled(true);
		mLocationService.start();
		myOrientationListener.start();
	}

	@Override
	public void onStop() {
		super.onStop();
		mLocationService.stop();
		myOrientationListener.stop();
	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_help_map;
	}

	@Override
	public String getC() {
		return null;
	}

	@Override
	public String getA() {
		return null;
	}

	@Override
	public void onPause() {
		super.onPause();
		mHelpMap.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		mHelpMap.onResume();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mHelpMap.onDestroy();
	}

	@Override
	public void onReceiveLocation(BDLocation bdLocation) {

		LogUtils.e(bdLocation.getLatitude() + "");
		LogUtils.e(bdLocation.getLongitude() + "");

		MyLocationData data = new MyLocationData.Builder()//
				.direction(mCurrentX)//
				.accuracy(500)//
				.latitude(bdLocation.getLatitude())//
				.longitude(bdLocation.getLongitude())//
				.build();
		mBaiduMap.setMyLocationData(data);
		// 设置自定义图标
		MyLocationConfiguration config = new MyLocationConfiguration(
				MyLocationConfiguration.LocationMode.NORMAL, true, mIconLocation);
		mBaiduMap.setMyLocationConfigeration(config);

		// 更新经纬度
		mLatitude = bdLocation.getLatitude();
		mLongtitude = bdLocation.getLongitude();


		if (isFirstIn) {
			LatLng latLng = new LatLng(bdLocation.getLatitude(),
					bdLocation.getLongitude());
			MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
			mBaiduMap.animateMapStatus(msu);
			isFirstIn = false;
			Toast.makeText(mActivity, "地址：" + bdLocation.getAddrStr(),
					Toast.LENGTH_SHORT).show();
			centerToMyLocation();
		}
	}
}
