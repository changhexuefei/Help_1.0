package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;

/**
 * Created by hyzs on 2016/12/14.
 */

public class Info implements Serializable {
    private Coordinateres coordinateres;//检索类别为0时，返回该用户定位结果
    private String curnum;//当前页行数
    private String curpage;//当前页
    private String perpage;////单页行数
    private String totalnum;//总数
    private String totalpage;//总页数

    public Info() {
    }

    public Coordinateres getCoordinateres() {
        return coordinateres;
    }

    public void setCoordinateres(Coordinateres coordinateres) {
        this.coordinateres = coordinateres;
    }

    public String getCurnum() {
        return curnum;
    }

    public void setCurnum(String curnum) {
        this.curnum = curnum;
    }

    public String getCurpage() {
        return curpage;
    }

    public void setCurpage(String curpage) {
        this.curpage = curpage;
    }

    public String getPerpage() {
        return perpage;
    }

    public void setPerpage(String perpage) {
        this.perpage = perpage;
    }

    public String getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(String totalnum) {
        this.totalnum = totalnum;
    }

    public String getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(String totalpage) {
        this.totalpage = totalpage;
    }

    @Override
    public String toString() {
        return "Info{" +
                "coordinateres=" + coordinateres +
                ", curnum='" + curnum + '\'' +
                ", curpage='" + curpage + '\'' +
                ", perpage='" + perpage + '\'' +
                ", totalnum='" + totalnum + '\'' +
                ", totalpage='" + totalpage + '\'' +
                '}';
    }
}
