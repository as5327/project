package com.persistance;

import java.util.List;

import com.domain.Exam;
import com.domain.Student;

public interface StudentDAO {

	//수강생 로그인
	public Student studentLogin(Student s);
	
	public Student studentinfo(Student s);
	
	
	//수강생 정보 출력
	//수강생명/수강생 사진/연락처/등록일/수강횟수
	public List<Student> studentList();
	
	//수강생명/수강생 사진/연락처/수료(중도포기)상태/수료(중도포기)날짜
	public List<Student> studentList_is();
	
	//수강생번호/수강생명/수강생 사진/연락처/수료(중도포기)상태/수료(중도포기)날짜/출결점수/필기점수/실기점수/총점/삭제가능여부
	public List<Student> studentList_is_score();
	
	//수강생번호/수강생명/연락처/수료-중도탈락여부/수료-중도탈락날짜/출결점수/필기점수/실기점수/총점/삭제가능여부
	public List<Student> studentList2_is_score(String i, String oc, String os);
	
	//수강생번호/수강생명/수강생 사진/연락처/등록일/수강횟수/삭제가능여부
	public List<Student> studentList_adi_st();
	
	//수강생번호/수강생명/수강생 사진/연락처/등록일/수강횟수
	public List<Student> studentList_adi_st_2();
	
	//수강생번호/수강생명/연락처/등록일/수강횟수
	public List<Student> slist();
	
	//수강생번호/수강생명/연락처/등록일/수강횟수	
	public Student studentinfo_adi_score(Student s);
	
	//(관리자>성적>개설과정별)
	//수강생번호/수강생명/수강생 사진/연락처/등록일/출결점수/필기점수/실기점수/총점
	public List<Student> studentList_adi_score(Exam ex);
	
	//신규 수강생 추가
	public int studentAdd(Student s);

	//기존 수강생 삭제
	public int studentDelete(Student s);
	
	//수강생 정보 수정
	public int studentUpdate(Student s);
	
	//수강생(본인) 패스워드 변경
	public int pwChange(Student s);

}
