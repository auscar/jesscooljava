package com.riseful.jesscooljava.entity;

public class ImgTag {
	int imgTagId;
	String imgTagName;
	String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getImgTagId() {
		return imgTagId;
	}
	public void setImgTagId(int imgTagId) {
		this.imgTagId = imgTagId;
	}
	public String getImgTagName() {
		return imgTagName;
	}
	public void setImgTagName(String imgTagName) {
		this.imgTagName = imgTagName;
	}
	
}
