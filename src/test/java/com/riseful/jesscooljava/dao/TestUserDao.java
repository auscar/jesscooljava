package com.riseful.jesscooljava.dao;

import junit.framework.TestCase;

import com.riseful.jesscooljava.base.Util;
import com.riseful.jesscooljava.entity.User;
import com.riseful.jesscooljava.entity.UserCookie;

public class TestUserDao extends TestCase {
	private UserDao userDao;
	
	public void setUp(){
		this.userDao = (UserDao)Util.getCtx().getBean("userDao");
	}
	
	public void testGetUserByName(){
		//despair2@126.com 在使用线上数据库时是存在的
		User user = userDao.getUserByName("despair2@126.com");
		assertNotNull(user);
		assertNotNull(user.getName());
		assertNotNull(user.getPwd());
		
		User user_none = userDao.getUserByName("auscar_none");
		assertNull(user_none);

	}
	
	public void testAddUser(){
		User user = new User();
		user.setName("林惠强"+Math.random());
		user.setPwd("123456");
		user.setUserGender(false);
		user.setUserHeight(170);
		user.setUserWeight(50);
		
		int ret = userDao.addUser(user);
		//System.out.println("--------------------------------------------");
		//System.out.println(ret);
		assertTrue(ret>0);
		User newUser = userDao.getUserByName(user.getName());
		String newPwd = newUser.getPwd();
		assertNotNull(newUser); //断言
		assertTrue(newPwd.equals("123456"));
	};
	
	public void testGetUserInfo(){
		String userName = "despair2@126.com";
		//userDao.getUserInfo(userName);
		assertNotNull(userDao.getUserInfo(userName));
	}
	
	public void testUpdateUserInfo(){
		User user = new User();
		user.setPwd("123456");
		user.setUserHeight(175);
		user.setUserWeight(55);
		user.setName("despair2@126.com");
		int num =userDao.updateUserInfo(user);
		assertTrue(num > 0);
	}
	
//	public void testSaveCookie(){
//		UserCookie userCookie = new UserCookie();
//		userCookie.setCookieName("beetle");
//		userCookie.setCookieValue("beetle" + Math.random());
//		int saveFlag = userDao.saveCookie(userCookie);
//		assertTrue(saveFlag > 0);
//	}
//	
//	public void testGetUserCookieValueByName(){
//		UserCookie userCookie = userDao.getUserCookieValueByName("despairlin@126.com");
//		System.out.println("=================================================================================================");
//		System.out.println(userCookie == null);
//		assertNotNull(userCookie.getCookieValue());
//	}
	
}
