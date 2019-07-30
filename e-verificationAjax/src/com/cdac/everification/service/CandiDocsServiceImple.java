package com.cdac.everification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.everification.dao.CandiDocsDao;
import com.cdac.everification.dao.CandidateDao;
import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.DocumentMaster;
import com.cdac.everification.model.Organization;

@Service
public class CandiDocsServiceImple implements CandiDocsService{

	@Autowired
	private CandiDocsDao candiDocsDao;
	
	@Override
	public List<CandiDocs> getAllDoc(int id) {
		List<CandiDocs> list=candiDocsDao.getAllDoc(id);
		return list;
	}
	
	/*@Override
	public List<CandiDocs> getAllDocById(int id) {
		List<CandiDocs> list=candiDocsDao.getAllDocById(id);
		return list;
	}*/

	
}
