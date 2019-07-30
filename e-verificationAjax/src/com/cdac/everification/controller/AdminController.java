package com.cdac.everification.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.everification.model.Admin;
import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.Organization;
import com.cdac.everification.model.PendingDoc;
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
		adminService.createUser(adm);
		//System.out.println("after..");
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
		return "Admin/AdminLogin";
	}
	@RequestMapping(value= "/PendingDocsList.htm")
	public String getPendingDocs(ModelMap model)
	{

		List<String>list=adminService.getPendingDocs();
		List<String>candiList=adminService.getCandiName();
		List<Integer>docId=adminService.getDocId();
		if(docId!=null) {
			model.put("candiName", candiList);
			model.put("docTypes", list);
			model.put("docId", docId);
			return "Admin/PendingDocsList";
		}else {
			return "error";
		}
	}
	@RequestMapping(value= "/PendingOrgList.htm")
	public String PendingOrgList(ModelMap model)
	{
		List<Organization> org=adminService.getPendingOrg();
		model.put("org", org);
		if(org!=null) {
			return "Admin/PendingOrgList";
		}else {
			return "error";
		}
	}

	@RequestMapping(value="/updateDocStatus.htm")
	public String updateDocStatus(@RequestParam("docId")int docId1,@RequestParam("docStatus")String docStatus,ModelMap model)
	{
		//System.out.println(docId+"**************"+orgStatus);
		if(!docStatus.equals("Select Option")) {
			System.out.println("*********************");

			adminService.updateDocStatus(docId1,docStatus);
		}


		List<String>list=adminService.getPendingDocs();
		List<String>candiList=adminService.getCandiName();
		List<Integer>docId=adminService.getDocId();

		model.put("candiName", candiList);
		model.put("docTypes", list);
		model.put("docId", docId);



		return "Admin/PendingDocsList";


	}

	@RequestMapping(value="/updateOrgStatus.htm")
	public String updateOrgStatus(@RequestParam("orgId")int orgId,@RequestParam("orgStatus")String orgStatus,ModelMap model)
	{System.out.println("*********************");
	if(!orgStatus.equals("Select Option")) {
		System.out.println("*********************");

		adminService.updateOrgStatus(orgId,orgStatus);
	}
	List<Organization> org=adminService.getPendingOrg();
	model.put("org", org);
	return "Admin/PendingOrgList";

	}

}
