package com.hyzsnt.onekeyhelp.module.index.bean;

/**
 * Created by gao on 2016/12/22.
 */

public class ProvinceAndCityInfo {
    private String provinceID;
    private String provinceName;
    private String cityID;
    private String cityName;

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ProvinceAndCityInfo(String provinceID, String provinceName, String cityID, String cityName) {
        this.provinceID = provinceID;
        this.provinceName = provinceName;
        this.cityID = cityID;
        this.cityName = cityName;
    }

    public ProvinceAndCityInfo() {
    }
}
