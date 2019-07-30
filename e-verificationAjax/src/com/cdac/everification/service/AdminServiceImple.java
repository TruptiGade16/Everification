package com.cdac.everification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.everification.dao.AdminDao;
import com.cdac.everification.dao.AdminDaoImple;
import com.cdac.everification.dao.OrgDao;
import com.cdac.everification.model.Admin;
import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.Organization;
import com.cdac.everification.model.PendingDoc;

@Service
public class AdminServiceImple implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	
	public void createUser(Admin adm) {
		
		adminDao.save(adm);
	}
	
	@Override
	public Admin checkUser(Admin adm) {
		
		return adminDao.validateUser(adm);
	}
	
	public List<Organization> getPendingOrg()
	{
		List<Organization> orgList=adminDao.getOrgList();
		
		return orgList;
	}
	
	
	@Override
	public List<String>getPendingDocs(){
		List<String> list=adminDao.getPendingDocs();
		return list;
	}
	
	
	@Override
	public List<String>getCandiName(){
		List<String> list=adminDao.getCandiName();
		return list;
	}
	@Override
	public List<Integer>getDocId(){
		List<Integer>list=adminDao.getDocId();
		return list;
	}
	@Override
	public void updateDocStatus(int docId,String docStatus)
	{
		adminDao.updateDocStatus(docId,docStatus);
		
	}
	@Override
	public void updateOrgStatus(int orgId,String orgStatus)
	{	System.out.println("+++++++++++++++++++++++");
		adminDao.updateOrgStatus(orgId,orgStatus);
		
	}
}

