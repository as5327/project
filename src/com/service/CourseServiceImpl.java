package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Course;
import com.persistance.CourseDAO;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Resource(name="courseDAO")
	private CourseDAO courseDAO;
	
	@Override
	public List<Course> courseList() {
		return this.courseDAO.courseList();
	}

	@Override
	public int courseAdd(Course c) {
		return this.courseDAO.courseAdd(c);
	}

	@Override
	public int courseDelete(Course c) {
		return this.courseDAO.courseDelete(c);
	}

	@Override
	public int courseUpdate(Course c) {
		return this.courseDAO.courseUpdate(c);
	}

}
