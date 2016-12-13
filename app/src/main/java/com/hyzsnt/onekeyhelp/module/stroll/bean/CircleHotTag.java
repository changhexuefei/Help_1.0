package com.hyzsnt.onekeyhelp.module.stroll.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class CircleHotTag {

	/**
	 * res : 1
	 * restr :
	 * info : []
	 * list : [{"tagid":"1","tagname":"美食","circlenum":"0","tagpic":"http://192.168.1.123/uploadfile/circletagpic/1.jpg"},{"tagid":"2","tagname":"健身","circlenum":"0","tagpic":"http://192.168.1.123/uploadfile/circletagpic/2.jpg"},{"tagid":"5","tagname":"亲子","circlenum":"0","tagpic":"http://192.168.1.123/uploadfile/circletagpic/5.jpg"},{"tagid":"9","tagname":"旅行","circlenum":"0","tagpic":"http://192.168.1.123/uploadfile/circletagpic/9.jpg"}]
	 */

	private int res;
	private String restr;
	private List<?> info;
	/**
	 * tagid : 1
	 * tagname : 美食
	 * circlenum : 0
	 * tagpic : http://192.168.1.123/uploadfile/circletagpic/1.jpg
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

	public List<?> getInfo() {
		return info;
	}

	public void setInfo(List<?> info) {
		this.info = info;
	}

	public List<ListEntry> getList() {
		return list;
	}

	public void setList(List<ListEntry> list) {
		this.list = list;
	}

	public static class ListEntry {
		private String tagid;
		private String tagname;
		private String circlenum;
		private String tagpic;

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

		public String getCirclenum() {
			return circlenum;
		}

		public void setCirclenum(String circlenum) {
			this.circlenum = circlenum;
		}

		public String getTagpic() {
			return tagpic;
		}

		public void setTagpic(String tagpic) {
			this.tagpic = tagpic;
		}
	}
}
