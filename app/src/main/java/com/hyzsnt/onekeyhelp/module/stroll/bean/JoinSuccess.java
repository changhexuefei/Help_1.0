package com.hyzsnt.onekeyhelp.module.stroll.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/12/20.
 */

public class JoinSuccess implements Parcelable {

	/**
	 * applynum : 0
	 * cccover : http://192.168.1.188/uploadfile/circle/39/39/cover/cover.png
	 * ccid : 39
	 * ccname : 哈哈
	 * cmid : 2803
	 * curnum : 1
	 * flag : 1
	 * headportraid : http://192.168.1.188/uploadfile/defaultpic/user.gif
	 * nickname : 131****7888
	 * status : 1
	 * summary : 通用默默哦
	 * tags : 2
	 * topicnum : 0
	 */

	private InfoEntry info;
	/**
	 * info : {"applynum":0,"cccover":"http://192.168.1.188/uploadfile/circle/39/39/cover/cover.png","ccid":39,"ccname":"哈哈","cmid":"2803","curnum":1,"flag":"1","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","nickname":"131****7888","status":"1","summary":"通用默默哦","tags":"2","topicnum":0}
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
		private int applynum;
		private String cccover;
		private int ccid;
		private String ccname;
		private String cmid;
		private int curnum;
		private String flag;
		private String headportraid;
		private String nickname;
		private String status;
		private String summary;
		private String tags;
		private int topicnum;

		public int getApplynum() {
			return applynum;
		}

		public void setApplynum(int applynum) {
			this.applynum = applynum;
		}

		public String getCccover() {
			return cccover;
		}

		public void setCccover(String cccover) {
			this.cccover = cccover;
		}

		public int getCcid() {
			return ccid;
		}

		public void setCcid(int ccid) {
			this.ccid = ccid;
		}

		public String getCcname() {
			return ccname;
		}

		public void setCcname(String ccname) {
			this.ccname = ccname;
		}

		public String getCmid() {
			return cmid;
		}

		public void setCmid(String cmid) {
			this.cmid = cmid;
		}

		public int getCurnum() {
			return curnum;
		}

		public void setCurnum(int curnum) {
			this.curnum = curnum;
		}

		public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}

		public String getHeadportraid() {
			return headportraid;
		}

		public void setHeadportraid(String headportraid) {
			this.headportraid = headportraid;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String getTags() {
			return tags;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}

		public int getTopicnum() {
			return topicnum;
		}

		public void setTopicnum(int topicnum) {
			this.topicnum = topicnum;
		}

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeInt(this.applynum);
			dest.writeString(this.cccover);
			dest.writeInt(this.ccid);
			dest.writeString(this.ccname);
			dest.writeString(this.cmid);
			dest.writeInt(this.curnum);
			dest.writeString(this.flag);
			dest.writeString(this.headportraid);
			dest.writeString(this.nickname);
			dest.writeString(this.status);
			dest.writeString(this.summary);
			dest.writeString(this.tags);
			dest.writeInt(this.topicnum);
		}

		public InfoEntry() {
		}

		protected InfoEntry(Parcel in) {
			this.applynum = in.readInt();
			this.cccover = in.readString();
			this.ccid = in.readInt();
			this.ccname = in.readString();
			this.cmid = in.readString();
			this.curnum = in.readInt();
			this.flag = in.readString();
			this.headportraid = in.readString();
			this.nickname = in.readString();
			this.status = in.readString();
			this.summary = in.readString();
			this.tags = in.readString();
			this.topicnum = in.readInt();
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

	public JoinSuccess() {
	}

	protected JoinSuccess(Parcel in) {
		this.info = in.readParcelable(InfoEntry.class.getClassLoader());
		this.res = in.readInt();
		this.restr = in.readString();
	}

	public static final Parcelable.Creator<JoinSuccess> CREATOR = new Parcelable.Creator<JoinSuccess>() {
		@Override
		public JoinSuccess createFromParcel(Parcel source) {
			return new JoinSuccess(source);
		}

		@Override
		public JoinSuccess[] newArray(int size) {
			return new JoinSuccess[size];
		}
	};
}
