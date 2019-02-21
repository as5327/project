package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Book;

@Repository("bookDAO")
public class BookDAOImple implements BookDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbctemplate;
	
	@Override
	public List<Book> bookList() {
		String sql = "SELECT book_ID, book_Name, ISBN_Number\r\n" + 
				"	, (SELECT COUNT(*) \r\n" + 
				"		FROM open_subject os\r\n" + 
				"        WHERE os.book_id = b.book_id) bookDel\r\n" + 
				"	FROM book b\r\n" + 
				"    ORDER BY book_ID";
		
		return this.jdbctemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
	}

	@Override
	public int bookAdd(Book b) {
		String sql = "INSERT INTO book (book_ID, book_Name, ISBN_Number)\r\n" + 
				"	VALUES ((SELECT CONCAT('BO', LPAD(IFNULL(SUBSTR(MAX(book_ID), 3), 0) + 1, 3, 0)) AS book_ID FROM book b)\r\n" + 
				"		, ?, ?);";
		return this.jdbctemplate.update(sql, b.getBook_Name(), b.getIsbn_Number());
	}

	@Override
	public int bookDelete(Book b) {
		String sql = "DELETE FROM book\r\n" + 
				"    WHERE book_ID=?";
		return this.jdbctemplate.update(sql, b.getBook_Id());
	}

	@Override
	public int bookUpdate(Book b) {
		String sql = "UPDATE book \r\n" + 
				"	SET book_Name=?\r\n" + 
				"		, isbn_number=?\r\n" + 
				"	WHERE book_ID=?";
		return this.jdbctemplate.update(sql, b.getBook_Name(), b.getIsbn_Number(), b.getBook_Id());
	}

}
