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

import com.niit.digi.dazzle.model.Register;


@SuppressWarnings("unused")
@Repository("registerDaoImpl")
public class RegisterDao implements RegisterDaoImpl{
	
	@Autowired
	private SessionFactory sessionFactory;


	public RegisterDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(Register register) {
		//sessionFactory.getCurrentSession().beginTransaction();
		//sessionFactory.getCurrentSession().saveOrUpdate(register);

	 Session sf = sessionFactory.openSession();
		Transaction tx = sf.beginTransaction();
			sf.saveOrUpdate(register);
			tx.commit();
			
	}

	@Transactional
	public void delete(String id) {
		Register register = new Register();
		register.setId(id);
		sessionFactory.getCurrentSession().delete(register);
	}

	@Transactional
	public Register get(String id) {
		String hql = "from User where id=" + "'"+ id +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Register> listRegister = (List<Register>) query.list();
		
		if (listRegister != null && !listRegister.isEmpty()) {
			return listRegister.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Register> list() {
		@SuppressWarnings("unchecked")
		List<Register> listRegister = (List<Register>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Register.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listRegister;
	}
	
}

