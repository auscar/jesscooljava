package com.riseful.jesscooljava.manager;

import com.riseful.jesscooljava.dao.UserDao;
import com.riseful.jesscooljava.entity.User;

public class UserManagerSimpleImpl implements UserManager {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}

	public int addUser(User user) {
		return userDao.addUser(user);
	}
	
	public User getUserInfo(String name){
		return userDao.getUserInfo(name);
	}
	
	public int updateUserInfo(User user){
		return userDao.updateUserInfo(user);
	}
	
//	public int saveCookie(UserCookie userCookie){
//		return userDao.saveCookie(userCookie);
//	}
//	
//	public UserCookie getUserCookieValueByName(String userCookieName){
//		return userDao.getUserCookieValueByName(userCookieName);
//	}

}
