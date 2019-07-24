package com.cdac.everification.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.everification.dao.OrgDao;
import com.cdac.everification.model.Organization;

@Service
public class OrgServiceImple implements OrgService {
	@Autowired
	private OrgDao userDao;
	
	@Override
	public void createUser(Organization org) {
		System.out.println("*****************************************servImple");
		userDao.save(org);
	}
	
	/*public void removeUser(int userId) {
		userDao.deleteById(userId);
	}
	
	public void modifyUser(User user) {
		userDao.update(user);
	}*/
	
	public List<Organization> selectAllDoc(String userName) {
		return userDao.getAllDoc(userName);
	}
	
	/*@Override
	public Organization checkUser(Organization org) {
		return userDao.validateUser(org);
	}*/
	@Override
	public List<Organization> checkUser(String userName,String password) {
		return userDao.validateUser(userName,password);
	}
}