package com.pjh.exam01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class Tvuser {


	public static void main(String[]ar) {
		
		/*Resource resource = 
				new ClassPathResource("applicationContext.xml");*/
		
		
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		
	
	TV tv2 = (TV) factory.getBean("tv");
		/*TV tv = (TV) factory.getBean("tv");
		
		tv.on();
		tv2.on();
		
		tv.off();
		tv.off();*/
		
	}
}
