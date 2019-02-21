package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.StudentScore;

public class StudentScoreRowMapper implements RowMapper<StudentScore>{

	//수강생성적번호, 수강생번호, 시험번호, 출결점수, 필기점수, 실기점수, 총점수, 삭제가능여부
	@Override
	public StudentScore mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentScore studentScore = new StudentScore();
		studentScore.setStudent_score_id(rs.getString("student_score_id"));
		studentScore.setStudent_id(rs.getString("student_id"));
		studentScore.setExam_id(rs.getString("exam_id"));
		studentScore.setAttendance_score(rs.getInt("attendance_score"));
		studentScore.setWritten_score(rs.getInt("written_score"));
		studentScore.setPerformance_score(rs.getInt("performance_score"));
		studentScore.setTotal_score(rs.getInt("total_score"));
		studentScore.setScore_del(rs.getInt("score_del"));
		return studentScore;
	}

}
