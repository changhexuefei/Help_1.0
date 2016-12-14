package com.hyzsnt.onekeyhelp.module.home.resovle;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hyzs on 2016/12/14.
 */

public class Resovle {
    //首页未加入圈子解析
    public static ArrayList<Date> getDate(String str){
        //ArrayList<Date> dates=new ArrayList<>();
       // MDate mDatedate=new MDate();

        try {
            JSONObject jsonDate=new JSONObject(str);
            String res="";
            if(jsonDate.has("res")){
                res=jsonDate.getString("res");
            }
           // date.set
            String restr="";
            if(jsonDate.has("restr")){
                res=jsonDate.getString("restr");
            }


        }catch (Exception e){

        }

        //dates.add(date);
        return null;
    }
}
