package com.domain;

import java.sql.Date;

public class Student {
	
	//수강생성적번호, 수강생번호, 수강생명, 연락처, 패스워드, 사진명, 새 패스워드, 수료(중도탈락)상태
	private String student_score_id, student_id, student_name, student_phone, student_pw, student_pic, student_newPw, status_;
	//등록일, 수료예정(중도탈락)날짜
	private Date student_regDate, end_date;
	//삭제 가능 여부, 수강횟수
	private int student_del, student_count;
	//출결점수, 필기점수, 실기점수, 총 점수, 삭제여부
	private int attendance_score, written_score, performance_score, total_score, score_del;
	
	public String getStudent_score_id() {
		return student_score_id;
	}
	public void setStudent_score_id(String student_score_id) {
		this.student_score_id = student_score_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	public String getStudent_pw() {
		return student_pw;
	}
	public void setStudent_pw(String student_pw) {
		this.student_pw = student_pw;
	}
	public String getStudent_pic() {
		return student_pic;
	}
	public void setStudent_pic(String student_pic) {
		this.student_pic = student_pic;
	}
	public String getStudent_newPw() {
		return student_newPw;
	}
	public void setStudent_newPw(String student_newPw) {
		this.student_newPw = student_newPw;
	}
	public String getStatus_() {
		return status_;
	}
	public void setStatus_(String status_) {
		this.status_ = status_;
	}
	public Date getStudent_regDate() {
		return student_regDate;
	}
	public void setStudent_regDate(Date student_regDate) {
		this.student_regDate = student_regDate;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getStudent_del() {
		return student_del;
	}
	public void setStudent_del(int student_del) {
		this.student_del = student_del;
	}
	public int getStudent_count() {
		return student_count;
	}
	public void setStudent_count(int student_count) {
		this.student_count = student_count;
	}
	public int getAttendance_score() {
		return attendance_score;
	}
	public void setAttendance_score(int attendance_score) {
		this.attendance_score = attendance_score;
	}
	public int getWritten_score() {
		return written_score;
	}
	public void setWritten_score(int written_score) {
		this.written_score = written_score;
	}
	public int getPerformance_score() {
		return performance_score;
	}
	public void setPerformance_score(int performance_score) {
		this.performance_score = performance_score;
	}
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public int getScore_del() {
		return score_del;
	}
	public void setScore_del(int score_del) {
		this.score_del = score_del;
	}

}
