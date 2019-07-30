package com.cdac.everification.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.everification.model.Admin;
import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.Organization;
import com.cdac.everification.model.PendingDoc;

@Repository
public class AdminDaoImple implements AdminDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	public void save(final Admin adm) {
		System.out.println("heyyy");
		hibernateTemplate.execute(new HibernateCallback<List<Admin>>() {
			public List<Admin> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.save(adm);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
	}
	
	
	@Override
	public Admin validateUser(Admin adm) {
		List<Admin> ul = hibernateTemplate.execute(new HibernateCallback<List<Admin>>() {
			public List<Admin> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Admin where adminId = ? and adminPassword = ?");
				q.setString(0, adm.getAdminId());
				q.setString(1, adm.getAdminPassword());
				List<Admin> userList = q.list();
				t.commit();
				session.flush();
				session.close();
				return userList;
			}
		});
		if(!ul.isEmpty()) {
			Admin admm = ul.get(0);
			return admm;
		}	
		return null;
	}
	
	@Override
	public List<Organization> getOrgList()
	{
		List<Organization> ul = hibernateTemplate.execute(new HibernateCallback<List<Organization>>() {
			public List<Organization> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Organization where orgStatus=?");
				q.setString(0, "Requested");
				List<Organization> userList = q.list();
				t.commit();
				session.flush();
				session.close();
				
				return userList;
			}
		});
		
		return ul;
	}
	
	
	@Override
	public List<String>getCandiName(){
		List<String> ul = hibernateTemplate.execute(new HibernateCallback<List<String>>() {
			public List<String> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				System.out.println("+++++++++");
				Query q = session.createQuery("select  candi.candiFname from CandiDocs candidoc,Candidate candi,DocumentMaster doc where candidoc.candiId=candi.candiId and candidoc.docId=doc.docId and candidoc.docStatus='Requested'");
				
				List<String> userList = q.list();
				 
				//System.out.println("+++++++++"+userList.get(0)+"  "+userList.get(1));

				t.commit();
				session.flush();
				session.close();
				return userList;
			}
		});
		if(!ul.isEmpty()) {
			
			return ul;
		}	
		return null;
	}
	
	@Override
	public List<String>getPendingDocs(){
		List<String> ul = hibernateTemplate.execute(new HibernateCallback<List<String>>() {
			public List<String> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				System.out.println("+++++++++");
				Query q = session.createQuery("select doc.docType from CandiDocs candidoc,Candidate candi,DocumentMaster doc where candidoc.candiId=candi.candiId and candidoc.docId=doc.docId and candidoc.docStatus='Requested'");
				
				List<String> userList = q.list();
				 
				//System.out.println("+++++++++"+userList.get(0)+"  "+userList.get(1));
				t.commit();
				session.flush();
				session.close();
				return userList;
			}
		});
		if(!ul.isEmpty()) {
			
			return ul;
		}	
		return null;
	}
	
	@Override
	public List<Integer>getDocId(){
		List<Integer> ul = hibernateTemplate.execute(new HibernateCallback<List<Integer>>() {
			public List<Integer> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				System.out.println("+++++++++");
				Query q = session.createQuery("select candidoc.id from CandiDocs candidoc,Candidate candi,DocumentMaster doc where candidoc.candiId=candi.candiId and candidoc.docId=doc.docId and candidoc.docStatus='Requested'");
				
				List<Integer> userList = q.list();
				 
			//	System.out.println("+++++++++"+userList.get(0));
				t.commit();
				session.flush();
				session.close();
				return userList;
			}
		});
		if(!ul.isEmpty()) {
			
			return ul;
		}	
		return null;
	}
	
	@Override
	public void updateDocStatus(int docId,String docStatus)
	{
		List<CandiDocs> ul = hibernateTemplate.execute(new HibernateCallback<List<CandiDocs>>() {
			public List<CandiDocs> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from CandiDocs where id=?");
				q.setInteger(0,docId);
				List<CandiDocs>list=q.list();
				list.get(0).setDocStatus(docStatus);
				session.update(list.get(0));
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
	}

	@Override
	public void updateOrgStatus(int orgId,String orgStatus)
	{
		System.out.println("*********************************************************************");
		List<Organization> ul = hibernateTemplate.execute(new HibernateCallback<List<Organization>>() {
			public List<Organization> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Organization where id=?");
				q.setInteger(0,orgId);
				List<Organization>list=q.list();
				list.get(0).setOrgStatus(orgStatus);
				session.update(list.get(0));
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
	}
}
