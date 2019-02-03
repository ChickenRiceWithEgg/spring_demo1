package com.spring.aop.b_factory_bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 当被代理的有接口+实现类的情况
 * @author Thinkpad
 *
 */

public class TestFactoryBean {
	
	@Test
	public void test1() {
		String xmlPath = "com/spring/aop/b_factory_bean/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//在AOP中，从bean工厂中要获得的是原始类的代理类
		UserService userService = (UserService)applicationContext.getBean("proxyServiceId");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
}
