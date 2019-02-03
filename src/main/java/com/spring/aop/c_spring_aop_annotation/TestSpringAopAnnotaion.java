package com.spring.aop.c_spring_aop_annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 当被代理的有接口+实现类的情况
 * @author Thinkpad
 *
 */

public class TestSpringAopAnnotaion {
	
	@Test
	public void test1() {
		String xmlPath = "com/spring/aop/c_spring_aop_annotation/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//获得目标类
		UserService userService = (UserService)applicationContext.getBean("userServiceImpl");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
}
