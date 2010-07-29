package com.riseful.jesscooljava.service;

import java.util.List;
import java.util.Map;

import com.riseful.jesscooljava.entity.Article;
import com.riseful.jesscooljava.entity.Comment;
import com.riseful.jesscooljava.entity.Tag;
import com.riseful.jesscooljava.entity.User;
import com.riseful.jesscooljava.manager.ArticleManager;
import com.riseful.jesscooljava.manager.TagManager;
import com.riseful.jesscooljava.manager.UserManager;

public class JesscoolServiceSimpleImpl implements JesscoolService {
	private ArticleManager articleManager;
	private UserManager userManager;
	private TagManager tagManager;
	
	public void setTagManager(TagManager tagManager) {
		this.tagManager = tagManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}


	public void setArticleManager(ArticleManager articleManager) {
		this.articleManager = articleManager;
	}
	
	
	public Article getArticleById(int id) {
		return articleManager.getArticleById(id);
	}
	public List<Article> getSimpleArticlesByTagName(String tag) {
		// TODO Auto-generated method stub
		return null;
	}
	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int addArticle(Article article) {
		int ret = articleManager.addArticle(article);//addArticle方法返回最近插入的Article id
		
		if(article.getTag()!=null && article.getTag().getId()>0){
			article.setId(ret);
			ret = articleManager.addTagIdToArticle(article, article.getTag().getId());
		}
		return ret;
	}
	
	public List<Article> getSimpleArticlesByTagId(int tagId, int num) {
		return articleManager.getSimpleArticlesByTagId(tagId, num);
	}

	public Map<String, List<Article>> getSimpleArticlesByTagIds(int[] tagIds, int num) {
		return articleManager.getSimpleArticlesByTagIds(tagIds, num);
	}


	public int addTagIdToArticle(Article article, int tagId) {
		return articleManager.addTagIdToArticle(article, tagId);
	}

	public Article getSimpleAritlceById(int id) {
		return articleManager.getSimpleArticleById(id);
	}
	
	public int deleteArticleTag(Article article, Tag tag) {
		return articleManager.deleteArticleTag(article, tag);
	}
	
	public int updateSimpleArticle(Article article) {
		return articleManager.updateSimpleArticle(article);
	}
	
	public Map<Tag, List<Article>> getSimpleArticlesWithTagByTagIds(int[] tagIds, int num) {
		return articleManager.getSimpleArticlesWithTagByTagIds(tagIds, num);
	}
	public User getUserByName(String name) {
		return userManager.getUserByName(name);
	}
	public List<Tag> getAllTag() {
		return articleManager.getAllTags();
	}
	public Map<String, List<Article>> getSimpleArticleDigestsByTagIds(
			int[] tagIds, int num, int wordNum) {
		return articleManager.getSimpleArticleDigestsByTagIds(tagIds, num, wordNum);
	}


	public int addTag(Tag tag) {
		return tagManager.addTag(tag);
	}


	public int delTagById(int id) {
		return tagManager.delTagById(id);
	}


	public int getBiggestId() {
		return tagManager.getBiggestId();
	}


	public Tag getTagById(int id) {
		return tagManager.getTagById(id);
	}


	public int updateTag(Tag tag) {
		return tagManager.updateTag(tag);
	}

	public int delArticle(int id) {
		return articleManager.delArticle(id);
	}

	public int getMaxArticleId() {
		return articleManager.getMaxArticleId();
	}

	public int addTagToArticle(Article article, Tag tag) {
		return articleManager.addTagIdToArticle(article, tag.getId());
	}

	public Article getSimpleArticleByIdAndTagId(int id, int tagId) {
		return articleManager.getSimpleArticleByIdAndTagId(id, tagId);
	}

}
