package com.riseful.jesscooljava.entity;

import java.util.HashSet;
import java.util.Set;

public class Img {
	String tagName;
	String imgName;
	String userId;
	String imgUrl;
	int tagId;
	int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	Set<String> groups = new HashSet<String>();
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getImgName(){
		return imgName;
	}
	public void setImgName(String imgName){
		this.imgName = imgName;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}
	public int getTagId(){
		return tagId;
	}
	public void setTagId(int tagId){
		this.tagId = tagId;
	}
	
}
