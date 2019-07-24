package com.cdac.everification.service;

import java.util.List;

import com.cdac.everification.model.Organization;





public interface OrgService {	
	public void createUser(Organization org);
	/*public void removeUser(int userId);
	public void modifyUser(User user);*/
	public List<Organization> selectAllDoc(String userName);
	//public Organization checkUser(Organization org);
	public List<Organization> checkUser(String userName,String password);


}