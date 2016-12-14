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
	public static final String CIRCLE = "circle";

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
		/**
		 * 用户注册
		 * a:register
		 * p:	phoneno	//手机号
		 * return：
		 * {
		 * "res":"",	//结果0失败，1成功
		 * "restr":"",	//失败则返回文字信息
		 * "info":"",	//
		 * "list":""	//
		 * }
		 */
		public static final String REGISTER = "register";
		/**
		 * 用户登录
		 * a:login
		 * p:	phoneno	//手机号
		 * return：
		 * {
		 * "res":"",	//结果0失败，1成功
		 * "restr":"",	//失败则返回文字信息
		 * "info":		//
		 * [{
		 * "uid":"",		//用户ID
		 * "phoneno":"",		//手机号
		 * "nickname":"",		//昵称
		 * "headportraid":"",	//头像链接
		 * "incommunity":"",	//当前小区
		 * "incommunitynum":"",	//加入小区数
		 * "incirclenum":"",	//加入圈子数
		 * "status":"",		//用户状态（待用）
		 * "gender":"",		//性别 0保密1男2女
		 * "hobbytags":"",		//喜好标签：多个用|分割
		 * "lastonline":"",	//最后在线时间
		 * "regtime":"",		//注册时间
		 * }]
		 * "list":		//
		 * [{
		 * "communities":	//该用户已加入小区列表
		 * [
		 * {
		 * "cmid":"",	//小区ID
		 * "cmname":"",	//小区名称
		 * "cmcover":"",	//小区封面图链接
		 * "curnum":"",	//成员人数
		 * "ifcur":""	//是否为当前小区 0否1是
		 * },
		 * ...
		 * ],
		 * "circles":	//该用户已加入圈子列表
		 * [
		 * {
		 * "ccid":"",	//圈子ID
		 * "ccname":"",	//圈子名称
		 * "cccover":"",	//圈子封面图链接
		 * "curnum":"",	//成员人数
		 * "cmid":"",	//归属小区ID
		 * },
		 * ...
		 * ],
		 * }]
		 * }
		 */
		public static final String LOGIN = "login";
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

	public static final class Circle {
		/**
		 * 闲逛获取热门标签a
		 */
		public static final String CIRCLE_HOTTAG = "getRecomTags";
	}


}
