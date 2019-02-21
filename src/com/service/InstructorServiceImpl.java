package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Instructor;
import com.domain.PossibleSubject;
import com.persistance.InstructorDAO;

@Service("instructorService")
public class InstructorServiceImpl implements InstructorService {

	@Resource(name="instructorDAO")
	private InstructorDAO instructorDAO;
	
	@Override
	public Instructor instructorLogin(Instructor is) {
		return this.instructorDAO.instructorLogin(is);
	}
	
	@Override
	public Instructor instructorInfo(Instructor i) {
		return instructorDAO.instructorInfo(i);
	}

	@Override
	public List<Instructor> instructorList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> instructorList_adi_is_schedule(Instructor is) {
		return this.instructorDAO.instructorList_adi_is_schedule(is);
	}

	@Override
	public List<Instructor> instructorList_adi_is() {
		return this.instructorDAO.instructorList_adi_is();
	}

	@Override
	public int instructorAdd(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int instructorDelete(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int instructorUpdate(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pwChange(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Instructor> possibleSubjectList(Instructor is) {
		return this.instructorDAO.possibleSubjectList(is);
	}

	@Override
	public int possibleSubjecAdd(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int possibleSubjecDelete(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

}
