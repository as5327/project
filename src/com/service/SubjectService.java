package com.service;

import java.util.List;

import com.domain.Subject;

public interface SubjectService {

	//과목 정보 출력
	//과목번호 / 과목명 / 삭제가능여부
	public List<Subject> subjectList();

	//신규 과목 추가
	public int subjectAdd(Subject s);

	//기존 과목 삭제
	public int subjectDelete(Subject s);
	
	//과목 정보 수정
	public int subjectUpdate(Subject s);

}
