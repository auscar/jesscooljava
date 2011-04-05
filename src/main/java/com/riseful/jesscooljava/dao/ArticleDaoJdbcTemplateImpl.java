package com.riseful.jesscooljava.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.util.ParserException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultReader;

import com.riseful.jesscooljava.entity.Article;
import com.riseful.jesscooljava.entity.Tag;
import com.riseful.jesscooljava.htmlUtil.SimpleHtmlParser;

public class ArticleDaoJdbcTemplateImpl implements ArticleDao {
	
	public static int wordNum = 300;
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public Article getArticleById(int id) {
		String sql = "select * from Articles where id=" + id;
		//String sql = "select *,s.id as tagId from Articles a,ArticleTag t,Tags s where a.id=t.a_id and t.t_id=s.id and a.id="+id+" limit 0,1";
		
		//Article article = (Article)template.queryForObject(sql, new ArticleRowMapper());
		Article article = (Article)template.queryForObject(sql, new ArticleRowMapper());
		return article;
	}
	public Article getSimpleArticleByIdAndTagId(int id, int tagId) {
		String sql = "select *,s.id as tagId from Articles a,ArticleTag t,Tags s where a.id=t.a_id and t.t_id=s.id and a.id=? and s.id=? limit 0,1";
		Article article = (Article)template.queryForObject(sql, new Object[]{id,tagId}, new SimpleArticleRowMapper());
		return article;
	}

	public List<Article> getSimpleArticlesByTagId(int tagId, int num) {
		String topN = "";
		if(num > 0){
			topN = " limit 0, "+num;
		}
		
		String sql = "select a.id,a.title,a.content,a.cover_url,a.intime,c.id as tagId,c.name,c.description from Articles a,ArticleTag b,Tags c where a.id = b.a_id and b.t_id = c.id and c.id="+tagId+" order by a.intime desc "+topN;
		List<Article> articles = template.query(sql, new RowMapperResultReader(new SimpleArticleRowMapper()));
		return articles;
	}
	
	/**
	 * 用一个tag id 获取在这个tag下的所有文章的摘要. 主要就是利用SimpleArticleDigestRowMapper将每个Article的content进行了substring
	 * @param tagId
	 * @param num
	 * @return
	 */
	public List<Article> getSimpleArticleDigestsByTagId(int tagId, int num) {
		String topN = "";
		if(num > 0){
			topN = " limit 0, "+num;
		}
		
		String sql = "select a.id,a.title,a.content,a.cover_url,a.intime,c.id as tagId,c.name,c.description from Articles a,ArticleTag b,Tags c where a.id = b.a_id and b.t_id = c.id and c.id="+tagId+" order by a.intime desc "+topN;
		List<Article> articles = template.query(sql, new RowMapperResultReader(new SimpleArticleDigestRowMapper()));
		return articles;
	}
	
	public int addArticle(Article article) {
		String sql = "insert into Articles (title,content,cover_url,intime) values (?,?,?,?)";
		int ret = template.update(sql,new Object[]{article.getTitle(),article.getContent(),article.getCover(),article.getIntime()});
		ret = this.getMaxArticleId();//获取最新插入的Article id
		return ret;
	}
	public List<Tag> getAllTag() {
		String sql = "select * from Tags";
		List<Tag> tags = template.query(sql, new RowMapperResultReader(new TagRowMapper()));
		return tags;
	}
	public Map<String,List<Article>> getSimpleArticlesByTagIds(int[] tagIds, int num) {
		Map<String,List<Article>> map = new HashMap<String,List<Article>>();
		for(int id : tagIds){
			List<Article> articles = this.getSimpleArticlesByTagId(id, num);
			if(articles.size()<=0)continue;
			map.put(articles.get(0).getTag().getName(), articles);
		}
		return map;
	}
	
	
	
	
	private class ArticleRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Article article = new Article();
			article.setId(rs.getInt("id"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			article.setIntime(rs.getString("intime"));
			article.setCover(rs.getString("cover_url"));
			return article;
		}
	}

	private class SimpleArticleRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Article article = new Article();
			Tag tag = new Tag();
			article.setId(rs.getInt("id"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			article.setIntime(rs.getString("intime"));
			article.setCover(rs.getString("cover_url"));
			tag.setId(rs.getInt("tagId"));
			tag.setName(rs.getString("name"));
			tag.setDescription(rs.getString("description"));
			article.setTag(tag);
			return article;
		}
	}
	private class SimpleArticleDigestRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Article article = new Article();
			Tag tag = new Tag();
			article.setId(rs.getInt("id"));
			article.setTitle(rs.getString("title"));
			
