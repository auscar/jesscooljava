package com.riseful.jesscooljava.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Util {
	public static ApplicationContext applicationContext;
	
	public static ApplicationContext getCtx(){
		if(applicationContext == null){
			applicationContext = new ClassPathXmlApplicationContext( "jesscool-beans.xml" );
		}
		return applicationContext;
	}
}
