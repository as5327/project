package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Student;

public class Student_instructor_Score_RowMapper implements RowMapper<Student>{

	//수강생성적번호/수강생번호/수강생명/연락처/수료-중도탈락여부/수료-중도탈락날짜/출결점수/필기점수/실기점수/총점/삭제가능여부
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudent_score_id(rs.getString("student_Score_ID"));
		student.setStudent_id(rs.getString("student_id"));
		student.setStudent_name(rs.getString("student_name"));
		student.setStudent_phone(rs.getString("student_Phone"));
		student.setStatus_(rs.getString("status_"));
		student.setEnd_date(rs.getDate("end_date"));
		student.setAttendance_score(rs.getInt("attendance_score"));
		student.setWritten_score(rs.getInt("written_score"));
		student.setPerformance_score(rs.getInt("performance_score"));
		student.setTotal_score(rs.getInt("total_score"));
		return student;
	}

}
