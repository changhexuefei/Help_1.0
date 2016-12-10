package com.hyzsnt.onekeyhelp.module.index.bean;

/**
 * Created by gao on 2016/12/10.
 */

public class MyNeighborInfo {


    private int neighborIcon;
    private String neighborName;
    private int neighborSexIcon;
    private String neighborAge;

    public MyNeighborInfo(int neighborIcon, String neighborName, int neighborSexIcon, String neighborAge) {
        this.neighborIcon = neighborIcon;
        this.neighborName = neighborName;
        this.neighborSexIcon = neighborSexIcon;
        this.neighborAge = neighborAge;
    }

    public MyNeighborInfo() {
    }

    public String getNeighborName() {

        return neighborName;
    }

    public void setNeighborName(String neighborName) {
        this.neighborName = neighborName;
    }

    public int getNeighborSexIcon() {
        return neighborSexIcon;
    }

    public void setNeighborSexIcon(int neighborSexIcon) {
        this.neighborSexIcon = neighborSexIcon;
    }

    public String getNeighborAge() {
        return neighborAge;
    }

    public void setNeighborAge(String neighborAge) {
        this.neighborAge = neighborAge;
    }

    public int getNeighborIcon() {

        return neighborIcon;
    }

    public void setNeighborIcon(int neighborIcon) {
        this.neighborIcon = neighborIcon;
    }
}
