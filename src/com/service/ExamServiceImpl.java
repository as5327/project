package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Exam;
import com.domain.OpenSubject;
import com.domain.Student;
import com.persistance.ExamDAO;
@Service("examService")
public class ExamServiceImpl implements ExamService {

	@Resource(name="examDAO")
	private ExamDAO examDAO;
	
	//
	@Override
	public List<Exam> exam_student(String s, String os) {
		return examDAO.exam_student(s, os);
	}
	
	//
	@Override
	public List<Exam> exam_is(String i, String oc, String os) {
		return examDAO.exam_is(i, oc, os);
	}
	
	//
	@Override
	public List<Exam> exam2_is(String i, String oc, String os, String ex) {
		return examDAO.exam2_is(i, oc, os, ex);
	}
	
	@Override
	public List<Exam> exam_student(Student s, OpenSubject os) {
		return this.examDAO.exam_student(s, os);
	}
	
	@Override
	public List<Exam> examList_adi_score(OpenSubject os) {
		return this.examDAO.examList_adi_score(os);
	}
	
	@Override
	public Exam examList_adi_score(Exam ex) {
		return this.examDAO.examList_adi_score(ex);
	}
	

	@Override
	public List<Exam> examList_st() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> examList_is_dis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> examList_is_score() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int examAdd(Exam e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int examDelete(Exam e) {
		// TODO Auto-generated method stub
		return 0;
	}

	//신규 배점 추가
	@Override
	public int distributionAdd(Exam e) {
		return this.examDAO.distributionAdd(e);
	}
	
	//기본 배점 삭제
	@Override
	public int distributionDelete(Exam e) {
		return this.examDAO.distributionDelete(e);
	}
	
	@Override
	public int studentScoreAdd(Exam e) {
		return this.examDAO.studentScoreAdd(e);
	}

	@Override
	public int studentScoreDelete(Exam e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
