package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.OpenSubject;

public class OpenSubjectRowMapper implements RowMapper<OpenSubject>{

	//개설과목번호, 개설과정번호, 과목번호, 과목명, 교재번호, 교재명, 강사번호, 강사명, 강사사진명
	//개설과목시작일, 개설과목종료일, 삭제가능 여부, ISBN 
	@Override
	public OpenSubject mapRow(ResultSet rs, int rowNum) throws SQLException {
		OpenSubject openSubject = new OpenSubject();
		openSubject.setSubject_id(rs.getString("open_subject_id"));
		openSubject.setOpen_course_id(rs.getString("open_course_id"));
		openSubject.setSubject_name(rs.getString("subject_name"));
		openSubject.setBook_id(rs.getString("book_id"));
		openSubject.setBook_name(rs.getString("book_name"));
		openSubject.setInstructor_id(rs.getString("instructor_id"));
		openSubject.setInstructor_name(rs.getString("insturctor_name"));
		openSubject.setInsturctor_pic(rs.getString("insturctor_pic"));
		openSubject.setSubject_start_date(rs.getDate("subject_start_date"));
		openSubject.setSubject_end_date(rs.getDate("subject_end_date"));
		openSubject.setOpen_subject_del(rs.getInt("open_subject_del"));
		openSubject.setIsbn_number(rs.getString("isbn_number"));
		return openSubject;
	}

}
