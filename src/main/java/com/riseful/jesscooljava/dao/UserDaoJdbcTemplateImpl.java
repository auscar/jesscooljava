package com.riseful.jesscooljava.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.riseful.jesscooljava.entity.User;
import com.riseful.jesscooljava.entity.UserCookie;


public class UserDaoJdbcTemplateImpl implements UserDao {
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public User getUserByName(String name) {
		String sql = "select * from User where userName=?";
		User user;
		try{
			user = (User)template.queryForObject(sql,new Object[]{name} ,new UserRowMapper());
		}catch(Exception e){
			return null;
		}
		
		return user;
	}
	public User getUserInfo(String name) {
		String sql = "select User.userId,userName,userPwd,UserInfo.userHeight,UserInfo.userWeight from User inner join UserInfo on User.userName=UserInfo.userId where User.userName=?";
		User user;
		try{
			user = (User)template.queryForObject(sql,new Object[]{name} ,new UserInfoRowMapper());
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		return user;
	}
	private class UserRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			User user = new User();
			user.setName(rs.getString("userName"));
			user.setPwd(rs.getString("userPwd"));
			return user;
		}
	}
	private class UserInfoRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			User user = new User();
			user.setName(rs.getString("userName"));
			user.setPwd(rs.getString("userPwd"));
			user.setUserHeight(rs.getInt("userHeight"));
			user.setUserWeight(rs.getInt("userWeight"));
			user.setUserId(rs.getInt("userId"));
			return user;
		}
	}
	public int addUser(User user) {
		//String sql = "Insert into User(userName,userPwd,userGender,userPhone,userWeight,userHeight) values('" + user.getName() + "','" + user.getPwd() + "','" + user.getUserGender() + "','" + user.getUserPhone() + "','" + user.getUserWeight() + "','" + user.getUserHeight() + "')";
		String sql_user = "Insert into User(userName,userPwd) values(?,?)";
		String sql_userInfo = "Insert into UserInfo(userId,userHeight,userWeight,userGender) values(?,?,?,?)";
		int rowNum = 0, rowNum_user = 0, rowNum_userInfo = 0;  //该变量主要用于接收执行sql语句后所影响的数据条数
		try{
			rowNum_user = template.update(sql_user,new Object[]{user.getName(),user.getPwd()});
			rowNum_userInfo = template.update(sql_userInfo,new Object[]{user.getName(),user.getUserHeight(),user.getUserWeight(),user.getUserGender()});
			if(rowNum_userInfo > 0){ //当两次写入的记录均无误时返回1，表示所有操作均没问题
				rowNum = 1;
			}
		}catch(Exception e){
			return 0;
		}
		return rowNum;
	}
	
	public int updateUserInfo(User user){
		String sql_userInfo = "update User,UserInfo set userPwd=?,userHeight=?,userWeight=? where User.userName=UserInfo.userId and User.userName=?";
		int num_userInfo = template.update(sql_userInfo, new Object[]{user.getPwd(),user.getUserHeight(),user.getUserWeight(),user.getName()});
		return num_userInfo;
	}
	
// user 的 这些数据已经放在了内存当中的一个hashMap内，不需要放到数据库内了。所以以下代码废弃	
//	public int saveCookie(UserCookie userCookie){
//		int rowNum_saveCookie = 0;
//		String sql_saveCookie = "insert into UserCookie(userCookieName,userCookieValue) values(?,?)";
//		try {
//			rowNum_saveCookie = template.update(sql_saveCookie, new Object[] {userCookie.getCookieName(), userCookie.getCookieValue() });
//		} catch (Exception e) {
//			return 0;
//		}
//		return rowNum_saveCookie;
//	}
//	
//	public UserCookie getUserCookieValueByName(String userCookieName){
//		UserCookie userCookie = new UserCookie();
//		String sql_getUserCookieName = "select * from UserCookie where userCookieId=(select MAX(userCookieId) from UserCookie where userCookieName=?)";
//		
//		try{
//			userCookie = (UserCookie)template.queryForObject(sql_getUserCookieName,new Object[]{userCookieName} ,new UserCookieRowMapper());
//		}catch(Exception e){
//			return null;
//		}
//		return userCookie;
//	}
//	private class UserCookieRowMapper implements RowMapper{
//		public Object mapRow(ResultSet rs, int index) throws SQLException {
//			UserCookie userCookie = new UserCookie();
//			userCookie.setCookieName( rs.getString("userCookieName") );
//			userCookie.setCookieValue( rs.getString("userCookieValue") );
//			return userCookie;
//		}
//	}

}
