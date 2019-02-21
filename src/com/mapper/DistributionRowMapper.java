package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Distribution;

public class DistributionRowMapper implements RowMapper<Distribution> {

	@Override
	public Distribution mapRow(ResultSet rs, int rowNum) throws SQLException {
		// 배점번호, 시험번호
		// 출결배점, 필기배점, 실기배점, 총 배점, 삭제가능여부

		Distribution distribution = new Distribution();

		distribution.setDistribution_id(rs.getString("distribution_id"));
		distribution.setExam_id(rs.getString("exam_Id"));
		distribution.setAttendance_distribution(rs.getInt("attendance_distribution"));
		distribution.setWritten_distribution(rs.getInt("written_distribution"));
		distribution.setPerformance_distribution(rs.getInt("performance_distribution"));
		distribution.setTotal_distribution(rs.getInt("total_distribution"));
		distribution.setDistribution_del(rs.getInt("distribution_del"));

		return distribution;
	}

}
