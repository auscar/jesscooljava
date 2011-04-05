package com.riseful.jesscooljava.htmlUtil;

import java.util.HashMap;
import java.util.Map;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;

public class SimpleHtmlParser {
    public static String getPlainText(String src) throws ParserException{
    	StringBuffer text = new StringBuffer();
    	if(src==null)return "";
    	Parser parser = Parser.createParser(src, "utf-8");
    	NodeList list = parser.extractAllNodesThatMatch(
    			new NodeFilter() {
					private static final long serialVersionUID = -6541958195823280889L;
					public boolean accept(Node _node) {
						return true;
					}
				}
    	);
    	for( SimpleNodeIterator it = list.elements(); it.hasMoreNodes(); ){
    		Node node = it.nextNode();
    		text.append(node.toPlainTextString());
    	}
    	return text.toString();
    }
    public static Map<String,String> getPlainTextAndFirstImg(String src) throws ParserException{
    	StringBuffer text = new StringBuffer();
    	String firstImg = "";
    	if(src==null)return null;
    	Parser parser = Parser.createParser(src, "utf-8");
    	NodeList list = parser.extractAllNodesThatMatch(
    			new NodeFilter() {
					private static final long serialVersionUID = -6541958195823280889L;
					public boolean accept(Node _node) {
						return true;
					}
				}
    	);
    	for( SimpleNodeIterator it = list.elements(); it.hasMoreNodes(); ){
    		Node node = it.nextNode();
    		if( node.toHtml().indexOf("<img")==0 && firstImg.equals("") ){
    			firstImg = node.toHtml();
    		}
    		text.append(node.toPlainTextString());
    	}
    	Map<String,String> ret = new HashMap<String,String>();
    	ret.put("plainText", text.toString());
    	ret.put("firstImg", firstImg);
    	return ret;
    }
    public static void main(String[] args){
    	try {
    		
			System.out.println(SimpleHtmlParser.getPlainText("<h2 class=\"articleTitle\"> <a href=\"/views/articleDetail.jsp\">爱意大胆穿出来 教你情侣如何着装</a> </h2> <div class=\"articleDec\"> <a href=\"/views/articleDetail.jsp\">不再含蓄，不再私密。感情的表达早已不同昔日，有情话就要大胆说出来，有爱意就要大胆穿出来。穿情侣装就是表达爱意最为时尚的方式！……</a> </div> <div class=\"articleImg\"> <a href=\"/views/articleDetail.jsp\"><img src=\"http://s.jesscool.com/imgpro/articleImg1.jpg\" /></a> <dl class=\"articleDate\"> <dt>04/02</dt><dd>2011</dd></dl></div>"));
			
		} catch (ParserException e) {
			e.printStackTrace();
		}
    	
    }

}










