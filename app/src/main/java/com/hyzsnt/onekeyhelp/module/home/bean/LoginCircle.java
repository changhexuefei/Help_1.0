package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;

/**
 * Created by hxw on 2016/12/19.
 */

/**
 * "ccid":"",	//圈子ID
 "ccname":"",	//圈子名称
 "cccover":"",	//圈子封面图链接
 "curnum":"",	//成员人数
 "cmid":"",	//归属小区ID
 */
public class LoginCircle implements Serializable{
    private String ccid;//圈子ID
    private String ccname;//圈子名称
    private String cccover;//圈子封面图链接
    private String curnum;//成员人数
    private String cmid;//归属小区ID

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

    public String getCurnum() {
        return curnum;
    }

    public void setCurnum(String curnum) {
        this.curnum = curnum;
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    @Override
    public String toString() {
        return "LoginCircle{" +
                "ccid='" + ccid + '\'' +
                ", ccname='" + ccname + '\'' +
                ", cccover='" + cccover + '\'' +
                ", curnum='" + curnum + '\'' +
                ", cmid='" + cmid + '\'' +
                '}';
    }
}
