package com.hyzsnt.onekeyhelp.module.home.bean;

/**
 * Created by hyzs on 2016/12/14.
 */
public class Coordinateres {
    private String position;//位置描述
    private String regid;//行政区域ID
    private String regname;//行政区域名称

    public Coordinateres() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

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

    @Override
    public String toString() {
        return "Coordinateres{" +
                "position='" + position + '\'' +
                ", regid='" + regid + '\'' +
                ", regname='" + regname + '\'' +
                '}';
    }
}
