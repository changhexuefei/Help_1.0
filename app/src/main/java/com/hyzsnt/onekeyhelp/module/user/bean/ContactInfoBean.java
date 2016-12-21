package com.hyzsnt.onekeyhelp.module.user.bean;

/**
 * Created by 14369 on 2016/12/21.
 */

public class ContactInfoBean {

	private String name;
	private String phone;
	private String icon;


	public ContactInfoBean(String name, String phone, String icon) {
		this.name = name;
		this.phone = phone;
		this.icon = icon;
	}

	public ContactInfoBean() {
	}

	@Override
	public String toString() {
		return "ContactInfoBean{" +
				"name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", icon='" + icon + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
