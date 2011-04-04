package com.riseful.jesscooljava.dao;

import java.util.List;
import com.riseful.jesscooljava.entity.Img;
import com.riseful.jesscooljava.entity.ImgTag;

public interface ImgDao {
	public int addImg(Img img);
	public int getMaxImgTagIdByName(String userName);
	public int getMaxTagId();
	public List<Img> getImgs();
	public List<ImgTag> getImgTags(String userName);
	public List<Img> getImgsByTagId(int tagId);
	public int addImgTag(ImgTag imgTag);
	public int imgUpdate(Img img);
	public int imgTagDelete(ImgTag imgTag);
	public int imgTagUpdate(ImgTag imgTag);
	public int getMaxImgId();
	public int imgDelete(Img img);
}
