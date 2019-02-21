package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.OpenCourse;
import com.domain.OpenSubject;
import com.persistance.OpenSubjectDAO;

@Service("openSubjectService")
public class OpenSubjectServiceImpl implements OpenSubjectService {

	@Resource(name="openSubjectDAO")
	private OpenSubjectDAO openSubjectDAO;
	
	@Override
	public List<OpenSubject> openSubjectList_student(String s, String oc) {
		return openSubjectDAO.openSubjectList_student(s, oc);
	}
	
	@Override
	public List<OpenSubject> openSubjectList_student(String s, String oc,String os) {
		return openSubjectDAO.openSubjectList_student(s, oc,os);
	}
	
	@Override
	public List<OpenSubject> openSubjectList2_is(String i, String oc) {
		return openSubjectDAO.openSubjectList2_is(i, oc);
	}
	
	@Override
	public List<OpenSubject> openSubjectList2_is(String i, String oc, String os) {
		return openSubjectDAO.openSubjectList2_is(i, oc, os);
	}

	@Override
	public List<OpenSubject> openSubjectList_adi_is_schedule(OpenSubject os) {
		return this.openSubjectDAO.openSubjectList_adi_is_schedule(os);
	}

	@Override
	public List<OpenSubject> openSubjectList_adi_os(OpenSubject os) {
		return this.openSubjectDAO.openSubjectList_adi_os(os);
	}

	@Override
	public List<OpenSubject> openSubjectList_adi_score(OpenCourse oc) {
		return this.openSubjectDAO.openSubjectList_adi_score(oc);
	}

	@Override
	public OpenSubject openSubjectList_adi_score_1(OpenSubject os) {
		return this.openSubjectDAO.openSubjectList_adi_score_1(os);
	}

	@Override
	public List<OpenSubject> openSubjectList_adi_score_subject(OpenCourse oc) {
		return this.openSubjectDAO.openSubjectList_adi_score_subject(oc);
	}

	@Override
	public OpenSubject openSubjectList_adi_score_subject(OpenSubject os) {
		return this.openSubjectDAO.openSubjectList_adi_score_subject(os);
	}

}
