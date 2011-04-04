package com.riseful.jesscooljava.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
	String name;
	String pwd;
	String userPhone;
	Boolean userGender;
	Integer userWeight;
	Integer userHeight;
	
	Set<String> groups = new HashSet<String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Boolean getUserGender() {
		return userGender;
	}
	public void setUserGender(Boolean userGender) {
		this.userGender = userGender;
	}
	public Integer getUserWeight() {
		return userWeight;
	}
	public void setUserWeight(Integer userWeight) {
		this.userWeight = userWeight;
	}
	public Integer getUserHeight() {
		return userHeight;
	}
	public void setUserHeight(Integer userHeight) {
		this.userHeight = userHeight;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Set<String> getGroups() {
		return groups;
	}
	public void setGroups(Set<String> groups) {
		this.groups = groups;
	}

}
