package com.hyzsnt.onekeyhelp.module.stroll.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */

public class CircleMember implements Parcelable {

	/**
	 * applynum : 0
	 * curnum : 1
	 * curpage : 1
	 * perpage : 1
	 * totalnum : 1
	 * totalpage : 1
	 */

	private InfoEntry info;
	/**
	 * info : {"applynum":0,"curnum":1,"curpage":1,"perpage":1,"totalnum":1,"totalpage":1}
	 * list : [{"cmid":"2803","cmname":"绿岛苑西区","gender":"0","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","hobbytags":"|3","ifcreate":"1","jointime":"1481766779","lastonline":"1481769663","nickname":"131****7888","regtime":"1481766244","status":"1","uid":"23"}]
	 * res : 1
	 * restr :
	 */

	private int res;
	private String restr;
	/**
	 * cmid : 2803
	 * cmname : 绿岛苑西区
	 * gender : 0
	 * headportraid : http://192.168.1.188/uploadfile/defaultpic/user.gif
	 * hobbytags : |3
	 * ifcreate : 1
	 * jointime : 1481766779
	 * lastonline : 1481769663
	 * nickname : 131****7888
	 * regtime : 1481766244
	 * status : 1
	 * uid : 23
	 */

	private List<ListEntry> list;

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

	public List<ListEntry> getList() {
		return list;
	}

	public void setList(List<ListEntry> list) {
		this.list = list;
	}

	public static class InfoEntry implements Parcelable {
		private int applynum;
		private int curnum;
		private int curpage;
		private int perpage;
		private int totalnum;
		private int totalpage;

		public int getApplynum() {
			return applynum;
		}

		public void setApplynum(int applynum) {
			this.applynum = applynum;
		}

		public int getCurnum() {
			return curnum;
		}

		public void setCurnum(int curnum) {
			this.curnum = curnum;
		}

		public int getCurpage() {
			return curpage;
		}

		public void setCurpage(int curpage) {
			this.curpage = curpage;
		}

		public int getPerpage() {
			return perpage;
		}

		public void setPerpage(int perpage) {
			this.perpage = perpage;
		}

		public int getTotalnum() {
			return totalnum;
		}

		public void setTotalnum(int totalnum) {
			this.totalnum = totalnum;
		}

		public int getTotalpage() {
			return totalpage;
		}

		public void setTotalpage(int totalpage) {
			this.totalpage = totalpage;
		}

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeInt(this.applynum);
			dest.writeInt(this.curnum);
			dest.writeInt(this.curpage);
			dest.writeInt(this.perpage);
			dest.writeInt(this.totalnum);
			dest.writeInt(this.totalpage);
		}

		public InfoEntry() {
		}

		protected InfoEntry(Parcel in) {
			this.applynum = in.readInt();
			this.curnum = in.readInt();
			this.curpage = in.readInt();
			this.perpage = in.readInt();
			this.totalnum = in.readInt();
			this.totalpage = in.readInt();
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

	public static class ListEntry implements Parcelable {
		private String cmid;
		private String cmname;
		private String gender;
		private String headportraid;
		private String hobbytags;
		private String ifcreate;
		private String jointime;
		private String lastonline;
		private String nickname;
		private String regtime;
		private String status;
		private String uid;

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

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
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

		public String getIfcreate() {
			return ifcreate;
		}

		public void setIfcreate(String ifcreate) {
			this.ifcreate = ifcreate;
		}

		public String getJointime() {
			return jointime;
		}

		public void setJointime(String jointime) {
			this.jointime = jointime;
		}

		public String getLastonline() {
			return lastonline;
		}

		public void setLastonline(String lastonline) {
			this.lastonline = lastonline;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getRegtime() {
			return regtime;
		}

		public void setRegtime(String regtime) {
			this.regtime = regtime;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(this.cmid);
			dest.writeString(this.cmname);
			dest.writeString(this.gender);
			dest.writeString(this.headportraid);
			dest.writeString(this.hobbytags);
			dest.writeString(this.ifcreate);
			dest.writeString(this.jointime);
			dest.writeString(this.lastonline);
			dest.writeString(this.nickname);
			dest.writeString(this.regtime);
			dest.writeString(this.status);
			dest.writeString(this.uid);
		}

		public ListEntry() {
		}

		protected ListEntry(Parcel in) {
			this.cmid = in.readString();
			this.cmname = in.readString();
			this.gender = in.readString();
			this.headportraid = in.readString();
			this.hobbytags = in.readString();
			this.ifcreate = in.readString();
			this.jointime = in.readString();
			this.lastonline = in.readString();
			this.nickname = in.readString();
			this.regtime = in.readString();
			this.status = in.readString();
			this.uid = in.readString();
		}

		public static final Creator<ListEntry> CREATOR = new Creator<ListEntry>() {
			@Override
			public ListEntry createFromParcel(Parcel source) {
				return new ListEntry(source);
			}

			@Override
			public ListEntry[] newArray(int size) {
				return new ListEntry[size];
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
		dest.writeList(this.list);
	}

	public CircleMember() {
	}

	protected CircleMember(Parcel in) {
		this.info = in.readParcelable(InfoEntry.class.getClassLoader());
		this.res = in.readInt();
		this.restr = in.readString();
		this.list = new ArrayList<ListEntry>();
		in.readList(this.list, ListEntry.class.getClassLoader());
	}

	public static final Parcelable.Creator<CircleMember> CREATOR = new Parcelable.Creator<CircleMember>() {
		@Override
		public CircleMember createFromParcel(Parcel source) {
			return new CircleMember(source);
		}

		@Override
		public CircleMember[] newArray(int size) {
			return new CircleMember[size];
		}
	};
}
