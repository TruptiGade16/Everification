package com.cdac.everification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.everification.dao.CandidateDao;
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
	
	

}
