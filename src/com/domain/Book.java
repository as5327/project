package com.domain;

public class Book {

	//교재번호, 교재명, ISBN 번호
	private String book_Id, book_Name, isbn_Number;
	//삭제가능여부
	private int bookDel;
	
	public String getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(String book_Id) {
		this.book_Id = book_Id;
	}
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public String getIsbn_Number() {
		return isbn_Number;
	}
	public void setIsbn_Number(String isbn_Number) {
		this.isbn_Number = isbn_Number;
	}
	public int getBookDel() {
		return bookDel;
	}
	public void setBookDel(int bookDel) {
		this.bookDel = bookDel;
	}
	
	
}
