package com.hyzsnt.onekeyhelp.module.help.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 14369 on 2016/12/26.
 */

public class HelpBean implements Parcelable {

    /**
     * res : 1
     * restr :
     * info : {"uid":"23","emid":10,"posttime":1482724555}
     * list : []
     */

    private int res;
    private String restr;
    private InfoBean info;

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

    public static class InfoBean implements Parcelable {
        /**
         * uid : 23
         * emid : 10
         * posttime : 1482724555
         */

        private String uid;
        private int emid;
        private int posttime;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getEmid() {
            return emid;
        }

        public void setEmid(int emid) {
            this.emid = emid;
        }

        public int getPosttime() {
            return posttime;
        }

        public void setPosttime(int posttime) {
            this.posttime = posttime;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.uid);
            dest.writeInt(this.emid);
            dest.writeInt(this.posttime);
        }

        public InfoBean() {
        }

        protected InfoBean(Parcel in) {
            this.uid = in.readString();
            this.emid = in.readInt();
            this.posttime = in.readInt();
        }

        public static final Creator<InfoBean> CREATOR = new Creator<InfoBean>() {
            @Override
            public InfoBean createFromParcel(Parcel source) {
                return new InfoBean(source);
            }

            @Override
            public InfoBean[] newArray(int size) {
                return new InfoBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.res);
        dest.writeString(this.restr);
        dest.writeParcelable(this.info, flags);
    }

    public HelpBean() {
    }

    protected HelpBean(Parcel in) {
        this.res = in.readInt();
        this.restr = in.readString();
        this.info = in.readParcelable(InfoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<HelpBean> CREATOR = new Parcelable.Creator<HelpBean>() {
        @Override
        public HelpBean createFromParcel(Parcel source) {
            return new HelpBean(source);
        }

        @Override
        public HelpBean[] newArray(int size) {
            return new HelpBean[size];
        }
    };
}
