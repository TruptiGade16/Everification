package com.cdac.everification.service;

import com.cdac.everification.model.Admin;
import com.cdac.everification.model.Organization;

public interface AdminService {
	public void createUser(Admin adm);
	public Admin checkUser(Admin adm);
}
