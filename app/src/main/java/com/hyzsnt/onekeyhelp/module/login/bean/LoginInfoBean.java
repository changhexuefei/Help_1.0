package com.hyzsnt.onekeyhelp.module.login.bean;

/**
 * Created by 14369 on 2016/12/14.
 */

public class LoginInfoBean {

	/**
	 * info : {"gender":"0","headportraid":"http://192.168.1.123/uploadfile/defaultpic/user.gif","hobbytags":"","incirclenum":"0","incommunity":"0","incommunitynum":"0","lastonline":"1481683966","nickname":"155****5396","phoneno":"15551675396","regtime":"1481682255","status":"1","uid":"5"}
	 * res : 1
	 * restr :
	 */

	private InfoBean info;
	private int res;
	private String restr;

	public InfoBean getInfo() {
		return info;
	}

	public void setInfo(InfoBean info) {
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

	public static class InfoBean {
		/**
		 * gender : 0
		 * headportraid : http://192.168.1.123/uploadfile/defaultpic/user.gif
		 * hobbytags :
		 * incirclenum : 0
		 * incommunity : 0
		 * incommunitynum : 0
		 * lastonline : 1481683966
		 * nickname : 155****5396
		 * phoneno : 15551675396
		 * regtime : 1481682255
		 * status : 1
		 * uid : 5
		 */

		private String gender;
		private String headportraid;
		private String hobbytags;
		private String incirclenum;
		private String incommunity;
		private String incommunitynum;
		private String lastonline;
		private String nickname;
		private String phoneno;
		private String regtime;
		private String status;
		private String uid;

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

		public String getIncirclenum() {
			return incirclenum;
		}

		public void setIncirclenum(String incirclenum) {
			this.incirclenum = incirclenum;
		}

		public String getIncommunity() {
			return incommunity;
		}

		public void setIncommunity(String incommunity) {
			this.incommunity = incommunity;
		}

		public String getIncommunitynum() {
			return incommunitynum;
		}

		public void setIncommunitynum(String incommunitynum) {
			this.incommunitynum = incommunitynum;
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

		public String getPhoneno() {
			return phoneno;
		}

		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
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
	}
}
