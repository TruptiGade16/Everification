package com.cdac.everification.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.DocumentMaster;
import com.cdac.everification.model.Organization;


public interface CandiDocsService {
	public List<CandiDocs> getAllDoc(int id);
	
	//List<CandiDocs> getAllDocById(int id);

}
