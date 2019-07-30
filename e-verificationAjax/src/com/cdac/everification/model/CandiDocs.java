package com.cdac.everification.model;

import java.io.File;
import java.io.Serializable;
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
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="candiDocs")
public class CandiDocs implements Serializable{
	
	
	//private static final long serialVersionUID = 74458L;
	
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
	@Column(name = "doc_status")
	private String docStatus;
	/*@Transient
	private MultipartFile file;*/
	
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
	//	this.file=file;
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
	
/*	@Transient
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}*/

	@Override
	public String toString() {
		return "CandiDocs [id=" + id + ", candiId=" + candiId + ", docId=" + docId + ", docPath=" + docPath
				+ ", docStatus=" + docStatus + "]";
	}
	
	

	
}
