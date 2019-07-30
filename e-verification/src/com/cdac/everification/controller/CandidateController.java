package com.cdac.everification.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.DocumentMaster;
import com.cdac.everification.model.Organization;
import com.cdac.everification.service.CandidateService;

@Controller
public class CandidateController {
	@Autowired
	private CandidateService candidateService;
	
	@RequestMapping(value = "/prep_candilogin_form.htm")
	public String prepLoginForm(ModelMap model) {
		model.put("candi", new Candidate());
		return "Candidate/CandidateLogin";
	}
	
	@RequestMapping(value = "/prep_candiReg_form.htm")
	public String prepRegForm(ModelMap model) {
		model.put("candi", new Candidate());
		return "Candidate/Candidate_Registration";
	}
	
	@RequestMapping(value = "/candiReg.htm")
	public String register(Candidate candi,ModelMap model) {
		System.out.println("22222222222");
		candidateService.createUser(candi);
		model.put("candi", new Candidate());
		return "Candidate/CandidateLogin";
		
	}
	
	@RequestMapping(value = "/candiLogin.htm")
	public String login(Candidate candi,ModelMap model,HttpSession session) {
		
		Candidate c = candidateService.checkUser(candi);
		System.out.println();
		if(c!=null) {
			model.put("candiDoc", new CandiDocs());
			session.setAttribute("candi", c);
			return "Candidate/CandidateWelcome";
		}
		model.put("user", new Candidate());
		return "Candidate/CandidateLogin";
	}
	
	@RequestMapping(value = "/upload_doc.htm")
	public String register(@RequestParam("id") int id, CandiDocs candi,ModelMap model) {
		candi.setDocStatus("Valid");
		candi.setCandiId(id);
		candidateService.saveDocs(candi);
		model.put("candi", new Candidate());
		return "Candidate/CandidateLogin";
		
	}
	
	@RequestMapping(value = "/candi_doc_list.htm")
	public String register(@RequestParam("id") int id,ModelMap model) {
		
		List<CandiDocs> ulist =candidateService.showList(id);
		String candiName=candidateService.getCName(id);
		System.out.println(ulist.size()+": Size");
		List<String> docName=new ArrayList<String>();
		for(int i=0;i<ulist.size();i++)
		{
			String docName1=candidateService.getDName(ulist.get(i).getDocId());
			docName.add(docName1);	
		}
		
		List<String>ul=new ArrayList<String>();
		ul.add(candiName);
		model.put("ul", ulist);
		model.put("cName", ul);
		model.put("dName", docName);

		return "Candidate/CandiDocList";
		
	}
	
//	private void initModelList(Model model) {
//        List<String> Genders = new ArrayList<String>();
//        Genders.add("Male");
//        Genders.add("Female");
//        model.addAttribute("Gender", Genders);
//    }
	
}
