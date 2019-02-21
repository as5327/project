package com.domain;

public class Classroom {
	
	//강의실번호, 강의실명
	private String class_Id, class_Name;
	//강의실 정원, 삭제가능여부
	private int class_limit, classDel;
	
	public String getClass_Id() {
		return class_Id;
	}
	public void setClass_Id(String class_Id) {
		this.class_Id = class_Id;
	}
	public String getClass_Name() {
		return class_Name;
	}
	public void setClass_Name(String class_Name) {
		this.class_Name = class_Name;
	}
	public int getClass_limit() {
		return class_limit;
	}
	public void setClass_limit(int class_limit) {
		this.class_limit = class_limit;
	}
	public int getClassDel() {
		return classDel;
	}
	public void setClassDel(int classDel) {
		this.classDel = classDel;
	}
	
	
	
}
