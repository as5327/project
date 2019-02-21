package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Student;

public class StudentInfoRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int count) throws SQLException {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setStudent_name(rs.getString("student_name"));
		student.setStudent_phone(rs.getString("student_phone"));
		student.setStudent_pic(rs.getString("student_Pic"));
		student.setStudent_count(rs.getInt("run"));
		return student;
	}

}
