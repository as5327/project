package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Student;

public class StudentLoginRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int count) throws SQLException {
		Student student = new Student();
		student.setStudent_id(rs.getString("student_id"));
		student.setStudent_id(rs.getString("student_name"));
		return student;
	}

}
