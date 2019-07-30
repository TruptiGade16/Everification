package com.cdac.everification.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.DocumentMaster;
import com.cdac.everification.model.Organization;



@Repository
public class OrgDaoImple implements OrgDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void save(final Organization org) {
		hibernateTemplate.execute(new HibernateCallback<List<Organization>>() {
			public List<Organization> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				org.setOrgStatus("Requested");
				session.save(org);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
	}

	/*public void deleteById(final int userId) {
		hibernateTemplate.execute(new HibernateCallback<List<User>>() {
			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.delete(new User(userId));
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
	}

	public void update(final User user) {
		
		hibernateTemplate.execute(new HibernateCallback<List<User>>() {
			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.update(user);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
	}*/
	@Override
	@Transactional(readOnly = true)
	public List<Organization> validateUser(String userName,String password) {
		List<Organization> ul = hibernateTemplate.execute(new HibernateCallback<List<Organization>>() {
			public List<Organization> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Organization where userName = ? and password = ? and orgStatus=?");
				q.setString(0,userName);
				q.setString(1, password);
				q.setString(2,"Valid");
				List<Organization> userList = q.list();
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
	public List<Candidate> getAllDoc(String userName) {
		List<Candidate> ul = hibernateTemplate.execute(new HibernateCallback<List<Candidate>>() {
			public List<Candidate> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Candidate where candiUserName=?");
				q.setString(0, userName);
				List<Candidate> userList = q.list();
				t.commit();
				session.flush();
				session.close();

				return userList;
			}
		});
		return ul;
	}	
	
	@Override
	public List<CandiDocs>getAllDoc(int id)
	{
		List<CandiDocs> ul = hibernateTemplate.execute(new HibernateCallback<List<CandiDocs>>() {
			public List<CandiDocs> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from CandiDocs where candiId=? and docStatus=?");
				q.setInteger(0, id);
				q.setString(1, "Valid");
				List<CandiDocs> userList = q.list();
				t.commit();
				session.flush();
				session.close();

				return userList;
			}
		});
		return ul;
		
	}
	
	@Override
	public String getDocNames(int id)
	{
		List<DocumentMaster> ul = hibernateTemplate.execute(new HibernateCallback<List<DocumentMaster>>() {
			public List<DocumentMaster> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from DocumentMaster where docId=?");
				q.setInteger(0, id);
				List<DocumentMaster> userList = q.list();
				t.commit();
				session.flush();
				session.close();
				return userList;
			}
		});
		if(!ul.isEmpty()) {
			String cand = ul.get(0).getDocType();
			//System.out.println("++++++++++++++ Doc :"+cand+"++++++++++++++++");

			return cand;
		}	
		return null;	
		
	}
	
	
	

	/*public List<CandiDocs> getCandiDocs(int candiId) {
		List<CandiDocs> ul = hibernateTemplate.execute(new HibernateCallback<List<CandiDocs>>() {
			public List<CandiDocs> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from CandiDocs where candiId=?");
				q.setInteger(0,candiId);
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
	/*@Override
	public Organization validateUser(Organization org) {
		List<Organization> ul = hibernateTemplate.execute(new HibernateCallback<List<Organization>>() {
			public List<Organization> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Organization where userName = ? and password = ?");
				q.setString(0, org.getUserName());
				q.setString(1, org.getPassword());
				List<Organization> userList = q.list();
				t.commit();
				session.flush();
				session.close();
				return userList;
			}
		});
		if(!ul.isEmpty()) {
			Organization orgg = ul.get(0);
			return orgg;
		}	
		return null;
	}*/
	
	
	
		
	/*	
		return SessionFactory.getCurrentSession().createQuery(
	"from User where userName=? and password=?")
	.setString("user",org.getUserName()).setString("password",org.getPassword()).list();
	
	q.setString(1, org.getPassword());
	}*/


	
}