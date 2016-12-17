package com.hyzsnt.onekeyhelp.module.home.bean;

import java.io.Serializable;

/**
 * Created by hyzs on 2016/12/17.
 */

public class DynamicKinds implements Serializable{
    private String id;
    private String kind;

    public DynamicKinds() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "DynamicKinds{" +
                "id='" + id + '\'' +
                ", kind='" + kind + '\'' +
                '}';
    }
}
