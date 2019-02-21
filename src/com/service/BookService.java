package com.service;

import java.util.List;

import com.domain.Book;

public interface BookService {

	//교재 정보 출력
	//교재번호 / 교재명 / ISBN / 삭제가능여부
	public List<Book> bookList();

	//신규 교재 추가
	public int bookAdd(Book b);

	//기존 교재 삭제
	public int bookDelete(Book b);
	
	//교재 정보 수정
	public int bookUpdate(Book b);
}
