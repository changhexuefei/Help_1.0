package com.hyzsnt.onekeyhelp.module.index.bean;

import java.util.List;

/**
 * Created by gao on 2016/12/10.
 */

public class MyNeighborInfo {

    /**
     * res : 1
     * restr :
     * info : {"totalnum":"2","totalpage":1,"perpage":15,"curpage":1,"curnum":2}
     * list : [{"uid":"1","phoneno":"13511023040","nickname":"135****3040","headportraid":"http://192.168.1.123/uploadfile/defaultpic/user.gif","status":"1","gender":"0","hobbytags":"|1|2","lastonline":"1481702847","regtime":"1481259989"},{"uid":"2","phoneno":"abcfegf","nickname":"abc****fegf","headportraid":"http://192.168.1.123/uploadfile/defaultpic/user.gif","status":"1","gender":"0","hobbytags":"","lastonline":"1481436395","regtime":"1481436395"}]
     */

    private int res;
    private String restr;
    private InfoBean info;
    private List<ListBean> list;


    public MyNeighborInfo() {
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
         * totalnum : 2
         * totalpage : 1
         * perpage : 15
         * curpage : 1
         * curnum : 2
         */

        private String totalnum;
        private int totalpage;
        private int perpage;
        private int curpage;
        private int curnum;

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

        public int getPerpage() {
            return perpage;
        }

        public void setPerpage(int perpage) {
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
    }

    public static class ListBean {
        /**
         * uid : 1
         * phoneno : 13511023040
         * nickname : 135****3040
         * headportraid : http://192.168.1.123/uploadfile/defaultpic/user.gif
         * status : 1
         * gender : 0
         * hobbytags : |1|2
         * lastonline : 1481702847
         * regtime : 1481259989
         */

        private String uid;
        private String phoneno;
        private String nickname;
        private String headportraid;
        private String status;
        private String gender;
        private String hobbytags;
        private String lastonline;
        private String regtime;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getPhoneno() {
            return phoneno;
        }

        public void setPhoneno(String phoneno) {
            this.phoneno = phoneno;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadportraid() {
            return headportraid;
        }

        public void setHeadportraid(String headportraid) {
            this.headportraid = headportraid;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getHobbytags() {
            return hobbytags;
        }

        public void setHobbytags(String hobbytags) {
            this.hobbytags = hobbytags;
        }

        public String getLastonline() {
            return lastonline;
        }

        public void setLastonline(String lastonline) {
            this.lastonline = lastonline;
        }

        public String getRegtime() {
            return regtime;
        }

        public void setRegtime(String regtime) {
            this.regtime = regtime;
        }
    }
}

//    public String getNeighborName() {
//
//        return neighborName;
//    }
//
//    public void setNeighborName(String neighborName) {
//        this.neighborName = neighborName;
//    }
//
//    public int getNeighborSexIcon() {
//        return neighborSexIcon;
//    }
//
//    public void setNeighborSexIcon(int neighborSexIcon) {
//        this.neighborSexIcon = neighborSexIcon;
//    }
//
//    public String getNeighborAge() {
//        return neighborAge;
//    }
//
//    public void setNeighborAge(String neighborAge) {
//        this.neighborAge = neighborAge;
//    }
//
//    public int getNeighborIcon() {
//
//        return neighborIcon;
//    }
//
//    public void setNeighborIcon(int neighborIcon) {
//        this.neighborIcon = neighborIcon;
//    }
//    private int neighborIcon;
//    private String neighborName;
//    private int neighborSexIcon;
//    private String neighborAge;


//    public MyNeighborInfo(int neighborIcon, String neighborName, int neighborSexIcon, String neighborAge) {
//        this.neighborIcon = neighborIcon;
//        this.neighborName = neighborName;
//        this.neighborSexIcon = neighborSexIcon;
//        this.neighborAge = neighborAge;
//    }