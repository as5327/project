package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Classroom;

@Repository("classroomDAO")
public class ClassroomDAOImpl implements ClassroomDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Classroom> classroomList() {
		String sql = "SELECT class_ID, class_Name, class_limit\r\n" + 
				"	, (SELECT COUNT(*) \r\n" + 
				"		FROM open_course oc \r\n" + 
				"        WHERE oc.class_id=cl.class_id) classDel\r\n" + 
				"	FROM classroom cl\r\n" + 
				"    ORDER BY class_ID";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Classroom>(Classroom.class));
	}

	@Override
	public int classroomAdd(Classroom c) {
		String sql = "INSERT INTO classroom (class_ID, class_Name, class_limit)\r\n" + 
				"	VALUES ((SELECT CONCAT('CL', LPAD(IFNULL(SUBSTR(MAX(class_ID), 3), 0) + 1, 3, 0)) AS class_ID FROM classroom c)\r\n" + 
				"    , ?, ?);";
		return this.jdbcTemplate.update(sql, c.getClass_Name(), c.getClass_limit());
	}

	@Override
	public int classroomDelete(Classroom c) {
		String sql = "DELETE FROM classroom\r\n" + 
				"    WHERE class_ID = ?";
		return this.jdbcTemplate.update(sql, c.getClass_Id());
	}

	@Override
	public int classroomUpdate(Classroom c) {
		String sql = "UPDATE classroom \r\n" + 
				"SET class_Name=?\r\n" + 
				"	, class_limit=? \r\n" + 
				"WHERE class_ID=?";
		return this.jdbcTemplate.update(sql, c.getClass_Name(), c.getClass_limit(), c.getClass_Id());
	}

}
