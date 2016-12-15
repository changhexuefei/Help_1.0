package com.hyzsnt.onekeyhelp.module.home.resovle;

import com.hyzsnt.onekeyhelp.module.home.bean.Circle;
import com.hyzsnt.onekeyhelp.module.home.bean.CommunityList;
import com.hyzsnt.onekeyhelp.module.home.bean.Coordinateres;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/14.
 */

public class Resovle {
    //首页未加入圈子解析
    public static ArrayList<MDate> getDate(String str){
        ArrayList<MDate> dates=new ArrayList<>();
        MDate mDate=new MDate();
        try {
            JSONObject jsonDate=new JSONObject(str);
            String res="";
            if(jsonDate.has("res")){
                res=jsonDate.getString("res");
            }
            mDate.setRes(res);

            String restr="";
            if(jsonDate.has("restr")){
                restr=jsonDate.getString("restr");
            }
            mDate.setRestr(restr);

            Info info=null;
            Coordinateres coordinateres=null;
            if(jsonDate.has("info")){
                JSONObject jsonInfo=jsonDate.getJSONObject("info");
                info=new Info();
                if (jsonInfo.has("curnum")){
                    info.setCurnum(jsonInfo.getString("curnum"));
                }
                if (jsonInfo.has("curpage")){
                    info.setCurnum(jsonInfo.getString("curpage"));
                }
                if (jsonInfo.has("perpage")){
                    info.setCurnum(jsonInfo.getString("perpage"));
                }
                if (jsonInfo.has("totalnum")){
                    info.setCurnum(jsonInfo.getString("totalnum"));
                }
                if (jsonInfo.has("totalpage")){
                    info.setCurnum(jsonInfo.getString("totalpage"));
                }
                if (jsonInfo.has("coordinateres")){
                    coordinateres=new Coordinateres();
                    JSONObject jsoncoordinateres= jsonInfo.getJSONObject("coordinateres");

                    if (jsoncoordinateres.has("position")){
                        coordinateres.setPosition(jsoncoordinateres.getString("position"));
                    }
                    if (jsoncoordinateres.has("regid")){
                        coordinateres.setRegid(jsoncoordinateres.getString("regid"));
                    }
                    if (jsoncoordinateres.has("regname")){
                        coordinateres.setRegname(jsoncoordinateres.getString("regname"));
                    }
                    info.setCoordinateres(coordinateres);
                }
            }
            mDate.setInfo(info);
            //获取小区列表
            if (jsonDate.has("list")){
                ArrayList<CommunityList> communityLists=new ArrayList<>();
                JSONArray list = jsonDate.getJSONArray("list");
                for (int i = 0; i <list.length() ; i++) {
                    CommunityList communityList=new CommunityList();
                    JSONObject jsonCommunityList=list.getJSONObject(i);
                    if(jsonCommunityList.has("cmid")){
                        communityList.setCmid(jsonCommunityList.getString("cmid"));
                    }
                    if(jsonCommunityList.has("cmname")){
                        communityList.setCmname(jsonCommunityList.getString("cmname"));
                    }
                    if(jsonCommunityList.has("cmcover")){
                        communityList.setCmcover(jsonCommunityList.getString("cmcover"));
                    }
                    if(jsonCommunityList.has("curnum")){
                        communityList.setCurnum(jsonCommunityList.getString("curnum"));
                    }
                    if(jsonCommunityList.has("ifjoin")){
                        communityList.setIfjoin(jsonCommunityList.getString("ifjoin"));
                    }
                    if(jsonCommunityList.has("ifcur")){
                        communityList.setIfcur(jsonCommunityList.getString("ifcur"));
                    }
                    if(jsonCommunityList.has("lat")){
                        communityList.setLat(jsonCommunityList.getString("lat"));
                    }
                    if(jsonCommunityList.has("lng")){
                        communityList.setLng(jsonCommunityList.getString("lng"));
                    }
                    if(jsonCommunityList.has("distance")){
                        communityList.setDistance(jsonCommunityList.getString("distance"));
                    }
                    if(jsonCommunityList.has("circle")){
                        ArrayList<Circle> circleList=new ArrayList<>();
                        JSONArray jsonCircleList=jsonCommunityList.getJSONArray("circle");
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
                        communityList.setCircleList(circleList);
                    }
                    communityLists.add(communityList);
                }
                mDate.setCommunityList(communityLists);
            }

        }catch (Exception e){
        }

        dates.add(mDate);
        return dates;
    }
}
