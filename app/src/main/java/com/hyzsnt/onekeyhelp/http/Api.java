package com.hyzsnt.onekeyhelp.http;

/**
 * Created by 14369 on 2016/12/9.
 */

public class Api {
	/**
	 * 接口基础地址
	 */
	public static final String BASE_URL = "http://192.168.1.188/mbapi.php";

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
	 * 发布类字段
	 */
	public static final String PUBLISH = "publish";


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
		/**
		 * 获取动态类别
		 */
		public static final String GETDYNAMICKINDS = "getDynamicKinds";
		/**
		 * 获取圈子标签
		 */
		public static final String GETCIRCLETAGS = "getCircleTags";
		/**
		 * 上报用户位置
		 * a:submitCoordinate
		 * p:	用户ID
		 * 纬度
		 * 经度
		 * 百度地图翻译地址
		 * 设备绑定号
		 * return：
		 * {
		 * "res":"",	//结果0失败，1成功
		 * "restr":"",	//失败则返回文字信息
		 * "info":		//
		 * {
		 * "position"=>位置描述,
		 * "regid"=>行政区域ID,
		 * "regname"=>行政区域名称
		 * },
		 * "list":""	//
		 * }
		 */
		public static final String SUBMITCOORDINATE = "submitCoordinate";
	}

	/**
	 * 用户类
	 */
	public static final class User {
		//切换小区操作
		public static final String SWITCHCOMMUNITY = "switchCommunity";
		//获取用户信息
		public static final String GETUSERINFO = "getUserInfo";
		//joinCommunity
		public static final String JOINCOMMUNITY = "joinCommunity";


		/**
		 * 添加紧急联系人
		 * a:addEmergLinker
		 * p:	用户ID
		 * 紧急联系人手机号
		 * return：
		 * {
		 * "res":"",	//结果0失败，1成功
		 * "restr":"",	//失败则返回文字信息
		 * "info":"",		//
		 * "list":"",		//
		 * }
		 */
		public static final String ADDEMERGLINKER = "addEmergLinker";
		/**
		 * 解除紧急联系人关系
		 * a:delEmergLinker
		 * p:	用户ID
		 * 关系ID
		 * return：
		 * {
		 * "res":"",	//结果0失败，1成功
		 * "restr":"",	//失败则返回文字信息
		 * "info":"",		//
		 * "list":"",		//
		 * }
		 */
		public static final String DELEMERGLINKER = "delEmergLinker";
		/**
		 * 获取紧急联系人列表
		 * a:getEnergLinkerList
		 * p:	用户ID
		 * return：
		 * {
		 * "res":"",	//结果0失败，1成功
		 * "restr":"",	//失败则返回文字信息
		 * "info":"",		//
		 * "list":		//
		 * [
		 * {
		 * "emlid":"",		//关系ID
		 * "uid":"",		//用户ID
		 * "linkerphoneno":"",	//联系人电话
		 * "linkeruid":"",		//联系人ID	联系人为非平台用户此值为0
		 * "nickname":"",		//联系人昵称	联系人为非平台用户此值为null
		 * "headportraid":"",	//联系人头像	联系人为非平台用户此值为null
		 * }
		 * ......
		 * ]
		 * }
		 */
		public static final String GETENERGLINKERLIST = "getEnergLinkerList";
	}

	/**
	 * 首页类
	 */
	public static final class Community {
		/**
		 * 1、获取小区列表				a:getCommunityList
		 * 2、获取单个小区信息			a:getCommunityInfo
		 * 3、获取单个小区下圈子列表		a:getCircleListByCommunity
		 * 4、获取小区成员列表			a:getMemberListByCommunity
		 * 5、获取动态信息列表			a:getDynamicListByCommunity
		 * 6、删除动态				a:deleteDynamic
		 * 7、动态点赞				a:giveGoodToDynamic			?
		 * 8、发布动态回复				a:publishDynamicReply			?
		 * 9、删除动态回复				a:publishDynamicReply			?
		 */
		public static final String GETCOMMUNITYLIST = "getCommunityList";
		public static final String GETCOMMUNITYINFO = "getCommunityInfo";
		public static final String GETCIRCLELISTBYCOMMUNITY = "getCircleListByCommunity";
		public static final String GETMEMBERLISTBYCOMMUNITY = "getMemberListByCommunity";
		public static final String GETDYNAMICLISTBYCOMMUNITY = "getDynamicListByCommunity";
	}

	public static final class Circle {
		/**
		 * 闲逛获取热门标签a
		 */
		public static final String CIRCLE_HOTTAG = "getRecomTags";
		/**
		 * 闲逛周边圈子列表
		 */
		public static final String ROUNDLIST = "getCircleList";
		/**
		 * 闲逛我的列表
		 */
		public static final String MELIST = "getCircleListByUser";
		/**
		 * 闲逛圈子详情
		 */
		public static final String CIRCLE_DETAILS = "getCircleInfo";
		/**
		 * 闲逛成员列表
		 */
		public static final String CIRCLE_MEMBER = "getMemberListCircle";
		/**
		 * 闲逛加入申请列表
		 */
		public static final String CIRCLE_join = "getJoinApplyList";
		/**
		 * 闲逛创建圈子
		 */
		public static final String CREATE_CIRCLE = "createCircle";
		/**
		 * 闲逛申请加入圈子
		 */
		public static final String APPLYJOINCIRCLE = "applyJoinCircle";
		/**
		 * 闲逛加入圈子申请处理
		 */
		public static final String DOWITHJOINAPPLY = "dowithJoinApply";
		/**
		 * 发布话题回复
		 */
		public static final String PUBLISHTOPICREPLY = "publishTopicReply";
		/**
		 * 获取话题回复列表
		 */
		public static final String GETCOMMENTLISTBYTOPIC = "getCommentListByTopic";
		/**
		 * 获取话题详情
		 */
		public static final String GETTOPICINFO = "getTopicInfo";
	}


}
