package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/15.
 */

public class MList implements Serializable{
    private ArrayList<CommunityListList> communityListLists;
    private ArrayList<CommunityInfoList> communityInfoLists;
    public MList() {
    }

    public ArrayList<CommunityListList> getCommunityListLists() {
        return communityListLists;
    }

    public void setCommunityListLists(ArrayList<CommunityListList> communityListLists) {
        this.communityListLists = communityListLists;
    }

    public ArrayList<CommunityInfoList> getCommunityInfoLists() {
        return communityInfoLists;
    }

    public void setCommunityInfoLists(ArrayList<CommunityInfoList> communityInfoLists) {
        this.communityInfoLists = communityInfoLists;
    }

    @Override
    public String toString() {
        return "MList{" +
                "communityListLists=" + communityListLists +
                ", communityInfoLists=" + communityInfoLists +
                '}';
    }
}
