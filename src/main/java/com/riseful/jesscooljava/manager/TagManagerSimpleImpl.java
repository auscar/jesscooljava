package com.riseful.jesscooljava.manager;

import com.riseful.jesscooljava.dao.TagDao;
import com.riseful.jesscooljava.entity.Tag;

public class TagManagerSimpleImpl implements TagManager {
	private TagDao tagDao;
	
	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	public int addTag(Tag tag) {
		return tagDao.addTag(tag);
	}

	public int delTagById(int id) {
		return tagDao.delTagById(id);
	}

	public int getBiggestId() {
		return tagDao.getBiggestId();
	}

	public int updateTag(Tag tag) {
		return tagDao.updateTag(tag);
	}

	public Tag getTagById(int id) {
		return tagDao.getTagById(id);
	}

}
