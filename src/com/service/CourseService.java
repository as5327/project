package com.service;

import java.util.List;

import com.domain.Course;

public interface CourseService {

	//과정 정보 출력
	//과정번호 / 과정명 / 삭제가능여부
	public List<Course> courseList();

	//신규 과정 추가
	public int courseAdd(Course c);

	//기존 과정 삭제
	public int courseDelete(Course c);
	
	//과정 정보 수정
	public int courseUpdate(Course c);
}
