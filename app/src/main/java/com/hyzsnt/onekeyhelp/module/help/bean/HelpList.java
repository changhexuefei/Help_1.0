package com.hyzsnt.onekeyhelp.module.help.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3.
 */

public class HelpList {

    /**
     * totalnum : 3
     */

    private InfoEntry info;
    /**
     * info : {"totalnum":3}
     * list : [{"cmid":"2803","cmname":"绿岛苑西区","distance":"0","emid":"16","flag":"3","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","lat":"39.923687","lng":"116.540051","nickname":"131****7888","objcmid":"2803","objcmname":"绿岛苑西区","phoneno":"13161117888","posttime":"1482732046","uid":"23"},{"cmid":"2803","cmname":"绿岛苑西区","distance":"777.099609375","emid":"19","flag":"3","headportraid":"http://192.168.1.123/uploadfile/defaultpic/user.gif","lat":"39.923804","lng":"116.539342","nickname":"155****5396","objcmid":"2803","objcmname":"绿岛苑西区","phoneno":"15551675396","posttime":"1482735324","uid":"5"},{"cmid":"2803","cmname":"绿岛苑西区","distance":"0","emid":"40","flag":"3","headportraid":"http://192.168.1.123/uploadfile/defaultpic/user.gif","lat":"39.923696","lng":"116.540045","nickname":"155****5396","objcmid":"2803","objcmname":"绿岛苑西区","phoneno":"15551675396","posttime":"1483405644","uid":"5"}]
     * res : 1
     * restr :
     */

    private int res;
    private String restr;
    /**
     * cmid : 2803
     * cmname : 绿岛苑西区
     * distance : 0
     * emid : 16
     * flag : 3
     * headportraid : http://192.168.1.188/uploadfile/defaultpic/user.gif
     * lat : 39.923687
     * lng : 116.540051
     * nickname : 131****7888
     * objcmid : 2803
     * objcmname : 绿岛苑西区
     * phoneno : 13161117888
     * posttime : 1482732046
     * uid : 23
     */

    private List<ListEntry> list;

    public InfoEntry getInfo() {
        return info;
    }

    public void setInfo(InfoEntry info) {
        this.info = info;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getRestr() {
        return restr;
    }

    public void setRestr(String restr) {
        this.restr = restr;
    }

    public List<ListEntry> getList() {
        return list;
    }

    public void setList(List<ListEntry> list) {
        this.list = list;
    }

    public static class InfoEntry {
        private int totalnum;

        public int getTotalnum() {
            return totalnum;
        }

        public void setTotalnum(int totalnum) {
            this.totalnum = totalnum;
        }
    }

    public static class ListEntry {
        private String cmid;
        private String cmname;
        private String distance;
        private String emid;
        private String flag;
        private String headportraid;
        private String lat;
        private String lng;
        private String nickname;
        private String objcmid;
        private String objcmname;
        private String phoneno;
        private String posttime;
        private String uid;

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

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getEmid() {
            return emid;
        }

        public void setEmid(String emid) {
            this.emid = emid;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getHeadportraid() {
            return headportraid;
        }

        public void setHeadportraid(String headportraid) {
            this.headportraid = headportraid;
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

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getObjcmid() {
            return objcmid;
        }

        public void setObjcmid(String objcmid) {
            this.objcmid = objcmid;
        }

        public String getObjcmname() {
            return objcmname;
        }

        public void setObjcmname(String objcmname) {
            this.objcmname = objcmname;
        }

        public String getPhoneno() {
            return phoneno;
        }

        public void setPhoneno(String phoneno) {
            this.phoneno = phoneno;
        }

        public String getPosttime() {
            return posttime;
        }

        public void setPosttime(String posttime) {
            this.posttime = posttime;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
