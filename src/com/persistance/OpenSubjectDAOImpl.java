package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.OpenCourse;
import com.domain.OpenSubject;
import com.mapper.OpenSubject_instructor2_RowMapper;
import com.mapper.OpenSubject_studentRowMapper;
@Repository("openSubjectDAO")
public class OpenSubjectDAOImpl implements OpenSubjectDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;
	
	@Override
	public List<OpenSubject> openSubjectList_student(String s, String oc) {
		String sql="call student_opensubject1(?,?)";
		return template.query(sql, new Object[] {s,oc},new OpenSubject_studentRowMapper());
	}
	
	@Override
	public List<OpenSubject> openSubjectList_student(String s, String oc,String os) {
		String sql="call student_opensubject2(?,?,?)";
		return template.query(sql, new Object[] {s,oc,os},new OpenSubject_studentRowMapper());
	}

	@Override
	public List<OpenSubject> openSubjectList_st() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpenSubject> openSubjectList_is() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<OpenSubject> openSubjectList2_is(String i, String oc) {
		String sql = "SELECT osi.open_subject_id, si.subject_Name, osi.subject_Start_Date, osi.subject_End_Date, bi.book_Name, bi.isbn_Number \r\n" + 
				"FROM open_subject osi, open_course oci, subject_ si, book bi\r\n" + 
				"WHERE osi.open_course_id = oci.open_course_id\r\n" + 
				"AND si.subject_id = osi.subject_id\r\n" + 
				"AND bi.book_id = osi.book_id\r\n" + 
				"AND osi.instructor_ID = ?\r\n" +
				"AND oci.open_course_id = ?\r\n" ;
		return template.query(sql, new Object[] {i, oc}, new OpenSubject_instructor2_RowMapper());
	}
	
	@Override
	public List<OpenSubject> openSubjectList2_is(String i, String oc, String os) {
		String sql = "SELECT osi.open_subject_id, si.subject_Name, osi.subject_Start_Date, osi.subject_End_Date, bi.book_Name, bi.isbn_Number\r\n" + 
				"FROM open_subject osi, open_course oci, subject_ si, book bi\r\n" + 
				"WHERE osi.open_course_id = oci.open_course_id\r\n" + 
				"AND si.subject_id = osi.subject_id\r\n" + 
				"AND bi.book_id = osi.book_id\r\n" + 
				"AND oci.open_course_id = ? \r\n" + 
				"AND osi.open_subject_id = ? \r\n" + 
				"AND osi.instructor_ID = ? \r\n" ;
		return template.query(sql, new Object[] {oc, os, i}, new OpenSubject_instructor2_RowMapper());
	}
	
	@Override
	public List<OpenSubject> openSubjectList_adi_is_schedule(OpenSubject os) {
		String sql = "SELECT os.open_Subject_ID, s.subject_Name, os.subject_Start_Date, os.subject_End_Date, b.book_Name\r\n" + 
				"FROM open_subject os, subject_ s, book b\r\n" + 
				"WHERE s.subject_id = os.subject_id\r\n" + 
				"AND b.book_id = os.book_id\r\n" + 
				"AND os.open_course_id = ?\r\n" + 
				"AND os.instructor_id = ?";
		return this.template.query(sql, new BeanPropertyRowMapper<OpenSubject>(OpenSubject.class), os.getOpen_course_id(), os.getInstructor_id());
	}

	@Override
	public List<OpenSubject> openSubjectList_adi_os(OpenSubject os) {
		String sql = "SELECT os.open_Subject_ID, s.subject_Name, os.subject_Start_Date, os.subject_End_Date\r\n" + 
				"	, b.book_Name, b.ISBN_Number, i.instructor_Name, i.instructor_pic\r\n" + 
				"	, (SELECT COUNT(*)\r\n" + 
				"		FROM exam e\r\n" + 
				"		WHERE e.open_subject_id = os.open_subject_id) as open_subject_del\r\n" + 
				"FROM open_subject os, subject_ s, book b, instructor i\r\n" + 
				"WHERE s.subject_id = os.subject_id\r\n" + 
				"AND b.book_id = os.book_id\r\n" + 
				"AND os.instructor_id = i.instructor_id\r\n" + 
				"AND os.open_course_id = ?";
		return this.template.query(sql, new BeanPropertyRowMapper<OpenSubject>(OpenSubject.class), os.getOpen_course_id());
	}
	
	@Override
	public List<OpenSubject> openSubjectList_adi_score(OpenCourse oc) {
		String sql = "SELECT os.open_Subject_ID, s.subject_Name, os.subject_Start_Date, os.subject_End_Date, i.instructor_Name, i.instructor_pic\r\n" + 
				"FROM open_subject os, subject_ s, instructor i\r\n" + 
				"WHERE s.subject_id = os.subject_id\r\n" + 
				"AND os.instructor_id = i.instructor_id\r\n" + 
				"AND os.open_course_id = ?";
		return this.template.query(sql, new BeanPropertyRowMapper<OpenSubject>(OpenSubject.class), oc.getOpen_course_id());
	}

	@Override
	public OpenSubject openSubjectList_adi_score_1(OpenSubject os) {
		String sql = "SELECT os.open_Subject_ID, s.subject_Name, os.subject_Start_Date, os.subject_End_Date, i.instructor_Name, i.instructor_pic\r\n" + 
				"FROM open_subject os, subject_ s, instructor i\r\n" + 
				"WHERE s.subject_id = os.subject_id\r\n" + 
				"AND os.instructor_id = i.instructor_id\r\n" + 
				"AND os.open_subject_id = ?";
		return this.template.queryForObject(sql, new BeanPropertyRowMapper<OpenSubject>(OpenSubject.class), os.getOpen_subject_id());
	}
	
	@Override
	public List<OpenSubject> openSubjectList_adi_score_subject(OpenCourse oc) {
		String sql = "SELECT os.open_Subject_ID, s.subject_Name, os.subject_Start_Date, os.subject_End_Date\r\n" + 
				"	, b.book_Name, b.ISBN_Number, i.instructor_Name, i.instructor_pic\r\n" + 
				"FROM open_subject os, subject_ s, book b, instructor i\r\n" + 
				"WHERE s.subject_id = os.subject_id\r\n" + 
				"AND b.book_id = os.book_id\r\n" + 
				"AND os.instructor_id = i.instructor_id\r\n" + 
				"AND os.open_course_id = ?";
		return this.template.query(sql, new BeanPropertyRowMapper<OpenSubject>(OpenSubject.class), oc.getOpen_course_id());
	}
	
	@Override
	public OpenSubject openSubjectList_adi_score_subject(OpenSubject os) {
		String sql = "SELECT os.open_Subject_ID, s.subject_Name, os.subject_Start_Date, os.subject_End_Date\r\n" + 
				"	, b.book_Name, b.ISBN_Number, i.instructor_Name, i.instructor_pic\r\n" + 
				"FROM open_subject os, subject_ s, book b, instructor i\r\n" + 
				"WHERE s.subject_id = os.subject_id\r\n" +
				"AND b.book_id = os.book_id\r\n" +
				"AND os.instructor_id = i.instructor_id\r\n" + 
				"AND os.open_subject_id = ?";
		return this.template.queryForObject(sql, new BeanPropertyRowMapper<OpenSubject>(OpenSubject.class), os.getOpen_subject_id());
	}
	
	@Override
	public int openSubjectAdd(OpenSubject os) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int openSubjectDelete(OpenSubject os) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int openSubjectUpdate(OpenSubject os) {
		// TODO Auto-generated method stub
		return 0;
	}


}
