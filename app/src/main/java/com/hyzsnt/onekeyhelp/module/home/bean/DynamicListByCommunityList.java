package com.hyzsnt.onekeyhelp.module.home.bean;

/**
 * Created by hyzs on 2016/12/16.
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 "goodnum":"",		//点赞数
 "":"",
 "":"",
 "":"",
 */
public class DynamicListByCommunityList implements Serializable{
    private String mid;//动态ID
    private String uid;//发布用户ID
    private String nickname;//发布用户昵称
    private String headportraid;//发布用户头像链接
    private String cmid;//发布人归属小区ID
    private String cmname;//发布人归属小区名称
    private String mtype;//动态类别 public:getDynamicKinds
    private String mtypeName;
    private String objectid;//该动态类别下数据id
    private String posttime;//时间戳
    private String lat;//发布时发布人纬度
    private String lng;//发布时发布人经度
    private String distance;//发布时发布人距离小区距离
    private String status;//动态状态
    private String goodnum;//点赞数
    private String replynum;//评论数
    private String content;//内容，如为语音，则为音频地址链接
    private String contenttype;//内容类别 0文字 1文字+图片 2语音
    private ArrayList<String> imgs;//配图列表
    private ArrayList<HomeComment> homeComments; //评论回复列表

    public DynamicListByCommunityList() {
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
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

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(String goodnum) {
        this.goodnum = goodnum;
    }

    public String getReplynum() {
        return replynum;
    }

    public void setReplynum(String replynum) {
        this.replynum = replynum;
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

    public ArrayList<String> getImgs() {
        return imgs;
    }

    public void setImgs(ArrayList<String> imgs) {
        this.imgs = imgs;
    }

    public ArrayList<HomeComment> getHomeComments() {
        return homeComments;
    }

    public void setHomeComments(ArrayList<HomeComment> homeComments) {
        this.homeComments = homeComments;
    }

    public String getMtypeName() {
        return mtypeName;
    }

    public void setMtypeName(String mtypeName) {
        this.mtypeName = mtypeName;
    }

    @Override
    public String toString() {
        return "DynamicListByCommunityList{" +
                "mid='" + mid + '\'' +
                ", uid='" + uid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headportraid='" + headportraid + '\'' +
                ", cmid='" + cmid + '\'' +
                ", cmname='" + cmname + '\'' +
                ", mtype='" + mtype + '\'' +
                ", mtypeName='" + mtypeName + '\'' +
                ", objectid='" + objectid + '\'' +
                ", posttime='" + posttime + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", distance='" + distance + '\'' +
                ", status='" + status + '\'' +
                ", goodnum='" + goodnum + '\'' +
                ", replynum='" + replynum + '\'' +
                ", content='" + content + '\'' +
                ", contenttype='" + contenttype + '\'' +
                ", imgs=" + imgs +
                ", homeComments=" + homeComments +
                '}';
    }
}
