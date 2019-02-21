package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Course;

@Repository("courseDAO")
public class CourseDAOImpl implements CourseDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Course> courseList() {
		String sql = "SELECT course_ID, course_Name\r\n" + 
				"	, (SELECT COUNT(*) \r\n" + 
				"		FROM open_course oc \r\n" + 
				"        WHERE oc.course_id=c.course_id) courseDel\r\n" + 
				"	FROM course c \r\n" + 
				"    ORDER BY course_ID";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
	}

	@Override
	public int courseAdd(Course c) {
		String sql = "INSERT INTO course (course_ID, course_Name)\r\n" + 
				"	VALUES ((SELECT CONCAT('CO', LPAD(IFNULL(SUBSTR(MAX(course_ID), 3), 0) + 1, 3, 0)) AS course_ID FROM course c)\r\n" + 
				"		, ?);";
		return this.jdbcTemplate.update(sql, c.getCourse_Name());
	}

	@Override
	public int courseDelete(Course c) {
		String sql = "DELETE FROM course\r\n" + 
				"    WHERE course_ID = ?";
		return this.jdbcTemplate.update(sql, c.getCourse_Id());
	}

	@Override
	public int courseUpdate(Course c) {
		String sql = "UPDATE course \r\n" + 
				"SET course_Name=? \r\n" + 
				"WHERE course_ID=?";
		return this.jdbcTemplate.update(sql, c.getCourse_Name(), c.getCourse_Id());
	}

}
