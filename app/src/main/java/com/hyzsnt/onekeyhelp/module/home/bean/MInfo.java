package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;

/**
 * Created by hyzs on 2016/12/15.
 */

public class MInfo implements Serializable {
    private CommunityListInfo communityListInfo;
    private CommunityInfoInfo communityInfoInfo;
    private UserInfoInfo userInfoInfo;
    public MInfo() {
    }

    public CommunityListInfo getCommunityListInfo() {
        return communityListInfo;
    }

    public void setCommunityListInfo(CommunityListInfo communityListInfo) {
        this.communityListInfo = communityListInfo;
    }

    public CommunityInfoInfo getCommunityInfoInfo() {
        return communityInfoInfo;
    }

    public void setCommunityInfoInfo(CommunityInfoInfo communityInfoInfo) {
        this.communityInfoInfo = communityInfoInfo;
    }

    public UserInfoInfo getUserInfoInfo() {
        return userInfoInfo;
    }

    public void setUserInfoInfo(UserInfoInfo userInfoInfo) {
        this.userInfoInfo = userInfoInfo;
    }

    @Override
    public String toString() {
        return "MInfo{" +
                "communityListInfo=" + communityListInfo +
                ", communityInfoInfo=" + communityInfoInfo +
                ", userInfoInfo=" + userInfoInfo +
                '}';
    }
}
