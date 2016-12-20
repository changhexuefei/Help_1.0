package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hxw on 2016/12/20.
 */
public class CommentListByTopic implements Serializable{
    private String cid;//回复ID
    private String tid;//话题ID
    private String uid;//发布用户ID
    private String nickname;//发布用户昵称
    private String headportraid;//发布用户头像链接
    private String gender;//性别 0保密1男2女
    private String hobbytags;//喜好标签：多个用|分割
    private String lastonline;//最后在线时间
    private String regtime;//注册时间
    private String posttime;//发布时间
    private String lat;//发布时发布人纬度
    private String lng;//发布时发布人经度
    private String status;//用户状态（待用）
    private String content;//内容
    private String contenttype;//内容类别 0文字 1文字+图片
    private String cmid;//作者所属小区ID
    private String cmname;//作者所属小区名称
    private ArrayList<String > imgs;//配图列表

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
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

    public ArrayList<String> getImgs() {
        return imgs;
    }

    public void setImgs(ArrayList<String> imgs) {
        this.imgs = imgs;
    }

    @Override
    public String toString() {
        return "CommentListByTopic{" +
                "cid='" + cid + '\'' +
                ", tid='" + tid + '\'' +
                ", uid='" + uid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headportraid='" + headportraid + '\'' +
                ", gender='" + gender + '\'' +
                ", hobbytags='" + hobbytags + '\'' +
                ", lastonline='" + lastonline + '\'' +
                ", regtime='" + regtime + '\'' +
                ", posttime='" + posttime + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                ", contenttype='" + contenttype + '\'' +
                ", cmid='" + cmid + '\'' +
                ", cmname='" + cmname + '\'' +
                ", imgs=" + imgs +
                '}';
    }
}
