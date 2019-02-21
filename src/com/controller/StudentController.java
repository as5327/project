package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.domain.OpenCourse;
import com.domain.Student;
import com.service.ExamService;
import com.service.OpenCourseService;
import com.service.OpenSubjectService;
import com.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource(name="studentService")
	private StudentService studentService;
	@Resource(name="openCourseService")
	private OpenCourseService openCourseService;
	@Resource(name="openSubjectService")
	private OpenSubjectService openSubjectService;
	@Resource(name="examService")
	private ExamService examService;
	
	String s= "ST001";
	@RequestMapping("/student.do")
	public String student(Model model) {
		Student student = new Student();
		student.setStudent_id(s);
		model.addAttribute("list",studentService.studentInfo(student));
		return "student/studentInfo";
	}
	
	@RequestMapping("/score1.do")
	public String score1(Model model) {
		Student student= new Student();
		student.setStudent_id(s);
		List<OpenCourse> list=  openCourseService.openCourseList_st(student);
		model.addAttribute("list",list);
		
		return "student/searchScore";
	}
	@RequestMapping("/score2.do")
	public String score2(Model model,@RequestParam("oc") String oc) {
		model.addAttribute("list1", openCourseService.openCourseList_st(s, oc));
		model.addAttribute("list2", openSubjectService.openSubjectList_student(s, oc));
		return "student/searchScore2";
	}
	@RequestMapping("/score3.do")
	public String score3(Model model,@RequestParam("oc") String oc, @RequestParam("os") String os) {
		model.addAttribute("list1",openCourseService.openCourseList_st(s, oc));
		model.addAttribute("list2", openSubjectService.openSubjectList_student(s, oc, os));
		model.addAttribute("list3",examService.exam_student(s, os));

		return "student/searchScore3";
	}
}
