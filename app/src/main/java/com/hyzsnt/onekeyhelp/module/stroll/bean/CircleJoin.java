package com.hyzsnt.onekeyhelp.module.stroll.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */

public class CircleJoin implements Parcelable {

	/**
	 * curnum : 4
	 * curpage : 1
	 * perpage : 4
	 * totalnum : 4
	 * totalpage : 1
	 */

	private InfoEntry info;
	/**
	 * info : {"curnum":4,"curpage":1,"perpage":4,"totalnum":4,"totalpage":1}
	 * list : [{"applytime":"1481874566","cmid":"2803","cmname":"绿岛苑西区","gender":"0","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","hobbytags":"|1|7","id":"5","lastonline":"1481698632","nickname":"131****7891","regtime":"1481698203","status":"1","uid":"9"},{"applytime":"1481874577","cmid":"2061","cmname":"都市经典家园","gender":"0","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","hobbytags":"|6|10|9","id":"6","lastonline":"1481700187","nickname":"131****7892","regtime":"1481699521","status":"1","uid":"10"},{"applytime":"1481874589","cmid":"2061","cmname":"都市经典家园","gender":"0","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","hobbytags":"","id":"7","lastonline":"1481700338","nickname":"131****7893","regtime":"1481699653","status":"1","uid":"11"},{"applytime":"1481874603","cmid":"2061","cmname":"都市经典家园","gender":"0","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","hobbytags":"|1|10","id":"8","lastonline":"1481700363","nickname":"131****7894","regtime":"1481699670","status":"1","uid":"12"}]
	 * res : 1
	 * restr :
	 */

	private int res;
	private String restr;
	/**
	 * applytime : 1481874566
	 * cmid : 2803
	 * cmname : 绿岛苑西区
	 * gender : 0
	 * headportraid : http://192.168.1.188/uploadfile/defaultpic/user.gif
	 * hobbytags : |1|7
	 * id : 5
	 * lastonline : 1481698632
	 * nickname : 131****7891
	 * regtime : 1481698203
	 * status : 1
	 * uid : 9
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
		private int curnum;
		private int curpage;
		private int perpage;
		private int totalnum;
		private int totalpage;

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
			dest.writeInt(this.curnum);
			dest.writeInt(this.curpage);
			dest.writeInt(this.perpage);
			dest.writeInt(this.totalnum);
			dest.writeInt(this.totalpage);
		}

		public InfoEntry() {
		}

		protected InfoEntry(Parcel in) {
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
		private String applytime;
		private String cmid;
		private String cmname;
		private String gender;
		private String headportraid;
		private String hobbytags;
		private String id;
		private String lastonline;
		private String nickname;
		private String regtime;
		private String status;
		private String uid;

		public String getApplytime() {
			return applytime;
		}

		public void setApplytime(String applytime) {
			this.applytime = applytime;
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

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
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
			dest.writeString(this.applytime);
			dest.writeString(this.cmid);
			dest.writeString(this.cmname);
			dest.writeString(this.gender);
			dest.writeString(this.headportraid);
			dest.writeString(this.hobbytags);
			dest.writeString(this.id);
			dest.writeString(this.lastonline);
			dest.writeString(this.nickname);
			dest.writeString(this.regtime);
			dest.writeString(this.status);
			dest.writeString(this.uid);
		}

		public ListEntry() {
		}

		protected ListEntry(Parcel in) {
			this.applytime = in.readString();
			this.cmid = in.readString();
			this.cmname = in.readString();
			this.gender = in.readString();
			this.headportraid = in.readString();
			this.hobbytags = in.readString();
			this.id = in.readString();
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

	public CircleJoin() {
	}

	protected CircleJoin(Parcel in) {
		this.info = in.readParcelable(InfoEntry.class.getClassLoader());
		this.res = in.readInt();
		this.restr = in.readString();
		this.list = new ArrayList<ListEntry>();
		in.readList(this.list, ListEntry.class.getClassLoader());
	}

	public static final Parcelable.Creator<CircleJoin> CREATOR = new Parcelable.Creator<CircleJoin>() {
		@Override
		public CircleJoin createFromParcel(Parcel source) {
			return new CircleJoin(source);
		}
		@Override
		public CircleJoin[] newArray(int size) {
			return new CircleJoin[size];
		}
	};
}
