package com.cdac.everification.dao;

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
import com.cdac.everification.model.Organization;

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
}
