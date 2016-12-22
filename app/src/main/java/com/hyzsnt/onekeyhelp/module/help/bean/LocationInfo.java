package com.hyzsnt.onekeyhelp.module.help.bean;

/**
 * Created by 14369 on 2016/12/14.
 */

public class LocationInfo {
	private int mLocType;
	private String mTime;
	private double mLatitude;
	private double mLongitude;
	private String mAddrStr;
	private String regid;
	private String regname;

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	public String getRegname() {
		return regname;
	}

	public void setRegname(String regname) {
		this.regname = regname;
	}

	public int getLocType() {
		return mLocType;
	}

	public void setLocType(int locType) {
		mLocType = locType;
	}

	public String getTime() {
		return mTime;
	}

	public void setTime(String time) {
		mTime = time;
	}

	public double getLatitude() {
		return mLatitude;
	}

	public void setLatitude(double latitude) {
		mLatitude = latitude;
	}

	public double getLongitude() {
		return mLongitude;
	}

	public void setLongitude(double longitude) {
		mLongitude = longitude;
	}

	public String getAddrStr() {
		return mAddrStr;
	}

	public void setAddrStr(String addrStr) {
		mAddrStr = addrStr;
	}

	@Override
	public String toString() {
		return "LocationInfo{" +
				"mLocType=" + mLocType +
				", mTime='" + mTime + '\'' +
				", mLatitude=" + mLatitude +
				", mLongitude=" + mLongitude +
				", mAddrStr='" + mAddrStr + '\'' +
				", regid='" + regid + '\'' +
				", regname='" + regname + '\'' +
				'}';
	}
}
