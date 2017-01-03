package com.hyzsnt.onekeyhelp.module.search.bean;

import java.util.List;

/**
 * Created by 14369 on 2016/12/29.
 */

public class CommunityResultBean {

    /**
     * info : {"coordinateres":{"position":"北京市朝阳区朝阳路67号院-10","regid":"110105","regname":"朝阳区"},"curnum":5,"curpage":1,"perpage":"5","totalnum":"29","totalpage":6}
     * list : [{"address":"address","circlenum":"0","cmid":"389","cmname":"团结湖北二条","curnum":"0","distance":"7453.677850775421","hotarea":"5","ifcur":"0","ifjoin":"0","lat":"39.937809279278","lng":"116.47229590016","regional":"110105"},{"address":"address","circlenum":"0","cmid":"390","cmname":"团结湖北口","curnum":"0","distance":"8000.730404863134","hotarea":"5","ifcur":"0","ifjoin":"0","lat":"39.938992815713","lng":"116.46931196461","regional":"110105"},{"address":"address","circlenum":"0","cmid":"259","cmname":"首开铂郡8号院","curnum":"0","distance":"9260.211223270744","hotarea":"5","ifcur":"0","ifjoin":"0","lat":"39.945015371883","lng":"116.45751385361","regional":"110105"},{"address":"address","circlenum":"0","cmid":"258","cmname":"首开铂郡12号院","curnum":"0","distance":"9260.211223270744","hotarea":"5","ifcur":"0","ifjoin":"0","lat":"39.945015371883","lng":"116.45751385361","regional":"110105"},{"address":"address","circlenum":"0","cmid":"270","cmname":"首开幸福广场","curnum":"0","distance":"9421.833262313157","hotarea":"5","ifcur":"0","ifjoin":"0","lat":"39.943295340771","lng":"116.45566030349","regional":"110105"}]
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
         * coordinateres : {"position":"北京市朝阳区朝阳路67号院-10","regid":"110105","regname":"朝阳区"}
         * curnum : 5
         * curpage : 1
         * perpage : 5
         * totalnum : 29
         * totalpage : 6
         */

        private CoordinateresBean coordinateres;
        private int curnum;
        private int curpage;
        private String perpage;
        private String totalnum;
        private int totalpage;

        public CoordinateresBean getCoordinateres() {
            return coordinateres;
        }

        public void setCoordinateres(CoordinateresBean coordinateres) {
            this.coordinateres = coordinateres;
        }

        public int getCurnum() {
            return curnum;
        }

        public void setCurnum(int curnum) {
            this.curnum = curnum;
        }

        public int getCurpage() {
            return curpage;
        }

        public void setCurpage(int curpage) {
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

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public static class CoordinateresBean {
            /**
             * position : 北京市朝阳区朝阳路67号院-10
             * regid : 110105
             * regname : 朝阳区
             */

            private String position;
            private String regid;
            private String regname;

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
        }
    }

    public static class ListBean {
        /**
         * address : address
         * circlenum : 0
         * cmid : 389
         * cmname : 团结湖北二条
         * curnum : 0
         * distance : 7453.677850775421
         * hotarea : 5
         * ifcur : 0
         * ifjoin : 0
         * lat : 39.937809279278
         * lng : 116.47229590016
         * regional : 110105
         */

        private String address;
        private String circlenum;
        private String cmid;
        private String cmname;
        private String curnum;
        private String distance;
        private String hotarea;
        private String ifcur;
        private String ifjoin;
        private String lat;
        private String lng;
        private String regional;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCirclenum() {
            return circlenum;
        }

        public void setCirclenum(String circlenum) {
            this.circlenum = circlenum;
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

        public String getCurnum() {
            return curnum;
        }

        public void setCurnum(String curnum) {
            this.curnum = curnum;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getHotarea() {
            return hotarea;
        }

        public void setHotarea(String hotarea) {
            this.hotarea = hotarea;
        }

        public String getIfcur() {
            return ifcur;
        }

        public void setIfcur(String ifcur) {
            this.ifcur = ifcur;
        }

        public String getIfjoin() {
            return ifjoin;
        }

        public void setIfjoin(String ifjoin) {
            this.ifjoin = ifjoin;
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

        public String getRegional() {
            return regional;
        }

        public void setRegional(String regional) {
            this.regional = regional;
        }
    }
}
