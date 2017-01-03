package com.hyzsnt.onekeyhelp.module.help.bean;

import java.util.List;

/**
 * Created by 14369 on 2016/12/27.
 */

public class NearbyBean {


    /**
     * info : {"totalnum":0}
     * list : [{"distance":"0","eid":"1a0018970aa9f3056ba","headportraid":"http://192.168.1.123/uploadfile/defaultpic/user.gif","incommunity":"2803","lasttime":"1482808648","lat":"39.923746","lng":"116.53935","nickname":"155****5396","phoneno":"15551675396","uid":"5"}]
     * res : 1
     * restr :
     */

    private InfoBean info;
    private int res;
    private String restr;
    private List<ListBean> list;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
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

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class InfoBean {
        /**
         * totalnum : 0
         */

        private int totalnum;

        public int getTotalnum() {
            return totalnum;
        }

        public void setTotalnum(int totalnum) {
            this.totalnum = totalnum;
        }
    }

    public static class ListBean {
        /**
         * distance : 0
         * eid : 1a0018970aa9f3056ba
         * headportraid : http://192.168.1.123/uploadfile/defaultpic/user.gif
         * incommunity : 2803
         * lasttime : 1482808648
         * lat : 39.923746
         * lng : 116.53935
         * nickname : 155****5396
         * phoneno : 15551675396
         * uid : 5
         */

        private String distance;
        private String eid;
        private String headportraid;
        private String incommunity;
        private String lasttime;
        private String lat;
        private String lng;
        private String nickname;
        private String phoneno;
        private String uid;

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getEid() {
            return eid;
        }

        public void setEid(String eid) {
            this.eid = eid;
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

        public String getLasttime() {
            return lasttime;
        }

        public void setLasttime(String lasttime) {
            this.lasttime = lasttime;
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

        public String getPhoneno() {
            return phoneno;
        }

        public void setPhoneno(String phoneno) {
            this.phoneno = phoneno;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
