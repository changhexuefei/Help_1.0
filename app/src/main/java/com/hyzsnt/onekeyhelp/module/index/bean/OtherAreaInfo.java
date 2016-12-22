package com.hyzsnt.onekeyhelp.module.index.bean;

import java.util.List;

/**
 * Created by gao on 2016/12/22.
 */

public class OtherAreaInfo {

    /**
     * info : 1
     * list : [{"regid":"130101","regname":"石家庄市市辖区"},{"regid":"130102","regname":"长安区"},{"regid":"130103","regname":"桥东区"},{"regid":"130104","regname":"桥西区"},{"regid":"130105","regname":"新华区"},{"regid":"130107","regname":"井陉矿区"},{"regid":"130108","regname":"裕华区"},{"regid":"130121","regname":"井陉县"},{"regid":"130123","regname":"正定县"},{"regid":"130124","regname":"栾城县"},{"regid":"130125","regname":"行唐县"},{"regid":"130126","regname":"灵寿县"},{"regid":"130127","regname":"高邑县"},{"regid":"130128","regname":"深泽县"},{"regid":"130129","regname":"赞皇县"},{"regid":"130130","regname":"无极县"},{"regid":"130131","regname":"平山县"},{"regid":"130132","regname":"元氏县"},{"regid":"130133","regname":"赵　县"},{"regid":"130181","regname":"辛集市"},{"regid":"130182","regname":"藁城市"},{"regid":"130183","regname":"晋州市"},{"regid":"130184","regname":"新乐市"},{"regid":"130185","regname":"鹿泉市"}]
     * res : 1
     * restr :
     */

    private String info;
    private int res;
    private String restr;
    private List<ListBean> list;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
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

    public static class ListBean {
        /**
         * regid : 130101
         * regname : 石家庄市市辖区
         */

        private String regid;
        private String regname;

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
