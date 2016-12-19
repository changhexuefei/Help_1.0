package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;

/**
 * Created by hxw on 2016/12/19.
 */
public class UserInfoInfo implements Serializable{
    private String uid;//用户ID
    private String phoneno;//手机号
    private String nickname;//昵称
    private String headportraid;//头像链接
    private String incommunity;//当前小区
    private String incommunitynum;//加入小区数
    private String incirclenum;//加入圈子数
    private String status;//用户状态（待用）
    private String gender;//性别 0保密1男2女
    private String hobbytags;//喜好标签：多个用|分割
    private String lastonline;//最后在线时间
    private String regtime;//注册时间

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadportraid() {
        return headportraid;
    }

    public void setHeadportraid(String headportraid) {
        this.headportraid = headportraid;
    }

    public String getIncommunity() {
        return incommunity;
    }

    public void setIncommunity(String incommunity) {
        this.incommunity = incommunity;
    }

    public String getIncommunitynum() {
        return incommunitynum;
    }

    public void setIncommunitynum(String incommunitynum) {
        this.incommunitynum = incommunitynum;
    }

    public String getIncirclenum() {
        return incirclenum;
    }

    public void setIncirclenum(String incirclenum) {
        this.incirclenum = incirclenum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobbytags() {
        return hobbytags;
    }

    public void setHobbytags(String hobbytags) {
        this.hobbytags = hobbytags;
    }

    public String getLastonline() {
        return lastonline;
    }

    public void setLastonline(String lastonline) {
        this.lastonline = lastonline;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    @Override
    public String toString() {
        return "UserInfoInfo{" +
                "uid='" + uid + '\'' +
                ", phoneno='" + phoneno + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headportraid='" + headportraid + '\'' +
                ", incommunity='" + incommunity + '\'' +
                ", incommunitynum='" + incommunitynum + '\'' +
                ", incirclenum='" + incirclenum + '\'' +
                ", status='" + status + '\'' +
                ", gender='" + gender + '\'' +
                ", hobbytags='" + hobbytags + '\'' +
                ", lastonline='" + lastonline + '\'' +
                ", regtime='" + regtime + '\'' +
                '}';
    }
}
