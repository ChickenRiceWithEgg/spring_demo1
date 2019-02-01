package com.spring.a_ioc;

import org.junit.Test;
//import com.spring.a_ioc.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpleTest {
	
	@Test
	public void demo01() {
		//之前开发
		UserServiceImpl userService = new UserServiceImpl();
		userService.addUser();
	}
	
	@Test
	public void demo2() {
		//从spring容器中获得
		//1、获得容器
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//2、获得内容
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
	}
}
