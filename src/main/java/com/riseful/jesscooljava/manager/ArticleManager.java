package com.riseful.jesscooljava.manager;

import java.util.List;
import java.util.Map;

import com.riseful.jesscooljava.entity.Article;
import com.riseful.jesscooljava.entity.Tag;

public interface ArticleManager {
	public Article getArticleById(int id);
	public Article getSimpleArticleByIdAndTagId(int id, int tagId);
	public List<Article> getSimpleArticlesByTagName(String tagName);
	public int delArticle(int id);
	public int addTagToArticle(Article article, Tag tag);
	public int addArticle(Article article);
	public int getMaxArticleId();
	
	public int addTagIdToArticle(Article article,int tagId);
	public List<Article> getSimpleArticlesByTagId(int tagId, int num);
	
	public Map<String,List<Article>> getSimpleArticleDigestsByTagIds(int[] tagIds, int num, int wordNum);
	public Map<String,List<Article>> getSimpleArticlesByTagIds(int[] tagIds, int num);
	public Map<Tag,List<Article>> getSimpleArticlesWithTagByTagIds(int[] tagIds, int num);
	
	public Article getSimpleArticleById(int id);
	
	public int deleteArticleTag(Article article, Tag tag);
	
	public int updateSimpleArticle(Article article);

	public List<Tag> getAllTags();
	
}
