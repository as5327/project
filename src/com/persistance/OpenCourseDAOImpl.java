package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Instructor;
import com.domain.OpenCourse;
import com.domain.Student;
import com.mapper.OpenCourse_studentRowMapper;

@Repository("openCourseDAO")
public class OpenCourseDAOImpl implements OpenCourseDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;
	
	@Override
	public List<OpenCourse> openCourseList_st(Student s) {
		String sql="call opencourselist_st1(?)";
		/*return template.query(sql,new Object[] {s.getStudent_id()},new OpenCourse_studentRowMapper());*/
		return template.query(sql,new Object[] {s.getStudent_id()},new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class));
	}
	
	@Override
	public List<OpenCourse> openCourseList_st(String s, String oc) {
		String sql="call opencourselist_st2(?,?)";
		/*return template.query(sql,new Object[] {s,oc},new OpenCourse_studentRowMapper());*/
		return template.query(sql,new Object[] {s,oc},new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class));
	}

	@Override
	public List<OpenCourse> openCourseList_is(Instructor i) {
		String sql = "SELECT oci.open_Course_ID, ci.course_Name, oci.course_Start_Date, oci.course_End_Date, c.class_Name\r\n" + 
				"	, (SELECT Count(*) FROM course_history ch WHERE open_course_id = oci.open_course_id) s_count \r\n" + 
				"    FROM open_course oci, course ci, classroom c\r\n" + 
				"    WHERE oci.course_ID = ci.course_ID\r\n" + 
				"    AND c.class_id = oci.class_id\r\n" + 
				"    AND open_Course_ID IN (SELECT oci.open_Course_ID\r\n" + 
				"FROM instructor i, open_course oci, open_subject osi\r\n" + 
				"WHERE osi.open_Course_ID = oci.open_Course_ID\r\n" + 
				"AND osi.instructor_ID = i.instructor_ID\r\n" + 
				"AND i.instructor_ID = ?)\r\n"+
				"ORDER BY oci.open_course_id";
		return this.template.query(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class), i.getInstructor_Id());
	}
	
	@Override
	public List<OpenCourse> openCourseList2_is(Instructor i) {
		String sql = "SELECT oci.open_Course_ID, ci.course_Name, oci.course_Start_Date, oci.course_End_Date, c.class_Name\r\n" + 
				"	, (SELECT Count(*) FROM course_history ch WHERE open_course_id = oci.open_course_id) s_count \r\n" + 
				"    FROM open_course oci, course ci, classroom c\r\n" + 
				"    WHERE oci.course_ID = ci.course_ID\r\n" + 
				"    AND c.class_id = oci.class_id\r\n" + 
				"    AND open_Course_ID IN (SELECT oci.open_Course_ID\r\n" + 
				"FROM instructor i, open_course oci, open_subject osi\r\n" + 
				"WHERE osi.open_Course_ID = oci.open_Course_ID\r\n" + 
				"AND osi.instructor_ID = i.instructor_ID\r\n" + 
				"AND i.instructor_ID=?)\r\n" +
				"ORDER BY oci.open_course_id";
		return template.query(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class), i.getInstructor_Id());
	}
	
	@Override
	public List<OpenCourse> openCourseList2_is(String i, String oc) {
		String sql = "SELECT oci.open_Course_ID, ci.course_Name, oci.course_Start_Date, oci.course_End_Date, c.class_Name\r\n" + 
				"	, (SELECT Count(*) FROM course_history ch WHERE open_course_id = oci.open_course_id) s_count \r\n" + 
				"FROM open_course oci, course ci, classroom c\r\n" + 
				"WHERE oci.course_ID = ci.course_ID\r\n" + 
				"AND c.class_id = oci.class_id\r\n" + 
				"AND oci.open_course_id = ? \r\n" + 
				"AND open_Course_ID IN (SELECT oci.open_Course_ID\r\n" + 
				"FROM instructor i, open_course oci, open_subject osi\r\n" + 
				"WHERE osi.open_Course_ID = oci.open_Course_ID\r\n" + 
				"AND osi.instructor_ID = i.instructor_ID\r\n" + 
				"AND i.instructor_ID= ? )\r\n" +
				"ORDER BY oci.open_course_id";
		return template.query(sql, new Object[] {oc, i}, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class));
	}
	
	@Override
	public List<OpenCourse> openCourseList_adi_is_schedule(Instructor i) {
		String sql = "SELECT oc.open_course_id, c.course_Name, oc.course_Start_Date, oc.course_End_Date, cl.class_Name\r\n" +
				"	, (SELECT COUNT(*) FROM course_history ch WHERE ch.open_course_id = oc.open_course_id) as s_count\r\n" +
				"	, (SELECT COUNT(*) FROM open_subject os WHERE os.open_course_id = oc.open_course_id) as os_count\r\n" + 
				"FROM open_course oc, course c, classroom cl\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND cl.class_id = oc.class_id\r\n" + 
				"AND oc.open_course_id IN (SELECT os.open_Course_ID\r\n" + 
				"							FROM open_subject os, open_course oc, instructor i\r\n" + 
				"							WHERE os.open_course_id = oc.open_course_id\r\n" + 
				"							AND i.instructor_id = os.instructor_id \r\n" + 
				"							AND os.instructor_id = ?)\r\n" +
				"ORDER BY oc.open_course_id";
		return this.template.query(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class), i.getInstructor_Id());
	}
	
	@Override
	public List<OpenCourse> openCourseList_adi_is_schedule(Instructor i, OpenCourse oc) {
		String sql = "SELECT oc.open_course_id, c.course_Name, oc.course_Start_Date, oc.course_End_Date, cl.class_Name\r\n" + 
				", (SELECT count(*) FROM course_history ch WHERE oc.open_Course_ID = ch.open_course_id) s_count\r\n" + 
				"FROM open_course oc, course c, classroom cl\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND cl.class_id = oc.class_id\r\n" + 
				"AND oc.open_course_id = ?\r\n" + 
				"AND oc.open_course_id IN (SELECT os.open_Course_ID\r\n" + 
				"							FROM open_subject os, open_course oc, instructor i\r\n" + 
				"							WHERE os.open_course_id = oc.open_course_id\r\n" + 
				"							AND i.instructor_id = os.instructor_id \r\n" + 
				"							AND os.instructor_id = ?)\r\n" +
				"ORDER BY oc.open_course_id";
		return this.template.query(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class), oc.getOpen_course_id(), i.getInstructor_Id());
	}

	@Override
	public List<OpenCourse> openCourseList_adi_oc() {
		String sql = "SELECT oc.open_course_id, c.course_Name, oc.course_Start_Date, oc.course_End_Date, cl.class_Name\r\n" +
				"	, (SELECT COUNT(*) FROM course_history ch WHERE ch.open_course_id = oc.open_course_id) as s_count\r\n" +
				"	, (SELECT COUNT(*) FROM open_subject os WHERE os.open_course_id = oc.open_course_id) as os_count\r\n" + 
				"FROM open_course oc, course c, classroom cl\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND cl.class_id = oc.class_id\r\n" +
				"ORDER BY oc.open_course_id";
		return this.template.query(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class));
	}
	
	@Override
	public List<OpenCourse> openCourseList_adi_oc(OpenCourse oc) {
		String sql = "SELECT oc.open_course_id, c.course_Name, oc.course_Start_Date, oc.course_End_Date, cl.class_Name\r\n" +
				"	, (SELECT COUNT(*) FROM course_history ch WHERE ch.open_course_id = oc.open_course_id) as s_count\r\n" +
				"	, (SELECT COUNT(*) FROM open_subject os WHERE os.open_course_id = oc.open_course_id) as os_count\r\n" + 
				"FROM open_course oc, course c, classroom cl\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND cl.class_id = oc.class_id\r\n" +
				"AND oc.open_course_id = ?\r\n" +
				"ORDER BY oc.open_course_id";
		return this.template.query(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class), oc.getOpen_course_id());
	}
	
	@Override
	public List<OpenCourse> openCourseList_adi_score() {
		String sql = "SELECT oc.open_course_id, c.course_Name, oc.course_Start_Date, oc.course_End_Date, cr.class_Name      \r\n" + 
				"FROM open_course oc, classroom cr, course c\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND oc.class_id = cr.class_id\r\n" +
				"ORDER BY oc.open_course_id"; 
		return this.template.query(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class));
	}
	
	@Override
	public OpenCourse openCourseList_adi_score(OpenCourse oc) {
		String sql = "SELECT oc.open_course_id, c.course_Name, oc.course_Start_Date, oc.course_End_Date, cr.class_Name      \r\n" + 
				"FROM open_course oc, classroom cr, course c\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND oc.class_id = cr.class_id\r\n" +
				"AND oc.open_course_id = ?"; 
		return this.template.queryForObject(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class), oc.getOpen_course_id());
	}

	@Override
	public List<OpenCourse> openCourseList_adi_score(Student s) {
		String sql = "SELECT oc.open_course_id, c.course_Name, oc.course_Start_Date, oc.course_End_Date, cr.class_Name      \r\n" + 
				"FROM open_course oc, classroom cr, course c, course_history ch\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND oc.class_id = cr.class_id\r\n" + 
				"AND oc.open_course_id = ch.open_course_id\r\n" + 
				"AND ch.student_id = ?\r\n"+
				"ORDER BY oc.open_course_id";
		return this.template.query(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class), s.getStudent_id());
	}
	
	@Override
	public OpenCourse openCourseList_adi_score(Student s, OpenCourse oc) {
		String sql = "SELECT oc.open_course_id, c.course_Name, oc.course_Start_Date, oc.course_End_Date, cr.class_Name      \r\n" + 
				"FROM open_course oc, classroom cr, course c, course_history ch\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND oc.class_id = cr.class_id\r\n" + 
				"AND oc.open_course_id = ch.open_course_id\r\n" +
				"AND oc.open_course_id = ?\r\n" +
				"AND ch.student_id = ?";
		return this.template.queryForObject(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class), oc.getOpen_course_id(), s.getStudent_id());
	}
	
	@Override
	public int openCourseAdd(OpenCourse oc) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int openCourseDelete(OpenCourse oc) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int openCourseUpdate(OpenCourse oc) {
		// TODO Auto-generated method stub
		return 0;
	}

}
