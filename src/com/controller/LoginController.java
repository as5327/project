package com.controller;

import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.domain.Admin;
import com.domain.Instructor;
import com.domain.Student;
import com.service.AdminService;
import com.service.InstructorService;
import com.service.StudentService;

@Controller
public class LoginController {

	@Resource(name = "studentService")
	private StudentService studentService;
	@Resource(name = "instructorService")
	private InstructorService instructorService;
	@Resource(name = "adminService")
	private AdminService adminService;

	@RequestMapping("/index.do")
	public String main() {
		return "login/login";
	}

	@RequestMapping("/login/login.do")
	public String login(@RequestParam("inputId") String id_, @RequestParam("inputPassword") String pw_,
			@RequestParam("inlineRadioOptions") String choice, HttpSession session) {
		String url = null;
		System.out.println(1);
		try {
			if (choice.equals("admin")) {
				Admin admin = new Admin();
				admin.setAdmin_id(id_);
				admin.setAdmin_pw(pw_);
				Admin ad = adminService.adminLogin(admin);
				System.out.println(ad.getAdmin_id() +"  a");
				if (!Objects.isNull(ad)) {
					session.setAttribute("login", ad);
					url = "redirect:/admin/admin.do?admin_id=" + ad.getAdmin_id();
				} else {
					url = "redirect:/login/fail.do";
				}
			} else if (choice.equals("instructor")) {
				Instructor insturctor = new Instructor();
				/*insturctor.setInstructor_Name(id_);*/
				insturctor.setInstructor_Id(id_);
				insturctor.setInstructor_pw(pw_);
				Instructor is = instructorService.instructorLogin(insturctor);
				if (!Objects.isNull(is)) {
					session.setAttribute("login", is);
					url = "redirect:/instructor/instructor.do?instructor_id=" + is.getInstructor_Id();
				} else {
					url = "redirect:/login/fail.do";
				}
			} else if (choice.equals("student")) {
				Student student = new Student();
				student.setStudent_name(id_);
				student.setStudent_pw(pw_);
				Student s = studentService.studentlogin(student);
				if (!Objects.isNull(s)) {
					session.setAttribute("login", s);
					url = "redirect:/student/student.do?student_id=" + s.getStudent_id();
				} else {
					url = "redirect:/login/fail.do";
				}
			}
		} catch (DataAccessException dae) {
			System.out.println("DataAccessException!");
			url = "redirect:/login/fail.do";
		}
		return url;
	}

	@RequestMapping("/login/fail.do")
	public String loginFail() {
		return "login/loginFailForm";
	}

	@RequestMapping("/login/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/logoutForm";
	}
	
}
