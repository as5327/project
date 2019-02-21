package com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Admin;
import com.domain.Book;
import com.domain.Classroom;
import com.domain.Course;
import com.domain.Exam;
import com.domain.Instructor;
import com.domain.OpenCourse;
import com.domain.OpenSubject;
import com.domain.Student;
import com.domain.Subject;
import com.persistance.ExamDAO;
import com.service.AdminService;
import com.service.BookService;
import com.service.ClassroomService;
import com.service.CourseService;
import com.service.InstructorService;
import com.service.OpenCourseService;
import com.service.OpenSubjectService;
import com.service.StudentService;
import com.service.SubjectService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource(name="adminService")
	private AdminService adminService;
	@Resource(name="studentService")
	private StudentService studentService;
	@Resource(name="openCourseService")
	private OpenCourseService openCourseService;
	@Resource(name="openSubjectService")
	private OpenSubjectService openSubjectService;
	@Resource(name="bookService")
	private BookService bookService;
	@Resource(name="classroomService")
	private ClassroomService classroomService;
	@Resource(name="courseService")
	private CourseService courseService;
	@Resource(name="subjectService")
	private SubjectService subjectService;
	@Resource(name="instructorService")
	private InstructorService instructorService;
	@Resource(name="examDAO")
	private ExamDAO examDAO;
	
	@RequestMapping("/admin.do")
	public String admin(Model model, Admin a, HttpSession session) {
		Admin admin = (Admin) session.getAttribute("login");
		a.setAdmin_id(admin.getAdmin_id());
		model.addAttribute("list", this.adminService.adminList(a));
		model.addAttribute("dash", this.adminService.adminDash());
		model.addAttribute("graph", this.adminService.adminGraph());
		return "admin/index";
	}
	
	@RequestMapping("/admin_information/adminManagement.do")
	public String adminManagement(Model model) {
		model.addAttribute("list", this.adminService.adminList_master());
		return "admin/admin_information/adminManagement";
	}
	
	@RequestMapping("/admin_information/insert.do")
	public String admin_insert(Admin a, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.adminService.adminAdd(a);
		if (result == 1) txt = "success";
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/admin_information/adminManagement.do";
	}
	
	@RequestMapping("/admin_information/lockUpdate.do")
	public String admin_lockUpdate(Admin a, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.adminService.lockUpdate(a);
		System.out.println(result);
		if (result == 1) txt = "success";
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/admin_information/adminManagement.do";
	}
	
	@RequestMapping("/basicInfo_management/subjectManagement.do")
	public String subjectManagement(Model model) {
		model.addAttribute("list", this.subjectService.subjectList());
		return "admin/basicInfo_management/subjectManagement";
	}
	
	@RequestMapping("/basicInfo_management/subject/insert.do")
	public String subject_insert(Subject s, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.subjectService.subjectAdd(s);
		if (result == 1) txt = "success";
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/basicInfo_management/subjectManagement.do";
	}
	
	@RequestMapping("/basicInfo_management/courseManagement.do")
	public String courseManagement(Model model) {
		model.addAttribute("list", this.courseService.courseList());
		return "admin/basicInfo_management/courseManagement";
	}
	
	@RequestMapping("/basicInfo_management/course/insert.do")
	public String course_insert(Course c, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.courseService.courseAdd(c);
		if (result == 1) txt = "success";
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/basicInfo_management/courseManagement.do";
	}
	
	@RequestMapping("/basicInfo_management/classManagement.do")
	public String classManagement(Model model) {
		model.addAttribute("list", this.classroomService.classroomList());
		return "admin/basicInfo_management/classManagement";
	}
	
	@RequestMapping("/basicInfo_management/class/insert.do")
	public String class_insert(Classroom cl, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.classroomService.classroomAdd(cl);
		if (result == 1) txt = "success";
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/basicInfo_management/classManagement.do";
	}

	@RequestMapping("/basicInfo_management/bookManagement.do")
	public String bookManagement(Model model) {
		model.addAttribute("list", this.bookService.bookList());
		return "admin/basicInfo_management/bookManagement";
	}
	
	//교재 추가 
	@RequestMapping("/basicInfo_management/book/insert.do")
	public String book_insert(Book b, RedirectAttributes rttr) {
		String txt = "fail";
		int result = this.bookService.bookAdd(b);
		if (result == 1) txt = "success";
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/basicInfo_management/bookManagement.do";
	}
	
	//강사 관리 
	@RequestMapping("/teacher_management/teacherManagement.do")
	public String teacherManagement(Model model) {
		model.addAttribute("list", this.instructorService.instructorList_adi_is());
		return "admin/teacher_management/teacherManagement";
	}
	
	//강의 가능 과목 모달 출력 
	@RequestMapping("/teacher_management/psList.do")
	public @ResponseBody List<Instructor> psList(Instructor is) {
		List<Instructor> temp = this.instructorService.possibleSubjectList(is);
		return temp;
	}
	
	//전과목 등록 모달 출력 
	@RequestMapping("/teacher_management/subList.do")
	public @ResponseBody List<Subject> subList() {
		List<Subject> temp = this.subjectService.subjectList();
		return temp;
	}
	
	//강사 관리 > 개설 과정
	@RequestMapping("/teacher_management/scheduleForEach.do")
	public String scheduleForEach(Model model, Instructor is) {
		is.setInstructor_Id("IS001");
		model.addAttribute("list", this.instructorService.instructorList_adi_is_schedule(is));
		model.addAttribute("ocList",this.openCourseService.openCourseList_adi_is_schedule(is));
		return "admin/teacher_management/scheduleForEach";
	}
	
	//강사 관리 > 개설 과정 > 개설 과목
	@RequestMapping("/teacher_management/scheduleForEach2.do")
	public String scheduleForEach2(Model model, Instructor is, OpenCourse oc, OpenSubject os) {
		is.setInstructor_Id("IS001");
		oc.setOpen_course_id("OC001");
		os.setInstructor_id("IS001");
		os.setOpen_course_id("OC001");
		model.addAttribute("list", this.instructorService.instructorList_adi_is_schedule(is));
		model.addAttribute("ocList",this.openCourseService.openCourseList_adi_is_schedule(is, oc));
		model.addAttribute("osList", this.openSubjectService.openSubjectList_adi_is_schedule(os));
		return "admin/teacher_management/scheduleForEach2";
	}
	
	//강사 추가 
	@RequestMapping("/teacher_management/insert.do")
	public String teacher_insert(Model model, Instructor is) {
		model.addAttribute("list", this.instructorService.instructorList_adi_is());
		is.setInstructor_Id("IS004");
		model.addAttribute("psList", this.instructorService.possibleSubjectList(is));
		return "redirect:/admin/teacher_management/teacherManagement.do";
	}
	
	//개설 과정 관리 
	@RequestMapping("/open_course_management/openCourse.do")
	public String openCourse(Model model) {
		model.addAttribute("list", this.openCourseService.openCourseList_adi_oc());
		return "admin/open_course_management/openCourse";
	}
	
	//개설 과목 관리 > 개설과정
	@RequestMapping("/open_subject_management/openSubject.do")
	public String openSubject(Model model) {
		model.addAttribute("list",this.openCourseService.openCourseList_adi_oc());
		return "admin/open_subject_management/openSubject";
	}
	
	//개설 과목 관리 > 개설과정 > 개설과목
	@RequestMapping("/open_subject_management/openSubject2.do")
	public String openSubject2(Model model, OpenCourse oc, OpenSubject os) {
		oc.setOpen_course_id("OC001");
		os.setOpen_course_id("OC001");
		model.addAttribute("ocList",this.openCourseService.openCourseList_adi_oc(oc));
		model.addAttribute("osList", this.openSubjectService.openSubjectList_adi_os(os));
		
		return "admin/open_subject_management/openSubject2";
	}
	
	//수강생 목록
	@RequestMapping("/student_management/student_list.do")
	public String student_list(Model model) {
		model.addAttribute("list", this.studentService.slist());
		return "admin/student_management/student_list";
	}
	
	// 수강생 입력
	@RequestMapping("/student_management/insert.do")
	public String add(Student s, RedirectAttributes rttr) {

		int result = 0;
		String txt = "수강생 입력 실패";
		if (s.getStudent_name() != null) {
			result = this.studentService.studentAdd(s);
			if (result == 1) {
				txt = "수강생 입력 성공";
			}
		}
		rttr.addFlashAttribute("result", txt);

		return "forward:/admin/student_management/student_list.do";

	}

	// 수강생 삭제
	@RequestMapping("/student_management/delete.do")
	public String delete(Student s, RedirectAttributes rttr) {
		int result = 0;

		String txt = "수강생 삭제 실패";
		if (s.getStudent_id() != null) {
			result = this.studentService.studentDelete(s);
			if (result == 1) {
				txt = "수강생 삭제 성공";
			}
		}
		rttr.addFlashAttribute("result", txt);

		return "forward:/admin/student_management/student_list.do";
	}

	// 수강생 수정
	@RequestMapping("/student_management/update.do")
	public String update(Student s, RedirectAttributes rttr) {
		int result = 0;

		String txt = "수강생 수정 실패";
		if (s.getStudent_id() != null) {
			result = this.studentService.studentUpdate(s);
			if (result == 1) {
				txt = "수강생 수정 성공";
			}
		}
		rttr.addFlashAttribute("result", txt);

		return "forward:/admin/student_management/student_list.do";
	}

	// 수강생 수강 과정 정보.
	@RequestMapping("/student_management/student_lectureCourse.do")
	public String student_lectureCourse(Model model, String student_id) {

		Student student = new Student();
		student.setStudent_id(student_id);

		model.addAttribute("list", this.openCourseService.openCourseList_st(student));

		return "admin/student_management/student_lectureCourse";
	}
	
	//수강생 과정 관리 
	@RequestMapping("/student_management/student_course.do")
	public String student_course(Model model) {
		model.addAttribute("list", this.studentService.slist());
		return "admin/student_management/student_course";
	}
	
	//개설 과목별 성적 조회 > 개설과정
	@RequestMapping("/score_management/score_for_each_subject.do")
	public String score_for_each_subject(Model model) {
		model.addAttribute("list", this.openCourseService.openCourseList_adi_score());
		return "admin/score_management/score_for_each_subject";
	}
	
	//개설 과목별 성적 조회 > 개설과정 > 개설과목
	@RequestMapping("/score_management/score_for_each_subject2.do")
	public String score_for_each_subject2(Model model, OpenCourse oc) {
		oc.setOpen_course_id("OC001");
		model.addAttribute("oc", this.openCourseService.openCourseList_adi_score(oc));
		model.addAttribute("list", this.openSubjectService.openSubjectList_adi_score_subject(oc));
		return "admin/score_management/score_for_each_subject2";
	}
	
	//개설 과목별 성적 조회 > 개설과정 > 개설과목 > 배점정보
	@RequestMapping("/score_management/score_for_each_subject3.do")
	public String score_for_each_subject3(Model model, OpenCourse oc, OpenSubject os) {
		oc.setOpen_course_id("OC001");
		os.setOpen_subject_id("OS001");
		model.addAttribute("oc", this.openCourseService.openCourseList_adi_score(oc));
		model.addAttribute("os", this.openSubjectService.openSubjectList_adi_score_subject(os));
		model.addAttribute("list", this.examDAO.examList_adi_score(os));
		return "admin/score_management/score_for_each_subject3";
	}
	
	//개설 과목별 성적 조회 > 개설과정 > 개설과목 > 배점정보 > 성적정보
	@RequestMapping("/score_management/score_for_each_subject4.do")
	public String score_for_each_subject4(Model model, OpenCourse oc, OpenSubject os, Exam ex) {
		oc.setOpen_course_id("OC001");
		os.setOpen_subject_id("OS001");
		ex.setOpen_subject_id("OS001");
		ex.setExam_id("EX001");
		model.addAttribute("oc", this.openCourseService.openCourseList_adi_score(oc));
		model.addAttribute("os", this.openSubjectService.openSubjectList_adi_score_subject(os));
		model.addAttribute("ex", this.examDAO.examList_adi_score(ex));
		model.addAttribute("list", this.studentService.studentList_adi_score(ex));
		return "admin/score_management/score_for_each_subject4";
	}
		
	
	//수강생별 성적 조회 > 수강생 리스트
	@RequestMapping("/score_management/score_for_each_student.do")
	public String score_for_each_student(Model model) {
		model.addAttribute("list", this.studentService.slist());
		return "admin/score_management/score_for_each_student";
	}
	
	//수강생별 성적 조회 > 수강생 리스트 > 개설과정
	@RequestMapping("/score_management/score_for_each_student2.do")
	public String score_for_each_student2(Model model, Student s) {
		s.setStudent_id("ST001");
		model.addAttribute("st", this.studentService.studentinfo_adi_score(s));
		model.addAttribute("list", this.openCourseService.openCourseList_adi_score(s));
		return "admin/score_management/score_for_each_student2";
	}
	
	//수강생별 성적 조회 > 수강생 리스트 > 개설과정 > 개설과목
	@RequestMapping("/score_management/score_for_each_student3.do")
	public String score_for_each_student3(Model model, Student s, OpenCourse oc) {
		s.setStudent_id("ST001");
		oc.setOpen_course_id("OC001");
		model.addAttribute("st", this.studentService.studentinfo_adi_score(s));
		model.addAttribute("oc", this.openCourseService.openCourseList_adi_score(s, oc));
		model.addAttribute("list", this.openSubjectService.openSubjectList_adi_score(oc));
		return "admin/score_management/score_for_each_student3";
	}
	
	//수강생별 성적 조회 > 수강생 리스트 > 개설과정 > 개설과목 > 성적정보
	@RequestMapping("/score_management/score_for_each_student4.do")
	public String score_for_each_student4(Model model, Student s, OpenCourse oc, OpenSubject os) {
		s.setStudent_id("ST001");
		oc.setOpen_course_id("OC001");
		os.setOpen_subject_id("OS001");
		model.addAttribute("st", this.	studentService.studentinfo_adi_score(s));
		model.addAttribute("oc", this.openCourseService.openCourseList_adi_score(s, oc));
		model.addAttribute("os", this.openSubjectService.openSubjectList_adi_score_1(os));
		model.addAttribute("list", this.examDAO.exam_student(s, os));
		return "admin/score_management/score_for_each_student4";
	}
}
