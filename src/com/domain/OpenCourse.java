package com.domain;

import java.sql.Date;

public class OpenCourse {
	
	//개설과정번호, 과정번호, 과정명, 강의실번호, 강의실명, 수료(중도탈락)상태
	private String open_course_id, course_id, course_name, class_id, class_name, status_;
	//개설과정 시작일, 개설과정 종료일, 수료예정(중도탈락)날짜
	private Date course_start_date, course_end_date, status_date;
	//삭제가능 여부, 강의실 정원, 개설과목수, 수강인원
	private int open_course_del, class_limit, os_count, s_count;
	
	public String getOpen_course_id() {
		return open_course_id;
	}
	public void setOpen_course_id(String open_course_id) {
		this.open_course_id = open_course_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getStatus_() {
		return status_;
	}
	public void setStatus_(String status_) {
		this.status_ = status_;
	}
	public Date getCourse_start_date() {
		return course_start_date;
	}
	public void setCourse_start_date(Date course_start_date) {
		this.course_start_date = course_start_date;
	}
	public Date getCourse_end_date() {
		return course_end_date;
	}
	public void setCourse_end_date(Date course_end_date) {
		this.course_end_date = course_end_date;
	}
	public Date getStatus_date() {
		return status_date;
	}
	public void setStatus_date(Date status_date) {
		this.status_date = status_date;
	}
	public int getOpen_course_del() {
		return open_course_del;
	}
	public void setOpen_course_del(int open_course_del) {
		this.open_course_del = open_course_del;
	}
	public int getClass_limit() {
		return class_limit;
	}
	public void setClass_limit(int class_limit) {
		this.class_limit = class_limit;
	}
	public int getOs_count() {
		return os_count;
	}
	public void setOs_count(int os_count) {
		this.os_count = os_count;
	}
	public int getS_count() {
		return s_count;
	}
	public void setS_count(int s_count) {
		this.s_count = s_count;
	}
	
}
