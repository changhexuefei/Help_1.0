package com.hyzsnt.onekeyhelp.module.home.resovle;
import com.hyzsnt.onekeyhelp.module.home.bean.Circle;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityInfoInfo;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityInfoList;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityListInfo;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityListList;
import com.hyzsnt.onekeyhelp.module.home.bean.Coordinateres;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.bean.MInfo;
import com.hyzsnt.onekeyhelp.module.home.bean.MList;
import com.hyzsnt.onekeyhelp.module.home.bean.MemberListByCommunityList;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/14.
 */

public class Resovle {
    //首页未加入小区解析
    public static ArrayList<MDate> getCommunityList(String str) {
        ArrayList<MDate> dates = new ArrayList<>();
        MDate mDate = new MDate();
        try{
            JSONObject jsonDate=new JSONObject(str);
            if(jsonDate.has("res")){
                String res=jsonDate.getString("res");
                mDate.setRes(res);
            }
            if(jsonDate.has("restr")){
                String  restr=jsonDate.getString("restr");
                mDate.setRestr(restr);
            }
            //获取info
            if(jsonDate.has("info")) {
                MInfo mInfo = new MInfo();
                CommunityListInfo communityListInfo = new CommunityListInfo();
                    JSONObject jsonCommunityListInfo = jsonDate.getJSONObject("info");
                    if (jsonCommunityListInfo.has("curnum")) {
                        communityListInfo.setCurnum(jsonCommunityListInfo.getString("curnum"));
                    }
                    if (jsonCommunityListInfo.has("curpage")) {
                        communityListInfo.setCurnum(jsonCommunityListInfo.getString("curpage"));
                    }
                    if (jsonCommunityListInfo.has("perpage")) {
                        communityListInfo.setCurnum(jsonCommunityListInfo.getString("perpage"));
                    }
                    if (jsonCommunityListInfo.has("totalnum")) {
                        communityListInfo.setCurnum(jsonCommunityListInfo.getString("totalnum"));
                    }
                    if (jsonCommunityListInfo.has("totalpage")) {
                        communityListInfo.setCurnum(jsonCommunityListInfo.getString("totalpage"));
                    }
                    if (jsonCommunityListInfo.has("coordinateres")) {
                        Coordinateres coordinateres = new Coordinateres();
                        JSONObject jsoncoordinateres = jsonCommunityListInfo.getJSONObject("coordinateres");

                        if (jsoncoordinateres.has("position")) {
                            coordinateres.setPosition(jsoncoordinateres.getString("position"));
                        }
                        if (jsoncoordinateres.has("regid")) {
                            coordinateres.setRegid(jsoncoordinateres.getString("regid"));
                        }
                        if (jsoncoordinateres.has("regname")) {
                            coordinateres.setRegname(jsoncoordinateres.getString("regname"));
                        }
                        communityListInfo.setCoordinateres(coordinateres);
                    }
                mInfo.setCommunityListInfo(communityListInfo);
                mDate.setmInfo(mInfo);
            }
            //获取list
            if(jsonDate.has("list")){
                MList mList=new MList();
                ArrayList<CommunityListList> communityListLists=new ArrayList<>();
                JSONArray jsoncommunityListLists=jsonDate.getJSONArray("list");
                for (int i = 0; i < jsoncommunityListLists.length(); i++) {
                    JSONObject jsoncommunityListList=jsoncommunityListLists.getJSONObject(i);
                    CommunityListList communityListList=new CommunityListList();
                    if(jsoncommunityListList.has("cmid")){
                        communityListList.setCmid(jsoncommunityListList.getString("cmid"));
                    }
                    if(jsoncommunityListList.has("cmname")){
                        communityListList.setCmname(jsoncommunityListList.getString("cmname"));
                    }
                    if(jsoncommunityListList.has("cmcover")){
                        communityListList.setCmcover(jsoncommunityListList.getString("cmcover"));
                    }
                    if(jsoncommunityListList.has("curnum")){
                        communityListList.setCurnum(jsoncommunityListList.getString("curnum"));
                    }
                    if(jsoncommunityListList.has("ifjoin")){
                        communityListList.setIfjoin(jsoncommunityListList.getString("ifjoin"));
                    }
                    if(jsoncommunityListList.has("ifcur")){
                        communityListList.setIfcur(jsoncommunityListList.getString("ifcur"));
                    }
                    if(jsoncommunityListList.has("lat")){
                        communityListList.setLat(jsoncommunityListList.getString("lat"));
                    }
                    if(jsoncommunityListList.has("lng")){
                        communityListList.setLng(jsoncommunityListList.getString("lng"));
                    }
                    if(jsoncommunityListList.has("distance")){
                        communityListList.setDistance(jsoncommunityListList.getString("distance"));
                    }
                    if(jsoncommunityListList.has("circle  111111111")){
                        ArrayList<Circle> circleList=new ArrayList<>();
                        JSONArray jsonCircleList=jsoncommunityListList.getJSONArray("circle");
                        for (int j = 0; j <jsonCircleList.length() ; j++) {
                            Circle circle=new Circle();
                            JSONObject jsonCircleListJSONObject = jsonCircleList.getJSONObject(j);
                            if(jsonCircleListJSONObject.has("ccid")){
                                circle.setCcid(jsonCircleListJSONObject.getString("ccid"));
                            }
                            if(jsonCircleListJSONObject.has("ccname")){
                                circle.setCcname(jsonCircleListJSONObject.getString("ccname"));
                            }
                            if(jsonCircleListJSONObject.has("cccover")){
                                circle.setCccover(jsonCircleListJSONObject.getString("cccover"));
                            }
                            if(jsonCircleListJSONObject.has("tags")){
                                circle.setTags(jsonCircleListJSONObject.getString("tags"));
                            }
                            if(jsonCircleListJSONObject.has("curnum")){
                                circle.setCurnum(jsonCircleListJSONObject.getString("curnum"));
                            }
                            if(jsonCircleListJSONObject.has("ifjoin")){
                                circle.setIfjoin(jsonCircleListJSONObject.getString("ifjoin"));
                            }
                            if(jsonCircleListJSONObject.has("cmid")){
                                circle.setCmid(jsonCircleListJSONObject.getString("cmid"));
                            }

                        }

                        communityListList.setCircleList(circleList);
                    }
                    communityListLists.add(communityListList);
                }
                mList.setCommunityListLists(communityListLists);
                mDate.setmList(mList);
            }

        }catch (Exception e){

        }
        dates.add(mDate);
        return dates;
    }
    public static ArrayList<MDate> getCommunityInfo(String str) {
        ArrayList<MDate> dates = new ArrayList<>();
        MDate mDate = new MDate();
        try{
            JSONObject jsonDate=new JSONObject(str);
            if(jsonDate.has("res")){
                String res=jsonDate.getString("res");
                mDate.setRes(res);
            }
            if(jsonDate.has("restr")){
                String  restr=jsonDate.getString("restr");
                mDate.setRestr(restr);
            }
            //获取info
            if(jsonDate.has("info")) {
                MInfo mInfo = new MInfo();
                CommunityInfoInfo communityInfoInfo = new CommunityInfoInfo();
                JSONObject jsonCommunityInfoInfo = jsonDate.getJSONObject("info");
                if (jsonCommunityInfoInfo.has("cmid")) {
                    communityInfoInfo.setCmid(jsonCommunityInfoInfo.getString("cmid"));
                }
                if (jsonCommunityInfoInfo.has("cmname")) {
                    communityInfoInfo.setCmname(jsonCommunityInfoInfo.getString("cmname"));
                }
                if (jsonCommunityInfoInfo.has("cmcover")) {
                    communityInfoInfo.setCmcover(jsonCommunityInfoInfo.getString("cmcover"));
                }
                if (jsonCommunityInfoInfo.has("curnum")) {
                    communityInfoInfo.setCurnum(jsonCommunityInfoInfo.getString("curnum"));
                }
                if (jsonCommunityInfoInfo.has("ifjoin")) {
                    communityInfoInfo.setIfjoin(jsonCommunityInfoInfo.getString("ifjoin"));
                }
                if (jsonCommunityInfoInfo.has("lat")) {
                    communityInfoInfo.setLat(jsonCommunityInfoInfo.getString("lat"));
                }
                if (jsonCommunityInfoInfo.has("lng")) {
                    communityInfoInfo.setLng(jsonCommunityInfoInfo.getString("lng"));
                }
                if (jsonCommunityInfoInfo.has("distance")) {
                    communityInfoInfo.setDistance(jsonCommunityInfoInfo.getString("distance"));
                }
                if (jsonCommunityInfoInfo.has("summary")) {
                    communityInfoInfo.setSummary(jsonCommunityInfoInfo.getString("summary"));
                }

                mInfo.setCommunityInfoInfo(communityInfoInfo);
                mDate.setmInfo(mInfo);
            }
            //获取list
            if(jsonDate.has("list")){
                MList mList=new MList();
                ArrayList<CommunityInfoList> communityInfoLists=new ArrayList<>();
                JSONArray jsoncommunityInfoLists=jsonDate.getJSONArray("list");
                for (int i = 0; i < jsoncommunityInfoLists.length(); i++) {
                    JSONObject jsoncommunityInfoList=jsoncommunityInfoLists.getJSONObject(i);
                    CommunityInfoList communityInfoList=new CommunityInfoList();
                    if(jsoncommunityInfoList.has("kind")){
                        communityInfoList.setKind(jsoncommunityInfoList.getString("kind"));
                    }
                    if(jsoncommunityInfoList.has("id")){
                        communityInfoList.setId(jsoncommunityInfoList.getString("id"));
                    }
                    if(jsoncommunityInfoList.has("name")){
                        communityInfoList.setName(jsoncommunityInfoList.getString("name"));
                    }
                    if(jsoncommunityInfoList.has("address")){
                        communityInfoList.setAddress(jsoncommunityInfoList.getString("address"));
                    }
                    if(jsoncommunityInfoList.has("telno")){
                        communityInfoList.setTelno(jsoncommunityInfoList.getString("telno"));
                    }
                    if(jsoncommunityInfoList.has("lat")){
                        communityInfoList.setLat(jsoncommunityInfoList.getString("lat"));
                    }
                    if(jsoncommunityInfoList.has("lng")){
                        communityInfoList.setLng(jsoncommunityInfoList.getString("lng"));
                    }
                    if(jsoncommunityInfoList.has("distance")){
                        communityInfoList.setDistance(jsoncommunityInfoList.getString("distance"));
                    }
                    if(jsoncommunityInfoList.has("summary")){
                        communityInfoList.setSummary(jsoncommunityInfoList.getString("summary"));
                    }
                    communityInfoLists.add(communityInfoList);
                }
                mList.setCommunityInfoLists(communityInfoLists);
                mDate.setmList(mList);
            }

        }catch (Exception e){

        }
        dates.add(mDate);
        return dates;
    }
    public static ArrayList<MDate> getMemberListByCommunity(String str) {
        ArrayList<MDate> dates = new ArrayList<>();
        MDate mDate = new MDate();
        try {
            JSONObject jsonDate=new JSONObject(str);
            if(jsonDate.has("res")){
                String res=jsonDate.getString("res");
                mDate.setRes(res);
            }
            if(jsonDate.has("restr")){
                String  restr=jsonDate.getString("restr");
                mDate.setRestr(restr);
            }
            //获取info
            //数据结构基本和CommunityListInfo一样，所以用的是CommunityListInfo
            if(jsonDate.has("info")) {
                MInfo mInfo = new MInfo();
                CommunityListInfo communityListInfo = new CommunityListInfo();
                JSONObject jsonCommunityListInfo = jsonDate.getJSONObject("info");
                if (jsonCommunityListInfo.has("curnum")) {
                    communityListInfo.setCurnum(jsonCommunityListInfo.getString("curnum"));
                }
                if (jsonCommunityListInfo.has("curpage")) {
                    communityListInfo.setCurpage(jsonCommunityListInfo.getString("curpage"));
                }
                if (jsonCommunityListInfo.has("perpage")) {
                    communityListInfo.setPerpage(jsonCommunityListInfo.getString("perpage"));
                }
                if (jsonCommunityListInfo.has("totalnum")) {
                    communityListInfo.setTotalnum(jsonCommunityListInfo.getString("totalnum"));
                }
                if (jsonCommunityListInfo.has("totalpage")) {
                    communityListInfo.setTotalpage(jsonCommunityListInfo.getString("totalpage"));
                }
                mInfo.setCommunityListInfo(communityListInfo);
                mDate.setmInfo(mInfo);
            }
            /**
             * "uid":"",		//用户ID
             "phoneno":"",		//手机号
             "nickname":"",		//昵称
             "headportraid":"",	//头像链接
             "status":"",		//用户状态（待用）
             "gender":"",		//性别 0保密1男2女
             "hobbytags":"",		//喜好标签：多个用|分割
             "lastonline":"",	//最后在线时间
             "regtime":"",		//注册时间
             */
            //获取list
            if(jsonDate.has("list")) {
                MList mList = new MList();
                ArrayList<MemberListByCommunityList> memberListByCommunityLists = new ArrayList<>();
                JSONArray jsonmemberListByCommunityLists = jsonDate.getJSONArray("list");
                for (int i = 0; i < jsonmemberListByCommunityLists.length(); i++) {
                    JSONObject jsonmemberListByCommunityList = jsonmemberListByCommunityLists.getJSONObject(i);
                    MemberListByCommunityList memberListByCommunityList=new MemberListByCommunityList();
                    if (jsonmemberListByCommunityList.has("uid")) {
                        memberListByCommunityList.setUid(jsonmemberListByCommunityList.getString("uid"));
                    }
                    if (jsonmemberListByCommunityList.has("phoneno")) {
                        memberListByCommunityList.setPhoneno(jsonmemberListByCommunityList.getString("phoneno"));
                    }
                    if (jsonmemberListByCommunityList.has("nickname")) {
                        memberListByCommunityList.setNickname(jsonmemberListByCommunityList.getString("nickname"));
                    }
                    if (jsonmemberListByCommunityList.has("headportraid")) {
                        memberListByCommunityList.setHeadportraid(jsonmemberListByCommunityList.getString("headportraid"));
                    }
                    if (jsonmemberListByCommunityList.has("status")) {
                        memberListByCommunityList.setStatus(jsonmemberListByCommunityList.getString("status"));
                    }
                    if (jsonmemberListByCommunityList.has("gender")) {
                        memberListByCommunityList.setGender(jsonmemberListByCommunityList.getString("gender"));
                    }
                    if (jsonmemberListByCommunityList.has("hobbytags")) {
                        memberListByCommunityList.setHobbytags(jsonmemberListByCommunityList.getString("hobbytags"));
                    }
                    if (jsonmemberListByCommunityList.has("lastonline")) {
                        memberListByCommunityList.setLastonline(jsonmemberListByCommunityList.getString("lastonline"));
                    }
                    if (jsonmemberListByCommunityList.has("regtime")) {
                        memberListByCommunityList.setRegtime(jsonmemberListByCommunityList.getString("regtime"));
                    }
                    memberListByCommunityLists.add(memberListByCommunityList);
                }
                mList.setMemberListByCommunityLists(memberListByCommunityLists);
                mDate.setmList(mList);
            }
        }catch(Exception e){

        }



        dates.add(mDate);
        return dates;
    }

}