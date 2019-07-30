package com.cdac.everification.dao;

import java.util.List;

import com.cdac.everification.model.Admin;
import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.Organization;
import com.cdac.everification.model.PendingDoc;

public interface AdminDao {
	public void save(Admin adm);	
	public Admin validateUser(Admin adm);
	public List<Organization> getOrgList();
	public List<String>getPendingDocs();
	public List<String>getCandiName();
	public List<Integer>getDocId();
	public void updateDocStatus(int docId,String docStatus);
	public void updateOrgStatus(int orgId,String orgStatus);;
}
