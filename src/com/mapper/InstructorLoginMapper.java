package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Instructor;

public class InstructorLoginMapper implements RowMapper<Instructor> {

	@Override
	public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Instructor instructor = new Instructor();

		instructor.setInstructor_Id(rs.getString("instructor_Id"));
		instructor.setInstructor_Name(rs.getString("instructor_name"));

		return instructor;
	}

}
