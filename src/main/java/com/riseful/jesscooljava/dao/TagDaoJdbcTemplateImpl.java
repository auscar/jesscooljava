package com.riseful.jesscooljava.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.riseful.jesscooljava.entity.Tag;

public class TagDaoJdbcTemplateImpl implements TagDao {
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int addTag(Tag tag) {
		String sql = "insert into Tags (name,is_home,description) values(?,?,?)";
		return template.update(sql, new Object[]{tag.getName(),tag.isAtHome(),tag.getDescription()});
	}

	public int delTagById(int id) {
		String sql = "delete from Tags where id=?";
		return template.update(sql, new Object[]{id});
	}

	public Tag getTagById(int id) {
		String sql = "select * from Tags where id=?";
		return (Tag)template.queryForObject(sql,new Object[]{id}, new TagRowMapper());
	}
	public int getBiggestId(){
		String sql = "select max(id) from Tags";
		return template.queryForInt(sql);
	}

	public int updateTag(Tag tag) {
		String sql = "update Tags set is_home=?,name=?,description=? where id=?";
		return template.update(sql, new Object[]{tag.isAtHome(),tag.getName(),tag.getDescription(),tag.getId()});
	}
	private class TagRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Tag tag = new Tag();
			tag.setId(rs.getInt("id"));
			tag.setAtHome(rs.getBoolean("is_home"));
			tag.setName(rs.getString("name"));
			tag.setDescription(rs.getString("description"));
			return tag;
		}
		
	} 

}
