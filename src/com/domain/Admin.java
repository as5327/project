package com.domain;

import java.sql.Date;

public class Admin {
	//관리자아이디, 관리자명, 연락처, 패스워드, 새 패스워드
	private String admin_id, admin_name, admin_phone, admin_pw, admin_newPw;
	//등록일
	private Date regDate;
	//잠금여부, 등급
	private int locking, grade;
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_phone() {
		return admin_phone;
	}
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	public String getAdmin_pw() {
		return admin_pw;
	}
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	public String getAdmin_newPw() {
		return admin_newPw;
	}
	public void setAdmin_newPw(String admin_newPw) {
		this.admin_newPw = admin_newPw;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getLocking() {
		return locking;
	}
	public void setLocking(int locking) {
		this.locking = locking;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
}
