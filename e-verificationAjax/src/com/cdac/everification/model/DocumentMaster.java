package com.cdac.everification.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "docMaster")
public class DocumentMaster {

	@Id
	@GeneratedValue
	@Column(name = "doc_id", updatable = false, nullable = false)
	private int docId;
	@Column(name = "doc_type")
	private String docType;
	@OneToMany
	@JoinColumn(name = "doc_id")
	private List<CandiDocs> candiDocs = new ArrayList<CandiDocs>();
	

	public DocumentMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentMaster(int docId, String docType) {
		super();
		this.docId = docId;
		this.docType = docType;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	@Override
	public String toString() {
		return docId + "     " + docType;
	}
}
