package com.cdac.everification.dao;

import com.cdac.everification.model.Admin;
import com.cdac.everification.model.Organization;

public interface AdminDao {
	public void save(Admin adm);	
	public Admin validateUser(Admin adm);
}
