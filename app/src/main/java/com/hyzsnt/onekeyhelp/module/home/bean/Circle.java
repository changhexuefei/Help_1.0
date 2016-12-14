package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;

/**
 * Created by hyzs on 2016/12/14.
 */

public class Circle implements Serializable{
    private String ccid;//圈子ID
    private String ccname;//圈子名称
    private String cccover;//圈子封面图链接
    private String tags;//标签：多个用|分割
    private String curnum;//成员数
    private String ifjoin;//是否已加入 0否1是
    private String cmid;//归属小区ID

    public Circle() {
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getCcname() {
        return ccname;
    }

    public void setCcname(String ccname) {
        this.ccname = ccname;
    }

    public String getCccover() {
        return cccover;
    }

    public void setCccover(String cccover) {
        this.cccover = cccover;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "ccid='" + ccid + '\'' +
                ", ccname='" + ccname + '\'' +
                ", cccover='" + cccover + '\'' +
                ", tags='" + tags + '\'' +
                ", curnum='" + curnum + '\'' +
                ", ifjoin='" + ifjoin + '\'' +
                ", cmid='" + cmid + '\'' +
                '}';
    }
}
