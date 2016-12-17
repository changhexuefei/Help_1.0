package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;

/**
 * Created by hyzs on 2016/12/17.
 */

/**
 * "cmid":"",
 "cmname":"",
 "cmcover":"",
 "curnum":"",
 "ifcur":""
 */
public class LoginCommunity implements Serializable{
    private String cmid;//小区ID
    private String cmname;//小区名称
    private String cmcover;//小区封面图链接
    private String curnum;//成员人数
    private String ifcur;//是否为当前小区 0否1是

    public LoginCommunity() {
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    public String getIfcur() {
        return ifcur;
    }

    public void setIfcur(String ifcur) {
        this.ifcur = ifcur;
    }

    public String getCurnum() {
        return curnum;
    }

    public void setCurnum(String curnum) {
        this.curnum = curnum;
    }

    public String getCmcover() {
        return cmcover;
    }

    public void setCmcover(String cmcover) {
        this.cmcover = cmcover;
    }

    public String getCmname() {
        return cmname;
    }

    public void setCmname(String cmname) {
        this.cmname = cmname;
    }

    @Override
    public String toString() {
        return "LoginCommunity{" +
                "cmid='" + cmid + '\'' +
                ", cmname='" + cmname + '\'' +
                ", cmcover='" + cmcover + '\'' +
                ", curnum='" + curnum + '\'' +
                ", ifcur='" + ifcur + '\'' +
                '}';
    }
}
