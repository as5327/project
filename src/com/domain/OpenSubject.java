package com.domain;

import java.sql.Date;

public class OpenSubject {

	//개설과목번호, 개설과정번호, 과목번호, 과목명, 교재번호, 교재명, 강사번호, 강사명, 강사사진명, ISBN 
	private String open_subject_id, open_course_id, subject_id, subject_name
		, book_id, book_name, instructor_id, instructor_name, instructor_pic, isbn_number;
	//개설과목시작일, 개설과목종료일
	private Date subject_start_date, subject_end_date;
	//삭제가능 여부
	private int open_subject_del;
	
	public String getOpen_subject_id() {
		return open_subject_id;
	}
	public void setOpen_subject_id(String open_subject_id) {
		this.open_subject_id = open_subject_id;
	}
	public String getOpen_course_id() {
		return open_course_id;
	}
	public void setOpen_course_id(String open_course_id) {
		this.open_course_id = open_course_id;
	}
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(String instructor_id) {
		this.instructor_id = instructor_id;
	}
	public String getInstructor_name() {
		return instructor_name;
	}
	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}
	public String getInstructor_pic() {
		return instructor_pic;
	}
	public void setInsturctor_pic(String instructor_pic) {
		this.instructor_pic = instructor_pic;
	}
	public Date getSubject_start_date() {
		return subject_start_date;
	}
	public void setSubject_start_date(Date subject_start_date) {
		this.subject_start_date = subject_start_date;
	}
	public Date getSubject_end_date() {
		return subject_end_date;
	}
	public void setSubject_end_date(Date subject_end_date) {
		this.subject_end_date = subject_end_date;
	}
	public int getOpen_subject_del() {
		return open_subject_del;
	}
	public void setOpen_subject_del(int open_subject_del) {
		this.open_subject_del = open_subject_del;
	}
	public String getIsbn_number() {
		return isbn_number;
	}
	public void setIsbn_number(String isbn_number) {
		this.isbn_number = isbn_number;
	}
	
}
