package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.domain.*;

public class Exam_instructor_RowMapper implements RowMapper<Exam> {
	
	//시험번호/시험문제/시험날짜/출결배점/필기배점/실기배점
	@Override
	public Exam mapRow(ResultSet rs, int count) throws SQLException {
		Exam ex = new Exam();
		ex.setExam_id(rs.getString("exam_ID"));
		ex.setExam_question_file(rs.getString("exam_Question_File"));
		ex.setExam_date(rs.getDate("exam_Date"));
		ex.setAttendance_distribution(rs.getInt("attendance_Distribution"));
		ex.setWritten_distribution(rs.getInt("written_Distribution"));
		ex.setPerformance_distribution(rs.getInt("performance_Distribution"));

		return ex;
	}
}
