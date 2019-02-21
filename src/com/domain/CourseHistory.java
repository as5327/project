package com.domain;

import java.sql.Date;

public class CourseHistory {
	
	//개설과정번호, 수강생번호
	private String openCourse_Id, student_Id;
	//중도탈락날짜
	private Date fail_date;

	
	public Date getFail_date() {
		return fail_date;
	}

	public void setFail_date(Date fail_date) {
		this.fail_date = fail_date;
	}

	public String getOpenCourse_Id() {
		return openCourse_Id;
	}

	public void setOpenCourse_Id(String openCourse_Id) {
		this.openCourse_Id = openCourse_Id;
	}

	public String getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(String student_Id) {
		this.student_Id = student_Id;
	}
	
}
