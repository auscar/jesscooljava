package com.riseful.jesscooljava.manager;

import java.util.List;
import java.util.Map;

import com.riseful.jesscooljava.dao.ArticleDao;
import com.riseful.jesscooljava.entity.Article;
import com.riseful.jesscooljava.entity.Tag;

public class ArticleManagerSimpleImpl implements ArticleManager {
	private ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}

	public List<Article> getSimpleArticlesByTagName(String tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addArticle(Article article) {
		return articleDao.addArticle(article);
	}

	public int addTagIdToArticle(Article article, int tagId) {
		return articleDao.addTagIdToArticle(article, tagId);
	}

	public List<Article> getSimpleArticlesByTagId(int tagId, int num) {
		return articleDao.getSimpleArticlesByTagId(tagId, num);
	}

	public Map<String, List<Article>> getSimpleArticlesByTagIds(int[] tagIds, int num) {
		return articleDao.getSimpleArticlesByTagIds(tagIds, num);
	}

	public Article getSimpleArticleById(int id) {
		return articleDao.getSimpleArticleById(id);
	}

	public int deleteArticleTag(Article article, Tag tag) {
		return articleDao.deleteSimpleArticleTag(article, tag);
	}

	public int updateSimpleArticle(Article article) {
		return articleDao.updateSimpleArticle(article);
	}

	public Map<Tag, List<Article>> getSimpleArticlesWithTagByTagIds(int[] tagIds, int num) {
		return articleDao.getSimpleArticlesWithTagByTagIds(tagIds, num);
	}

	public List<Tag> getAllTags() {
		return articleDao.getAllTag();
	}

	public Map<String, List<Article>> getSimpleArticleDigestsByTagIds(
			int[] tagIds, int num, int wordNum) {
		return articleDao.getSimpleArticleDigestsByTagIds(tagIds, num, wordNum);
	}

//	public int addTag(Tag tag) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int delTagById(int id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int getBiggestId() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public Tag getTagById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public int updateTag(Tag tag) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	public int delArticle(int id) {
		return articleDao.delArticle(id);
	}

	public int getMaxArticleId() {
		return articleDao.getMaxArticleId();
	}
	public int addTagToArticle(Article article, Tag tag) {
		return articleDao.addTagIdToArticle(article, tag.getId());
	}

	public Article getSimpleArticleByIdAndTagId(int id, int tagId) {
		return articleDao.getSimpleArticleByIdAndTagId(id, tagId);
	}


}
