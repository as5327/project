package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Student;

public class StudentRowMapper implements RowMapper<Student>{

	//수강생번호, 수강생명, 연락처, 패스워드, 사진명, 새 패스워드, 수료(중도탈락)상태
	//등록일, 수료예정(중도탈락)날짜, 삭제 가능 여부, 수강횟수, 출결점수, 필기점수, 실기점수, 총 점수
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudent_id(rs.getString("student_id"));
		student.setStudent_name(rs.getString("student_name"));
		student.setStudent_phone(rs.getString("student_phone"));
		student.setStudent_pw(rs.getString("student_pw"));
		student.setStudent_pic(rs.getString("student_pic"));
		student.setStudent_newPw(rs.getString("student_newPw"));
		student.setStatus_(rs.getString("status_"));
		student.setStudent_regDate(rs.getDate("student_regDate"));
		student.setEnd_date(rs.getDate("end_date"));
		student.setStudent_del(rs.getInt("student_del"));
		student.setStudent_count(rs.getInt("student_count"));
		student.setAttendance_score(rs.getInt("attendance_score"));
		student.setWritten_score(rs.getInt("written_score"));
		student.setPerformance_score(rs.getInt("performance_score"));
		student.setTotal_score(rs.getInt("total_score"));
		return student;
	}

}
