package com.spring.g_annotation.b_web;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotationIoC {

	@Test
	public void test() {
		String xmlPath = "com/spring/g_annotation/b_web/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		StudentAction studentAction = (StudentAction)applicationContext.getBean("studentActionId");
		studentAction.execute();
	}
}
