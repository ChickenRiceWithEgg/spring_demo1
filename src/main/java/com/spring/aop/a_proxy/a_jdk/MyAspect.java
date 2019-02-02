package com.spring.aop.a_proxy.a_jdk;

/*
 * 切面类，用来放通知/增强方法的
 */
public class MyAspect {
	
	public void before() {
		System.out.println("鸡首");
	}
	
	public void after() {
		System.out.println("牛后");
	}
}
