package com.cdac.everification.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.Organization;
import com.cdac.everification.service.CandiDocsService;
import com.cdac.everification.service.CandidateService;
import com.cdac.everification.service.OrgService;

@Controller
public class OrgController {

	 @Autowired
	private OrgService userService;
	 private CandidateService  candiService;
		private CandidateService  candidateService;
	 @Autowired
	private CandiDocsService candiDocsService;
	
	
	@RequestMapping(value = "/prep_login_form.htm")
	public String prepLoginForm(ModelMap model) {
		model.put("org", new Organization());
		return "Organization/OrgLogin";
	}

	@RequestMapping(value = "/prep_OrgReg_form.htm")
	public String prepRegForm(ModelMap model) {
		model.put("org", new Organization());
		return "Organization/Org_Registration";
	}

	@RequestMapping(value = "/orgReg.htm")
	public String register(Organization org, ModelMap model) {
		org.setPassword(Encryption.encrypt(org.getPassword()));
		System.out.println(org.getPassword());
		userService.createUser(org);
		model.put("org", new Organization());
		return "Organization/OrgLogin";
	}

	/*
	 * @RequestMapping(value = "/login.htm") public String login(Organization
	 * org,ModelMap model,HttpSession session) { model.put("org", new
	 * Organization()); Organization b = userService.checkUser(org); if(b!=null) {
	 * session.setAttribute("org", b);
	 * 
	 * return "Organization/welcomeOrg"; } model.put("org", new Organization());
	 * return "Organization/OrgLogin"; }
	 */
	
	@RequestMapping(value="/login.htm")
	public String login(Organization org, ModelMap model,HttpSession session) {
		String username = org.getUserName();
		String password = org.getPassword();
		List<Organization> ulist = userService.checkUser(username, Encryption.encrypt(password));
		if (ulist  != null) {
			session.setAttribute("org", ulist.get(0));
			model.put("ul", ulist);
					return "Organization/welcomeOrg";
		} else {
				return "HomePage";
		}
	}
	
	@RequestMapping(value="/loginList.htm")
	public @ResponseBody String userList(@RequestParam("id") int id, ModelMap model,HttpSession session) { 
		List<CandiDocs> ulist1 = candiDocsService.getAllDoc(id);
		if(ulist1!=null) {
		System.out.println("**=> " + ulist1);
		String s = "<table class=\"table\">";
		s += "<tr><td> <b>Sr No.</b> </td> <td> <b>Document Name</b> </td> <td> <b>Status</b> </td></tr>";
		for (CandiDocs candiDocs : ulist1) {	
			s+= "<tr> <td>" +  candiDocs.getId() + " </td> <td>" + candiDocs.getDocId() +"</td> <td>"+ candiDocs.getDocStatus() +"</td> </tr>"; 
		}
		s = s+ "</table>";
		return s; //ulist.toString();
		}else {
			return "error";
		}
		}
	
	@RequestMapping(value = "/userList.htm")
	public String userList(@RequestParam("userName") String userName, ModelMap model,HttpSession session) {
		List<Candidate> ulist = userService.selectAllDoc(userName);
		List<CandiDocs>docList=userService.getAllDoc(ulist.get(0).getCandiId());
		List<String>docType=new ArrayList<String>();
		for(int i=0;i<docList.size();i++)
		{
			String docName1=userService.getDocNames(docList.get(i).getDocId());
			docType.add(docName1);	
		}
		model.put("ul", ulist);
		model.put("docList", docList);
		model.put("docType", docType);
		return "Organization/welcomeOrgList";
	}

	/*@RequestMapping(value = "/userList1.htm")
	public String userList(@RequestParam("userName") int userName, ModelMap model,HttpSession session) {
		List<Organization> ulist = userService.getCandiDocs(userName);
		session.setAttribute("org", ulist.get(0));
		model.put("ul", ulist);
		return "Organization/welcomeOrgList";
	}*/

	
	
	/*
	 * @RequestMapping(value = "/delete_user.htm") public String
	 * deleteUser(@RequestParam int userId,ModelMap model) {
	 * userService.removeUser(userId); List<User> ulist =
	 * userService.selectAllUsers(); model.put("ul", ulist); return "user_list"; }
	 */
}