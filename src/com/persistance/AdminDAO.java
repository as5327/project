package com.persistance;

import java.util.List;

import com.domain.Admin;
import com.domain.GraphOnly;
import com.domain.OpenCourse;

public interface AdminDAO {

	//관리자 로그인
	public Admin adminLogin(Admin a);
	
	//관리자 명단 출력
	//관리자명 / 연락처 / 등록일
	public Admin adminList(Admin a);
	
	//등급 / 아이디 / 관리자명 / 연락처 / 등록일 / 계정 잠금 상태
	public List<Admin> adminList_master();

	//관리자 추가
	public int adminAdd(Admin a);

	//관리자(본인) 패스워드 변경
	public int pwChange(Admin a);

	//관리자 패스워드 초기화
	public int pwReset(Admin a);
	
	//계정 잠금 변경
	public int lockUpdate(Admin a);
	
	//메인 화면 그래프
	public List<GraphOnly> adminGraph();
	
	//메인 화면 대쉬보드
	public List<OpenCourse> adminDash();
}
