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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.DocumentMaster;
import com.cdac.everification.model.Organization;
@Service
public class CandiDocsDaoImple implements CandiDocsDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<CandiDocs> getAllDoc(int id){
		List<CandiDocs> ul = hibernateTemplate.execute(new HibernateCallback<List<CandiDocs>>() {
			public List<CandiDocs> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from CandiDocs");
				List<CandiDocs> userList = q.list();
				t.commit();
				session.flush();
				session.close();

				return userList;
			}
		});
		return ul;
	}
	
	
	
	/*
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<CandiDocs> getAllDocById(int id){
		List<CandiDocs> ul = hibernateTemplate.execute(new HibernateCallback<List<CandiDocs>>() {
			public List<CandiDocs> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from DocumentMaster");
				List<CandiDocs> userList = q.list();
				t.commit();
				session.flush();
				session.close();

				return userList;
			}
		});
		return ul;
	}
*/
	


	
}
