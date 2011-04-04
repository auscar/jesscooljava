package com.riseful.jesscooljava.manager;

import java.util.List;
import com.riseful.jesscooljava.dao.ImgDao;
import com.riseful.jesscooljava.entity.Img;
import com.riseful.jesscooljava.entity.ImgTag;

public class ImgManagerSimpleImpl implements ImgManager {
	private ImgDao imgDao;
	
	public void setImgDao(ImgDao imgDao) {
		this.imgDao = imgDao;
	}

	public int addImg(Img img){
		return imgDao.addImg(img);
	}
	
	public List<Img> getImgs(){
		return imgDao.getImgs();
	}
	
	public List<ImgTag> getImgTags(String userName){
		return imgDao.getImgTags(userName);
	}
	
	public List<Img> getImgsByTagId(int tagId){
		return imgDao.getImgsByTagId(tagId);
	}
	
	public int addImgTag(ImgTag imgTag){
		return imgDao.addImgTag(imgTag);
	}
	
	public int getMaxTagId(){
		return imgDao.getMaxTagId();
	}
	
	public int getMaxImgTagIdByName(String userName){
		return imgDao.getMaxImgTagIdByName(userName);
	}
	
	public int imgUpdate(Img img){
		return imgDao.imgUpdate(img);
	}
	
	public int imgTagDelete(ImgTag imgTag){
		return imgDao.imgTagDelete(imgTag);
	}
	
	public int imgTagUpdate(ImgTag imgTag){
		return imgDao.imgTagUpdate(imgTag);
	}
	
	public int imgDelete(Img img){
		return imgDao.imgDelete(img);
	}
	
}
