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
	 *
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
	 * list : [{"contenttype":"0","distance":135.68336732457,"gender":"0","goodnum":"0","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","hobbytags":"|","lastonline":"1481769663","nickname":"131****7888","postlat":"39.923215","postlng":"116.540793","posttime":"1481768707","regtime":"1481766244","replynum":"0","status":"1","tid":"7","title":"都是生活美景","uid":"23"},{"contenttype":"0","distance":135.68336732457,"gender":"0","goodnum":"0","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","hobbytags":"|3|亲","lastonline":"1481769663","nickname":"131****7888","postlat":"39.923215","postlng":"116.540793","posttime":"1481768661","regtime":"1481766244","replynum":"0","status":"1","tid":"6","title":"午间新闻联播","uid":"23"},{"contenttype":"0","distance":135.68336732457,"gender":"0","goodnum":"0","headportraid":"http://192.168.1.188/uploadfile/defaultpic/user.gif","hobbytags":"|3|","lastonline":"1481769663","nickname":"131****7888","postlat":"39.923215","postlng":"116.540793","posttime":"1481768607","regtime":"1481766244","replynum":"0","status":"1","tid":"5","title":"zheshiceshishuju de biaoti","uid":"23"}]
	 * res : 1
	 * restr :
	 */

	private int res;
	private String restr;
	/**
	 * contenttype : 0
	 * distance : 135.68336732457
	 * gender : 0
	 * goodnum : 0
	 * headportraid : http://192.168.1.188/uploadfile/defaultpic/user.gif
	 * hobbytags : |
	 * lastonline : 1481769663
	 * nickname : 131****7888
	 * postlat : 39.923215
	 * postlng : 116.540793
	 * posttime : 1481768707
	 * regtime : 1481766244
	 * replynum : 0
	 * status : 1
	 * tid : 7
	 * title : 都是生活美景
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

	public static class ListEntry implements Parcelable {
		private String contenttype;
		private double distance;
		private String gender;
		private String goodnum;
		private String headportraid;
		private String hobbytags;
		private String lastonline;
		private String nickname;
		private String postlat;
		private String postlng;
		private String posttime;
		private String regtime;
		private String replynum;
		private String status;
		private String tid;
		private String title;
		private String uid;

		public String getContenttype() {
			return contenttype;
		}

		public void setContenttype(String contenttype) {
			this.contenttype = contenttype;
		}

		public double getDistance() {
			return distance;
		}

		public void setDistance(double distance) {
			this.distance = distance;
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

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
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

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(this.contenttype);
			dest.writeDouble(this.distance);
			dest.writeString(this.gender);
			dest.writeString(this.goodnum);
			dest.writeString(this.headportraid);
			dest.writeString(this.hobbytags);
			dest.writeString(this.lastonline);
			dest.writeString(this.nickname);
			dest.writeString(this.postlat);
			dest.writeString(this.postlng);
			dest.writeString(this.posttime);
			dest.writeString(this.regtime);
			dest.writeString(this.replynum);
			dest.writeString(this.status);
			dest.writeString(this.tid);
			dest.writeString(this.title);
			dest.writeString(this.uid);
		}

		public ListEntry() {
		}

		protected ListEntry(Parcel in) {
			this.contenttype = in.readString();
			this.distance = in.readDouble();
			this.gender = in.readString();
			this.goodnum = in.readString();
			this.headportraid = in.readString();
			this.hobbytags = in.readString();
			this.lastonline = in.readString();
			this.nickname = in.readString();
			this.postlat = in.readString();
			this.postlng = in.readString();
			this.posttime = in.readString();
			this.regtime = in.readString();
			this.replynum = in.readString();
			this.status = in.readString();
			this.tid = in.readString();
			this.title = in.readString();
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

	public CircleDetails() {
	}

	protected CircleDetails(Parcel in) {
		this.info = in.readParcelable(InfoEntry.class.getClassLoader());
		this.res = in.readInt();
		this.restr = in.readString();
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
