package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/14.
 */

public class Date implements Serializable {
    private String res;//结果0失败，1成功
    private String restr;//失败则返回文字信息
    private Info info;//请求信息及用户信息
    private ArrayList<CommunityList> communityList;//小区集合

}