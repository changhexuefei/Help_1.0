package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;

/**
 * Created by hyzs on 2016/12/16.
 */

public class HomeComment implements Serializable{
    private String suid;//评论人
    private String sunickname;//评论人昵称
    private String sheadportraid;//评论人头像链接
    private String ruid;//被回复人	//一级评论为0
    private String runickname;//被回复人昵称
    private String rheadportraid;//被回复人头像链接
    private String content;//内容
    private String posttime;//时间戳

    public HomeComment() {
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public String getSunickname() {
        return sunickname;
    }

    public void setSunickname(String sunickname) {
        this.sunickname = sunickname;
    }

    public String getSheadportraid() {
        return sheadportraid;
    }

    public void setSheadportraid(String sheadportraid) {
        this.sheadportraid = sheadportraid;
    }

    public String getRuid() {
        return ruid;
    }

    public void setRuid(String ruid) {
        this.ruid = ruid;
    }

    public String getRunickname() {
        return runickname;
    }

    public void setRunickname(String runickname) {
        this.runickname = runickname;
    }

    public String getRheadportraid() {
        return rheadportraid;
    }

    public void setRheadportraid(String rheadportraid) {
        this.rheadportraid = rheadportraid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    @Override
    public String toString() {
        return "HomeComment{" +
                "suid='" + suid + '\'' +
                ", sunickname='" + sunickname + '\'' +
                ", sheadportraid='" + sheadportraid + '\'' +
                ", ruid='" + ruid + '\'' +
                ", runickname='" + runickname + '\'' +
                ", rheadportraid='" + rheadportraid + '\'' +
                ", content='" + content + '\'' +
                ", posttime='" + posttime + '\'' +
                '}';
    }
}
