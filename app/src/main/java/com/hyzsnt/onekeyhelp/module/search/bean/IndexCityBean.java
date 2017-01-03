package com.hyzsnt.onekeyhelp.module.search.bean;

import java.util.List;

import me.yokeyword.indexablerv.IndexableEntity;

/**
 * Created by 14369 on 2016/12/30.
 */

public class IndexCityBean {


    /**
     * info : 0
     * list : [{"regid":"110000","regname":"北京市"},{"regid":"120000","regname":"天津市"},{"regid":"130000","regname":"河北省"},{"regid":"140000","regname":"山西省"},{"regid":"150000","regname":"内蒙古自治区"},{"regid":"210000","regname":"辽宁省"},{"regid":"220000","regname":"吉林省"},{"regid":"230000","regname":"黑龙江省"},{"regid":"310000","regname":"上海市"},{"regid":"320000","regname":"江苏省"},{"regid":"330000","regname":"浙江省"},{"regid":"340000","regname":"安徽省"},{"regid":"350000","regname":"福建省"},{"regid":"360000","regname":"江西省"},{"regid":"370000","regname":"山东省"},{"regid":"410000","regname":"河南省"},{"regid":"420000","regname":"湖北省"},{"regid":"430000","regname":"湖南省"},{"regid":"440000","regname":"广东省"},{"regid":"450000","regname":"广西壮族自治区"},{"regid":"460000","regname":"海南省"},{"regid":"500000","regname":"重庆市"},{"regid":"510000","regname":"四川省"},{"regid":"520000","regname":"贵州省"},{"regid":"530000","regname":"云南省"},{"regid":"540000","regname":"西藏自治区"},{"regid":"610000","regname":"陕西省"},{"regid":"620000","regname":"甘肃省"},{"regid":"630000","regname":"青海省"},{"regid":"640000","regname":"宁夏回族自治区"},{"regid":"650000","regname":"新疆维吾尔自治区"}]
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

    public static class ListBean implements IndexableEntity {
        /**
         * regid : 110000
         * regname : 北京市
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

        @Override
        public String getFieldIndexBy() {
            return regname;
        }

        @Override
        public void setFieldIndexBy(String indexField) {
            this.regname = indexField;
        }

        @Override
        public void setFieldPinyinIndexBy(String pinyin) {

        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "regid='" + regid + '\'' +
                    ", regname='" + regname + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "IndexCityBean{" +
                "info='" + info + '\'' +
                ", res=" + res +
                ", restr='" + restr + '\'' +
                ", list=" + list +
                '}';
    }
}
