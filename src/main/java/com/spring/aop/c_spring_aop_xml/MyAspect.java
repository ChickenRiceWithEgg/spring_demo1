package com.spring.aop.c_spring_aop_xml;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
 * 切面类，用来放通知/增强方法的。
 * 需要实现不同的接口，接口就是规范，从而就确定了方法的名称。
 * 采用环绕通知
 */
public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		//前执行
		System.out.println("前执行");
		
		//手动执行目标方法
		Object obj = mi.proceed();

		//后执行
		System.out.println("后执行");
		
		
		return obj;
	}
	
}
