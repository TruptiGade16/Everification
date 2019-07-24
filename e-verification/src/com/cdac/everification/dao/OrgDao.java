package com.cdac.everification.dao;



import java.util.List;

import com.cdac.everification.model.Organization;



public interface OrgDao {	
	public void save(Organization org);	
	/*public void deleteById(int userId);	
	public void update(User user) ;*/
	public List<Organization> getAllDoc(String userName) ;
	//public Organization validateUser(Organization org);
	public List<Organization> validateUser(String userName,String password);
}
