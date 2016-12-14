package com.hyzsnt.onekeyhelp.module.stroll.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
*/

public class CircleRound {

	/**
	 * circlenum : 5
	 * communitynum : 3
	 */

	private InfoEntry info;
	/**
	 * info : {"circlenum":5,"communitynum":3}
	 * list : [{"circle":[{"cccover":"/circle/2/2/cover/cover.png","ccid":"2","ccname":"测试交流群","curnum":"1","flag":"1","tags":"1","topicnum":"0"},{"cccover":"/circle/6/6/cover/cover.png","ccid":"6","ccname":"同城交友聚会","curnum":"1","flag":"1","tags":"6|10|9","topicnum":"0"}],"community":{"circlenum":"2","cmid":"2061","cmname":"都市经典家园","curnum":"9","distance":1420.2608328527,"lat":"39.920095244742","lng":"116.52686782425","thiscirclenum":2}},{"circle":[{"cccover":"/circle/4/4/cover/cover.png","ccid":"4","ccname":"音乐盛会","curnum":"1","flag":"1","tags":"1|7","topicnum":"0"},{"cccover":"/circle/5/5/cover/cover.png","ccid":"5","ccname":"同城交友","curnum":"1","flag":"1","tags":"6|10|9","topicnum":"0"}],"community":{"circlenum":"2","cmid":"2601","cmname":"京棉新城二厂","curnum":"0","distance":2956.3696121516,"lat":"39.923933528654","lng":"116.5129655323","thiscirclenum":2}},{"circle":[{"cccover":"/circle/3/3/cover/cover.png","ccid":"3","ccname":"音乐节","curnum":"1","flag":"1","tags":"1","topicnum":"0"}],"community":{"circlenum":"1","cmid":"2803","cmname":"绿岛苑西区","curnum":"2","distance":1396.6065194715,"lat":"39.923968267862","lng":"116.55213789665","thiscirclenum":1}}]
	 * res : 1
	 * restr :
	 */

	private int res;
	private String restr;
	/**
	 * circle : [{"cccover":"/circle/2/2/cover/cover.png","ccid":"2","ccname":"测试交流群","curnum":"1","flag":"1","tags":"1","topicnum":"0"},{"cccover":"/circle/6/6/cover/cover.png","ccid":"6","ccname":"同城交友聚会","curnum":"1","flag":"1","tags":"6|10|9","topicnum":"0"}]
	 * community : {"circlenum":"2","cmid":"2061","cmname":"都市经典家园","curnum":"9","distance":1420.2608328527,"lat":"39.920095244742","lng":"116.52686782425","thiscirclenum":2}
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

	public static class InfoEntry {
		private int circlenum;
		private int communitynum;

		public int getCirclenum() {
			return circlenum;
		}

		public void setCirclenum(int circlenum) {
			this.circlenum = circlenum;
		}

		public int getCommunitynum() {
			return communitynum;
		}

		public void setCommunitynum(int communitynum) {
			this.communitynum = communitynum;
		}
	}

	public static class ListEntry {
		/**
		 * circlenum : 2
		 * cmid : 2061
		 * cmname : 都市经典家园
		 * curnum : 9
		 * distance : 1420.2608328527
		 * lat : 39.920095244742
		 * lng : 116.52686782425
		 * thiscirclenum : 2
		 */

		private CommunityEntry community;
		/**
		 * cccover : /circle/2/2/cover/cover.png
		 * ccid : 2
		 * ccname : 测试交流群
		 * curnum : 1
		 * flag : 1
		 * tags : 1
		 * topicnum : 0
		 */

		private List<CircleEntry> circle;

		public CommunityEntry getCommunity() {
			return community;
		}

		public void setCommunity(CommunityEntry community) {
			this.community = community;
		}

		public List<CircleEntry> getCircle() {
			return circle;
		}

		public void setCircle(List<CircleEntry> circle) {
			this.circle = circle;
		}

		public static class CommunityEntry {
			private String circlenum;
			private String cmid;
			private String cmname;
			private String curnum;
			private double distance;
			private String lat;
			private String lng;
			private int thiscirclenum;

			public String getCirclenum() {
				return circlenum;
			}

			public void setCirclenum(String circlenum) {
				this.circlenum = circlenum;
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

			public String getCurnum() {
				return curnum;
			}

			public void setCurnum(String curnum) {
				this.curnum = curnum;
			}

			public double getDistance() {
				return distance;
			}

			public void setDistance(double distance) {
				this.distance = distance;
			}

			public String getLat() {
				return lat;
			}

			public void setLat(String lat) {
				this.lat = lat;
			}

			public String getLng() {
				return lng;
			}

			public void setLng(String lng) {
				this.lng = lng;
			}

			public int getThiscirclenum() {
				return thiscirclenum;
			}

			public void setThiscirclenum(int thiscirclenum) {
				this.thiscirclenum = thiscirclenum;
			}
		}

		public static class CircleEntry {
			private String cccover;
			private String ccid;
			private String ccname;
			private String curnum;
			private String flag;
			private String tags;
			private String topicnum;

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
		}
	}
}
