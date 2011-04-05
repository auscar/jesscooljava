package com.riseful.jesscooljava.dao;

import junit.framework.TestCase;
import java.util.List;

import com.riseful.jesscooljava.base.Util;
import com.riseful.jesscooljava.entity.Img;
import com.riseful.jesscooljava.entity.ImgTag;

public class TestImgDao extends TestCase {
	private ImgDao imgDao;
	
	public void setUp(){
		this.imgDao = (ImgDao)Util.getCtx().getBean("imgDao");
	}
	
	
	public void testAddImg(){
		Img img = new Img();
		img.setImgName("img2.jpg");
		//img.setTagName("运动服饰");
		img.setTagId(34);
		img.setUserId("despairlin@126.com");
		
		int img_num = imgDao.addImg(img);
		//System.out.println("--------------------------------------------");
		//System.out.println(ret);
		assertTrue(img_num > 0);
		
	};
	
	public void testGetImgs(){
		List<Img> imgs = imgDao.getImgs();
		assertNotNull(imgs);
		assertNotNull(imgs.get(0).getImgUrl());
	}
	
	public void testGetImgTags(){
		String userName = "userNotExist"+Math.random();
		List<ImgTag> imgTags = imgDao.getImgTags(userName);
		assertTrue(imgTags.size()==0);
		
		//这个用户杂线上是有的
		List<ImgTag> imgTags2 = imgDao.getImgTags("auscar@126.com");
		assertTrue(imgTags2.size()>0);
		//assertNotNull(imgTags.get(0).getImgTagName());
	}
	
	public void testGetImgByTagId(){
		List<Img> imgs = imgDao.getImgsByTagId(34);
		assertNotNull(imgs);
		assertNotNull(imgs.get(0).getImgUrl());
	}
	
	public void testAddImgTag(){
		ImgTag imgTag = new ImgTag();
		imgTag.setImgTagName("时尚宅男");
		imgTag.setUserName("auscar@qq.com");
		int imgTag_num = imgDao.addImgTag(imgTag);
		assertTrue(imgTag_num > 0);
	}
	
	public void testImgUpdate(){
		int num_ImgUpdate = 0;
		Img img_ImgUpdate = new Img();
		img_ImgUpdate.setTagId(143);
		img_ImgUpdate.setId(imgDao.getMaxImgId());
		num_ImgUpdate = imgDao.imgUpdate(img_ImgUpdate);
		assertTrue(num_ImgUpdate > 0);
		
	}
	
	public void testImgTagDelete(){
		ImgTag imgTag_imgTagDelete = new ImgTag();
		imgTag_imgTagDelete.setImgTagId(imgDao.getMaxTagId());
		assertTrue(imgDao.imgTagDelete(imgTag_imgTagDelete) > 0);
	}
	
	public void testImgTagUpdate(){
		ImgTag imgTag_imgTagUpdate = new ImgTag();
		imgTag_imgTagUpdate.setImgTagId(imgDao.getMaxTagId());
		imgTag_imgTagUpdate.setImgTagName("新类别名称");
		assertTrue(imgDao.imgTagUpdate(imgTag_imgTagUpdate) > 0);
	}
	
	public void testImgDelete(){
		Img img_imgDel = new Img();
		img_imgDel.setId(imgDao.getMaxImgId());
		assertTrue( imgDao.imgDelete(img_imgDel) > 0 );
	}
	
	public void getMaxImgTagIdByName(){
		String userName = "despairlin@126.com";
		int getId = imgDao.getMaxImgTagIdByName(userName);
		assertTrue( getId > 0 );
	}
	
}
