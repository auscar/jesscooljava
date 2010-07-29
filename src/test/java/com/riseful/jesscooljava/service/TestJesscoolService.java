package com.riseful.jesscooljava.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import com.riseful.jesscooljava.base.Util;
import com.riseful.jesscooljava.entity.Article;
import com.riseful.jesscooljava.entity.Tag;
import com.riseful.jesscooljava.entity.User;

public class TestJesscoolService extends TestCase {
	private JesscoolService service;
	public void setUp(){
		this.service = (JesscoolService)Util.getCtx().getBean("JesscoolService");
	}
	public void testGetArticleById() {
		Article a = service.getArticleById(151);
		System.out.println("@@@@@@@@@@@@@@@@@@@content : "+a.getContent());
		
		assertTrue(a.getTitle()!=null&&!a.getTitle().equals(""));
	}
	public void testGetArticleByIdAndTagId(){
		Article a = service.getSimpleArticleByIdAndTagId(195,7);
		assertTrue(a.getId()==195);
		assertTrue(a.getTag().getId() == 7);
		
	}
	public void testAddArticle() {
		Article article = new Article();
		article.setTitle("没有插入?");
		article.setContent("Spring is coming, and winter is leaving, time to show, man!");
		article.setIntime("2010-2-15");
		
		Tag tag = new Tag();
		tag.setId(8);
		
		article.setTag(tag);
		
		int ret = service.addArticle(article);
		assertTrue(ret>0);
	}
	public void testGetSimpleArticlesByTagIds(){
		int tagIds[]={1,2};
		Map<String,List<Article>> map;
		map = service.getSimpleArticlesByTagIds(tagIds,8);
		Set<String> keys = map.keySet();
		for(String key : keys){
			List<Article> articles = map.get(key);
			for(Article ar : articles){
				System.out.println("xxxxxxxxxxx> intime: "+ar.getIntime());
			}
		}
		assertTrue(map!=null&&map.size()>0);
	}
	public void testGetSimpleArticleById(){
		Article ar = service.getSimpleAritlceById(151);
		assertNotNull(ar.getTitle());
		assertTrue(ar.getTitle() != "");
		assertNotNull(ar.getTag());
		System.out.println("^^^^^^^^^^^^^^^^simple article tag name : "+ar.getTag().getName());
		assertTrue(ar.getTag().getId()>0);
	}
	public void testUpdateSimpleArticle(){
		Article article = new Article();
		article.setIntime("2010-06-19");
		article.setId(1);
		article.setTitle("Service更新的标题");
		article.setContent("Service更新的内容");
		article.setCover("http://www.jesscool.com");
		
		int ret = service.updateSimpleArticle(article);
		
		assertTrue(ret>0);
		
	}
	public void testGetSimpleArticlesWithTagByTagIds(){
		int ids[] = {1,2};
		Map<Tag,List<Article>> map = service.getSimpleArticlesWithTagByTagIds(ids,8);
		assertTrue(map.size()>0);
		Set<Tag> set = map.keySet();
		System.out.println("--->"+set.size());
		for(Tag tag : set){
			for(Article a : map.get(tag)){
				System.out.println("BBBBBBBBBBB-> key : "+tag.getName()+"  value:"+a.getTitle()+" a_id:"+a.getId()+"  time:"+a.getIntime());
			}
			System.out.println("\n");
		}
	}
	public void testGetUserByName(){
		User user = service.getUserByName("auscar");
		assertNotNull(user);
		assertNotNull(user.getName());
		assertNotNull(user.getPwd());
		
		User user_none = service.getUserByName("auscar_none");
		assertNull(user_none);
		
	}
	public void testGetAllTags(){
		List<Tag> tags = service.getAllTag();
		assertTrue(tags.size()>0);
	}
	public void testGetSimpleArticleDigestByTagIds(){
		int ids[] = {2,1};
		Map<String,List<Article>> map = service.getSimpleArticleDigestsByTagIds(ids,10,150);
		assertTrue(map.size()>0);
		
		Set<String> set = map.keySet();
		for(String key : set){
			System.out.println("~~~~~~~~~~~"+ key +"~~~~~~~~~~~~~");
			for(Article a : map.get(key)){
				System.out.println("###"+ key +"###"+a.getId());
				System.out.println(a.getContent());
			}
			System.out.println("\n");
		}
	}
	
	public void testAddTag(){
		Tag tag = new Tag();
		tag.setName("测试标题2");
		tag.setAtHome(true);
		tag.setDescription("就是测试标题，就是就是");
		
		int ret = service.addTag(tag);
		assertTrue(ret>0);
		
		
	}
	public void testGetTagByid(){
		Tag ret = service.getTagById(service.getBiggestId());
		assertTrue(ret != null);
		assertTrue(ret.getName()!=null);
	}
	public void testUpdateTag(){
		Tag tag = new Tag();
		tag.setId(service.getBiggestId());
		tag.setName("测试修改后的名字");
		tag.setDescription("测试修改后的description");
		int ret = service.updateTag(tag);
		assertTrue(ret>0);
	}
	public void testGetBiggestId(){
		int ret = service.getBiggestId();
		assertTrue(ret>0);
	}
	public void testDelTagById(){
		int ret = service.delTagById(service.getBiggestId());
		assertTrue(ret>0);
	}
	public void testDelArticle(){
		Article article_new = new Article();
		article_new.setTitle("test go go go!");
		article_new.setContent("test go go go!");
		article_new.setIntime("2010-2-13");
		article_new.setCover("http://baidu.com");
		int addRet = service.addArticle(article_new);
		assertTrue(addRet>0);
		
		int r = service.getMaxArticleId();
		
		int ret = service.delArticle(r);
		
		assertTrue(ret>0);
		
	}
}
