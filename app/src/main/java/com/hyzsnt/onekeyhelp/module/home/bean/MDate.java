package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;

/**
 * Created by hyzs on 2016/12/14.
 */

public class MDate implements Serializable {
    private String res;//结果0失败，1成功
    private String restr;//失败则返回文字信息
    private MInfo mInfo;//请求信息及用户信息
    private MList mList;//小区集合

    public MDate() {
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getRestr() {
        return restr;
    }

    public void setRestr(String restr) {
        this.restr = restr;
    }

    public MInfo getmInfo() {
        return mInfo;
    }

    public void setmInfo(MInfo mInfo) {
        this.mInfo = mInfo;
    }

    public MList getmList() {
        return mList;
    }

    public void setmList(MList mList) {
        this.mList = mList;
    }

    @Override
    public String toString() {
        return "MDate{" +
                "res='" + res + '\'' +
                ", restr='" + restr + '\'' +
                ", mInfo=" + mInfo +
                ", mList=" + mList +
                '}';
    }
}