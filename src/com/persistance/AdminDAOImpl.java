package com.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Admin;
import com.domain.GraphOnly;
import com.domain.OpenCourse;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO{
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	//관리자 로그인
	@Override
	public Admin adminLogin(Admin a) {
		String sql = "SELECT admin_id\r\n" + 
				"FROM administ\r\n" + 
				"WHERE admin_id = ?\r\n" + 
				"AND admin_pw = ?";
		return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), a.getAdmin_id(), a.getAdmin_pw());
	}

	//관리자 명단 출력
	//관리자명 / 연락처 / 등록일
	@Override
	public Admin adminList(Admin a) {
		String sql = "SELECT regDate\r\n" + 
				"FROM administ\r\n" + 
				"WHERE admin_id = ?";
		return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), a.getAdmin_id());
	}

	//등급 / 아이디 / 관리자명 / 연락처 / 등록일 / 계정 잠금 상태
	@Override
	public List<Admin> adminList_master() {
		String sql = "SELECT grade, admin_id, regDate,  locking\r\n" + 
				"FROM administ\r\n" + 
				"ORDER BY grade, admin_id";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Admin>(Admin.class));
	}

	//관리자 추가
	@Override
	public int adminAdd(Admin a) {
		String sql = "INSERT INTO administ (admin_id, admin_name, admin_phone, admin_pw, regDate, locking, grade)\r\n" + 
				"VALUES(?, ?, ?, ?, curdate(), 0, 1)";
		return this.jdbcTemplate.update(sql, a.getAdmin_id(), a.getAdmin_name(), a.getAdmin_phone(), a.getAdmin_pw());
	}

	//관리자(본인) 패스워드 변경
	@Override
	public int pwChange(Admin a) {
		String sql = "UPDATE administ\r\n" + 
				"SET admin_pw = ?\r\n" + 
				"WHERE admin_id = ?\r\n" + 
				"AND admin_pw = ?";
		return this.jdbcTemplate.update(sql, a.getAdmin_newPw(), a.getAdmin_id(), a.getAdmin_pw());
	}

	//관리자 패스워드 초기화
	@Override
	public int pwReset(Admin a) {
		String sql = "UPDATE administ\r\n" + 
				"SET admin_pw = ?\r\n" + 
				"WHERE admin_id = ?\r\n" + 
				"AND admin_pw = ?";
		return this.jdbcTemplate.update(sql, a.getAdmin_newPw(), a.getAdmin_id(), a.getAdmin_pw());
	}
	
	@Override
	public int lockUpdate(Admin a) {
		String sql = "UPDATE administ\r\n" + 
				"SET locking = ?\r\n" + 
				"WHERE admin_id = ?";
		return this.jdbcTemplate.update(sql, a.getLocking(), a.getAdmin_id());
	}

	//관리자 메인 화면 그래프
	@Override
	public List<GraphOnly> adminGraph() {
		String sql = "SELECT cr.class_Name, cr.class_limit\r\n" + 
				"	, (SELECT COUNT(ch.student_ID) \r\n" + 
				"		FROM course_history ch, open_course oc\r\n" + 
				"		WHERE ch.open_Course_ID = oc.open_Course_ID\r\n" + 
				"        AND oc.class_ID = cr.class_ID\r\n" + 
				"        AND curdate() BETWEEN oc.course_Start_Date AND oc.course_End_Date) success\r\n" + 
				"	, (SELECT COUNT(cfh.student_ID) \r\n" + 
				"		FROM course_fail_history cfh, open_course oc \r\n" + 
				"        WHERE cfh.open_Course_ID = oc.open_Course_ID\r\n" + 
				"        AND oc.class_ID = cr.class_ID\r\n" + 
				"        AND curdate() BETWEEN oc.course_Start_Date AND oc.course_End_Date) fail\r\n" + 
				"FROM classroom cr";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<GraphOnly>(GraphOnly.class));
	}

	//관리자 메인 화면 대쉬보드
	@Override
	public List<OpenCourse> adminDash() {
		String sql = "SELECT cr.class_Name, co.course_Name, oc.course_Start_Date, oc.course_End_Date\r\n" + 
				"FROM open_course oc, classroom cr, course co\r\n" + 
				"WHERE oc.class_ID = cr.class_ID\r\n" + 
				"AND oc.course_ID = co.course_ID\r\n" + 
				"AND curdate() BETWEEN oc.course_Start_Date AND oc.course_End_Date\r\n" + 
				"ORDER BY cr.class_Name";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<OpenCourse>(OpenCourse.class));
	}

}
