package com.riseful.jesscooljava.dao;

import java.util.List;
import java.util.Map;

import com.riseful.jesscooljava.entity.Article;
import com.riseful.jesscooljava.entity.Tag;

public interface ArticleDao {
	public Article getArticleById(int id);
	public Article getSimpleArticleByIdAndTagId(int id, int tagId);
	public int addArticle(Article article);
	public int delArticle(int id);
	public List<Tag> getAllTag();
	
	
	public int addTagIdToArticle(Article article, int tagId);
	public List<Article> getSimpleArticlesByTagId(int tagId, int num);
	public Map<String,List<Article>> getSimpleArticlesByTagIds(int[] tagIds,int num);
	
	public Map<Tag,List<Article>> getSimpleArticlesWithTagByTagIds(int[] tagIds, int num);
	public Map<String,List<Article>> getSimpleArticleDigestsByTagIds(int[] tagIds, int num, int wordNum);
	
	
	public Article getSimpleArticleById(int id);
	
	public int updateSimpleArticle(Article article);
	public int deleteSimpleArticleTag(Article article, Tag tag);
	
	public int getMaxArticleId();
}
