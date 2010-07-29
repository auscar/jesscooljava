package com.riseful.jesscooljava.entity;

public class Tag {
	int id;
	boolean isAtHome;
	String name;
	String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAtHome() {
		return isAtHome;
	}
	public boolean getIsAtHome(){
		return isAtHome;
	}
	public void setAtHome(boolean isAtHome) {
		this.isAtHome = isAtHome;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
