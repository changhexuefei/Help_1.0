package com.hyzsnt.onekeyhelp.module.stroll.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */

public class CircleDetails implements Parcelable {


	/**
	 * res : 1
	 * restr :
	 * info : {"ccid":"14","ccname":"ceshi2","cccover":"/circle/14/14/cover/cover.png","tags":"3","curnum":"4","topicnum":"3","applynum":"0","flag":"1","summary":"ceshidejieshao","createtime":"1481766779","uid":"23","nickname":"131****7888","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","gender":"0","status":"1","cmid":"2803","cmname":"绿岛苑西区","ifjoin":"1","listinfo":{"totalnum":"3","totalpage":0,"perpage":20,"curpage":1,"curnum":3}}
	 * list : [{"tid":"7","title":"都是生活美景","contenttype":"0","goodnum":"0","replynum":"0","posttime":"1481768707","postlat":"39.923215","postlng":"116.540793","distance":135.68336732457,"uid":"23","nickname":"131****7888","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","gender":"0","hobbytags":"|3","status":"1","lastonline":"1481769663","regtime":"1481766244"},{"tid":"6","title":"午间新闻联播","contenttype":"0","goodnum":"0","replynum":"0","posttime":"1481768661","postlat":"39.923215","postlng":"116.540793","distance":135.68336732457,"uid":"23","nickname":"131****7888","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","gender":"0","hobbytags":"|3","status":"1","lastonline":"1481769663","regtime":"1481766244"},{"tid":"5","title":"zheshiceshishuju de biaoti","contenttype":"0","goodnum":"0","replynum":"0","posttime":"1481768607","postlat":"39.923215","postlng":"116.540793","distance":135.68336732457,"uid":"23","nickname":"131****7888","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","gender":"0","hobbytags":"|3","status":"1","lastonline":"1481769663","regtime":"1481766244"}]
	 */

	private int res;
	private String restr;
	/**
	 * ccid : 14
	 * ccname : ceshi2
	 * cccover : /circle/14/14/cover/cover.png
	 * tags : 3
	 * curnum : 4
	 * topicnum : 3
	 * applynum : 0
	 * flag : 1
	 * summary : ceshidejieshao
	 * createtime : 1481766779
	 * uid : 23
	 * nickname : 131****7888
	 * headportraid : http://192.168.1.188/uploadfile/defaultpic/user.gif
	 * gender : 0
	 * status : 1
	 * cmid : 2803
	 * cmname : 绿岛苑西区
	 * ifjoin : 1
	 * listinfo : {"totalnum":"3","totalpage":0,"perpage":20,"curpage":1,"curnum":3}
	 */

	private InfoEntry info;
	/**
	 * tid : 7
	 * title : 都是生活美景
	 * contenttype : 0
	 * goodnum : 0
	 * replynum : 0
	 * posttime : 1481768707
	 * postlat : 39.923215
	 * postlng : 116.540793
	 * distance : 135.68336732457
	 * uid : 23
	 * nickname : 131****7888
	 * headportraid : http://192.168.1.188/uploadfile/defaultpic/user.gif
	 * gender : 0
	 * hobbytags : |3
	 * status : 1
	 * lastonline : 1481769663
	 * regtime : 1481766244
	 */

	private List<ListEntry> list;

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

	public InfoEntry getInfo() {
		return info;
	}

	public void setInfo(InfoEntry info) {
		this.info = info;
	}

	public List<ListEntry> getList() {
		return list;
	}

	public void setList(List<ListEntry> list) {
		this.list = list;
	}

	public static class InfoEntry implements Parcelable {
		private String ccid;
		private String ccname;
		private String cccover;
		private String tags;
		private String curnum;
		private String topicnum;
		private String applynum;
		private String flag;
		private String summary;
		private String createtime;
		private String uid;
		private String nickname;
		private String headportraid;
		private String gender;
		private String status;
		private String cmid;
		private String cmname;
		private String ifjoin;
		/**
		 * totalnum : 3
		 * totalpage : 0
		 * perpage : 20
		 * curpage : 1
		 * curnum : 3
		 */

		private ListinfoEntry listinfo;

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

		public String getCccover() {
			return cccover;
		}

		public void setCccover(String cccover) {
			this.cccover = cccover;
		}

		public String getTags() {
			return tags;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}

		public String getCurnum() {
			return curnum;
		}

		public void setCurnum(String curnum) {
			this.curnum = curnum;
		}

		public String getTopicnum() {
			return topicnum;
		}

		public void setTopicnum(String topicnum) {
			this.topicnum = topicnum;
		}

		public String getApplynum() {
			return applynum;
		}

		public void setApplynum(String applynum) {
			this.applynum = applynum;
		}

		public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String getCreatetime() {
			return createtime;
		}

