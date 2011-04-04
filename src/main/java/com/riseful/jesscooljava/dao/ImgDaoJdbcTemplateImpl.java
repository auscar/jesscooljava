package com.riseful.jesscooljava.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultReader;

import com.riseful.jesscooljava.entity.Img;
import com.riseful.jesscooljava.entity.ImgTag;
@SuppressWarnings("unchecked")

public class ImgDaoJdbcTemplateImpl implements ImgDao {
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int getMaxTagId(){
		String sql_maxId = "select max(imgTagId) from ImgTag";
		return template.queryForInt(sql_maxId);
	}
	
	public int getMaxImgTagIdByName(String userName){
		String sql_maxId = "select max(imgTagId) from ImgTag where userName=?";
		return template.queryForInt(sql_maxId,new Object[]{userName});
	}
	
	public int addImg(Img img){
		int ImgTagImg_num = 0, ImgTagUser_num = 0;
		
		//String sql_ImgTag = "insert into ImgTag(imgTagName) values(?)";
		String sql_ImgTagImg = "insert into ImgTagImg(imgTagId,imgUrl) values(?,?)";
		String sql_ImgTagUser = "insert into ImgTagUser(imgUserId,imgTagId) values(?,?)";
		
		//ImgTag_num = template.update(sql_ImgTag,new Object[]{img.getTagName()});
		
		//int maxId = this.getMaxTagId();
		ImgTagImg_num = template.update(sql_ImgTagImg,new Object[]{img.getTagId(), img.getImgName()});
		ImgTagUser_num = template.update(sql_ImgTagUser,new Object[]{img.getUserId(), img.getTagId()});
		
		if(ImgTagImg_num > 0 && ImgTagUser_num > 0){  //所有记录插入成功才算操作成功
			return 1;
		}
		
		return 0;
	}
	
	public List<Img> getImgs(){
		String sql_imgTagImg = "select * from ImgTagImg order by id desc";
		//String sql_imgTagImg = "select * from ImgTagImg where imgTagId=38";

		List<Img> imgs = template.query(sql_imgTagImg,new RowMapperResultReader( new ImgRowMapper()) );
		return imgs;
	}
	
	public List<ImgTag> getImgTags(String userName){
		String sql_imgTag = "select imgTagId,imgTagName,userName from ImgTag where userName='" + userName + "' order by imgTagId desc"; 
		List<ImgTag> imgTags = template.query(sql_imgTag, new ImgTagRowMapper());
		return imgTags;
	}
	
	public List<Img> getImgsByTagId(int tagId){
		String sql_imgTagImg = "select id,imgTagId,imgUrl from ImgTagImg where imgTagId=" + tagId + " order by id desc";
		List<Img> imgs = template.query(sql_imgTagImg,new RowMapperResultReader( new NewImgRowMapper()) );
		return imgs;
	}
	
	private class ImgTagRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			ImgTag imgTags = new ImgTag();
			imgTags.setUserName(rs.getString("userName"));
			imgTags.setImgTagId(rs.getInt("imgTagId"));
			imgTags.setImgTagName(rs.getString("imgTagName"));
			return imgTags;
		}
	}
	
	private class ImgRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Img img = new Img();
			img.setImgUrl(rs.getString("imgUrl"));
			img.setId(rs.getInt("id"));
			return img;
		}
	}
	
	private class NewImgRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Img imgs = new Img();
			imgs.setTagId(rs.getInt("imgTagId"));
			imgs.setImgUrl(rs.getString("imgUrl"));
			imgs.setId(rs.getInt("id"));
			return imgs;
		}
	}
	
	public int addImgTag(ImgTag imgTag){
		int flag = 0;
		String sql_imgTagName = "insert into ImgTag(imgTagName,userName) values(?,?)";
		flag = template.update(sql_imgTagName,new Object[]{imgTag.getImgTagName(),imgTag.getUserName()});
		if(flag <= 0){
			return 0;
		}
		return this.getMaxTagId();
	}
	
	public int imgUpdate(Img img){
		int num = 0;
		String sql_imgUpdate = "update ImgTagImg set imgTagId=? where id=?";
		try {
			num = template.update(sql_imgUpdate, new Object[] { img.getTagId(),img.getId() });
		} catch (Exception e) {
			num = 0;
		}
		return num;
	}
	
	public int imgTagDelete(ImgTag imgTag){
		int num = 0, num_imgTag = 0, num_imgTagImg = 0, num_imgTagUser = 0;
		String sql_imgTagDelete = "delete from ImgTag where imgTagId=?";
		String sql_imgTagImgDelete = "delete from ImgTagImg where imgTagId=?";
		String sql_imgTagUserDelete = "delete from ImgTagUser where imgTagId=?";
		
		try{
			num_imgTag = template.update(sql_imgTagDelete, new Object[]{imgTag.getImgTagId()});
			num_imgTagImg = template.update(sql_imgTagImgDelete, new Object[]{imgTag.getImgTagId()});
			num_imgTagUser = template.update(sql_imgTagUserDelete, new Object[]{imgTag.getImgTagId()});
			num = num_imgTag + num_imgTagImg + num_imgTagUser;
			if(num > 0){
				num = 1;
			}
		}catch(Exception e){
			num = 0;
		}
		return num;
	}
	
	public int imgTagUpdate(ImgTag imgTag){
		int num = 0;
		String sql_imgTagUpdate = "update ImgTag set imgTagName=? where imgTagId=?";
		try{
			num = template.update(sql_imgTagUpdate, new Object[]{imgTag.getImgTagName(),imgTag.getImgTagId()});
		}catch(Exception e){
			
		}
		return num;
	}
	
	public int imgDelete(Img img){
		int num_imgDel = 0;
		String sql_imgDel = "delete from ImgTagImg where id=?";
		try{
			num_imgDel = template.update(sql_imgDel, new Object[]{ img.getId() });
		}catch(Exception e){
			
		}
		return num_imgDel;
	}
	
	public int getMaxImgId(){
		String sql_getMaxImgId = "select MAX(id) from ImgTagImg";
		return template.queryForInt(sql_getMaxImgId);
	}
	
}
