package com.spring.aop.c_spring_aop_annotation;

import org.springframework.stereotype.Component;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("b_factory_bean addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("b_factory_bean updateUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("b_factory_bean deleteUser");
	}

}
