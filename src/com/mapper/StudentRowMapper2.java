package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Student;

public class StudentRowMapper2 implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudent_id(rs.getString("student_ID"));
		student.setStudent_name(rs.getString("student_Name"));
		student.setStudent_phone(rs.getString("student_Phone"));
		student.setStudent_regDate(rs.getDate("student_Reg_Date"));
		student.setStudent_count(rs.getInt("count_"));
		return student;
	}

}
