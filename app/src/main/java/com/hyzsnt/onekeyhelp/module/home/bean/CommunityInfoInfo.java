package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;

/**
 * Created by hyzs on 2016/12/14.
 */

public class CommunityInfoInfo implements Serializable {
    private String cmid;//小区ID
    private String cmname;//小区名称
    private String cmcover;////小区封面图链接
    private String curnum;//成员人数
    private String ifjoin;//是否已加入 0否1是
    private String lat;//纬度
    private String lng;//坐标Y
    private String distance;//当前距离
    private String summary;//小区简介

    public CommunityInfoInfo() {
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    public String getCmname() {
        return cmname;
    }

    public void setCmname(String cmname) {
        this.cmname = cmname;
    }

    public String getCmcover() {
        return cmcover;
    }

    public void setCmcover(String cmcover) {
        this.cmcover = cmcover;
    }

    public String getCurnum() {
        return curnum;
    }

    public void setCurnum(String curnum) {
        this.curnum = curnum;
    }

    public String getIfjoin() {
        return ifjoin;
    }

    public void setIfjoin(String ifjoin) {
        this.ifjoin = ifjoin;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "CommunityInfoInfo{" +
                "cmid='" + cmid + '\'' +
                ", cmname='" + cmname + '\'' +
                ", cmcover='" + cmcover + '\'' +
                ", curnum='" + curnum + '\'' +
                ", ifjoin='" + ifjoin + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", distance='" + distance + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
