package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Exam;
import com.domain.Instructor;
import com.domain.OpenCourse;
import com.service.ExamService;
import com.service.InstructorService;
import com.service.OpenCourseService;
import com.service.OpenSubjectService;
import com.service.StudentService;


@Controller
@RequestMapping("/instructor")
public class InstructorController {

	@Autowired
    private ServletContext context;
	
	@Resource(name="instructorService")
	private InstructorService instructorService;
	@Resource(name="openCourseService")
	private OpenCourseService openCourseService;
	@Resource(name="openSubjectService")
	private OpenSubjectService openSubjectService;
	@Resource(name="examService")
	private ExamService examService;
	@Resource(name="studentService")
	private StudentService studentService;
	
	//info
	String i = "IS001";
	@RequestMapping("/instructor.do")
	public String instructor(Model model) {
		Instructor instructor = new Instructor();
		instructor.setInstructor_Id(i);
		model.addAttribute("list",instructorService.instructorInfo(instructor));
		return "instructor/teacherInfo";
	}
	
	//강의 스케줄 조회
	@RequestMapping("/course_schedule/courseSchedule.do")
	public String courseSchedule() {
		return "instructor/course_schedule/courseSchedule";
	}
	
	//배점 관리
	@RequestMapping("/distribution_management/distribution_1_openCourse.do")
	public String distribution_1_openCourse(Model model) {
		Instructor instructor = new Instructor();
		instructor.setInstructor_Id(i);
		List<OpenCourse> list = openCourseService.openCourseList2_is(instructor);
		model.addAttribute("list", list);
		return "instructor/distribution_management/distribution_1_openCourse";
	}
	
	//개설 과목 보기
	@RequestMapping("/distribution_management/distribution_2_openSubject.do")
	public String distribution_2_openSubject(Model model, @RequestParam("oc") String oc) {
		model.addAttribute("list1", openCourseService.openCourseList2_is(i, oc));
		model.addAttribute("list2", openSubjectService.openSubjectList2_is(i, oc));
		return "instructor/distribution_management/distribution_2_openSubject";
	}
	
	//시험 정보 보기
	@RequestMapping("/distribution_management/distribution_3_exam.do")
	public String distribution_3_exam(Model model,@RequestParam("oc") String oc, @RequestParam("os") String os) {
		model.addAttribute("list1", openCourseService.openCourseList2_is(i, oc));
		model.addAttribute("list2", openSubjectService.openSubjectList2_is(i, oc, os));
		model.addAttribute("list3", examService.exam_is(i, oc, os));
		return "instructor/distribution_management/distribution_3_exam";
	}
	
	//배점 등록
	@RequestMapping("/distribution_management/distributionAdd.do")
	public String distributionAdd(Exam e, RedirectAttributes rttr) throws IOException {
		
		String txt = "fail";

		//파일업로드된 물리적 파일(exam_question_file_)에 대한 처리 필요
		MultipartFile fileName = e.getExam_question_file_();
		String uploadPath = this.context.getRealPath("") + "resources/examFile" + File.separator;
		String temp = fileName.getOriginalFilename();
		FileCopyUtils.copy(fileName.getBytes(), new File(uploadPath));
		
		//데이터베이스에 관련 자료(exam_question_file) 저장 처리 필요
		e.setExam_question_file(e.getExam_question_file_().getOriginalFilename());
		int result = this.examService.distributionAdd(e);
		if (result == 1) {
			txt = "success";
		}
	
		rttr.addFlashAttribute("result", txt);
		
		return null;
		/*return String.format("redirect:/instructor/distribution_management/distribution_3_exam.do?oc=%s&os=%s", e.getOpen_course_id(), e.getOpen_subject_id());*/
	}
	
	//배점 삭제
	@RequestMapping("/distribution_management/distributionDelete.do")
	public String distributionDelete(Exam e, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.examService.distributionDelete(e);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/instructor/distribution_management/distribution_3_exam.do";
	}
	
