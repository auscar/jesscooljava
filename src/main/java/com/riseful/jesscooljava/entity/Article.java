package com.riseful.jesscooljava.entity;

public class Article {
	private int id;
	private String title;
	private String content;
	private String intime;
	private String cover;
	private String tagName;
	private String firstImg;
	private Tag tag;
	
	
	public String getFirstImg() {
		return firstImg;
	}
	public void setFirstImg(String firstImg) {
		this.firstImg = firstImg;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tag) {
		this.tagName = tag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String time) {
		this.intime = time;
	}
	
}
