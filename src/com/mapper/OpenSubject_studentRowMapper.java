package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.OpenSubject;

public class OpenSubject_studentRowMapper implements RowMapper<OpenSubject> {

	@Override
	public OpenSubject mapRow(ResultSet rs, int count) throws SQLException {
		OpenSubject os= new OpenSubject();
		os.setOpen_subject_id(rs.getString("open_subject_id"));
		os.setSubject_name(rs.getString("subject_name"));
		os.setSubject_start_date(rs.getDate("subject_start_date"));
		os.setSubject_end_date(rs.getDate("subject_end_date"));
		os.setBook_name(rs.getString("book_name"));
		os.setInstructor_id(rs.getString("instructor_id"));
		os.setInstructor_name(rs.getString("instructor_name"));
		os.setInsturctor_pic(rs.getString("instructor_pic"));
		os.setIsbn_number(rs.getString("isbn_number"));
		return os;
	}

}
