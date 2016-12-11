package com.hyzsnt.onekeyhelp.module.stroll.bean;

/**
 * Created by Administrator on 2016/12/11.
 */

public class CircleType {
	private String name;
	private int icon;
	private int backgroundcolor;

	public CircleType(String name, int icon, int backgroundcolor) {
		this.name = name;
		this.icon = icon;
		this.backgroundcolor = backgroundcolor;
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
