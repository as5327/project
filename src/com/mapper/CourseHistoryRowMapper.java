package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.CourseHistory;

public class CourseHistoryRowMapper implements RowMapper<CourseHistory> {

	@Override
	public CourseHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
		// 개설과정번호, 수강생번호
		CourseHistory courseHistory = new CourseHistory();

		courseHistory.setOpenCourse_Id(rs.getString("openCourse_Id"));
		courseHistory.setStudent_Id(rs.getString("student_Id"));

		return courseHistory;
	}

}
