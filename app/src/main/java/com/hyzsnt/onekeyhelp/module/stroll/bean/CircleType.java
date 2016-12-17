package com.hyzsnt.onekeyhelp.module.stroll.bean;

/**
 * Created by Administrator on 2016/12/11.
 */

public class CircleType {
	private String name;
	private int icon;
	private int backgroundcolor;
	private Boolean isselect;

	public CircleType(String name, int icon, int backgroundcolor, Boolean isselect) {
		this.name = name;
		this.icon = icon;
		this.backgroundcolor = backgroundcolor;
		this.isselect = isselect;
	}

	public CircleType(String name, int icon, int backgroundcolor) {
		this.name = name;
		this.icon = icon;
		this.backgroundcolor = backgroundcolor;
	}

	public Boolean getIsselect() {
		return isselect;
	}

	public void setIsselect(Boolean isselect) {
		this.isselect = isselect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getBackgroundcolor() {
		return backgroundcolor;
	}

	public void setBackgroundcolor(int backgroundcolor) {
		this.backgroundcolor = backgroundcolor;
	}

}
