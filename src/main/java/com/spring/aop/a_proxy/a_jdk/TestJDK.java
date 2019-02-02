package com.spring.aop.a_proxy.a_jdk;

import org.junit.Test;

/**
 * 当被代理的有接口+实现类的情况
 * @author Thinkpad
 *
 */

public class TestJDK {
	
	@Test
	public void test1() {
		UserService userService = MyBeanFactory.createUserServie();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
}
