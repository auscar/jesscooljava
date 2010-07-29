package com.riseful.jesscooljava.dao;

import junit.framework.TestCase;

import com.riseful.jesscooljava.base.Util;
import com.riseful.jesscooljava.entity.User;

public class TestUserDao extends TestCase {
	private UserDao userDao;
	
	public void setUp(){
		this.userDao = (UserDao)Util.getCtx().getBean("userDao");
	}
	
	public void testGetUserByName(){
		
		User user = userDao.getUserByName("auscar");
		assertNotNull(user);
		assertNotNull(user.getName());
		assertNotNull(user.getPwd());
		
		User user_none = userDao.getUserByName("auscar_none");
		assertNull(user_none);

	}
	
	
}
