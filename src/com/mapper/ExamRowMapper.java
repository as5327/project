package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Exam;

public class ExamRowMapper implements RowMapper<Exam> {

	@Override
	public Exam mapRow(ResultSet rs, int rowNum) throws SQLException {
		// 개설과목번호, 시험파일명, 시험번호
		// 시험 날짜, 배점번호
		// 출결배점, 필기배점, 실기배점, 총 배점, 삭제가능여부
		// 수강생 성적 번호, 수강생 번호
		// 출결점수, 필기점수, 실기점수, 총 점수, 삭제가능여부

		Exam exam = new Exam();

		exam.setOpen_subject_id(rs.getString("open_subject_id"));
		exam.setExam_question_file(rs.getString("exam_question_file"));
		exam.setExam_id(rs.getString("exam_id"));
		exam.setExam_date(rs.getDate("exam_date"));
		exam.setDistribution_id(rs.getString("distribution_id"));
		exam.setAttendance_distribution(rs.getInt("attendance_distribution"));
		exam.setWritten_distribution(rs.getInt("written_distribution"));
		exam.setPerformance_distribution(rs.getInt("performance_distribution"));
		exam.setTotal_distribution(rs.getInt("total_distribution"));
		exam.setDistribution_del(rs.getInt("distribution_del"));
		exam.setStudent_score_id(rs.getString("student_score_id"));
		exam.setStudent_id(rs.getString("student_id"));
		exam.setAttendance_score(rs.getInt("attendance_score"));
		exam.setWritten_score(rs.getInt("written_score"));
		exam.setPerformance_score(rs.getInt("performance_score"));
		exam.setTotal_score(rs.getInt("total_score"));
		exam.setScore_del(rs.getInt("score_del"));

		return exam;
	}

}
