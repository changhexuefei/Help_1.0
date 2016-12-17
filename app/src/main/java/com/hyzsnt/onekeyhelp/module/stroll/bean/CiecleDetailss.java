package com.hyzsnt.onekeyhelp.module.stroll.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/12/15.
 */

public class CiecleDetailss implements Parcelable {
	/**
	 * applynum : 4
	 * cccover : /circle/14/14/cover/cover.png
	 * ccid : 14
	 * ccname : ceshi2
	 * cmid : 2803
	 * cmname : 绿岛苑西区
	 * createtime : 1481766779
	 * curnum : 4
	 * flag : 1
	 * gender : 0
	 * headportraid : http://192.168.1.188/uploadfile/defaultpic/user.gif
	 * ifjoin : 1
	 * listinfo : {"curnum":3,"curpage":1,"perpage":20,"totalnum":"3","totalpage":0}
	 * nickname : 131****7888
	 * status : 1
	 * summary : ceshidejieshao
	 * tags : 3
	 * topicnum : 3
	 * uid : 23
	 */

	private InfoEntry info;
	/**
	 * info : {"applynum":"4","cccover":"/circle/14/14/cover/cover.png","ccid":"14","ccname":"ceshi2","cmid":"2803","cmname":"绿岛苑西区","createtime":"1481766779","curnum":"4","flag":"1","gender":"0","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","ifjoin":"1","listinfo":{"curnum":3,"curpage":1,"perpage":20,"totalnum":"3","totalpage":0},"nickname":"131****7888","status":"1","summary":"ceshidejieshao","tags":"3","topicnum":"3","uid":"23"}
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
		private String applynum;
		private String cccover;
		private String ccid;
		private String ccname;
		private String cmid;
		private String cmname;
		private String createtime;
		private String curnum;
		private String flag;
		private String gender;
		private String headportraid;
		private String ifjoin;
		/**
		 * curnum : 3
		 * curpage : 1
		 * perpage : 20
		 * totalnum : 3
		 * totalpage : 0
		 */

		private ListinfoEntry listinfo;
		private String nickname;
		private String status;
		private String summary;
		private String tags;
		private String topicnum;
		private String uid;

		public String getApplynum() {
			return applynum;
		}

		public void setApplynum(String applynum) {
			this.applynum = applynum;
		}

		public String getCccover() {
			return cccover;
		}

		public void setCccover(String cccover) {
			this.cccover = cccover;
		}

		public String getCcid() {
			return ccid;
		}

		public void setCcid(String ccid) {
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

		public String getCmname() {
			return cmname;
		}

		public void setCmname(String cmname) {
			this.cmname = cmname;
		}

		public String getCreatetime() {
			return createtime;
		}

		public void setCreatetime(String createtime) {
			this.createtime = createtime;
		}

		public String getCurnum() {
			return curnum;
		}

		public void setCurnum(String curnum) {
			this.curnum = curnum;
		}

		public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
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

		public String getIfjoin() {
			return ifjoin;
		}

		public void setIfjoin(String ifjoin) {
			this.ifjoin = ifjoin;
		}

		public ListinfoEntry getListinfo() {
			return listinfo;
		}

		public void setListinfo(ListinfoEntry listinfo) {
			this.listinfo = listinfo;
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

		public String getTopicnum() {
			return topicnum;
		}

		public void setTopicnum(String topicnum) {
			this.topicnum = topicnum;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public static class ListinfoEntry implements Parcelable {
			private int curnum;
			private int curpage;
			private int perpage;
			private String totalnum;
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

			@Override
			public int describeContents() {
				return 0;
			}

			@Override
			public void writeToParcel(Parcel dest, int flags) {
				dest.writeInt(this.curnum);
				dest.writeInt(this.curpage);
				dest.writeInt(this.perpage);
				dest.writeString(this.totalnum);
				dest.writeInt(this.totalpage);
			}

			public ListinfoEntry() {
			}

			protected ListinfoEntry(Parcel in) {
				this.curnum = in.readInt();
				this.curpage = in.readInt();
				this.perpage = in.readInt();
				this.totalnum = in.readString();
				this.totalpage = in.readInt();
			}

			public static final Creator<ListinfoEntry> CREATOR = new Creator<ListinfoEntry>() {
				@Override
				public ListinfoEntry createFromParcel(Parcel source) {
					return new ListinfoEntry(source);
				}

				@Override
				public ListinfoEntry[] newArray(int size) {
					return new ListinfoEntry[size];
				}
			};
		}

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(this.applynum);
			dest.writeString(this.cccover);
			dest.writeString(this.ccid);
			dest.writeString(this.ccname);
			dest.writeString(this.cmid);
			dest.writeString(this.cmname);
			dest.writeString(this.createtime);
			dest.writeString(this.curnum);
			dest.writeString(this.flag);
			dest.writeString(this.gender);
			dest.writeString(this.headportraid);
			dest.writeString(this.ifjoin);
			dest.writeParcelable(this.listinfo, flags);
			dest.writeString(this.nickname);
			dest.writeString(this.status);
			dest.writeString(this.summary);
			dest.writeString(this.tags);
			dest.writeString(this.topicnum);
			dest.writeString(this.uid);
		}

		public InfoEntry() {
		}

		protected InfoEntry(Parcel in) {
			this.applynum = in.readString();
			this.cccover = in.readString();
			this.ccid = in.readString();
			this.ccname = in.readString();
			this.cmid = in.readString();
			this.cmname = in.readString();
			this.createtime = in.readString();
			this.curnum = in.readString();
			this.flag = in.readString();
			this.gender = in.readString();
			this.headportraid = in.readString();
			this.ifjoin = in.readString();
			this.listinfo = in.readParcelable(ListinfoEntry.class.getClassLoader());
			this.nickname = in.readString();
			this.status = in.readString();
			this.summary = in.readString();
			this.tags = in.readString();
			this.topicnum = in.readString();
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

	public CiecleDetailss() {
	}

	protected CiecleDetailss(Parcel in) {
		this.info = in.readParcelable(InfoEntry.class.getClassLoader());
		this.res = in.readInt();
		this.restr = in.readString();
	}

	public static final Parcelable.Creator<CiecleDetailss> CREATOR = new Parcelable.Creator<CiecleDetailss>() {
		@Override
		public CiecleDetailss createFromParcel(Parcel source) {
			return new CiecleDetailss(source);
		}

		@Override
		public CiecleDetailss[] newArray(int size) {
			return new CiecleDetailss[size];
		}
	};
}
