package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Subject;
import com.persistance.SubjectDAO;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	@Resource(name="subjectDAO")
	private SubjectDAO subjectDAO;
	
	@Override
	public List<Subject> subjectList() {
		return this.subjectDAO.subjectList();
	}

	@Override
	public int subjectAdd(Subject s) {
		return this.subjectDAO.subjectAdd(s);
	}

	@Override
	public int subjectDelete(Subject s) {
		return this.subjectDAO.subjectDelete(s);
	}

	@Override
	public int subjectUpdate(Subject s) {
		return this.subjectDAO.subjectUpdate(s);
	}

}