	//성적 관리
	@RequestMapping("/score_management/score_1_openCourse.do")
	public String score_1_openCourse(Model model) {
		Instructor instructor = new Instructor();
		instructor.setInstructor_Id(i);
		List<OpenCourse> list = openCourseService.openCourseList2_is(instructor);
		model.addAttribute("list", list);
		return "instructor/score_management/score_1_openCourse";
	}
	
	//성적 관리 과목
	@RequestMapping("/score_management/score_2_openSubject.do")
	public String score_2_openSubject(Model model, @RequestParam("oc") String oc) {
		model.addAttribute("list1", openCourseService.openCourseList2_is(i, oc));
		model.addAttribute("list2", openSubjectService.openSubjectList2_is(i, oc));
		return "instructor/score_management/score_2_openSubject";
	}
	
	//성적 관리 시험
	@RequestMapping("/score_management/score_3_exam.do")
	public String score_3_exam(Model model,@RequestParam("oc") String oc, @RequestParam("os") String os) {
		model.addAttribute("list1", openCourseService.openCourseList2_is(i, oc));
		model.addAttribute("list2", openSubjectService.openSubjectList2_is(i, oc, os));
		model.addAttribute("list3", examService.exam_is(i, oc, os));
		return "instructor/score_management/score_3_exam";
	}
	
	//성적 관리 학생
	@RequestMapping("/score_management/score_4_student.do")
	public String score_4_student(Model model,@RequestParam("oc") String oc, @RequestParam("os") String os, @RequestParam("ex") String ex) {
		model.addAttribute("list1", openCourseService.openCourseList2_is(i, oc));
		model.addAttribute("list2", openSubjectService.openSubjectList2_is(i, oc, os));
		model.addAttribute("list3", examService.exam2_is(i, oc, os, ex));
		model.addAttribute("list4", studentService.studentList2_is_score(i, oc, os));
		return "instructor/score_management/score_4_student";
	}
	
	//성적 등록
	@RequestMapping("/score_management/studentScoreAdd.do")
	public String studentScoreAdd(Exam e, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.examService.studentScoreAdd(e);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		return null;
		/*return String.format("redirect:/instructor/score_management/score_4_student.do?oc=%s&os=%s&ex=%s", e.getOpen_course_id(), e.getOpen_subject_id(), e.getExam_id());*/
	}
	
	//강의예정
	@RequestMapping("/course_schedule/courseSchedule_future.do")
	public String courseSchedule_future() {
		return "instructor/course_schedule/courseSchedule_future";
	}
	
	//강의 예정 보기
	@RequestMapping("/course_schedule/courseSchedule_future2.do")
	public String courseSchedule_future2() {
		return "instructor/course_schedule/courseSchedule_future2";
	}
	
	//강의 예정 보기2
	@RequestMapping("/course_schedule/courseSchedule_future3.do")
	public String courseSchedule_future3() {
		return "instructor/course_schedule/courseSchedule_future3";
	}
	
	//강의중 
	@RequestMapping("/course_schedule/courseSchedule_now.do")
	public String courseSchedule_now() {
		return "instructor/course_schedule/courseSchedule_now";
	}
	
	//강의 중 보기
	@RequestMapping("/course_schedule/courseSchedule_now2.do")
	public String courseSchedule_now2() {
		return "instructor/course_schedule/courseSchedule_now2";
	}
	
	//강의 중 보기2
	@RequestMapping("/course_schedule/courseSchedule_now3.do")
	public String courseSchedule_now3() {
		return "instructor/course_schedule/courseSchedule_now3";
	}
	
	//강의종료
	@RequestMapping("/course_schedule/courseSchedule_past.do")
	public String courseSchedule_past() {
		return "instructor/course_schedule/courseSchedule_past";
	}
	
	//강의종료 보기
	@RequestMapping("/course_schedule/courseSchedule_past2.do")
	public String courseSchedule_past2() {
		return "instructor/course_schedule/courseSchedule_past2";
	}
	
	//강의종료 보기2
	@RequestMapping("/course_schedule/courseSchedule_past3.do")
	public String courseSchedule_past3() {
		return "instructor/course_schedule/courseSchedule_past3";
	}

}
