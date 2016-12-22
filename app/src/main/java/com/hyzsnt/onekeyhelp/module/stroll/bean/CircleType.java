package com.hyzsnt.onekeyhelp.module.stroll.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/11.
 */

public class CircleType {



	/**
	 * info : []
	 * list : [{"tagdesc":"#dfa772","tagid":"1","tagname":"美食"},{"tagdesc":"#78abde","tagid":"2","tagname":"健身"},{"tagdesc":"#79dab9","tagid":"3","tagname":"爱宠"},{"tagdesc":"#ea7575","tagid":"4","tagname":"影视"},{"tagdesc":"#53d5d4","tagid":"5","tagname":"亲子"},{"tagdesc":"#dfd07c","tagid":"6","tagname":"聚会"},{"tagdesc":"#dd82a6","tagid":"7","tagname":"音乐"},{"tagdesc":"#ee91e2","tagid":"8","tagname":"互助"},{"tagdesc":"#d6dd82","tagid":"9","tagname":"旅行"},{"tagdesc":"#98e694","tagid":"10","tagname":"交友"},{"tagdesc":"#e7a37c","tagid":"11","tagname":"理财"}]
	 * res : 1
	 * restr :
	 */

	private int res;
	private String restr;




	/**
	 * tagdesc : #dfa772

	 * tagid : 1
	 * tagname : 美食
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



	public List<ListEntry> getList() {
		return list;
	}

	public void setList(List<ListEntry> list) {
		this.list = list;
	}

	public static class ListEntry {
		private String tagdesc;
		private String tagid;
		private String tagname;
		private Boolean isselect;

		public ListEntry(String tagdesc, String tagid, String tagname, Boolean isselect) {
			this.tagdesc = tagdesc;
			this.tagid = tagid;
			this.tagname = tagname;
			this.isselect = isselect;
		}

		public String getTagdesc() {
			return tagdesc;
		}

		public ListEntry(String tagdesc, String tagid, String tagname) {
			this.tagdesc = tagdesc;
			this.tagid = tagid;
			this.tagname = tagname;
		}

		@Override
		public String toString() {
			return "ListEntry{" +
					"tagdesc='" + tagdesc + '\'' +
					", tagid='" + tagid + '\'' +
					", tagname='" + tagname + '\'' +
					", isselect=" + isselect +
					'}';
		}

		public void setTagdesc(String tagdesc) {
			this.tagdesc = tagdesc;
		}

		public Boolean getIsselect() {
			return isselect;
		}

		public void setIsselect(Boolean isselect) {
			this.isselect = isselect;
		}

		public String getTagid() {
			return tagid;

		}

		public void setTagid(String tagid) {
			this.tagid = tagid;
		}

		public String getTagname() {
			return tagname;
		}

		public void setTagname(String tagname) {
			this.tagname = tagname;
		}
	}
}
