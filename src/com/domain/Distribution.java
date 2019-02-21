package com.domain;

public class Distribution {

	//배점번호, 시험번호
	private String distribution_id, exam_id;
	//출결배점, 필기배점, 실기배점, 총 배점, 삭제가능여부
	private int attendance_distribution, written_distribution, performance_distribution
			, total_distribution, distribution_del;
	
	public String getDistribution_id() {
		return distribution_id;
	}
	public void setDistribution_id(String distribution_id) {
		this.distribution_id = distribution_id;
	}
	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	public int getAttendance_distribution() {
		return attendance_distribution;
	}
	public void setAttendance_distribution(int attendance_distribution) {
		this.attendance_distribution = attendance_distribution;
	}
	public int getWritten_distribution() {
		return written_distribution;
	}
	public void setWritten_distribution(int written_distribution) {
		this.written_distribution = written_distribution;
	}
	public int getPerformance_distribution() {
		return performance_distribution;
	}
	public void setPerformance_distribution(int performance_distribution) {
		this.performance_distribution = performance_distribution;
	}
	public int getTotal_distribution() {
		return total_distribution;
	}
	public void setTotal_distribution(int total_distribution) {
		this.total_distribution = total_distribution;
	}
	public int getDistribution_del() {
		return distribution_del;
	}
	public void setDistribution_del(int distribution_del) {
		this.distribution_del = distribution_del;
	}
	
	
}
