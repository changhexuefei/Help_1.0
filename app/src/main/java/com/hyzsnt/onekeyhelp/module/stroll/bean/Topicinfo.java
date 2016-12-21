package com.hyzsnt.onekeyhelp.module.stroll.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/12/21.
 */

public class Topicinfo implements Parcelable {


	/**
	 * ccid : 14
	 * cmid : 2803
	 * cmname : 绿岛苑西区
	 * content : 大喊大叫基督教
	 * contenttype : 0
	 * gender : 0
	 * goodnum : 0
	 * headportraid : http://192.168.1.188/uploadfile/defaultpic/user.gif
	 * hobbytags :
	 * lastonline : 1482303866
	 * lat : 39.924232
	 * lng : 116.520689
	 * nickname : 131****7888
	 * posttime : 1482216470
	 * regtime : 1481766244
	 * replynum : 0
	 * status : 1
	 * tid : 8
	 * title : 表土
	 * uid : 23
	 */

	private InfoEntry info;
	/**
	 * info : {"ccid":"14","cmid":"2803","cmname":"绿岛苑西区","content":"大喊大叫基督教","contenttype":"0","gender":"0","goodnum":"0","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","hobbytags":"","lastonline":"1482303866","lat":"39.924232","lng":"116.520689","nickname":"131****7888","posttime":"1482216470","regtime":"1481766244","replynum":"0","status":"1","tid":"8","title":"表土","uid":"23"}
	 * res : 1
	 * restr :
	 */

	private int res;
	private String restr;

	public InfoEntry getInfo() {
		return info;
	}

	public void setInfo(InfoEntry info) {
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

	public static class InfoEntry implements Parcelable {
		private String ccid;
		private String cmid;
		private String cmname;
		private String content;
		private String contenttype;
		private String gender;
		private String goodnum;
		private String headportraid;
		private String hobbytags;
		private String lastonline;
		private String lat;
		private String lng;
		private String nickname;
		private String posttime;
		private String regtime;
		private String replynum;
		private String status;
		private String tid;
		private String title;
		private String uid;

		public String getCcid() {
			return ccid;
		}

		public void setCcid(String ccid) {
			this.ccid = ccid;
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

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getContenttype() {
			return contenttype;
		}

		public void setContenttype(String contenttype) {
			this.contenttype = contenttype;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getGoodnum() {
			return goodnum;
		}

		public void setGoodnum(String goodnum) {
			this.goodnum = goodnum;
		}

		public String getHeadportraid() {
			return headportraid;
		}

		public void setHeadportraid(String headportraid) {
			this.headportraid = headportraid;
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

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getPosttime() {
			return posttime;
		}

		public void setPosttime(String posttime) {
			this.posttime = posttime;
		}

		public String getRegtime() {
			return regtime;
		}

		public void setRegtime(String regtime) {
			this.regtime = regtime;
		}

		public String getReplynum() {
			return replynum;
		}

		public void setReplynum(String replynum) {
			this.replynum = replynum;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getTid() {
			return tid;
		}

		public void setTid(String tid) {
			this.tid = tid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public InfoEntry() {
		}

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(this.ccid);
			dest.writeString(this.cmid);
			dest.writeString(this.cmname);
			dest.writeString(this.content);
			dest.writeString(this.contenttype);
			dest.writeString(this.gender);
			dest.writeString(this.goodnum);
			dest.writeString(this.headportraid);
			dest.writeString(this.hobbytags);
			dest.writeString(this.lastonline);
			dest.writeString(this.lat);
			dest.writeString(this.lng);
			dest.writeString(this.nickname);
			dest.writeString(this.posttime);
			dest.writeString(this.regtime);
			dest.writeString(this.replynum);
			dest.writeString(this.status);
			dest.writeString(this.tid);
			dest.writeString(this.title);
			dest.writeString(this.uid);
		}

		protected InfoEntry(Parcel in) {
			this.ccid = in.readString();
			this.cmid = in.readString();
			this.cmname = in.readString();
			this.content = in.readString();
			this.contenttype = in.readString();
			this.gender = in.readString();
			this.goodnum = in.readString();
			this.headportraid = in.readString();
			this.hobbytags = in.readString();
			this.lastonline = in.readString();
			this.lat = in.readString();
			this.lng = in.readString();
			this.nickname = in.readString();
			this.posttime = in.readString();
			this.regtime = in.readString();
			this.replynum = in.readString();
			this.status = in.readString();
			this.tid = in.readString();
			this.title = in.readString();
			this.uid = in.readString();
		}

		public static final Creator<InfoEntry> CREATOR = new Creator<InfoEntry>() {
			@Override
			public InfoEntry createFromParcel(Parcel source) {
				return new InfoEntry(source);
			}

			@Override
			public InfoEntry[] newArray(int size) {
				return new InfoEntry[size];
			}
		};
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(this.info, flags);
		dest.writeInt(this.res);
		dest.writeString(this.restr);
	}

	public Topicinfo() {
	}

	protected Topicinfo(Parcel in) {
		this.info = in.readParcelable(InfoEntry.class.getClassLoader());
		this.res = in.readInt();
		this.restr = in.readString();
	}

	public static final Parcelable.Creator<Topicinfo> CREATOR = new Parcelable.Creator<Topicinfo>() {
		@Override
		public Topicinfo createFromParcel(Parcel source) {
			return new Topicinfo(source);
		}

		@Override
		public Topicinfo[] newArray(int size) {
			return new Topicinfo[size];
		}
	};
}
