package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Exam;

public class Exam_studentRowMapper implements RowMapper<Exam>{

	@Override
	public Exam mapRow(ResultSet rs, int count) throws SQLException {
		Exam ex= new Exam();
		ex.setExam_question_file(rs.getString("exam_question_file"));
		ex.setExam_date(rs.getDate("exam_date"));
		ex.setAttendance_score(rs.getInt("attendance_score"));
		ex.setAttendance_distribution(rs.getInt("attendance_distribution"));
		ex.setWritten_distribution(rs.getInt("written_distribution"));
		ex.setWritten_score(rs.getInt("written_score"));
		ex.setPerformance_distribution(rs.getInt("performance_distribution"));
		ex.setPerformance_score(rs.getInt("performance_score"));
		ex.setTotal_score(rs.getInt("scoretotal"));
		ex.setTotal_distribution(rs.getInt("ditotal"));
		return ex;
	}

}
