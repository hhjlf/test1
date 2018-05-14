package com.springbook.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	
	public static void main(String[]ar) {
		AbstractApplicationContext d = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService) d.getBean("userServiceInpl");
		
	UserVo vo = new UserVo();
	vo.setId("test");
	vo.setPass("test123");
	UserVo user = userService.getUser(vo);
	
	if(user != null) {
		System.out.println(user.getName()+"¥‘»≠≥Á");
	}else {
		System.out.println("Ω«∆–");
	}
	
	d.close();
		
	}

}
