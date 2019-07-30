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

import com.cdac.everification.model.CandiDocs;
import com.cdac.everification.model.Candidate;
import com.cdac.everification.model.DocumentMaster;
import com.cdac.everification.model.Organization;
@Repository
public class CandidateDaoImple implements CandidateDao{

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public String save(final Candidate candi) {
		List<Candidate> ul =hibernateTemplate.execute(new HibernateCallback<List<Candidate>>() {
			public List<Candidate> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				int candiId=(int)session.save(candi);
				System.out.println("=============== : "+candiId);
				Query q=session.createQuery("from Candidate where candiId=?");
				q.setInteger(0, candiId);
				List<Candidate> list = q.list();
				String path=list.get(0).getCandiId()+".jpg";
				list.get(0).setCandiDocPath(path);
				session.update(list.get(0));
				t.commit();
				session.flush();
				session.close();
				return list;
			}
		});
		return ul.get(0).getCandiDocPath();
		
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
	
	//CandiDocs
	
	@Override
	public void createDocs(final CandiDocs candi)
	{
		hibernateTemplate.execute(new HibernateCallback<List<CandiDocs>>() {
			public List<CandiDocs> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q=session.createQuery("delete from CandiDocs where candi_id=? and doc_id=?");
				q.setInteger(0, candi.getCandiId());
				q.setInteger(1, candi.getDocId());
				q.executeUpdate();
				session.save(candi);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});	
		
	}
	@Override
	public List<CandiDocs>getList(int id)
	{
		List<CandiDocs> ul = hibernateTemplate.execute(new HibernateCallback<List<CandiDocs>>() {
			public List<CandiDocs> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from CandiDocs where candiId=?");
				q.setInteger(0, id);
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
	public String getCandiName(int id)
	{
		List<Candidate> ul = hibernateTemplate.execute(new HibernateCallback<List<Candidate>>() {
			public List<Candidate> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Candidate where candiId=?");
				q.setInteger(0, id);
				List<Candidate> userList = q.list();
				t.commit();
				session.flush();
				session.close();
				return userList;
			}
		});
		if(!ul.isEmpty()) {
			String cand = ul.get(0).getCandiFname();
		}	
		return null;	
			
	}
	
	@Override
	public String getDocName(int id)
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

			return cand;
		}	
		return null;	
			
	}
	@Override
	public List<DocumentMaster> getAllDocType(){
		List<DocumentMaster> ul = hibernateTemplate.execute(new HibernateCallback<List<DocumentMaster>>() {
			public List<DocumentMaster> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from DocumentMaster");
				List<DocumentMaster> userList = q.list();
				t.commit();
				session.flush();
				session.close();

				return userList;
			}
		});
		return ul;
	}
	@Override
	public void updateDocStatusofCandidate(int id) {
		List<CandiDocs> ul = hibernateTemplate.execute(new HibernateCallback<List<CandiDocs>>() {
			public List<CandiDocs> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from CandiDocs where id=?");
				q.setInteger(0,id);
				List<CandiDocs>list=q.list();
				list.get(0).setDocStatus("Requested");
				session.update(list.get(0));
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
	}

}	
