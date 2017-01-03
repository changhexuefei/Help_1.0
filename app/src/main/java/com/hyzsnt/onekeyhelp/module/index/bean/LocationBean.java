package com.hyzsnt.onekeyhelp.module.index.bean;

import java.util.List;



public class LocationBean {

	/**
	 * info : {"position":"北京市朝阳区朝阳路67号院-10","regid":"110105","regname":"朝阳区"}
	 * list : []
	 * res : 1
	 * restr :
	 */

	private InfoBean info;
	private int res;
	private String restr;
	private List<?> list;

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

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public static class InfoBean {
		/**
		 * position : 北京市朝阳区朝阳路67号院-10
		 * regid : 110105
		 * regname : 朝阳区
		 */

		private String position;
		private String regid;
		private String regname;
		private int selfemerg;
		private int surroundingemerg;

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getRegid() {
			return regid;
		}

		public void setRegid(String regid) {
			this.regid = regid;
		}

		public String getRegname() {
			return regname;
		}

		public void setRegname(String regname) {
			this.regname = regname;
		}

		public int getSelfemerg() {
			return selfemerg;
		}

		public void setSelfemerg(int selfemerg) {
			this.selfemerg = selfemerg;
		}

		public int getSurroundingemerg() {
			return surroundingemerg;
		}

		public void setSurroundingemerg(int surroundingemerg) {
			this.surroundingemerg = surroundingemerg;
		}
	}
}
