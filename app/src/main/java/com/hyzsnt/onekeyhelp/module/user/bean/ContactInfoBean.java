package com.hyzsnt.onekeyhelp.module.user.bean;

import java.util.List;

/**
 * Created by 14369 on 2016/12/21.
 */

public class ContactInfoBean {


	/**
	 * info : []
	 * list : [{"emlid":"1","headportraid":"0","linkerdesc":"666","linkername":"陈宇勋","linkerphoneno":"18516521194","linkeruid":"0","nickname":"陈宇勋","uid":"5"}]
	 * res : 1
	 * restr :
	 */

	private int res;
	private String restr;
	private List<?> info;
	private List<ListBean> list;

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

	public List<?> getInfo() {
		return info;
	}

	public void setInfo(List<?> info) {
		this.info = info;
	}

	public List<ListBean> getList() {
		return list;
	}

	public void setList(List<ListBean> list) {
		this.list = list;
	}

	public static class ListBean {
		/**
		 * emlid : 1
		 * headportraid : 0
		 * linkerdesc : 666
		 * linkername : 陈宇勋
		 * linkerphoneno : 18516521194
		 * linkeruid : 0
		 * nickname : 陈宇勋
		 * uid : 5
		 */

		private String emlid;
		private String headportraid;
		private String linkerdesc;
		private String linkername;
		private String linkerphoneno;
		private String linkeruid;
		private String nickname;
		private String uid;

		public String getEmlid() {
			return emlid;
		}

		public void setEmlid(String emlid) {
			this.emlid = emlid;
		}

		public String getHeadportraid() {
			return headportraid;
		}

		public void setHeadportraid(String headportraid) {
			this.headportraid = headportraid;
		}

		public String getLinkerdesc() {
			return linkerdesc;
		}

		public void setLinkerdesc(String linkerdesc) {
			this.linkerdesc = linkerdesc;
		}

		public String getLinkername() {
			return linkername;
		}

		public void setLinkername(String linkername) {
			this.linkername = linkername;
		}

		public String getLinkerphoneno() {
			return linkerphoneno;
		}

		public void setLinkerphoneno(String linkerphoneno) {
			this.linkerphoneno = linkerphoneno;
		}

		public String getLinkeruid() {
			return linkeruid;
		}

		public void setLinkeruid(String linkeruid) {
			this.linkeruid = linkeruid;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}
	}
}
