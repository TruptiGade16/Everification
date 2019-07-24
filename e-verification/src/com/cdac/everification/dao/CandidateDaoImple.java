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

import com.cdac.everification.model.Candidate;
@Repository
public class CandidateDaoImple implements CandidateDao{

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public void save(final Candidate candi) {
		hibernateTemplate.execute(new HibernateCallback<List<Candidate>>() {
			public List<Candidate> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.save(candi);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
	}

	@Override
	public Candidate validateUser(Candidate candi) {
		List<Candidate> ul = hibernateTemplate.execute(new HibernateCallback<List<Candidate>>() {
			public List<Candidate> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Candidate where candiUserName = ? and password = ?");
				q.setString(0, candi.getCandiUserName());
				q.setString(1, candi.getPassword());
				List<Candidate> userList = q.list();
				t.commit();
				session.flush();
				session.close();
				return userList;
			}
		});
		if(!ul.isEmpty()) {
			Candidate cand = ul.get(0);
			return cand;
		}	
		return null;
	}

}
