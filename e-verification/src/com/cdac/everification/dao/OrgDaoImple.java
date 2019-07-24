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

import com.cdac.everification.model.Organization;



@Repository
public class OrgDaoImple implements OrgDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void save(final Organization org) {
		hibernateTemplate.execute(new HibernateCallback<List<Organization>>() {
			public List<Organization> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
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

	public List<Organization> getAllDoc(String userName) {
		List<Organization> ul = hibernateTemplate.execute(new HibernateCallback<List<Organization>>() {
			public List<Organization> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Organization");
				//q.setString(0, userName);
				List<Organization> userList = q.list();
				t.commit();
				session.flush();
				session.close();

				return userList;
			}
		});
		return ul;
	}	
	
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
	@Override
	@Transactional(readOnly = true)
	public List<Organization> validateUser(String userName,String password) {
		List<Organization> ul = hibernateTemplate.execute(new HibernateCallback<List<Organization>>() {
			public List<Organization> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Organization where userName = ? and password = ?");
				q.setString(0,userName);
				q.setString(1, password);
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
		
	/*	
		return SessionFactory.getCurrentSession().createQuery(
	"from User where userName=? and password=?")
	.setString("user",org.getUserName()).setString("password",org.getPassword()).list();
	
	q.setString(1, org.getPassword());
	}*/


	
}