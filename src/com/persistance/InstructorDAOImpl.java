package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Instructor;
import com.mapper.InstructorLoginMapper;

@Repository("instructorDAO")
public class InstructorDAOImpl implements InstructorDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Instructor instructorLogin(Instructor is) {
		String sql = "SELECT instructor_id, instructor_name\r\n" + 
				"FROM instructor\r\n" + 
				"WHERE instructor_name = ?\r\n" + 
				"AND instructor_pw = ?";
		return this.jdbcTemplate.queryForObject(sql, new InstructorLoginMapper(), is.getInstructor_Name(), is.getInstructor_pw());
	}
	
	@Override
	public Instructor instructorInfo(Instructor is) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> instructorList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> instructorList_adi_is_schedule(Instructor is) {
		String sql = "SELECT i.instructor_ID, i.instructor_Name, i.instructor_Phone, i.instructor_regDate, i.instructor_pic\r\n" + 
				"FROM instructor i\r\n" + 
				"WHERE i.instructor_id = ?";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Instructor>(Instructor.class), is.getInstructor_Id());
	}

	@Override
	public List<Instructor> instructorList_adi_is() {
		String sql = "SELECT i.instructor_ID, i.instructor_Name, i.instructor_Phone, i.instructor_regDate, i.instructor_pic\r\n" + 
				"	,(SELECT count(*)\r\n" + 
				"		FROM open_course oc\r\n" + 
				"		WHERE oc.open_course_id \r\n" + 
				"		IN (SELECT os.open_Course_ID\r\n" + 
				"			FROM open_subject os, open_course oc\r\n" + 
				"			WHERE os.open_course_id = oc.open_course_id\r\n" + 
				"			AND i.instructor_id = os.instructor_id)) as schedule_count\r\n" + 
				"    ,(select count(*)\r\n" + 
				"		from possible_subject ps\r\n" + 
				"		where i.instructor_ID = ps.instructor_ID) as possible_count\r\n" + 
				"	, (select count(*)\r\n" + 
				"		from open_subject os\r\n" + 
				"		where os.instructor_id = i.instructor_ID) as instructorDel\r\n" + 
				"FROM instructor i";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Instructor>(Instructor.class));
	}

	@Override
	public int instructorAdd(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int instructorDelete(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int instructorUpdate(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pwChange(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Instructor> possibleSubjectList(Instructor is) {
		String sql = "SELECT s.subject_name\r\n" + 
				"FROM possible_subject ps, subject_ s\r\n" + 
				"WHERE ps.subject_id = s.subject_id\r\n" + 
				"AND ps.instructor_id = ?";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Instructor>(Instructor.class), is.getInstructor_Id());
	}

	@Override
	public int possibleSubjecAdd(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int possibleSubjecDelete(Instructor is) {
		// TODO Auto-generated method stub
		return 0;
	}

}
