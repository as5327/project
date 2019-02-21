package com.domain;

public class Subject {

	//과목번호, 과목명
	private String subject_Id, subject_Name;
	//삭제가능여부, 체크박스 전용
	private int subjectDel, checked;
	
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public String getSubject_Id() {
		return subject_Id;
	}
	public void setSubject_Id(String subject_Id) {
		this.subject_Id = subject_Id;
	}
	public String getSubject_Name() {
		return subject_Name;
	}
	public void setSubject_Name(String subject_Name) {
		this.subject_Name = subject_Name;
	}
	public int getSubjectDel() {
		return subjectDel;
	}
	public void setSubjectDel(int subjectDel) {
		this.subjectDel = subjectDel;
	}
	
	
}