		public void setCreatetime(String createtime) {
			this.createtime = createtime;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
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

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
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

		public static class ListinfoEntry implements Parcelable {
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

			@Override
			public int describeContents() {
				return 0;
			}

			@Override
			public void writeToParcel(Parcel dest, int flags) {
				dest.writeString(this.totalnum);
				dest.writeInt(this.totalpage);
				dest.writeInt(this.perpage);
				dest.writeInt(this.curpage);
				dest.writeInt(this.curnum);
			}

			public ListinfoEntry() {
			}

			protected ListinfoEntry(Parcel in) {
				this.totalnum = in.readString();
				this.totalpage = in.readInt();
				this.perpage = in.readInt();
				this.curpage = in.readInt();
				this.curnum = in.readInt();
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
			dest.writeString(this.ccid);
			dest.writeString(this.ccname);
			dest.writeString(this.cccover);
			dest.writeString(this.tags);
			dest.writeString(this.curnum);
			dest.writeString(this.topicnum);
			dest.writeString(this.applynum);
			dest.writeString(this.flag);
			dest.writeString(this.summary);
			dest.writeString(this.createtime);
			dest.writeString(this.uid);
			dest.writeString(this.nickname);
			dest.writeString(this.headportraid);
			dest.writeString(this.gender);
			dest.writeString(this.status);
			dest.writeString(this.cmid);
			dest.writeString(this.cmname);
			dest.writeString(this.ifjoin);
			dest.writeParcelable(this.listinfo, flags);
		}

		public InfoEntry() {
		}

		protected InfoEntry(Parcel in) {
			this.ccid = in.readString();
			this.ccname = in.readString();
			this.cccover = in.readString();
			this.tags = in.readString();
			this.curnum = in.readString();
			this.topicnum = in.readString();
			this.applynum = in.readString();
			this.flag = in.readString();
			this.summary = in.readString();
			this.createtime = in.readString();
			this.uid = in.readString();
			this.nickname = in.readString();
			this.headportraid = in.readString();
			this.gender = in.readString();
			this.status = in.readString();
			this.cmid = in.readString();
			this.cmname = in.readString();
			this.ifjoin = in.readString();
			this.listinfo = in.readParcelable(ListinfoEntry.class.getClassLoader());
		}

		public static final Parcelable.Creator<InfoEntry> CREATOR = new Parcelable.Creator<InfoEntry>() {
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
		private String tid;
		private String title;
		private String contenttype;
		private String goodnum;
		private String replynum;
		private String posttime;
		private String postlat;
		private String postlng;
		private double distance;
		private String uid;
		private String nickname;
		private String headportraid;
		private String gender;
		private String hobbytags;
		private String status;
		private String lastonline;
		private String regtime;

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

		public String getContenttype() {
			return contenttype;
		}

		public void setContenttype(String contenttype) {
			this.contenttype = contenttype;
		}

		public String getGoodnum() {
			return goodnum;
		}

		public void setGoodnum(String goodnum) {
			this.goodnum = goodnum;
		}

		public String getReplynum() {
			return replynum;
		}

		public void setReplynum(String replynum) {
			this.replynum = replynum;
		}

		public String getPosttime() {
			return posttime;
		}

		public void setPosttime(String posttime) {
			this.posttime = posttime;
		}

		public String getPostlat() {
			return postlat;
		}

		public void setPostlat(String postlat) {
			this.postlat = postlat;
		}

		public String getPostlng() {
			return postlng;
		}

		public void setPostlng(String postlng) {
			this.postlng = postlng;
		}

		public double getDistance() {
			return distance;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
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

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(this.tid);
			dest.writeString(this.title);
			dest.writeString(this.contenttype);
			dest.writeString(this.goodnum);
			dest.writeString(this.replynum);
			dest.writeString(this.posttime);
			dest.writeString(this.postlat);
			dest.writeString(this.postlng);
			dest.writeDouble(this.distance);
			dest.writeString(this.uid);
			dest.writeString(this.nickname);
			dest.writeString(this.headportraid);
			dest.writeString(this.gender);
			dest.writeString(this.hobbytags);
			dest.writeString(this.status);
			dest.writeString(this.lastonline);
			dest.writeString(this.regtime);
		}

		public ListEntry() {
		}

		protected ListEntry(Parcel in) {
			this.tid = in.readString();
			this.title = in.readString();
			this.contenttype = in.readString();
			this.goodnum = in.readString();
			this.replynum = in.readString();
			this.posttime = in.readString();
			this.postlat = in.readString();
			this.postlng = in.readString();
			this.distance = in.readDouble();
			this.uid = in.readString();
			this.nickname = in.readString();
			this.headportraid = in.readString();
			this.gender = in.readString();
			this.hobbytags = in.readString();
			this.status = in.readString();
			this.lastonline = in.readString();
			this.regtime = in.readString();
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
		dest.writeInt(this.res);
		dest.writeString(this.restr);
		dest.writeParcelable(this.info, flags);
		dest.writeList(this.list);
	}

	public CircleDetails() {
	}

	protected CircleDetails(Parcel in) {
		this.res = in.readInt();
		this.restr = in.readString();
		this.info = in.readParcelable(InfoEntry.class.getClassLoader());
		this.list = new ArrayList<ListEntry>();
		in.readList(this.list, ListEntry.class.getClassLoader());
	}

	public static final Parcelable.Creator<CircleDetails> CREATOR = new Parcelable.Creator<CircleDetails>() {
		@Override
		public CircleDetails createFromParcel(Parcel source) {
			return new CircleDetails(source);
		}

		@Override
		public CircleDetails[] newArray(int size) {
			return new CircleDetails[size];
		}
	};
}
