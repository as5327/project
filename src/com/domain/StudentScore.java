package com.domain;

public class StudentScore {

	//수강생 성적 번호, 수강생 번호, 시험번호
	private String student_score_id, student_id, exam_id;	
	//출결점수, 필기점수, 실기점수, 총 점수, 삭제가능여부
	private int attendance_score, written_score, performance_score
			, total_score, score_del;
	
	public String getStudent_score_id() {
		return student_score_id;
	}
	public void setStudent_score_id(String student_score_id) {
		this.student_score_id = student_score_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	public int getAttendance_score() {
		return attendance_score;
	}
	public void setAttendance_score(int attendance_score) {
		this.attendance_score = attendance_score;
	}
	public int getWritten_score() {
		return written_score;
	}
	public void setWritten_score(int written_score) {
		this.written_score = written_score;
	}
	public int getPerformance_score() {
		return performance_score;
	}
	public void setPerformance_score(int performance_score) {
		this.performance_score = performance_score;
	}
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public int getScore_del() {
		return score_del;
	}
	public void setScore_del(int score_del) {
		this.score_del = score_del;
	}
		
}
