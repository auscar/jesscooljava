package com.riseful.jesscooljava.dao;

import junit.framework.TestCase;

import com.riseful.jesscooljava.base.Util;
import com.riseful.jesscooljava.entity.Tag;

public class TestTagDao extends TestCase {
	private TagDao tagDao;
	public void setUp(){
		tagDao = (TagDao)Util.getCtx().getBean("tagDao");
	}
	public void testAddTag(){
		Tag tag = new Tag();
		tag.setName("测试标题2");
		tag.setAtHome(true);
		tag.setDescription("就是测试标题，就是就是");
		
		int ret = tagDao.addTag(tag);
		assertTrue(ret>0);
		
		
	}
	public void testGetTagByid(){
		Tag ret = tagDao.getTagById(tagDao.getBiggestId());
		assertTrue(ret != null);
		assertTrue(ret.getName()!=null);
	}
	public void testUpdateTag(){
		Tag tag = new Tag();
		tag.setId(tagDao.getBiggestId());
		tag.setName("测试修改后的名字");
		tag.setDescription("测试修改后的description");
		int ret = tagDao.updateTag(tag);
		assertTrue(ret>0);
	}
	public void testGetBiggestId(){
		int ret = tagDao.getBiggestId();
		assertTrue(ret>0);
	}
	public void testDelTagById(){
		int ret = tagDao.delTagById(tagDao.getBiggestId());
		assertTrue(ret>0);
	}
}
