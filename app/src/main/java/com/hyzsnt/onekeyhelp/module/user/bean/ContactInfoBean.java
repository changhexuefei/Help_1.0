package com.hyzsnt.onekeyhelp.module.user.bean;

import java.util.List;

/**
 * Created by 14369 on 2016/12/21.
 */

public class ContactInfoBean {

	/**
	 * info : []
	 * list : [{"emlid":"3","linkerphoneno":"13635676978","linkeruid":"0","uid":"5"},{"emlid":"4","linkerphoneno":"13635676978","linkeruid":"0","uid":"5"},{"emlid":"5","linkerphoneno":"15210016348","linkeruid":"0","uid":"5"},{"emlid":"6","linkerphoneno":"18298115431","linkeruid":"0","uid":"5"},{"emlid":"7","linkerphoneno":"15555826656","linkeruid":"0","uid":"5"}]
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
		 * emlid : 3
		 * linkerphoneno : 13635676978
		 * linkeruid : 0
		 * uid : 5
		 */

		private String emlid;
		private String linkerphoneno;
		private String linkeruid;
		private String uid;

		public String getEmlid() {
			return emlid;
		}

		public void setEmlid(String emlid) {
			this.emlid = emlid;
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

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}
	}
}
