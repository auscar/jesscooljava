package com.riseful.jesscooljava.manager;

import com.riseful.jesscooljava.entity.Tag;

public interface TagManager {
	public int addTag(Tag tag);
	public Tag getTagById(int id);
	public int delTagById(int id);
	public int updateTag(Tag tag);
	public int getBiggestId();
}
