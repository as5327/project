package com.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Exam {
	
	//개설과목번호, 시험파일명, 시험번호
	private String open_subject_id, exam_question_file, exam_id;
	//시험 날짜
	private Date exam_date;
	//배점번호
	private String distribution_id;
	//출결배점, 필기배점, 실기배점, 총 배점, 삭제가능여부
	private int attendance_distribution, written_distribution, performance_distribution
			, total_distribution, distribution_del;
	//수강생 성적 번호, 수강생 번호
	private String student_score_id, student_id;	
	//출결점수, 필기점수, 실기점수, 총 점수, 삭제가능여부
	private int attendance_score, written_score, performance_score
			, total_score, score_del;
	//시험파일
	private MultipartFile exam_question_file_;
	
	public MultipartFile getExam_question_file_() {
		return exam_question_file_;
	}
	public void setExam_question_file_(MultipartFile exam_question_file_) {
		this.exam_question_file_ = exam_question_file_;
	}
	public String getOpen_subject_id() {
		return open_subject_id;
	}
	public void setOpen_subject_id(String open_subject_id) {
		this.open_subject_id = open_subject_id;
	}
	public String getExam_question_file() {
		return exam_question_file;
	}
	public void setExam_question_file(String exam_question_file) {
		this.exam_question_file = exam_question_file;
	}
	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	public Date getExam_date() {
		return exam_date;
	}
	public void setExam_date(Date exam_date) {
		this.exam_date = exam_date;
	}
	public String getDistribution_id() {
		return distribution_id;
	}
	public void setDistribution_id(String distribution_id) {
		this.distribution_id = distribution_id;
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
