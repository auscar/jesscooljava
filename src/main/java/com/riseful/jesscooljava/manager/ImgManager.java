package com.riseful.jesscooljava.manager;

import java.util.List;
import com.riseful.jesscooljava.entity.Img;
import com.riseful.jesscooljava.entity.ImgTag;

public interface ImgManager {
	public int addImg(Img img);
	public List<Img> getImgs();
	public List<ImgTag> getImgTags(String userName);
	public List<Img> getImgsByTagId(int tagId);
	public int addImgTag(ImgTag imgTag);
	public int getMaxTagId();
	public int getMaxImgTagIdByName(String userName);
	public int imgUpdate(Img img);
	public int imgTagDelete(ImgTag imgTag);
	public int imgTagUpdate(ImgTag imgTag);
	public int imgDelete(Img img);
}
