package com.cdac.everification.controller;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.DocumentMaster;
import com.cdac.everification.model.Organization;
import com.cdac.everification.model.Product;
import com.cdac.everification.service.CandidateService;

@Controller
public class CandidateController {
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private CandidateService candidateService;

	@RequestMapping(value = "/prep_candilogin_form.htm")
	public String prepLoginForm(ModelMap model,Candidate candi) {
		model.put("candi", new Candidate());
		return "Candidate/CandidateLogin";
	}

	@RequestMapping(value = "/prep_candiReg_form.htm")
	public String prepRegForm(ModelMap model) {

		model.put("candi", new Candidate());
		return "Candidate/Candidate_Registration";
	}

	@RequestMapping(value = "/candiReg.htm")
	public String register(@RequestParam("file") MultipartFile file,Candidate candi,ModelMap model) throws IllegalStateException, IOException {
		String path=candidateService.createUser(candi);
		System.out.println("D://adv java//e-verificationAjax//WebContent//assets//profilePic//"+path);

		String filePath= "D://adv java//e-verificationAjax//WebContent//assets//profilePic//"+path; 
		File dir = new File(filePath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(dir);

		model.put("candi", new Candidate());
		return "Candidate/CandidateLogin";

	}

	@RequestMapping(value = "/candiLogin.htm")
	public String login(Candidate candi,ModelMap model,HttpSession session) {

		Candidate c = candidateService.checkUser(candi);
		//System.out.println("in login: " + c);
		if(c!=null) {
			List<DocumentMaster> list=candidateService.getAllDocType();
			model.put("list", list);
			model.put("candiDoc", new CandiDocs());
			session.setAttribute("candi", c);
			//System.out.println("redirect: Candidate/CandidateWelcome" );
			return "Candidate/CandidateWelcome";
		}
		//System.out.println("redirect: Candidate/CandidateLogin" );
		model.put("error", "Username or Password not maching");
		model.put("candi", candi);
		return "Candidate/CandidateLogin";
	}

	@RequestMapping(value = "/upload_doc.htm")
	public String uploadDoc(@RequestParam("file") MultipartFile file,@RequestParam("id") int candiId,@RequestParam("name") String candiName,CandiDocs candiDoc, ModelMap model, HttpSession session) throws IllegalStateException, IOException {

		String tem= candiId+ "_" + candiDoc.getDocId()+".jpg";
		String filePath= "D://adv java//e-verification//WebContent//assets//"+tem; 
		File dir = new File(filePath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(dir);
		candiDoc.setDocStatus("Uploaded");
		candiDoc.setCandiId(candiId);
		candiDoc.setDocPath(tem);
		candidateService.saveDocs(candiDoc);
		Candidate c=new Candidate();
		c.setCandiId(candiId);
		c.setCandiFname(candiName);
		List<DocumentMaster> list=candidateService.getAllDocType();
		model.put("list", list);
		model.put("candiDoc", new CandiDocs());
		session.setAttribute("candi", c);
		return "Candidate/CandidateWelcome";
	}

	@RequestMapping(value = "/candi_doc_list.htm")
	public String getDocList(@RequestParam("id") int id,ModelMap model) {

		List<CandiDocs> ulist =candidateService.showList(id);
		String candiName=candidateService.getCName(id);
		//System.out.println(ulist.size()+": Size");
		List<String> docName=new ArrayList<String>();
		if(docName!=null) 
		{
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
		}else{
			return "error";
		}
	}

	@RequestMapping(value="/updateDocStatusofCandidate.htm")
	public String updateDocStatusofCandidate(@RequestParam("docId")int docId,ModelMap model,@RequestParam("candiId") int candiId) {

		System.out.println(docId+"   "+candiId);
		candidateService.updateDocStatusofCandidate(docId);

		List<CandiDocs> ulist =candidateService.showList(candiId);
		String candiName=candidateService.getCName(candiId);
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
	@RequestMapping(value = "/viewDoc.htm")
	public String viewDoc(@RequestParam("docPath") String docPath,ModelMap model) {

		System.out.println("Path " +docPath);
		model.put("docPath", docPath);
		return "Document";
	}

}
