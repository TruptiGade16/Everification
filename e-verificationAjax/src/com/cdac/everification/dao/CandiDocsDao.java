package com.cdac.everification.dao;

import java.util.List;

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.DocumentMaster;
import com.cdac.everification.model.Organization;

public interface CandiDocsDao {
	public List<CandiDocs> getAllDoc(int id);

	
	
//	List<CandiDocs> getAllDocById(int id);

}
