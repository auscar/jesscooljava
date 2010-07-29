package com.riseful.jesscooljava.service;

import java.util.List;
import java.util.Map;

import com.riseful.jesscooljava.entity.Article;
import com.riseful.jesscooljava.entity.Comment;
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
