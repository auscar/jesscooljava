package com.riseful.jesscooljava.service;

import java.util.List;
import java.util.Map;

import com.riseful.jesscooljava.entity.Article;
import com.riseful.jesscooljava.entity.Comment;
import com.riseful.jesscooljava.entity.Img;
import com.riseful.jesscooljava.entity.ImgTag;
import com.riseful.jesscooljava.entity.Tag;
import com.riseful.jesscooljava.entity.User;

public interface JesscoolService {
	//public List<Set<Article>> getSimpleArticlesByTagNames(String[] tags);
	public List<Article> getSimpleArticlesByTagName(String tag);
	public Article getArticleById(int id);
	public Article getSimpleArticleByIdAndTagId(int id, int tagId);
	public int addComment( Comment comment );
	public int delArticle(int id);
	public int addArticle( Article article );
	public int getMaxArticleId();
	public int addUser(User user);
	public int addImg(Img img);
	public List<Img> getImgs();
	public List<ImgTag> getImgTags(String userName);
	public List<Img> getImgsByTagId(int tagId);
	public int addImgTag(ImgTag imgTag);
	public int getMaxTagId();
	public int getMaxImgTagIdByName(String userName);
	//public int saveCookie(UserCookie userCookie);
	//public UserCookie getUserCookieValueByName(String userCookieName);
	public int imgUpdate(Img img);
	public int imgTagDelete(ImgTag imgTag);
	public int imgTagUpdate(ImgTag imgTag);
	public int imgDelete(Img img);
	
	public int addTagIdToArticle(Article article,int tagId);
	public List<Article> getSimpleArticlesByTagId(int tagId , int num);
	public Map<String,List<Article>> getSimpleArticlesByTagIds(int[] tagIds, int num);
	
	public Map<String,List<Article>> getSimpleArticleDigestsByTagIds(int[] tagIds, int num, int wordNum);
	public Map<Tag,List<Article>> getSimpleArticlesWithTagByTagIds(int[] tagIds, int num);
	
	public Article getSimpleAritlceById(int id);
	
	public int deleteArticleTag(Article article, Tag tag);
	public int addTagToArticle(Article article, Tag tag);
	
	public int updateSimpleArticle(Article article);
	
	public User getUserByName(String name);
	
	public List<Tag> getAllTag();
	
	public Tag getTagById(int id);
	public int addTag(Tag tag);
	public int delTagById(int id);
	public int updateTag(Tag tag);
	public int getBiggestId();
	
	
}
