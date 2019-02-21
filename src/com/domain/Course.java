package com.domain;

public class Course {

	//과정번호, 과정명
	private String course_Id, course_Name;
	//삭제 가능 여부
	private int courseDel;
	
	public String getCourse_Id() {
		return course_Id;
	}
	public void setCourse_Id(String course_Id) {
		this.course_Id = course_Id;
	}
	public String getCourse_Name() {
		return course_Name;
	}
	public void setCourse_Name(String course_Name) {
		this.course_Name = course_Name;
	}
	public int getCourseDel() {
		return courseDel;
	}
	public void setCourseDel(int courseDel) {
		this.courseDel = courseDel;
	}
	
	
}
