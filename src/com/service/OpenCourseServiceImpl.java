package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Instructor;
import com.domain.OpenCourse;
import com.domain.Student;
import com.persistance.OpenCourseDAO;

@Service("openCourseService")
public class OpenCourseServiceImpl implements OpenCourseService {

	@Resource(name="openCourseDAO")
	private OpenCourseDAO openCourseDAO;
	
	@Override
	public List<OpenCourse> openCourseList_st(Student s) {
		return openCourseDAO.openCourseList_st(s);
	}
	
	@Override
	public List<OpenCourse> openCourseList_st(String s, String oc) {
		return openCourseDAO.openCourseList_st(s,oc);
	}
	
	@Override
	public List<OpenCourse> openCourseList_is(Instructor i) {
		return openCourseDAO.openCourseList_is(i);
	}
	
	@Override
	public List<OpenCourse> openCourseList2_is(Instructor i) {
		return openCourseDAO.openCourseList2_is(i);
	}
	
	@Override
	public List<OpenCourse> openCourseList2_is(String i, String oc) {
		return openCourseDAO.openCourseList2_is(i,oc);
	}
	
	@Override
	public List<OpenCourse> openCourseList_adi_is_schedule(Instructor i) {
		return this.openCourseDAO.openCourseList_adi_is_schedule(i);
	}

	@Override
	public List<OpenCourse> openCourseList_adi_is_schedule(Instructor i, OpenCourse oc) {
		return this.openCourseDAO.openCourseList_adi_is_schedule(i, oc);
	}

	@Override
	public List<OpenCourse> openCourseList_adi_oc() {
		return this.openCourseDAO.openCourseList_adi_oc();
	}

	@Override
	public List<OpenCourse> openCourseList_adi_oc(OpenCourse oc) {
		return this.openCourseDAO.openCourseList_adi_oc(oc);
	}

	@Override
	public List<OpenCourse> openCourseList_adi_score() {
		return this.openCourseDAO.openCourseList_adi_score();
	}
	
	@Override
	public OpenCourse openCourseList_adi_score(OpenCourse oc) {
		return this.openCourseDAO.openCourseList_adi_score(oc);
	}
	
	@Override
	public List<OpenCourse> openCourseList_adi_score(Student s) {
		return this.openCourseDAO.openCourseList_adi_score(s);
	}

	@Override
	public OpenCourse openCourseList_adi_score(Student s, OpenCourse oc) {
		return this.openCourseDAO.openCourseList_adi_score(s, oc);
	}

}
