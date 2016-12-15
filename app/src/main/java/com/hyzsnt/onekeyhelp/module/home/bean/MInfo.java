package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hyzs on 2016/12/15.
 */

public class MInfo implements Serializable {
    private CommunityListInfo communityListInfo;
    private CommunityInfoInfo communityInfoInfo;
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

    @Override
    public String toString() {
        return "MInfo{" +
                "communityListInfo=" + communityListInfo +
                ", communityInfoInfo=" + communityInfoInfo +
                '}';
    }
}
