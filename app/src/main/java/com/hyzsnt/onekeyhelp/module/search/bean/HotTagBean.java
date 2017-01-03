package com.hyzsnt.onekeyhelp.module.search.bean;

import java.util.List;

/**
 * Created by 14369 on 2016/12/29.
 */

public class HotTagBean {

    /**
     * info : {"position":"北京市朝阳区朝阳路67号院-10","regid":"110105","regname":"朝阳区"}
     * list : [{"hid":"1","hname":"建外大街"},{"hid":"2","hname":"大望路"},{"hid":"3","hname":"朝外大街"},{"hid":"4","hname":"朝阳公园"},{"hid":"5","hname":"团结湖"},{"hid":"6","hname":"亮马桥三元桥"},{"hid":"7","hname":"亚运村"},{"hid":"8","hname":"望京"},{"hid":"9","hname":"劲松潘家园"},{"hid":"10","hname":"安贞"},{"hid":"11","hname":"芍药居"},{"hid":"12","hname":"国贸"},{"hid":"13","hname":"双井"},{"hid":"14","hname":"三里屯"},{"hid":"15","hname":"外经贸"},{"hid":"16","hname":"酒仙桥"},{"hid":"17","hname":"首都机场"},{"hid":"18","hname":"十八里店"},{"hid":"19","hname":"北苑"},{"hid":"20","hname":"孙河"},{"hid":"21","hname":"马泉营"},{"hid":"22","hname":"定福庄"},{"hid":"23","hname":"四惠"},{"hid":"24","hname":"太阳宫"},{"hid":"25","hname":"青年路"},{"hid":"26","hname":"石佛营"},{"hid":"27","hname":"甜水园"},{"hid":"28","hname":"慈云寺"},{"hid":"29","hname":"工人体育场"},{"hid":"30","hname":"百子湾"},{"hid":"31","hname":"传媒大学二外"},{"hid":"32","hname":"双桥"},{"hid":"33","hname":"北京欢乐谷"},{"hid":"34","hname":"高碑店"},{"hid":"35","hname":"北京东站"},{"hid":"36","hname":"霄云路"},{"hid":"37","hname":"蓝色港湾"},{"hid":"38","hname":"农展馆"},{"hid":"39","hname":"立水桥"},{"hid":"40","hname":"大屯"},{"hid":"41","hname":"红庙"},{"hid":"42","hname":"朝阳其它"}]
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

    public static class ListBean {
        /**
         * hid : 1
         * hname : 建外大街
         */

        private String hid;
        private String hname;

        public String getHid() {
            return hid;
        }

        public void setHid(String hid) {
            this.hid = hid;
        }

        public String getHname() {
            return hname;
        }

        public void setHname(String hname) {
            this.hname = hname;
        }
    }
}
