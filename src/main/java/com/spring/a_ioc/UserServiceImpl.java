package com.spring.a_ioc;

import com.spring.a_ioc.UserService;


/**
 * @author Thinkpad
 *
 */
public class UserServiceImpl implements UserService{

	@Override
	public void addUser() {
		System.out.println("a_ioc add user");
	}
	
}
