package com.cdac.everification.service;

import java.util.List;

import com.cdac.everification.model.Admin;
import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.Organization;
import com.cdac.everification.model.PendingDoc;

public interface AdminService {
	public void createUser(Admin adm);
	public Admin checkUser(Admin adm);
	public List<Organization> getPendingOrg();
	public List<String>getPendingDocs();
	public List<String>getCandiName();
	public List<Integer>getDocId();
	public void updateDocStatus(int docId,String docStatus);
	public void updateOrgStatus(int orgId,String orgStatus);

}
