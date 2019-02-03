package com.spring.aop.c_spring_aop_annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面类，用来放通知/增强方法的。
 * 需要实现不同的接口，接口就是规范，从而就确定了方法的名称。
 * 采用环绕通知
 */

@Component
@Aspect
public class MyAspect{

	@Pointcut("execution(* com.spring.aop.c_spring_aop_annotation.UserServiceImpl.*(..))")
	public void aspect(){}
	
	//前执行
	@Before("aspect()")
	public void before() {
		System.out.println("前执行");
	}

	//后执行
	@After("aspect()")
	public void after() {
		System.out.println("后执行");
	}
}