			//过滤html标签以及裁减内容形成digest
			try {
				
				//String plainText = SimpleHtmlParser.getPlainText(rs.getString("content"));
				Map<String,String> ret = SimpleHtmlParser.getPlainTextAndFirstImg(rs.getString("content"));
				if(ret == null)return null;
				
				String plainText = ret.get("plainText");
				String firstImg = ret.get("firstImg");
				
				plainText = plainText.replaceAll("&nbsp;", "");
				plainText = plainText.replaceAll(" ", "");
				
				int end = 0;
				if(plainText.length()>=1){
					end = plainText.length()<ArticleDaoJdbcTemplateImpl.wordNum?plainText.length()-1:ArticleDaoJdbcTemplateImpl.wordNum-1;
				}
				
				article.setContent(plainText.substring(0, end));
				article.setFirstImg(firstImg);
			} catch (ParserException e) {
				e.printStackTrace();
			}
			
			article.setIntime(rs.getString("intime"));
			article.setCover(rs.getString("cover_url"));
			tag.setId(rs.getInt("tagId"));
			tag.setName(rs.getString("name"));
			tag.setDescription(rs.getString("description"));
			article.setTag(tag);
			return article;
		}
	}
	
	private class TagRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Tag tag = new Tag();
			tag.setId(rs.getInt("id"));
			tag.setDescription(rs.getString("description"));
			tag.setName(rs.getString("name"));
			tag.setAtHome(rs.getBoolean("is_home"));
			return tag;
		}
	}
	public int addTagToArticle(Article article, String tagName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addTagIdToArticle(Article article, int tagId) {
		String sql = "insert into ArticleTag (a_id,t_id) values(?,?)";
		return template.update(sql,new Object[]{article.getId(),tagId});
	}

	public Article getSimpleArticleById(int id) {
		String sql = "select a.id,a.title,a.content,a.cover_url,a.intime,c.id as tagId,c.name,c.description from Articles a,ArticleTag b,Tags c where a.id = b.a_id and b.t_id = c.id and a.id="+id+" limit 0,1";

		Article article = (Article)template.queryForObject(sql, new SimpleArticleRowMapper());

		return article;
	}

	public int updateSimpleArticle(Article article) {
		String sql = "update Articles set content=?,title=?,cover_url=?,intime=? where id="+article.getId();
		return template.update(sql, new Object[]{article.getContent(),article.getTitle(),article.getCover(),article.getIntime()});
	}

	public int deleteSimpleArticleTag(Article article, Tag tag) {
		String sql = "delete from ArticleTag where a_id=? and t_id=?";
		return template.update(sql, new Object[]{article.getId(),tag.getId()});
	}
	public int getMaxArticleId(){
		String sql = "select max(id) from Articles";
		//String sql = "select last_insert_id()";
		return template.queryForInt(sql);
	}

	public Map<Tag, List<Article>> getSimpleArticlesWithTagByTagIds(int[] tagIds, int num) {
		Map<Tag,List<Article>> map = new HashMap<Tag,List<Article>>();
		for(int id : tagIds){
			List<Article> articles = this.getSimpleArticlesByTagId(id, num);
			if(articles.size()<=0)continue;
			map.put(articles.get(0).getTag(), articles);
		}
		return map;
	}
	
	/**
	 * 利用一组tagId 获取一组文章摘要
	 */
	public Map<String, List<Article>> getSimpleArticleDigestsByTagIds(
			int[] tagIds, int num, int wordNum) {
		ArticleDaoJdbcTemplateImpl.wordNum = wordNum;//将所需要的digest数存在wordNum的静态变量当中，一会有用
		Map<String,List<Article>> map = new HashMap<String,List<Article>>();
		for(int id : tagIds){
			List<Article> articles = this.getSimpleArticleDigestsByTagId(id, num);
			if(articles.size()<=0)continue;
			map.put(articles.get(0).getTag().getName(), articles);
		}
		return map;
	}

	public int delArticle(int id) {
		String sql = "delete from Articles where id=?";
		return template.update(sql, new Object[]{id});
	}

}
