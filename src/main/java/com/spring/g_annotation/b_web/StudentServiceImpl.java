package com.spring.g_annotation.b_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	/**
	 * @param studentDao
	 * 也可以在setter方法上使用注解，来注入引用类型变量
	 */
	@Autowired
	@Qualifier("studentDaoId")
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void addStudent() {
		studentDao.save();
	}
	
}
