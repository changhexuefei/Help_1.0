package com.hyzsnt.onekeyhelp.module.index.bean;

/**
 * Created by gao on 2016/12/13.
 */

public class HotAreaInfo {


    /**
     * res : 1
     * restr :
     * info : {"position":"甘肃省张掖市肃南裕固族自治县","regid":"620721","regname":"肃南裕固族自治县"}
     * list : null
     */

    private int res;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public static class InfoBean {
        /**
         * position : 甘肃省张掖市肃南裕固族自治县
         * regid : 620721
         * regname : 肃南裕固族自治县
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
