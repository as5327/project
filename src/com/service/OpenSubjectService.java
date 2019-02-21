package com.service;

import java.util.List;

import com.domain.OpenCourse;
import com.domain.OpenSubject;

public interface OpenSubjectService {

	public List<OpenSubject> openSubjectList_student(String s, String oc);
	public List<OpenSubject> openSubjectList_student(String s, String oc,String os);	
	public List<OpenSubject> openSubjectList2_is(String i, String oc);
	public List<OpenSubject> openSubjectList2_is(String i, String oc, String os);
	
	//개설과목번호/개설과목명/개설과목시작일/개설과목종료일/교재명/ISBN
	public List<OpenSubject> openSubjectList_adi_is_schedule(OpenSubject os);
	
	//개설과목번호/개설과목명/개설과목시작일/개설과목종료일/교재명/ISBN/강사명/강사사진/삭제가능여부
	public List<OpenSubject> openSubjectList_adi_os(OpenSubject os);
	
	//개설과목번호/개설과목명/개설과목시작일/개설과목종료일/강사명/강사사진(관리자>성적>수강생별)
	public List<OpenSubject> openSubjectList_adi_score(OpenCourse oc);
	
	//개설과목번호/개설과목명/개설과목시작일/개설과목종료일/강사명/강사사진(관리자>성적>수강생별)
	public OpenSubject openSubjectList_adi_score_1(OpenSubject os);
	
	//개설과목번호/개설과목명/개설과목시작일/개설과목종료일/교재명/ISBN/강사명/강사사진(관리자>성적>개설과목별)
	public List<OpenSubject> openSubjectList_adi_score_subject(OpenCourse oc);
	
	//개설과목번호/개설과목명/개설과목시작일/개설과목종료일/교재명/ISBN/강사명/강사사진(관리자>성적>개설과목별)
	public OpenSubject openSubjectList_adi_score_subject(OpenSubject os);
}
