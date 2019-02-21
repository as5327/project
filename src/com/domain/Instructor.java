package com.domain;

import java.sql.Date;

public class Instructor {

	//강사번호, 강사명, 연락처, 패스워드, 사진명, 새 패스워드, 과목번호, 과목명
	private String instructor_Id, instructor_Name, instructor_Phone, instructor_pw, instructor_pic, instructor_newPw
				, subject_id, subject_name;
	//등록일
	private Date instructor_regDate;
	//삭제가능여부 , 강의가능과목표시, 강의스케줄 갯수, 강의가능과목 갯수
	private int instructorDel, checked, schedule_count, possible_count;
	
	
	public int getSchedule_count() {
		return schedule_count;
	}
	public void setSchedule_count(int schedule_count) {
		this.schedule_count = schedule_count;
	}
	public int getPossible_count() {
		return possible_count;
	}
	public void setPossible_count(int possible_count) {
		this.possible_count = possible_count;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public String getInstructor_Id() {
		return instructor_Id;
	}
	public void setInstructor_Id(String instructor_Id) {
		this.instructor_Id = instructor_Id;
	}
	public String getInstructor_Name() {
		return instructor_Name;
	}
	public void setInstructor_Name(String instructor_Name) {
		this.instructor_Name = instructor_Name;
	}
	public String getInstructor_Phone() {
		return instructor_Phone;
	}
	public void setInstructor_Phone(String instructor_Phone) {
		this.instructor_Phone = instructor_Phone;
	}
	public String getInstructor_pw() {
		return instructor_pw;
	}
	public void setInstructor_pw(String instructor_pw) {
		this.instructor_pw = instructor_pw;
	}
	public String getInstructor_pic() {
		return instructor_pic;
	}
	public void setInstructor_pic(String instructor_pic) {
		this.instructor_pic = instructor_pic;
	}
	public String getInstructor_newPw() {
		return instructor_newPw;
	}
	public void setInstructor_newPw(String instructor_newPw) {
		this.instructor_newPw = instructor_newPw;
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
	public Date getInstructor_regDate() {
		return instructor_regDate;
	}
	public void setInstructor_regDate(Date instructor_regDate) {
		this.instructor_regDate = instructor_regDate;
	}
	public int getInstructorDel() {
		return instructorDel;
	}
	public void setInstructorDel(int instructorDel) {
		this.instructorDel = instructorDel;
	}
	
}
