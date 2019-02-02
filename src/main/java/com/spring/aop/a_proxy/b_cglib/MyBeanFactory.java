package com.spring.aop.a_proxy.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 当被代理的只有实现类(UserServiceImpl)时。使用字节码增强框架cglib
 * 在运行时创建目标类的子类，从而对目标类进行增强 
 * @author Thinkpad
 *
 */

public class MyBeanFactory {

	public static UserServiceImpl createUserServie() {
		//1、目标类
		final UserServiceImpl userService = new UserServiceImpl();
		
		//2、切面类
		final MyAspect myAspect = new MyAspect();
		
		//3、代理类：使用cglib，底层创建目标类的子类
		//3.1核心类
		Enhancer enhancer = new Enhancer();
		//3.2确定父类
		enhancer.setSuperclass(userService.getClass());
		//3.3设置回调函数
		/*
		 * MethodInterceptor接口等效于jdk中的InvocationHandler接口
		 * intercept方法等效jdk中的invoke方法
		 * 			参数1、2、3和invoke中作用一样
		 * 			参数4：方法的代理
		 */
		enhancer.setCallback(new MethodInterceptor(){
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				
				//前执行方法
				myAspect.before();
				
				//执行目标类中的方法
				Object obj = method.invoke(userService, args);
				
				//后执行方法
				myAspect.after();
				
				return obj;
			}});
		//3.4创建代理
		UserServiceImpl proxyService = (UserServiceImpl)enhancer.create();
		return proxyService;
	}
	
}
