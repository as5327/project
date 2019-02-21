package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.domain.*;

public class OpenSubject_instructor2_RowMapper implements RowMapper<OpenSubject> {

	//개설과목번호/개설과목명/개설과목시작일/개설과목종료일/교재명/isbn
	@Override
	public OpenSubject mapRow(ResultSet rs, int count) throws SQLException {
		OpenSubject os = new OpenSubject();
		os.setOpen_subject_id(rs.getString("open_Subject_ID"));
		os.setSubject_name(rs.getString("subject_Name"));
		os.setSubject_start_date(rs.getDate("subject_Start_Date"));
		os.setSubject_end_date(rs.getDate("subject_End_Date"));
		os.setBook_name(rs.getString("book_Name"));
		os.setIsbn_number(rs.getString("isbn_Number"));
		return os;
	}

}
