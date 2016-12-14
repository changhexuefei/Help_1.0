package com.hyzsnt.onekeyhelp.module.login.bean;

import java.util.List;

/**
 * Created by 14369 on 2016/12/14.
 */

public class UserInfoBean {


	/**
	 * info : {"gender":0,"headportraid":"http://192.168.1.123/uploadfile/defaultpic/user.gif","hobbytags":"","incirclenum":0,"incommunity":0,"incommunitynum":0,"lastonline":1481682562,"nickname":"170****4798","phoneno":"17010284798","regtime":1481682562,"status":1,"uid":6}
	 * list : {"circles":[],"communities":[]}
	 * res : 1
	 * restr :
	 */

	private InfoBean info;
	private ListBean list;
	private int res;
	private String restr;

	public InfoBean getInfo() {
		return info;
	}

	public void setInfo(InfoBean info) {
		this.info = info;
	}

	public ListBean getList() {
		return list;
	}

	public void setList(ListBean list) {
		this.list = list;
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

	public static class InfoBean {
		/**
		 * gender : 0
		 * headportraid : http://192.168.1.123/uploadfile/defaultpic/user.gif
		 * hobbytags :
		 * incirclenum : 0
		 * incommunity : 0
		 * incommunitynum : 0
		 * lastonline : 1481682562
		 * nickname : 170****4798
		 * phoneno : 17010284798
		 * regtime : 1481682562
		 * status : 1
		 * uid : 6
		 */

		private int gender;
		private String headportraid;
		private String hobbytags;
		private int incirclenum;
		private int incommunity;
		private int incommunitynum;
		private int lastonline;
		private String nickname;
		private String phoneno;
		private int regtime;
		private int status;
		private int uid;

		public int getGender() {
			return gender;
		}

		public void setGender(int gender) {
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

		public int getIncirclenum() {
			return incirclenum;
		}

		public void setIncirclenum(int incirclenum) {
			this.incirclenum = incirclenum;
		}

		public int getIncommunity() {
			return incommunity;
		}

		public void setIncommunity(int incommunity) {
			this.incommunity = incommunity;
		}

		public int getIncommunitynum() {
			return incommunitynum;
		}

		public void setIncommunitynum(int incommunitynum) {
			this.incommunitynum = incommunitynum;
		}

		public int getLastonline() {
			return lastonline;
		}

		public void setLastonline(int lastonline) {
			this.lastonline = lastonline;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getPhoneno() {
			return phoneno;
		}

		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}

		public int getRegtime() {
			return regtime;
		}

		public void setRegtime(int regtime) {
			this.regtime = regtime;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
		}
	}

	public static class ListBean {
		private List<?> circles;
		private List<?> communities;

		public List<?> getCircles() {
			return circles;
		}

		public void setCircles(List<?> circles) {
			this.circles = circles;
		}

		public List<?> getCommunities() {
			return communities;
		}

		public void setCommunities(List<?> communities) {
			this.communities = communities;
		}
	}
}
