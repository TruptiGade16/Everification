package com.cdac.everification.service;

import java.util.List;

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.Organization;





public interface OrgService {	
	public void createUser(Organization org);
	/*public void removeUser(int userId);
	public void modifyUser(User user);*/
	public List<Candidate> selectAllDoc(String userName);
	//public Organization checkUser(Organization org);
	public List<Organization> checkUser(String userName,String password);
	public List<CandiDocs>getAllDoc(int id);
	public String getDocNames(int id);


}