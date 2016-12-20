package com.hyzsnt.onekeyhelp.module.index.bean;

import java.io.Serializable;

/**
 * Created by gao on 2016/12/19.
 */

public class ProvinceHasCityInfo implements Serializable {
    private String cName;
    private String cID;

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }




}
