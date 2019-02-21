package com.persistance;

import java.util.List;

import com.domain.Exam;
import com.domain.OpenSubject;
import com.domain.Student;

public interface ExamDAO {

	//시험 정보 출력
	//시험 문제/시험 날짜/출결(점수/배점)/필기(점수/배점)/실기(점수/배점)/총점(점수/배점)
	public List<Exam> exam_student(String s, String os);
	public List<Exam> examList_st();
	
	//시험번호/시험문제/시험날짜/출결배점/필기배점/실기배점
	public List<Exam> exam_is(String i, String oc, String os);
	public List<Exam> exam2_is(String i, String oc, String os, String ex);
	
	//시험번호/시험문제/시험날짜/출결배점/필기배점/실기배점/삭제가능여부
	public List<Exam> examList_is_dis();
	
	//시험번호/시험문제/시험날짜/출결배점/필기배점/실기배점
	public List<Exam> examList_is_score();
	
	//(관리자>성적>수강생별)
	//시험 문제/시험 날짜/출결(점수/배점)/필기(점수/배점)/실기(점수/배점)/총점(점수/배점)
	public List<Exam> exam_student(Student s, OpenSubject os);
	
	//(관리자>성적>개설과목별)
	//시험번호/시험문제/시험날짜/출결배점/필기배점/실기배점
	public List<Exam> examList_adi_score(OpenSubject os);
	
	//(관리자>성적>개설과목별)
	//시험번호/시험문제/시험날짜/출결배점/필기배점/실기배점
	public Exam examList_adi_score(Exam ex);
	
	//신규 시험 추가
	public int examAdd(Exam e);

	//기존 시험 삭제
	public int examDelete(Exam e);
	
	//신규 배점 추가
	public int distributionAdd(Exam e);

	//기본 배점 삭제
	public int distributionDelete(Exam e);
	
	//신규 수강생 성적 추가
	public int studentScoreAdd(Exam e);

	//기존 수강생 성적 삭제
	public int studentScoreDelete(Exam e);

}
