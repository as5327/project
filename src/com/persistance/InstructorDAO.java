package com.persistance;

import java.util.List;

import com.domain.Instructor;

public interface InstructorDAO {

	//강사 로그인
	public Instructor instructorLogin(Instructor is);
	public Instructor instructorInfo(Instructor is);
	
	//강사 정보 출력
	//강사명/강사사진/연락처/등록일
	public List<Instructor> instructorList();
	
	//강사번호/강사명/강사사진/연락처/등록일
	public List<Instructor> instructorList_adi_is_schedule(Instructor is);
	
	//강사번호/강사명/강사사진/연락처/등록일/강의스케줄갯수/강의가능과목갯수/삭제가능여부
	public List<Instructor> instructorList_adi_is();

	//신규 강사 추가
	public int instructorAdd(Instructor is);
	
	//기존 강사 삭제
	public int instructorDelete(Instructor is);
	
	//강사 정보 수정
	public int instructorUpdate(Instructor is);

	//강사(본인) 패스워드 변경
	public int pwChange(Instructor is);
	
	//강의 가능 과목 출력
	public List<Instructor> possibleSubjectList(Instructor is);

	//신규 강의 가능 과목 추가
	public int possibleSubjecAdd(Instructor is);

	//기존 강의 가능 과목 삭제
	public int possibleSubjecDelete(Instructor is);

}
