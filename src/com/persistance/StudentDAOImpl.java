package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.*;
import com.mapper.*;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;
	
	@Override
	public Student studentLogin(Student s) {
		String sql="call studentlogin(?,?);";
		return template.queryForObject(sql, new Object[] {s.getStudent_name(), s.getStudent_pw()}, new StudentLoginRowMapper()); 
	}
	@Override
	public Student studentinfo(Student s) {
		String sql ="call studentinfo(?)";
		return template.queryForObject(sql, new Object[] {s.getStudent_id()},new StudentInfoRowMapper());
	}

	@Override
	public List<Student> studentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> studentList_is() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> studentList_is_score() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//수강생번호/수강생명/연락처/수료-중도탈락여부/수료-중도탈락날짜/출결점수/필기점수/실기점수/총점/삭제가능여부
	@Override
	public List<Student> studentList2_is_score(String i, String oc, String os) {
		String sql = "SELECT b.student_Score_ID, a.student_id, a.student_name, a.student_Phone, a.status_, a.end_date, b.attendance_Score, b.written_Score, b.performance_Score, b.total_score\r\n" + 
				"FROM (SELECT open_Course_ID, student_ID, student_Name, student_Phone\r\n" + 
				"    , IF (fail_date IS NULL, IF(course_end_date > CURDATE(), '수료예정', '수료'), '중도탈락') status_\r\n" + 
				"    , IF (fail_date IS NULL, course_End_Date, fail_date) end_date\r\n" + 
				"FROM (SELECT oci.open_Course_ID, s.student_ID, s.student_Name, s.student_Phone\r\n" + 
				"	, oci.course_Start_Date\r\n" + 
				"	, oci.course_End_Date\r\n" + 
				"    , (SELECT fail_date FROM course_fail_history\r\n" + 
				"		WHERE open_Course_ID=oci.open_Course_ID\r\n" + 
				"        AND student_ID=s.student_ID) fail_date\r\n" + 
				"FROM course_history ch, student s, open_course oci\r\n" + 
				"WHERE ch.open_course_id = oci.open_course_id\r\n" + 
				"AND ch.student_id = s.student_id\r\n" + 
				"AND oci.open_course_id = ?)temp) a\r\n" + 
				"LEFT JOIN \r\n" + 
				"(SELECT ss.student_Score_ID , ss.student_id, ss.attendance_score, ss.written_score, ss.performance_Score\r\n" + 
				"   , (ss.attendance_score + ss.written_score + ss.written_score) AS total_score\r\n" + 
				"FROM student_score ss, open_subject os, exam e\r\n" + 
				"WHERE e.open_subject_id = os.open_subject_id\r\n" + 
				"AND e.exam_id = ss.exam_id\r\n" + 
				"AND os.open_subject_id = ? \r\n" + 
				"AND os.instructor_id = ?) b\r\n" + 
				"ON a.student_id = b.student_id\r\n";
		return template.query(sql, new Student_instructor_Score_RowMapper(), oc, os, i);
	}

	@Override
	public List<Student> studentList_adi_st() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Student> slist() {
		String sql = "SELECT student_ID, student_Name, student_Phone, student_Reg_Date,\r\n"
				+ "        (SELECT COUNT(*) FROM course_history\r\n"
				+ "                WHERE student_ID = s.student_ID) as student_count\r\n"
				+ " FROM student s\r\n"
				+ "	ORDER BY student_ID";

		return this.template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
	}
	
	@Override
	public Student studentinfo_adi_score(Student s) {
		String sql = "SELECT student_ID, student_Name, student_Phone, student_Reg_Date,\r\n"
				+ "        (SELECT COUNT(*) FROM course_history\r\n"
				+ "                WHERE student_ID = s.student_ID) as student_count\r\n"
				+ " FROM student s\r\n"
				+ " WHERE student_id=?\r\n"
				+ "	ORDER BY student_ID";
		return this.template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), s.getStudent_id());
	}

	@Override
	public List<Student> studentList_adi_st_2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> studentList_adi_score(Exam ex) {
		String sql = "SELECT s.student_ID, s.student_Name, s.student_Pic, s.student_Phone, s.student_Reg_Date\r\n" + 
				"	, ss.attendance_Score, ss.written_Score, ss.performance_Score\r\n" + 
				"    , (ss.attendance_Score + ss.written_Score + ss.performance_Score) as total_score\r\n" + 
				"FROM student s LEFT JOIN student_score ss\r\n" + 
				"ON s.student_id = ss.student_id\r\n" + 
				"WHERE ss.exam_id = ?";
		return this.template.query(sql , new BeanPropertyRowMapper<Student>(Student.class), ex.getExam_id());
	}

	@Override
	public int studentAdd(Student s) {
		String sql = "INSERT INTO student (student_ID, student_Name, student_Phone, student_Reg_Date, student_PW, student_Pic)\r\n"
				+ "    VALUES ((SELECT CONCAT('ST', LPAD(IFNULL(SUBSTR(MAX(student_ID), 3), 0)+1, 3, 0)) AS newId 	FROM student s), ?, ?, curdate(), ?, 'avatar.png')";

		return this.template.update(sql, s.getStudent_name(), s.getStudent_phone(), s.getStudent_pw());
	}

	@Override
	public int studentDelete(Student s) {
		String sql = "DELETE FROM student WHERE student_ID = ?";
		return this.template.update(sql, s.getStudent_id());
	}

	@Override
	public int studentUpdate(Student s) {
		/*
		 * String sql =
		 * "UPDATE student SET student_Name=?, student_Phone=?, student_PW=? WHERE student_ID=?"
		 * ;
		 * 
		 * return template.update(sql, s.getStudent_name(), s.getStudent_phone(),
		 * s.getStudent_pw(), s.getStudent_id());
		 */
		String sql = "UPDATE student SET student_Name=?, student_Phone=? WHERE student_ID=?";

		return template.update(sql, s.getStudent_name(), s.getStudent_phone(), s.getStudent_id());
	}

	@Override
	public int pwChange(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
