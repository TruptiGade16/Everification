package com.cdac.everification.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organization")
public class Organization {
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name = "org_name")
	private String orgName;
	@Column(name = "org_email")
	private String email;
	@Column(name = "org_phone")
	private String phone;
	@Column(name = "org_city")
	private String city;
	@Column(name = "org_state")
	private String state;
	@Column(name="org_status")
	private String orgStatus;
	@Column(name = "org_userName")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name = "org_docPath")
	private String docPath;
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Organization(int id, String orgName, String email, String phone, String city, String state, String userName,
			String password, String docPath,String st) {
		super();
		this.id = id;
		this.orgName = orgName;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.userName = userName;
		this.password = password;
		this.docPath = docPath;
		this.orgStatus=st;
	}
	public String getOrgStatus() {
		return orgStatus;
	}
	public void setOrgStatus(String orgStatus) {
		this.orgStatus = orgStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDocPath() {
		return docPath;
	}
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}
	@Override
	public String toString() {
		return id + "  "+ orgName + "  " + email + "  " + phone + "  "
				+ city + "  " + state + "  " + userName + "  " + password + "  "
				+ docPath +"  " + orgStatus;
	}
	
}
	