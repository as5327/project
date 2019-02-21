package com.persistance;

import java.util.List;

import com.domain.Instructor;
import com.domain.OpenCourse;
import com.domain.Student;

public interface OpenCourseDAO {

	//개설 과정 정보 출력
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명/수료(중도포기) 상태/수료(중도포기) 날짜
	public List<OpenCourse> openCourseList_st(Student s);
	public List<OpenCourse> openCourseList_st(String s, String oc);
	
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명/수강인원
	//강의예정,강의중,강의종료,조건없음 네가지 구분하는 로직
	public List<OpenCourse> openCourseList_is(Instructor i);
	
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명/수강인원
	public List<OpenCourse> openCourseList2_is(Instructor i);
	public List<OpenCourse> openCourseList2_is(String i, String oc);
	
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명/수강인원/개설과목등록수
	public List<OpenCourse> openCourseList_adi_is_schedule(Instructor i);
	
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명/수강인원
	public List<OpenCourse> openCourseList_adi_is_schedule(Instructor i, OpenCourse oc);
	
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명/개설과목등록수/수강인원
	public List<OpenCourse> openCourseList_adi_oc();
	
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명/개설과목등록수/수강인원
	public List<OpenCourse> openCourseList_adi_oc(OpenCourse oc);
	
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명(관리자>성적>개설과목별)
	public List<OpenCourse> openCourseList_adi_score();
	
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명(관리자>성적>개설과목별)
	public OpenCourse openCourseList_adi_score(OpenCourse oc);
	
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명(관리자>성적>수강생별)
	public List<OpenCourse> openCourseList_adi_score(Student s);
	
	//개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실명(관리자>성적>수강생별)
	public OpenCourse openCourseList_adi_score(Student s, OpenCourse oc);
	
	//신규 개설과정 추가
	public int openCourseAdd(OpenCourse oc);

	//기존 개설과정 삭제
	public int openCourseDelete(OpenCourse oc);
	
	//개설과정 정보 수정
	public int openCourseUpdate(OpenCourse oc);

}
