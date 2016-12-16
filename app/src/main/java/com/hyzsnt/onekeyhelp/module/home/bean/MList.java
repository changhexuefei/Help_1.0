package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/15.
 */

public class MList implements Serializable{
    private ArrayList<CommunityListList> communityListLists;
    private ArrayList<CommunityInfoList> communityInfoLists;
    private ArrayList<MemberListByCommunityList> memberListByCommunityLists;
    private ArrayList<DynamicListByCommunityList> dynamicListByCommunityLists;
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

    public ArrayList<MemberListByCommunityList> getMemberListByCommunityLists() {
        return memberListByCommunityLists;
    }

    public void setMemberListByCommunityLists(ArrayList<MemberListByCommunityList> memberListByCommunityLists) {
        this.memberListByCommunityLists = memberListByCommunityLists;
    }

    public ArrayList<DynamicListByCommunityList> getDynamicListByCommunityLists() {
        return dynamicListByCommunityLists;
    }

    public void setDynamicListByCommunityLists(ArrayList<DynamicListByCommunityList> dynamicListByCommunityLists) {
        this.dynamicListByCommunityLists = dynamicListByCommunityLists;
    }

    @Override
    public String toString() {
        return "MList{" +
                "communityListLists=" + communityListLists +
                ", communityInfoLists=" + communityInfoLists +
                ", memberListByCommunityLists=" + memberListByCommunityLists +
                ", dynamicListByCommunityLists=" + dynamicListByCommunityLists +
                '}';
    }
}
