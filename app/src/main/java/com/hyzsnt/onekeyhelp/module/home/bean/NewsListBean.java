package com.hyzsnt.onekeyhelp.module.home.bean;

import java.util.List;

/**
 * Created by 14369 on 2017/1/18.
 */

public class NewsListBean {

    /**
     * data : [{"id":5325,"title":"鸡蛋有多少营养价值，你真的知道吗？","imgURL":"","resource":"今日头条","sj":"09-28","viewnum":54},{"id":5323,"title":"吃什么抗衰老 女人常吃三宝抗衰不显老","imgURL":"","resource":"今日头条","sj":"09-28","viewnum":26},{"id":5322,"title":"降压止血、美容养颜，秋季养生佳品，便宜好吃","imgURL":"","resource":"今日头条","sj":"09-28","viewnum":16},{"id":5321,"title":"有一种谷物助睡眠、养胃，还能防治糖尿病","imgURL":"","resource":"今日头条","sj":"09-28","viewnum":4},{"id":5320,"title":"孕妇可以吃柚子吗 孕妇秋季吃什么水果好","imgURL":"","resource":"今日头条","sj":"09-28","viewnum":2},{"id":5319,"title":"挑选莲藕小窍门 多吃莲藕益处多","imgURL":"","resource":"今日头条","sj":"09-28","viewnum":0},{"id":5318,"title":"有一种食物被称为\u201c抗癌之王\u201d","imgURL":"","resource":"今日头条","sj":"09-28","viewnum":2},{"id":5316,"title":"一生不生病的三道菜送给您，90岁还箭步如飞！","imgURL":"","resource":"今日头条","sj":"09-28","viewnum":3},{"id":5315,"title":"一道家常菜，竟能扫光五脏毒素！不愧为菜中之王","imgURL":"","resource":"今日头条","sj":"09-28","viewnum":2},{"id":5311,"title":"杀鸡扔掉的一层膜，是比冬虫夏草还珍贵的药","imgURL":"","resource":"今日头条","sj":"09-27","viewnum":4}]
     * code : 0
     * error :
     */

    private int code;
    private String error;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5325
         * title : 鸡蛋有多少营养价值，你真的知道吗？
         * imgURL :
         * resource : 今日头条
         * sj : 09-28
         * viewnum : 54
         */

        private int id;
        private String title;
        private String imgURL;
        private String resource;
        private String sj;
        private int viewnum;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImgURL() {
            return imgURL;
        }

        public void setImgURL(String imgURL) {
            this.imgURL = imgURL;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public String getSj() {
            return sj;
        }

        public void setSj(String sj) {
            this.sj = sj;
        }

        public int getViewnum() {
            return viewnum;
        }

        public void setViewnum(int viewnum) {
            this.viewnum = viewnum;
        }
    }
}
