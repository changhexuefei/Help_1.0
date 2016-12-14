package com.hyzsnt.onekeyhelp.http;

/**
 * Created by 14369 on 2016/12/9.
 */

public class Api {
	/**
	 * 接口基础地址
	 */
	public static final String BASE_URL = "http://192.168.1.123/mbapi.php";

	/**
	 * 接口验证key
	 */
	public static final String KEY = "1g2c4b4b8b5g5x0c7g2";
	/**
	 * 公共类字段
	 */
	public static final String PUBLIC = "public";
	/**
	 * 用户类字段
	 */
	public static final String USER = "user";
	/**
	 * 首页类字段
	 */
	public static final String COMMUNITY = "community";
	/**
	 * 闲逛类字段
	 */
	public static final String CIRCLE ="circle";

	/**
	 * 公共类
	 */
	public static final class Public {
		/**
		 * 测试接口
		 * a:test
		 * p:随意值或者随意值组
		 * return：
		 * {
		 * "res":"",	//结果0失败，1成功
		 * "restr":"",	//失败则返回文字信息
		 * "info":p值的明文,		//
		 * "list":		//p值可分割，返回分割后数组
		 * [
		 * {
		 * },
		 * ...
		 * }]
		 * }
		 */
		public static final String TEST = "test";
	}

	/**
	 * 用户类
	 */
	public static final class User {

	}

	/**
	 * 首页类
	 */
	public static final class Community {
		public static final String GETCOMMUNITYLIST = "getCommunityList";
	}

	public static final class Circle{
		/**
		 闲逛获取热门标签a
		 */
		public static final String CIRCLE_HOTTAG ="getRecomTags";
		/**
	 * 闲逛周边圈子列表
		 */
		public static final String CIRCLELIST ="getCircleList";
	}


}
