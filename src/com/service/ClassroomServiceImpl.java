package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Classroom;
import com.persistance.ClassroomDAO;

@Service("classroomService")
public class ClassroomServiceImpl implements ClassroomService {

	@Resource(name="classroomDAO")
	private ClassroomDAO classroomDAO;
	
	@Override
	public List<Classroom> classroomList() {
		return this.classroomDAO.classroomList();
	}

	@Override
	public int classroomAdd(Classroom c) {
		return this.classroomDAO.classroomAdd(c);
	}

	@Override
	public int classroomDelete(Classroom c) {
		return this.classroomDAO.classroomDelete(c);
	}

	@Override
	public int classroomUpdate(Classroom c) {
		return this.classroomDAO.classroomUpdate(c);
	}

}
