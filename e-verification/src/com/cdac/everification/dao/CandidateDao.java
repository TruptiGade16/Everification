package com.cdac.everification.dao;

import java.util.List;

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;;

public interface CandidateDao {
	public void save(Candidate candi);	
	/*public void deleteByUserName(String userName);	
	public void update(Candidate candi) ;
	public List<Candidate> getAll() ;*/
	public Candidate validateUser(Candidate candi);
	
	//Candidocs
	
	public void createDocs(CandiDocs candi);
	public List<CandiDocs>getList(int id);
	public String getCandiName(int id);
	public String getDocName(int id);
}