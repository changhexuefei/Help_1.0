package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/14.
 */
public class CommunityList implements Serializable{

    private String cmid;//小区ID
    private String cmname;//小区名称
    private String cmcover;//小区封面图链接
    private String curnum;//成员人数
    private String ifjoin;//是否已加入 0否1是
    private String ifcur;//是否为当前小区 0否1是
    private String lat;//纬度
    private String lng;//坐标Y
    private String distance;//当前距离
    private ArrayList<HomeCircle> homeCircleList;//圈子集合

    public CommunityList() {
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

    public String getIfcur() {
        return ifcur;
    }

    public void setIfcur(String ifcur) {
        this.ifcur = ifcur;
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

    public ArrayList<HomeCircle> getHomeCircleList() {
        return homeCircleList;
    }

    public void setHomeCircleList(ArrayList<HomeCircle> homeCircleList) {
        this.homeCircleList = homeCircleList;
    }

    @Override
    public String toString() {
        return "CommunityList{" +
                "cmid='" + cmid + '\'' +
                ", cmname='" + cmname + '\'' +
                ", cmcover='" + cmcover + '\'' +
                ", curnum='" + curnum + '\'' +
                ", ifjoin='" + ifjoin + '\'' +
                ", ifcur='" + ifcur + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", distance='" + distance + '\'' +
                ", homeCircleList=" + homeCircleList +
                '}';
    }
}
