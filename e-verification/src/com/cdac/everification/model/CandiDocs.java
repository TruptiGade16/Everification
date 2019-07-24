package com.cdac.everification.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="candiDocs")
public class CandiDocs {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "candi_id")
	private int candiId;
	@Column(name = "doc_id")
	private int docId;
	@Column(name = "doc_path")
	private String docPath;
	@Column(name = "doc_statuas")
	private String docStatus;
	
	public CandiDocs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CandiDocs(int id, int candiId, int docId, String docPath, String docStatus) {
		super();
		this.id = id;
		this.candiId = candiId;
		this.docId = docId;
		this.docPath = docPath;
		this.docStatus = docStatus;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCandiId() {
		return candiId;
	}
	public void setCandiId(int candiId) {
		this.candiId = candiId;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocPath() {
		return docPath;
	}
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}
	public String getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	@Override
	public String toString() {
		return id + "   "+ candiId + "   " + docId + "   " + docPath + "   "
				+ docStatus;
	}
	
}
