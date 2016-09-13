package com.niit.digi.dazzle.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.digi.dazzle.model.Forum;



@Repository("forumDao")
public class ForumDaoImpl implements ForumDao{

	@Autowired
	private SessionFactory sessionFactory;


	public ForumDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(Forum forum) {
		//sessionFactory.getCurrentSession().saveOrUpdate(job);
		Session sf = sessionFactory.openSession();
		Transaction tx = sf.beginTransaction();
			sf.saveOrUpdate(forum);
			tx.commit();
			
	}

	@Transactional
	public void delete(String forumid) {
		Forum forum = new Forum();
		forum.setFid(forumid);
		sessionFactory.getCurrentSession().delete(forum);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Forum get(String forumid) {
		String hql = "from Category where id=" + "'"+ forumid +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum> listForum= (List<Forum>) query.list();
		
		if (listForum != null && !listForum.isEmpty()) {
			return listForum.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Forum> list() {
		@SuppressWarnings("unchecked")
		List<Forum> listForum = (List<Forum>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Forum.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listForum;
	}
}
