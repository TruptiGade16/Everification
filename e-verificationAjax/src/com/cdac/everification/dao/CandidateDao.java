package com.cdac.everification.dao;

import java.util.List;

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.DocumentMaster;;

public interface CandidateDao {
	public String save(Candidate candi);	
	/*public void deleteByUserName(String userName);	
	public void update(Candidate candi) ;
	public List<Candidate> getAll() ;*/
	public Candidate validateUser(Candidate candi);
	
	//Candidocs
	
	public void createDocs(CandiDocs candi);
	public List<CandiDocs>getList(int id);
	public String getCandiName(int id);
	public String getDocName(int id);
	public List<DocumentMaster> getAllDocType();
	public void updateDocStatusofCandidate(int id);

	
}