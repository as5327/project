package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Book;
import com.persistance.BookDAO;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Resource(name="bookDAO")
	private BookDAO bookDAO;
	
	@Override
	public List<Book> bookList() {
		return this.bookDAO.bookList();
	}

	@Override
	public int bookAdd(Book b) {
		return this.bookDAO.bookAdd(b);
	}

	@Override
	public int bookDelete(Book b) {
		return this.bookDAO.bookDelete(b);
	}

	@Override
	public int bookUpdate(Book b) {
		return this.bookDAO.bookUpdate(b);
	}

}
