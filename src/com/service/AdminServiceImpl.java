package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Admin;
import com.domain.GraphOnly;
import com.domain.OpenCourse;
import com.persistance.AdminDAO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Resource(name="adminDAO")
	private AdminDAO adminDAO;
	@Override
	public Admin adminLogin(Admin a) {
		return this.adminDAO.adminLogin(a);
	}

	@Override
	public Admin adminList(Admin a) {
		return this.adminDAO.adminList(a);
	}

	@Override
	public List<Admin> adminList_master() {
		return this.adminDAO.adminList_master();
	}

	@Override
	public int adminAdd(Admin a) {
		return this.adminDAO.adminAdd(a);
	}

	@Override
	public int pwChange(Admin a) {
		return this.adminDAO.pwChange(a);
	}

	@Override
	public int pwReset(Admin a) {
		return this.adminDAO.pwReset(a);
	}
	
	@Override
	public int lockUpdate(Admin a) {
		return this.adminDAO.lockUpdate(a);
	}

	@Override
	public List<GraphOnly> adminGraph() {
		return this.adminDAO.adminGraph();
	}

	@Override
	public List<OpenCourse> adminDash() {
		return this.adminDAO.adminDash();
	}


}
