package com.hyzsnt.onekeyhelp.module.release.bean;

import java.util.List;

/**
 * Created by gao on 2016/12/19.
 */

public class Release {

    private int res;
    private String restr;
    private List<?> info;
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

    public List<?> getInfo() {
        return info;
    }

    public void setInfo(List<?> info) {
        this.info = info;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * desc : djaosdaodas
         * pkey : 2
         * pval : 综合消息
         */
        private String desc;
        private String pkey;
        private String pval;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPkey() {
            return pkey;
        }

        public void setPkey(String pkey) {
            this.pkey = pkey;
        }

        public String getPval() {
            return pval;
        }

        public void setPval(String pval) {
            this.pval = pval;
        }
    }
}
