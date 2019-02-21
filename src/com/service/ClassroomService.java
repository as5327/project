package com.service;

import java.util.List;

import com.domain.Classroom;

public interface ClassroomService {

	//강의실 정보 출력
	//강의실번호 / 강의실명 / 정원 / 삭제가능여부
	public List<Classroom> classroomList();

	//신규 강의실 추가
	public int classroomAdd(Classroom c);

	//기존 강의실 삭제
	public int classroomDelete(Classroom c);
	
	//강의실 정보 수정
	public int classroomUpdate(Classroom c);
}
