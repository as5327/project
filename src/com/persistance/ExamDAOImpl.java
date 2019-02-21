package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Exam;
import com.domain.OpenSubject;
import com.domain.Student;
import com.mapper.Exam_instructor_RowMapper;
import com.mapper.Exam_studentRowMapper;

@Repository("examDAO")
public class ExamDAOImpl implements ExamDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Exam> exam_student(String s, String os) {
		String sql="call student_exam(?,?)";
		return jdbcTemplate.query(sql, new Object[] {s,os} , new Exam_studentRowMapper());
	}
	
	@Override
	public List<Exam> exam_is(String i, String oc, String os) {
		String sql = "SELECT d.Distribution_ID, oci.open_Course_ID, osi.open_subject_id, osi.instructor_ID, e.exam_ID, d.Distribution_ID, e.exam_Question_File, e.exam_Date, d.attendance_Distribution, d.written_Distribution, d.performance_Distribution\r\n" + 
				"FROM exam e, distribution d, open_subject osi, open_course oci\r\n" + 
				"WHERE e.exam_id = d.exam_id\r\n" + 
				"AND osi.open_subject_id = e.open_subject_id\r\n" + 
				"AND oci.open_course_id = ? \r\n" + 
				"AND osi.open_subject_id = ? \r\n" + 
				"AND oci.open_Course_ID = osi.open_Course_ID\r\n" + 
				"AND osi.instructor_ID = ? \r\n";
		return jdbcTemplate.query(sql, new Exam_instructor_RowMapper(), oc, os, i);
	}
	
	@Override
	public List<Exam> exam2_is(String i, String oc, String os, String ex) {
		String sql = "SELECT d.Distribution_ID, oci.open_Course_ID, osi.open_subject_id, osi.instructor_ID, e.exam_ID, d.Distribution_ID, e.exam_Question_File, e.exam_Date, d.attendance_Distribution, d.written_Distribution, d.performance_Distribution\r\n" + 
				"FROM exam e, distribution d, open_subject osi, open_course oci\r\n" + 
				"WHERE e.exam_id = d.exam_id\r\n" + 
				"AND osi.open_subject_id = e.open_subject_id\r\n" + 
				"AND oci.open_Course_ID = osi.open_Course_ID\r\n" + 
				"AND oci.open_course_id = ?\r\n" + 
				"AND osi.open_subject_id = ?\r\n" + 
				"AND osi.instructor_ID = ?\r\n" + 
				"AND e.exam_id = ?\r\n";
		return jdbcTemplate.query(sql, new Exam_instructor_RowMapper(), oc, os, i, ex);
	}
	
	@Override
	public List<Exam> examList_st() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> examList_is_dis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> examList_is_score() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Exam> exam_student(Student s, OpenSubject os) {
		String sql = "SELECT e.exam_id, e.exam_Question_File, e.exam_Date\r\n" + 
				", ss.attendance_Score, di.attendance_Distribution\r\n" + 
				", ss.written_Score, di.written_Distribution\r\n" + 
				", ss.performance_Score, di.performance_Distribution\r\n" + 
				", (ss.attendance_Score + ss.written_Score + ss.performance_Score) as total_score\r\n" + 
				", (di.attendance_Distribution + di.written_Distribution + di.performance_Distribution) as total_distribution\r\n" + 
				"FROM exam e, student s, student_score ss, distribution di, open_subject os\r\n" + 
				"WHERE e.open_subject_id = os.open_subject_id\r\n" + 
				"AND e.exam_id = ss.exam_id\r\n" + 
				"AND e.exam_id = di.exam_id\r\n" + 
				"AND ss.student_id = s.student_id\r\n" + 
				"AND e.open_subject_id = ?\r\n" + 
				"AND s.student_id = ?";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Exam>(Exam.class), os.getOpen_subject_id(), s.getStudent_id());
	}
	
	@Override
	public List<Exam> examList_adi_score(OpenSubject os) {
		String sql = "SELECT e.exam_ID, e.exam_Question_File, e.exam_DATE\r\n" + 
				"	, d.attendance_Distribution, d.written_Distribution, d.performance_Distribution\r\n" + 
				"FROM exam e, distribution d\r\n" + 
				"WHERE e.exam_id = d.exam_id\r\n" + 
				"AND e.open_subject_id = ?";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Exam>(Exam.class), os.getOpen_subject_id());
	}
	
	@Override
	public Exam examList_adi_score(Exam ex) {
		String sql = "SELECT e.exam_ID, e.exam_Question_File, e.exam_DATE\r\n" + 
				"	, d.attendance_Distribution, d.written_Distribution, d.performance_Distribution\r\n" + 
				"FROM exam e, distribution d\r\n" + 
				"WHERE e.exam_id = d.exam_id\r\n" + 
				"AND e.open_subject_id = ?\r\n" +
				"AND e.exam_id = ?";
		return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Exam>(Exam.class), ex.getOpen_subject_id(), ex.getExam_id());
	}

	@Override
	public int examAdd(Exam e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int examDelete(Exam e) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 신규 배점 추가
	@Override
	public int distributionAdd(Exam e) {
		String sql = "CALL Insert_Exam_Distribution2(?, ?, ?, ?, ?, ?)";
		return this.jdbcTemplate.update(sql, e.getOpen_subject_id(), e.getExam_question_file(), e.getExam_date(), e.getAttendance_distribution(), e.getWritten_distribution(), e.getPerformance_distribution());
	}

	// 기본 배점 삭제
	@Override
	public int distributionDelete(Exam e) {
		String sql = "CALL Delete_Exam_Distribution(?, ?)";
		return this.jdbcTemplate.update(sql, e.getExam_id(), e.getDistribution_id());
	}

	@Override
	public int studentScoreAdd(Exam e) {
		String sql = "INSERT \r\n" + 
				"INTO student_score (student_score_id, attendance_score, written_score, performance_score, exam_id, student_id)\r\n" + 
				"VALUES((SELECT CONCAT('SS',LPAD(IFNULL(SUBSTR(MAX(student_score_id), 3), 0) + 1, 3, 0)) AS newId\r\n" + 
				"FROM student_score ss), ?, ?, ?, ?, ?)" ;
		return this.jdbcTemplate.update(sql, e.getAttendance_score(), e.getWritten_score(), e.getPerformance_score(), e.getExam_id(), e.getStudent_id());
	}

	@Override
	public int studentScoreDelete(Exam e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
