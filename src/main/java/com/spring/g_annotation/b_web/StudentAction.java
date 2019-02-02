package com.spring.g_annotation.b_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("studentActionId")
public class StudentAction {

	/**
	 * 注入时可以直接在引用类型属性上通过@Autowired
	 */
	@Autowired
	private StudentService studentService;
	
	public void execute() {
		studentService.addStudent();
	}

}
