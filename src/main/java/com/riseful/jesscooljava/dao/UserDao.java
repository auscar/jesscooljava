package com.riseful.jesscooljava.dao;

import com.riseful.jesscooljava.entity.User;
import com.riseful.jesscooljava.entity.UserCookie;

public interface UserDao {
	public User getUserByName(String name);
	public int addUser(User user);
	public User getUserInfo(String name);
	public int updateUserInfo(User user);
	//public int saveCookie(UserCookie userCookie);
	//public UserCookie getUserCookieValueByName(String userCookieName);
}
