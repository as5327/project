package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Exam;
import com.domain.Student;
import com.persistance.StudentDAO;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource(name="studentDAO")
	private StudentDAO studentDAO;
	
	@Override
	public Student studentlogin(Student s) {
		return studentDAO.studentLogin(s);
	}

	@Override
	public Student studentInfo(Student s) {
		return studentDAO.studentinfo(s);
	}
	
	@Override
	public List<Student> slist() {
		return this.studentDAO.slist();
	}
	
	@Override
	public Student studentinfo_adi_score(Student s) {
		return this.studentDAO.studentinfo_adi_score(s);
	}
	
	//수강생번호/수강생명/연락처/수료-중도탈락여부/수료-중도탈락날짜/출결점수/필기점수/실기점수/총점/삭제가능여부
	@Override
	public List<Student> studentList2_is_score(String i, String oc, String os) {
		return this.studentDAO.studentList2_is_score(i, oc, os);
	}

	@Override
	public List<Student> studentList_adi_score(Exam ex) {
		return this.studentDAO.studentList_adi_score(ex);
	}
	
	// 수강생 입력.
	@Override
	public int studentAdd(Student s) {
		// TODO Auto-generated method stub
		return this.studentDAO.studentAdd(s);
	}

	// 수강생 삭제.
	@Override
	public int studentDelete(Student s) {
		// TODO Auto-generated method stub
		return this.studentDAO.studentDelete(s);
	}

	@Override
	public int studentUpdate(Student s) {
		// TODO Auto-generated method stub
		return this.studentDAO.studentUpdate(s);
	}


}
