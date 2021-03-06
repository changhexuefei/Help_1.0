package com.hyzsnt.onekeyhelp.module.home.resovle;

import com.hyzsnt.onekeyhelp.module.home.bean.CommentListByTopic;
import com.hyzsnt.onekeyhelp.module.home.bean.HomeCircle;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityInfoInfo;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityInfoList;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityListInfo;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityListList;
import com.hyzsnt.onekeyhelp.module.home.bean.Coordinateres;
import com.hyzsnt.onekeyhelp.module.home.bean.DynamicKinds;
import com.hyzsnt.onekeyhelp.module.home.bean.DynamicListByCommunityList;
import com.hyzsnt.onekeyhelp.module.home.bean.HomeComment;
import com.hyzsnt.onekeyhelp.module.home.bean.LoginCircle;
import com.hyzsnt.onekeyhelp.module.home.bean.LoginCommunity;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.bean.MInfo;
import com.hyzsnt.onekeyhelp.module.home.bean.MList;
import com.hyzsnt.onekeyhelp.module.home.bean.MemberListByCommunityList;
import com.hyzsnt.onekeyhelp.module.home.bean.UserInfoInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

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
                    if(jsoncommunityListList.has("circle")){
                        ArrayList<HomeCircle> homeCircleList =new ArrayList<>();
                        JSONArray jsonCircleList=jsoncommunityListList.getJSONArray("circle");
                        for (int j = 0; j <jsonCircleList.length() ; j++) {
                            HomeCircle homeCircle =new HomeCircle();
                            JSONObject jsonCircleListJSONObject = jsonCircleList.getJSONObject(j);
                            if(jsonCircleListJSONObject.has("ccid")){
                                homeCircle.setCcid(jsonCircleListJSONObject.getString("ccid"));
                            }
                            if(jsonCircleListJSONObject.has("ccname")){
                                homeCircle.setCcname(jsonCircleListJSONObject.getString("ccname"));
                            }
                            if(jsonCircleListJSONObject.has("cccover")){
                                homeCircle.setCccover(jsonCircleListJSONObject.getString("cccover"));
                            }
                            if(jsonCircleListJSONObject.has("tags")){
                                homeCircle.setTags(jsonCircleListJSONObject.getString("tags"));
                            }
                            if(jsonCircleListJSONObject.has("curnum")){
                                homeCircle.setCurnum(jsonCircleListJSONObject.getString("curnum"));
                            }
                            if(jsonCircleListJSONObject.has("ifjoin")){
                                homeCircle.setIfjoin(jsonCircleListJSONObject.getString("ifjoin"));
                            }
                            if(jsonCircleListJSONObject.has("cmid")){
                                homeCircle.setCmid(jsonCircleListJSONObject.getString("cmid"));
                            }
                            homeCircleList.add(homeCircle);
                        }

                        communityListList.setHomeCircleList(homeCircleList);
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
    //加入小区
    public static ArrayList<MDate> getJoinCommunity(String str) {
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
        }catch (Exception e){

        }
        dates.add(mDate);
        return  dates;
    }
    //获取单个小区信息
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
    //获取小区成员列表
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
    //获取动态信息列表
    public static ArrayList<MDate> getDynamicListByCommunity(String str) {
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
            //获取list
            if(jsonDate.has("list")) {
                MList mList = new MList();
                ArrayList<DynamicListByCommunityList> dynamicListByCommunityLists = new ArrayList<>();
                JSONArray jsondynamicListByCommunityLists = jsonDate.getJSONArray("list");
                for (int i = 0; i < jsondynamicListByCommunityLists.length(); i++) {
                    JSONObject jsondynamicListByCommunityList = jsondynamicListByCommunityLists.getJSONObject(i);
                    DynamicListByCommunityList dynamicListByCommunityList=new DynamicListByCommunityList();
                    if (jsondynamicListByCommunityList.has("mid")) {
                        dynamicListByCommunityList.setMid(jsondynamicListByCommunityList.getString("mid"));
                    }
                    if (jsondynamicListByCommunityList.has("uid")) {
                        dynamicListByCommunityList.setUid(jsondynamicListByCommunityList.getString("uid"));
                    }
                    if (jsondynamicListByCommunityList.has("nickname")) {
                        dynamicListByCommunityList.setNickname(jsondynamicListByCommunityList.getString("nickname"));
                    }
                    if (jsondynamicListByCommunityList.has("headportraid")) {
                        dynamicListByCommunityList.setHeadportraid(jsondynamicListByCommunityList.getString("headportraid"));
                    }
                    if (jsondynamicListByCommunityList.has("cmid")) {
                        dynamicListByCommunityList.setCmid(jsondynamicListByCommunityList.getString("cmid"));
                    }
                    if (jsondynamicListByCommunityList.has("cmname")) {
                        dynamicListByCommunityList.setCmname(jsondynamicListByCommunityList.getString("cmname"));
                    }
                    if (jsondynamicListByCommunityList.has("mtype")) {
                        dynamicListByCommunityList.setMtype(jsondynamicListByCommunityList.getString("mtype"));
                    }
                    if (jsondynamicListByCommunityList.has("mtypename")) {
                        dynamicListByCommunityList.setMtypeName(jsondynamicListByCommunityList.getString("mtypename"));
                    }
                    if (jsondynamicListByCommunityList.has("objectid")) {
                        dynamicListByCommunityList.setObjectid(jsondynamicListByCommunityList.getString("objectid"));
                    }
                    if (jsondynamicListByCommunityList.has("posttime")) {
                        dynamicListByCommunityList.setPosttime(jsondynamicListByCommunityList.getString("posttime"));
                    }
                    if (jsondynamicListByCommunityList.has("lat")) {
                        dynamicListByCommunityList.setLat(jsondynamicListByCommunityList.getString("lat"));
                    }
                    if (jsondynamicListByCommunityList.has("lng")) {
                        dynamicListByCommunityList.setLng(jsondynamicListByCommunityList.getString("lng"));
                    }
                    if (jsondynamicListByCommunityList.has("distance")) {
                        dynamicListByCommunityList.setDistance(jsondynamicListByCommunityList.getString("distance"));
                    }
                    if (jsondynamicListByCommunityList.has("status")) {
                        dynamicListByCommunityList.setStatus(jsondynamicListByCommunityList.getString("status"));
                    }
                    if (jsondynamicListByCommunityList.has("goodnum")) {
                        dynamicListByCommunityList.setGoodnum(jsondynamicListByCommunityList.getString("goodnum"));
                    }
                    if (jsondynamicListByCommunityList.has("replynum")) {
                        dynamicListByCommunityList.setReplynum(jsondynamicListByCommunityList.getString("replynum"));
                    }
                    if (jsondynamicListByCommunityList.has("content")) {
                        dynamicListByCommunityList.setContent(jsondynamicListByCommunityList.getString("content"));
                    }
                    if (jsondynamicListByCommunityList.has("contenttype")) {
                        dynamicListByCommunityList.setContenttype(jsondynamicListByCommunityList.getString("contenttype"));
                    }
                    if (jsondynamicListByCommunityList.has("imgs")) {
                        ArrayList<String > imags=new ArrayList<>();
                        JSONArray jsondynamicListByCommunityListJSONArray = jsondynamicListByCommunityList.getJSONArray("imgs");
                        for (int j = 0; j <jsondynamicListByCommunityListJSONArray.length() ; j++) {
                            imags.add(jsondynamicListByCommunityListJSONArray.getString(j));
                        }
                        dynamicListByCommunityList.setImgs(imags);
                    }

                    if (jsondynamicListByCommunityList.has("comments")) {
                        ArrayList<HomeComment> homeComments=new ArrayList<>();
                        JSONArray jsonHomeComments = jsondynamicListByCommunityList.getJSONArray("comments");
                        for (int j = 0; j < jsonHomeComments.length(); j++) {
                            HomeComment homeComment=new HomeComment();
                            JSONObject jsonHomeComment = jsonHomeComments.getJSONObject(j);
                            if(jsonHomeComment.has("suid")){
                                homeComment.setSuid(jsonHomeComment.getString("suid"));
                            }
                            if(jsonHomeComment.has("sunickname")){
                                homeComment.setSunickname(jsonHomeComment.getString("sunickname"));
                            }
                            if(jsonHomeComment.has("sheadportraid")){
                                homeComment.setSheadportraid(jsonHomeComment.getString("sheadportraid"));
                            }
                            if(jsonHomeComment.has("ruid")){
                                homeComment.setRuid(jsonHomeComment.getString("ruid"));
                            }
                            if(jsonHomeComment.has("runickname")){
                                homeComment.setRunickname(jsonHomeComment.getString("runickname"));
                            }
                            if(jsonHomeComment.has("rheadportraid")){
                                homeComment.setRheadportraid(jsonHomeComment.getString("rheadportraid"));
                            }
                            if(jsonHomeComment.has("content")){
                                homeComment.setContent(jsonHomeComment.getString("content"));
                            }
                            if(jsonHomeComment.has("posttime")){
                                homeComment.setPosttime(jsonHomeComment.getString("posttime"));
                            }
                            homeComments.add(homeComment);
                        }

                        dynamicListByCommunityList.setHomeComments(homeComments);
                    }
                    dynamicListByCommunityLists.add(dynamicListByCommunityList);
                }
                mList.setDynamicListByCommunityLists(dynamicListByCommunityLists);
                mDate.setmList(mList);
            }
        }catch(Exception e){

        }
        dates.add(mDate);
        return dates;
    }
    //获取动态类别
    public static ArrayList<MDate> getDynamicKinds(String str) {
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
            if(jsonDate.has("list")) {
                MList mList = new MList();
                ArrayList<DynamicKinds> dynamicKindses=new ArrayList<>();
                JSONObject jsonDynamicKindses = jsonDate.getJSONObject("list");
                Iterator<String> iterator=jsonDynamicKindses.keys();
                while (iterator.hasNext()){
                    DynamicKinds dynamicKind=new DynamicKinds();
                    String jsonId = iterator.next();
                    dynamicKind.setId(jsonId);
                    String jsonKind = (String) jsonDynamicKindses.get(jsonId);
                    dynamicKind.setKind(jsonKind);
                    dynamicKindses.add(dynamicKind);
                }
                mList.setDynamicKindses(dynamicKindses);
                mDate.setmList(mList);
            }
        }catch (Exception e){

        }
        dates.add(mDate);
        return dates;
    }
    //获取用户信息
    public static ArrayList<MDate> getUserInfo(String str) {
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
                UserInfoInfo userInfoInfo = new UserInfoInfo();
                JSONObject jsonUserInfoInfo = jsonDate.getJSONObject("info");
                if (jsonUserInfoInfo.has("uid")) {
                    userInfoInfo.setUid(jsonUserInfoInfo.getString("uid"));
                }
                if (jsonUserInfoInfo.has("phoneno")) {
                    userInfoInfo.setPhoneno(jsonUserInfoInfo.getString("phoneno"));
                }
                if (jsonUserInfoInfo.has("nickname")) {
                    userInfoInfo.setNickname(jsonUserInfoInfo.getString("nickname"));
                }
                if (jsonUserInfoInfo.has("headportraid")) {
                    userInfoInfo.setHeadportraid(jsonUserInfoInfo.getString("headportraid"));
                }
                if (jsonUserInfoInfo.has("incommunity")) {
                    userInfoInfo.setIncommunity(jsonUserInfoInfo.getString("incommunity"));
                }
                if (jsonUserInfoInfo.has("incommunitynum")) {
                    userInfoInfo.setIncommunitynum(jsonUserInfoInfo.getString("incommunitynum"));
                }
                if (jsonUserInfoInfo.has("incirclenum")) {
                    userInfoInfo.setIncirclenum(jsonUserInfoInfo.getString("incirclenum"));
                }
                if (jsonUserInfoInfo.has("status")) {
                    userInfoInfo.setStatus(jsonUserInfoInfo.getString("status"));
                }
                if (jsonUserInfoInfo.has("gender")) {
                    userInfoInfo.setGender(jsonUserInfoInfo.getString("gender"));
                }
                if (jsonUserInfoInfo.has("hobbytags")) {
                    userInfoInfo.setHobbytags(jsonUserInfoInfo.getString("hobbytags"));
                }
                if (jsonUserInfoInfo.has("lastonline")) {
                    userInfoInfo.setLastonline(jsonUserInfoInfo.getString("lastonline"));
                }
                if (jsonUserInfoInfo.has("regtime")) {
                    userInfoInfo.setRegtime(jsonUserInfoInfo.getString("regtime"));
                }
                mInfo.setUserInfoInfo(userInfoInfo);
                mDate.setmInfo(mInfo);
            }
            //获取list
            if(jsonDate.has("list")) {
                MList mList = new MList();
                ArrayList<LoginCommunity> loginCommunities=new ArrayList<>();
                JSONObject jsonLoginCommunityList = jsonDate.getJSONObject("list");
                if(jsonLoginCommunityList.has("communities")){
                    JSONArray jsonCommunities = jsonLoginCommunityList.getJSONArray("communities");
                    for (int i = 0; i < jsonCommunities.length(); i++) {
                        JSONObject jsonoginCommunity= jsonCommunities.getJSONObject(i);
                        LoginCommunity loginCommunity=new LoginCommunity();
                        if(jsonoginCommunity.has("cmid")) {
                            loginCommunity.setCmid(jsonoginCommunity.getString("cmid"));
                        }
                        if(jsonoginCommunity.has("cmname")) {
                            loginCommunity.setCmname(jsonoginCommunity.getString("cmname"));
                        }
                        if(jsonoginCommunity.has("cmcover")) {
                            loginCommunity.setCmcover(jsonoginCommunity.getString("cmcover"));
                        }
                        if(jsonoginCommunity.has("curnum")) {
                            loginCommunity.setCurnum(jsonoginCommunity.getString("curnum"));
                        }
                        if(jsonoginCommunity.has("ifcur")) {
                            loginCommunity.setIfcur(jsonoginCommunity.getString("ifcur"));
                        }
                        loginCommunities.add(loginCommunity);
                    }
                }
                //已加入圈子解析
                ArrayList<LoginCircle> loginCircles=new ArrayList<>();
                if(jsonLoginCommunityList.has("circles")){
                    JSONArray jsonCommunities = jsonLoginCommunityList.getJSONArray("circles");
                    for (int i = 0; i < jsonCommunities.length(); i++) {
                        JSONObject jsonLoginCommunity= jsonCommunities.getJSONObject(i);
                        LoginCircle loginCircle=new LoginCircle();
                        if(jsonLoginCommunity.has("ccid")) {
                            loginCircle.setCcid(jsonLoginCommunity.getString("ccid"));
                        }
                        if(jsonLoginCommunity.has("ccname")) {
                            loginCircle.setCcname(jsonLoginCommunity.getString("ccname"));
                        }
                        if(jsonLoginCommunity.has("cccover")) {
                            loginCircle.setCccover(jsonLoginCommunity.getString("cccover"));
                        }
                        if(jsonLoginCommunity.has("curnum")) {
                            loginCircle.setCurnum(jsonLoginCommunity.getString("curnum"));
                        }
                        if(jsonLoginCommunity.has("cmid")) {
                            loginCircle.setCmid(jsonLoginCommunity.getString("cmid"));
                        }
                        loginCircles.add(loginCircle);
                    }
                }
                mList.setLoginCommunities(loginCommunities);
                mList.setLoginCircles(loginCircles);
                mDate.setmList(mList);
            }
        }catch (Exception e){
        }
        dates.add(mDate);
        return dates;
    }
    //回复列表
    public static ArrayList<MDate> getCommentListByTopic(String str) {
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
            //获取list
            if(jsonDate.has("list")) {
                MList mList = new MList();
                ArrayList<CommentListByTopic> commentListByTopics = new ArrayList<>();
                JSONArray jsonCommentListByTopics = jsonDate.getJSONArray("list");
                for (int i = 0; i < jsonCommentListByTopics.length(); i++) {
                    JSONObject jsonCommentListByTopic = jsonCommentListByTopics.getJSONObject(i);
                    CommentListByTopic commentListByTopic=new CommentListByTopic();

                    if(jsonCommentListByTopic.has("cid")){
                        commentListByTopic.setCid(jsonCommentListByTopic.getString("cid"));
                    }
                    if(jsonCommentListByTopic.has("tid")){
                        commentListByTopic.setTid(jsonCommentListByTopic.getString("tid"));
                    }if(jsonCommentListByTopic.has("uid")){
                        commentListByTopic.setUid(jsonCommentListByTopic.getString("uid"));
                    }if(jsonCommentListByTopic.has("nickname")){
                        commentListByTopic.setNickname(jsonCommentListByTopic.getString("nickname"));
                    }if(jsonCommentListByTopic.has("headportraid")){
                        commentListByTopic.setHeadportraid(jsonCommentListByTopic.getString("headportraid"));
                    }if(jsonCommentListByTopic.has("gender")){
                        commentListByTopic.setGender(jsonCommentListByTopic.getString("gender"));
                    }if(jsonCommentListByTopic.has("hobbytags")){
                        commentListByTopic.setHobbytags(jsonCommentListByTopic.getString("hobbytags"));
                    }if(jsonCommentListByTopic.has("lastonline")){
                        commentListByTopic.setLastonline(jsonCommentListByTopic.getString("lastonline"));
                    }if(jsonCommentListByTopic.has("regtime")){
                        commentListByTopic.setRegtime(jsonCommentListByTopic.getString("regtime"));
                    }if(jsonCommentListByTopic.has("posttime")){
                        commentListByTopic.setPosttime(jsonCommentListByTopic.getString("posttime"));
                    }if(jsonCommentListByTopic.has("lat")){
                        commentListByTopic.setLat(jsonCommentListByTopic.getString("lat"));
                    }if(jsonCommentListByTopic.has("lng")){
                        commentListByTopic.setLng(jsonCommentListByTopic.getString("lng"));
                    }if(jsonCommentListByTopic.has("status")){
                        commentListByTopic.setStatus(jsonCommentListByTopic.getString("status"));
                    }if(jsonCommentListByTopic.has("content")){
                        commentListByTopic.setContent(jsonCommentListByTopic.getString("content"));
                    }if(jsonCommentListByTopic.has("contenttype")){
                        commentListByTopic.setContenttype(jsonCommentListByTopic.getString("contenttype"));
                    }if(jsonCommentListByTopic.has("cmid")){
                        commentListByTopic.setCmid(jsonCommentListByTopic.getString("cmid"));
                    }if(jsonCommentListByTopic.has("cmname")){
                        commentListByTopic.setCmname(jsonCommentListByTopic.getString("cmname"));
                    }if(jsonCommentListByTopic.has("imgs")){
                        JSONArray jsonImags=jsonCommentListByTopic.getJSONArray("imgs");
                        ArrayList<String> imgs=new ArrayList<>();
                        for (int j = 0; j <jsonImags.length(); j++) {
                            String img = jsonImags.getString(j);
                            imgs.add(img);
                        }
                        commentListByTopic.setImgs(imgs);
                    }
                    commentListByTopics.add(commentListByTopic);
                }
                mList.setCommentListByTopics(commentListByTopics);
                mDate.setmList(mList);
            }
        }catch (Exception e){
        }
        dates.add(mDate);
        return dates;
    }
}