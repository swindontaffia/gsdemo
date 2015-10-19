package com.pallelli.hibpract.policymodel;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pallelli.hibpract.policymodel.beans.Risk;

@Component
public class PolicyDaoImpl implements PolicyDao {
	
	@Autowired
	private MyHibernateSessionFactory sessionFactory;
	
	@Override
	public void addRisk(Risk risk) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(risk);
			session.getTransaction().commit();
		}
		finally {
			if(session != null) session.close();
		}
		
	}
}
