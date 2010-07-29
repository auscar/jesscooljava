package com.riseful.jesscooljava.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.riseful.jesscooljava.entity.User;

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
	private class UserRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			User user = new User();
			user.setName(rs.getString("userName"));
			user.setPwd(rs.getString("userPwd"));
			return user;
		}
	}

}
