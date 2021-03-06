package com.cdac.everification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.everification.dao.CandidateDao;
import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;;

@Service
public class CandidateServiceImple implements CandidateService {
	@Autowired
	private CandidateDao candidateDao;

	@Override
	public void createUser(Candidate candi) {
		candidateDao.save(candi);	
	}

	@Override
	public Candidate checkUser(Candidate candi) {
		return candidateDao.validateUser(candi);
	}
	@Override
	public void saveDocs(CandiDocs cand)
	{
		candidateDao.createDocs(cand);
	}
	@Override
	public List<CandiDocs>showList(int id)
	{
		
		List<CandiDocs>ul=candidateDao.getList(id);
		return ul;
	}
	@Override
	public String getCName(int id)
	{
		String name=candidateDao.getCandiName(id);
		return name;
	}
	@Override
	public String getDName(int id)
	{
		String name=candidateDao.getDocName(id);
		return name;
	}
}
