package com.cdac.everification.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.everification.model.Admin;
import com.cdac.everification.service.AdminService;


@Controller 
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/prep_login_form1.htm")
	public String prepLoginForm1(ModelMap model) {
		model.put("adm", new Admin());
		return "Admin/AdminLogin";
	}
	
	@RequestMapping(value = "/prep_OrgReg_form1.htm")
	public String prepRegForm1(ModelMap model) {
		model.put("adm", new Admin());
		return "Admin/Admin_Registration";
	}
	

	@RequestMapping(value = "/AdminReg.htm")
	public String register1(Admin adm,ModelMap model) {
		//System.out.println("hello");
		//adm.setAdminPassword(Encryption.encrypt(adm.getAdminPassword()));
  		adminService.createUser(adm);
		System.out.println("after..");
		model.put("adm", new Admin());
		return "Admin/AdminLogin";
	}
	

	@RequestMapping(value = "/login1.htm")
	public String login1(Admin adm,ModelMap model,HttpSession session) {
		model.put("adm", new Admin());
		Admin b = adminService.checkUser(adm);
		if(b!=null) {
			session.setAttribute("adm", b);
			
			return "Admin/AdminWelcome";
		}
		model.put("adm", new Admin());
		//return "Admin/AdminLogin";
		return "Admin/AdminLogin";
	}
	
}
