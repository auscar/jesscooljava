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

}
