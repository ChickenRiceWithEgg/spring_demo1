package com.spring.aop.c_spring_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 当被代理的有接口+实现类的情况
 * @author Thinkpad
 *
 */

public class TestSpringAop {
	
	@Test
	public void test1() {
		String xmlPath = "com/spring/aop/c_spring_aop/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//获得目标类
		UserService userService = (UserService)applicationContext.getBean("userServiceId");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
}
