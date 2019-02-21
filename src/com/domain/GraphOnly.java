package com.domain;

//그래프 전용 자료형 클래스
public class GraphOnly {
	//강의실명
	private String class_name;
	//정원, 수강인원, 중도포기 인원
	private int class_limit, success, fail;
	
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getClass_limit() {
		return class_limit;
	}
	public void setClass_limit(int class_limit) {
		this.class_limit = class_limit;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
	
	
}
