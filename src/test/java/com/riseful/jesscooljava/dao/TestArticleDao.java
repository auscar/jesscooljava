package com.riseful.jesscooljava.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import com.riseful.jesscooljava.base.Util;
import com.riseful.jesscooljava.entity.Article;
import com.riseful.jesscooljava.entity.Tag;

public class TestArticleDao extends TestCase {
	private ArticleDao articleDao;
	public void setUp(){
		articleDao = (ArticleDao)Util.getCtx().getBean("articleDao");
	}
	public void testGetArticleById() {
		Article a = articleDao.getArticleById(195);
		
		assertTrue(a.getTitle()!=null&&!a.getTitle().equals(""));
	}
	public void testGetArticleByIdAndTagId(){
		Article a = articleDao.getSimpleArticleByIdAndTagId(195,7);
		assertTrue(a.getId()==195);
		assertTrue(a.getTag().getId() == 7);
		
	}
	public void testGetAllTag() {
		List<Tag> tags = articleDao.getAllTag();
		assertTrue(tags.size() > 0);
	}
	public void testAddTagIdToArticle(){

	}
	public void testGetSimpleArticlesByTagId(){
		List<Article> articles = articleDao.getSimpleArticlesByTagId(1,0);
		assertTrue( articles.size()>0 );
	}
	public void testGetSimpleArticlesByTagIds(){
		int ids[] = {1,2};
		Map<String,List<Article>> map = articleDao.getSimpleArticlesByTagIds(ids,10);
		assertTrue(map.size()>0);
		Set<String> set = map.keySet();
		System.out.println("--->"+set.size());
		for(String key : set){
			for(Article a : map.get(key)){
				System.out.println("############## key : "+key+"  value:"+a.getTitle()+" a_id:"+a.getId()+"  time:"+a.getIntime());
			}
			System.out.println("\n");
		}
	}
	public void testAddArticle(){
		Article article_new = new Article();
		article_new.setTitle("2010流行春装go,go,go!"+Math.random());
		article_new.setContent("不要错过!");
		article_new.setIntime("2010-2-13");
		article_new.setCover("http://baidu.com");
		articleDao.addArticle(article_new);
		int r = articleDao.getMaxArticleId();
		assertTrue(r>0);
		System.out.println("++++++++++++++++++--->"+r);
	}
	public void testGetSimpleArticleById(){
		Article ar = articleDao.getSimpleArticleById(195);
		assertNotNull(ar.getTitle());
		assertTrue(ar.getTitle() != "");
		assertNotNull(ar.getTag());
		//System.out.println("^^^^^^^^^^^^^^^^simple article tag name : "+ar.getTag().getName());
		assertTrue(ar.getTag().getId()>0);
	}
	public void testUpdateSimpleArticle(){
		String s = "http://s.jesscool.com/test";
		Article ar = new Article();
		ar.setIntime("2010-06-19");
		ar.setId(1);
		ar.setTitle("我要更新标题");
		ar.setContent("内容也一并更新算了吧!");
		ar.setCover(s);
		
		int ret = articleDao.updateSimpleArticle(ar);
		assertTrue(ret>0);
		
		Article a = articleDao.getArticleById(1);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(s);
		System.out.println(a.getCover());
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
		assertTrue( s.equals(a.getCover()) );
		
	}
	public void testDeleteSimpleArticleTag(){
//		Article ar = new Article();
//		ar.setId(1);
//		Tag tag = new Tag();
//		tag.setId(2);
//		
//		int ret = articleDao.deleteSimpleArticleTag(ar, tag);
//		assertTrue(ret>0);
	}
	public void testGetMaxArticleId(){
//		
//		int id = articleDao.getMaxArticleId();
//		assertTrue(id>0);
	}
	public void testGetSimpleArticlesWithTagByTagIds(){
		int ids[] = {1,2};
		Map<Tag,List<Article>> map = articleDao.getSimpleArticlesWithTagByTagIds(ids,8);
		assertTrue(map.size()>0);
		Set<Tag> set = map.keySet();
		System.out.println("--->"+set.size());
		for(Tag tag : set){
			for(Article a : map.get(tag)){
				System.out.println("AAAAAAAAAAA-> key : "+tag.getName()+"  value:"+a.getTitle()+" a_id:"+a.getId()+"  time:"+a.getIntime());
			}
			System.out.println("\n");
		}
	}
	
	public void testGetSimpleArticleDigestsByTagIds(){
		int ids[] = {12};
		Map<String,List<Article>> map = articleDao.getSimpleArticleDigestsByTagIds(ids,10,150);
		assertTrue(map.size()>0);
		Set<String> set = map.keySet();
		for(String key : set){
			System.out.println("~~~~~~~~~~~"+ key +"~~~~~~~~~~~~~");
			for(Article a : map.get(key)){
				assertNotNull(a.getContent());
				assertNotNull(a.getFirstImg());
				assertTrue(!a.getFirstImg().equals(""));
			}
			
		}
	}
	public void testDelArticle(){
		Article article_new = new Article();
		article_new.setTitle("test go go go!");
		article_new.setContent("test go go go!");
		article_new.setIntime("2010-2-13");
		article_new.setCover("http://baidu.com");
		articleDao.addArticle(article_new);
		int r = articleDao.getMaxArticleId();
		
		int ret = articleDao.delArticle(r);
		
		assertTrue(ret>0);
		
	}
	
	
}
