package com.spring.aop.a_proxy.a_jdk;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

/**
 * 当被代理的有接口(UserService)+实现类(UserServiceImpl)时。使用jdk动态代理
 * @author Thinkpad
 *
 */

public class MyBeanFactory {

	public static UserService createUserServie() {
		//1、目标类
		final UserService userService = new UserServiceImpl();
		
		//2、切面类
		final MyAspect myAspect = new MyAspect();
		
		//3、代理类：将目标类（切入点）和切面类（通知）结合 ——> 得到切面
		/*
		 * Proxy.newProxyInstance
		 * 		参数1：loader，类加载器，动态代理类运行时创建，任何类都需要类加载器将其加载到内存
		 * 			一般情况：当前类.class.getClassLoader();
		 * 					目标类实例.getClass().getClassLoader();
		 * 		参数2：Class[] interfaces 代理类需要实现的所有接口
		 * 			方式1：目标类实例.getClass().getInterfaces();注意，只能获得自己接口，不能获得父元素接口
		 * 			方式2：new Class[]{UserService.class}
		 * 			例如：jdbc驱动 --> DriverManager  获得接口Connection
		 * 		参数3：InvocationHandler  处理类，接口，必须进行实现类，一般采用匿名内部类
		 * 			提供invoke方法，代理类 的每一个方法执行时，都将调用一次invoke
		 * 			参数31：Object proxy：代理对象  
		 * 			参数32：Method method：代理对象当前执行方法的描述对象（反射）
		 * 				执行方法名：method.getName()
		 * 				执行方法：method.invoke(对象，实际参数)
		 * 			参数33：Object[] args：方法实际参数
		 */
		
		
		UserService proxyService = (UserService)Proxy.newProxyInstance(
									MyBeanFactory.class.getClassLoader(),  	  //一个ClassLoader对象，用来定义由哪个ClassLoader对象来对生成的代理对象进行加载
									userService.getClass().getInterfaces(),   //一个Interface对象的数组，用来定义为代理对象提供一组接口，这样代理对象就可以实现这些接口（多态），这样就可以调用这组接口中的方法了
									new InvocationHandler() {                 //一个InvocationHandler对象，用来表示代理对象在调用方法时，会关联到哪个InocationHandler对象
										//proxy：指代我们所代理的那个真实的对象
										//method：指代proxy中某个方法的Method对象
										//args：指代method中方法的具体参数
										@Override
										public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
											//前执行
											myAspect.before();
											
											//执行目标类方法
											Object obj = method.invoke(userService,args);
											
											//后执行
											myAspect.after();
											
											return obj;
										}
									});
		
		return proxyService;
	}
	
}
