package com.cdac.everification.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.everification.model.Organization;
import com.cdac.everification.service.OrgService;

@Controller
public class OrgController {

	 @Autowired
	private OrgService userService;

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
		System.out.println("*****************************************contra");
		System.out.println(org.getPassword());
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

	@RequestMapping(value = "/userList.htm")
	public String userList(@RequestParam("userName") String userName, ModelMap model,HttpSession session) {
		List<Organization> ulist = userService.selectAllDoc(userName);
		session.setAttribute("org", ulist.get(0));
		model.put("ul", ulist);
		// System.out.println(ulist.get(0));
		// System.out.println(ulist.get(1));
		return "Organization/welcomeOrgList";

	}

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

	/*
	 * @RequestMapping(value = "/delete_user.htm") public String
	 * deleteUser(@RequestParam int userId,ModelMap model) {
	 * userService.removeUser(userId); List<User> ulist =
	 * userService.selectAllUsers(); model.put("ul", ulist); return "user_list"; }
	 */
}