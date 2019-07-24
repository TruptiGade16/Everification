package com.cdac.everification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.everification.dao.AdminDao;
import com.cdac.everification.dao.AdminDaoImple;
import com.cdac.everification.dao.OrgDao;
import com.cdac.everification.model.Admin;
import com.cdac.everification.model.Organization;

@Service
public class AdminServiceImple implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	
	public void createUser(Admin adm) {
		
		adminDao.save(adm);
	}
	
	@Override
	public Admin checkUser(Admin adm) {
		System.out.println("before service");
		return adminDao.validateUser(adm);
	}
	
	
}
