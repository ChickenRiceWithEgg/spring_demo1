package com.spring.b_di;

public class BookDaoImpl implements BookDao{
	
	@Override
	public void addBook() {
		System.out.println("di add book");
	}
	
}
