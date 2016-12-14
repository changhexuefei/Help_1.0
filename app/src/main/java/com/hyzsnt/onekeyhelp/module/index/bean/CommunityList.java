package com.hyzsnt.onekeyhelp.module.index.bean;

import java.util.List;


public class CommunityList {
    /**
     * res : 1
     * restr :
     * info : {"totalnum":301,"totalpage":76,"perpage":"4","curpage":1,"curnum":301,"coordinateres":{"position":"北京市朝阳区朝阳路67号院-10","regid":"110105","regname":"朝阳区"}}
     * list : [{"cmid":"1738","cmname":"白领家园","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.916746053462","lng":"116.52706054492","distance":"777.099609375"},{"cmid":"1880","cmname":"财满街财经中心","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.923772065722","lng":"116.53891005876","distance":"777.099609375"},{"cmid":"2814","cmname":"美丽亚洲假日花园","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.920820038118","lng":"116.53366585001","distance":"777.099609375"},{"cmid":"2815","cmname":"美丽亚洲假日花园别墅","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.920820038118","lng":"116.53366585001","distance":"777.099609375"},{"cmid":"240","cmname":"世纪天乐潮青汇","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.922699049264","lng":"116.53374474639","distance":"777.099609375"},{"cmid":"1734","cmname":"白家楼小区A区","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.934323443541","lng":"116.55128750424","distance":"777.099609375"},{"cmid":"604","cmname":"雅成一里","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.931708904062","lng":"116.53104743587","distance":"777.099609375"},{"cmid":"352","cmname":"天鹅湾南区","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.926659812848","lng":"116.52792109555","distance":"1098.9847880846355"},{"cmid":"2139","cmname":"甘露晴苑","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.92220483472","lng":"116.5265562901","distance":"1098.9847880846355"},{"cmid":"2803","cmname":"绿岛苑西区","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.923968267862","lng":"116.55213789665","distance":"1098.9847880846355"},{"cmid":"2347","cmname":"花园闸小区","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.916501414643","lng":"116.55318608534","distance":"1098.9847880846355"},{"cmid":"2239","cmname":"国际创展中心","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.923281613678","lng":"116.5238666062","distance":"1098.9847880846355"},{"cmid":"654","cmname":"姚家园平房村238号","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.949582158567","lng":"116.55108235624","distance":"1345.9759818215389"},{"cmid":"3938","cmname":"八里庄北里","cmcover":null,"address":"address","curnum":"0","circlenum":"0","ifjoin":"0","ifcur":"0","regional":"region","hotarea":"0","lat":"39.929515345083","lng":"116.53128809192","distance":"1345.9759818215389"}]
     */

    private int res;
    private String restr;
    private InfoBean info;
    private List<ListBean> list;

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

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class InfoBean {
        /**
         * totalnum : 301
         * totalpage : 76
         * perpage : 4
         * curpage : 1
         * curnum : 301
         * coordinateres : {"position":"北京市朝阳区朝阳路67号院-10","regid":"110105","regname":"朝阳区"}
         */

        private int totalnum;
        private int totalpage;
        private String perpage;
        private int curpage;
        private int curnum;
        private CoordinateresBean coordinateres;

        public int getTotalnum() {
            return totalnum;
        }

        public void setTotalnum(int totalnum) {
            this.totalnum = totalnum;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public String getPerpage() {
            return perpage;
        }

        public void setPerpage(String perpage) {
            this.perpage = perpage;
        }

        public int getCurpage() {
            return curpage;
        }

        public void setCurpage(int curpage) {
            this.curpage = curpage;
        }

        public int getCurnum() {
            return curnum;
        }

        public void setCurnum(int curnum) {
            this.curnum = curnum;
        }

        public CoordinateresBean getCoordinateres() {
            return coordinateres;
        }

        public void setCoordinateres(CoordinateresBean coordinateres) {
            this.coordinateres = coordinateres;
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
         * cmid : 1738
         * cmname : 白领家园
         * cmcover : null
         * address : address
         * curnum : 0
         * circlenum : 0
         * ifjoin : 0
         * ifcur : 0
         * regional : region
         * hotarea : 0
         * lat : 39.916746053462
         * lng : 116.52706054492
         * distance : 777.099609375
         */

        private String cmid;
        private String cmname;
        private Object cmcover;
        private String address;
        private String curnum;
        private String circlenum;
        private String ifjoin;
        private String ifcur;
        private String regional;
        private String hotarea;
        private String lat;
        private String lng;
        private String distance;

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

        public Object getCmcover() {
            return cmcover;
        }

        public void setCmcover(Object cmcover) {
            this.cmcover = cmcover;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCurnum() {
            return curnum;
        }

        public void setCurnum(String curnum) {
            this.curnum = curnum;
        }

        public String getCirclenum() {
            return circlenum;
        }

        public void setCirclenum(String circlenum) {
            this.circlenum = circlenum;
        }

        public String getIfjoin() {
            return ifjoin;
        }

        public void setIfjoin(String ifjoin) {
            this.ifjoin = ifjoin;
        }

        public String getIfcur() {
            return ifcur;
        }

        public void setIfcur(String ifcur) {
            this.ifcur = ifcur;
        }

        public String getRegional() {
            return regional;
        }

        public void setRegional(String regional) {
            this.regional = regional;
        }

        public String getHotarea() {
            return hotarea;
        }

        public void setHotarea(String hotarea) {
            this.hotarea = hotarea;
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
    }
}
