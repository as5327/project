package com.persistance;

import com.domain.CourseHistory;

public interface CourseHistoryDAO {
	
	//신규 수강 내역 추가
	public int courseHitoryAdd(CourseHistory ch);

	//기존 수강 내역 취소
	public int courseHistoryDelete(CourseHistory ch);
	
	//중도포기 등록
	public int courseFailHistoryAdd(CourseHistory cfh);

}
