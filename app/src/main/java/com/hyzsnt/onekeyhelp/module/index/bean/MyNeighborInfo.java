package com.hyzsnt.onekeyhelp.module.index.bean;

/**
 * Created by gao on 2016/12/10.
 */

public class MyNeighborInfo {

    private String neighborIcon;
    private String neighborName;
    private String neighborSexIcon;
    private String neighborAge;

    public String getNeighborIcon() {
        return neighborIcon;
    }

    public void setNeighborIcon(String neighborIcon) {
        this.neighborIcon = neighborIcon;
    }

    public String getNeighborName() {
        return neighborName;
    }

    public void setNeighborName(String neighborName) {
        this.neighborName = neighborName;
    }

    public String getNeighborSexIcon() {
        return neighborSexIcon;
    }

    public void setNeighborSexIcon(String neighborSexIcon) {
        this.neighborSexIcon = neighborSexIcon;
    }

    public String getNeighborAge() {
        return neighborAge;
    }

    public void setNeighborAge(String neighborAge) {
        this.neighborAge = neighborAge;
    }

    public MyNeighborInfo() {

    }

    public MyNeighborInfo(String neighborIcon, String neighborName, String neighborSexIcon, String neighborAge) {

        this.neighborIcon = neighborIcon;
        this.neighborName = neighborName;
        this.neighborSexIcon = neighborSexIcon;
        this.neighborAge = neighborAge;
    }
}
