package com.spring.b_di;

public class BookServiceImpl implements BookService {

	//方式1：没用DI之前，接口=实现类
	//private BookDao bookDao = new BookDaoImpl();
	
	//方式2：使用DI，接口+setter
	private BookDao bookDao;

	@Override
	public void addBook() {
		this.bookDao.addBook();
	}

	public BookDao getBookDao() {
		return bookDao;
	}
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
