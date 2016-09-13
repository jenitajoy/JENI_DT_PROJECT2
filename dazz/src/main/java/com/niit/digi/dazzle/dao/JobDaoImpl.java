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

import com.niit.digi.dazzle.model.Job;
import com.niit.digi.dazzle.model.Register;

@SuppressWarnings("unused")
@Repository("jobDao")
public class JobDaoImpl implements JobDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	public JobDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(Job job) {
		//sessionFactory.getCurrentSession().saveOrUpdate(job);
		Session sf = sessionFactory.openSession();
		Transaction tx = sf.beginTransaction();
			sf.saveOrUpdate(job);
			tx.commit();
			
	}

	@Transactional
	public void delete(String jobid) {
		Job job = new Job();
		job.setJobid(jobid);
		sessionFactory.getCurrentSession().delete(job);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Job get(String jobid) {
		String hql = "from Category where jobid=" + "'"+ jobid +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Job> listJob= (List<Job>) query.list();
		
		if (listJob != null && !listJob.isEmpty()) {
			return listJob.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Job> list() {
		@SuppressWarnings("unchecked")
		List<Job> listJob = (List<Job>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Job.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listJob;
	}
	
	
	
}
