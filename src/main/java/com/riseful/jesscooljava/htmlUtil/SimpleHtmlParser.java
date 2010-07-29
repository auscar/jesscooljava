package com.riseful.jesscooljava.htmlUtil;

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
					public boolean accept(Node arg0) {
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

}










