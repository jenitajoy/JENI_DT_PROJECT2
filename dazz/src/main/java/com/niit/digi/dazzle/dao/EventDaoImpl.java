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

import com.niit.digi.dazzle.model.Event;

@Repository("eventDao")
public class EventDaoImpl implements EventDao{

	@Autowired
	private SessionFactory sessionFactory;


	public EventDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(Event event) {
		//sessionFactory.getCurrentSession().saveOrUpdate(job);
		Session sf = sessionFactory.openSession();
		Transaction tx = sf.beginTransaction();
			sf.saveOrUpdate(event);
			tx.commit();
			
	}

	@Transactional
	public void delete(String eventid) {
		Event event = new Event();
		event.setEid(eventid);
		sessionFactory.getCurrentSession().delete(event);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Event get(String eventid) {
		String hql = "from Category where id=" + "'"+ eventid +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> listEvent= (List<Event>) query.list();
		
		if (listEvent != null && !listEvent.isEmpty()) {
			return listEvent.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Event> list() {
		@SuppressWarnings("unchecked")
		List<Event> listEvent = (List<Event>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Event.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listEvent;
	}
}
