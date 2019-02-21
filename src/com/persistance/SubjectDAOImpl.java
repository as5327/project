package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Subject;

@Repository("subjectDAO")
public class SubjectDAOImpl implements SubjectDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Subject> subjectList() {
		String sql = "SELECT subject_ID, subject_Name\r\n" + 
				"	, (SELECT COUNT(*)\r\n" + 
				"		FROM open_subject os\r\n" + 
				"		WHERE os.subject_id = s.subject_id) subject_del\r\n" + 
				"	FROM subject_ s\r\n" + 
				"    ORDER BY subject_ID;";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Subject>(Subject.class));
	}

	@Override
	public int subjectAdd(Subject s) {
		String sql = "INSERT INTO subject_ (subject_ID, subject_Name)\r\n" + 
				"	VALUES ((SELECT CONCAT('SB', LPAD(IFNULL(SUBSTR(MAX(subject_ID), 3), 0) + 1, 3, 0)) AS subject_ID FROM Subject_ si)\r\n" + 
				"    , ?)";
		return this.jdbcTemplate.update(sql, s.getSubject_Name());
	}

	@Override
	public int subjectDelete(Subject s) {
		String sql = "DELETE FROM subject_\r\n" + 
				"    WHERE subject_id = ?";
		return this.jdbcTemplate.update(sql, s.getSubject_Id());
	}

	@Override
	public int subjectUpdate(Subject s) {
		String sql = "UPDATE subject_ \r\n" + 
				"SET subject_name=? \r\n" + 
				"WHERE subject_id=?";
		return this.jdbcTemplate.update(sql, s.getSubject_Id());
	}

}
