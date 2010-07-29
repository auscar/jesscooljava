package com.riseful.jesscooljava.dao;

import com.riseful.jesscooljava.entity.Tag;

public interface TagDao {
	public Tag getTagById(int id);
	public int addTag(Tag tag);
	public int delTagById(int id);
	public int updateTag(Tag tag);
	public int getBiggestId();
}
