package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/14.
 */

public class MDate implements Serializable {
    private String res;//结果0失败，1成功
    private String restr;//失败则返回文字信息
    private Info info;//请求信息及用户信息
    private ArrayList<CommunityList> communityList;//小区集合

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

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public ArrayList<CommunityList> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(ArrayList<CommunityList> communityList) {
        this.communityList = communityList;
    }

    @Override
    public String toString() {
        return "MDate{" +
                "res='" + res + '\'' +
                ", restr='" + restr + '\'' +
                ", info=" + info +
                ", communityList=" + communityList +
                '}';
    }
}