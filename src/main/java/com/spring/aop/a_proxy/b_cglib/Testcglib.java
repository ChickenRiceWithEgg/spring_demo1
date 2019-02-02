package com.spring.aop.a_proxy.b_cglib;

import org.junit.Test;

/**
 * 当被代理的有接口+实现类的情况
 * @author Thinkpad
 *
 */

public class Testcglib {
	
	@Test
	public void test1() {
		UserServiceImpl userService = MyBeanFactory.createUserServie();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
}
