package com.riseful.jesscooljava.manager;

import com.riseful.jesscooljava.entity.User;

public interface UserManager {
	public User getUserByName(String name);
	public int addUser(User user);
	public User getUserInfo(String name);
	public int updateUserInfo(User user);
	//public int saveCookie(UserCookie userCookie);
	//public UserCookie getUserCookieValueByName(String userCookieName);
}
