package com.hyzsnt.onekeyhelp.module.index.bean;

import java.io.Serializable;

/**
 * Created by gao on 2016/12/13.
 */

public class HotAreaInfo implements Serializable {
    private String restr;
    private int res;
    private MyHotAreaInfo mInfo;
    private MyHotAreaList mList;

    public String getRestr() {
        return restr;
    }

    public void setRestr(String restr) {
        this.restr = restr;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public MyHotAreaInfo getInfo() {
        return mInfo;
    }

    public void setInfo(MyHotAreaInfo info) {
        mInfo = info;
    }

    public MyHotAreaList getList() {
        return mList;
    }

    public void setList(MyHotAreaList list) {
        mList = list;
    }
}

