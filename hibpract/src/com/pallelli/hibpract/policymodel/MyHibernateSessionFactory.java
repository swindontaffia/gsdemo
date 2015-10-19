package com.pallelli.hibpract.policymodel;

import org.hibernate.Session;

public interface MyHibernateSessionFactory {

	Session openSession();
}
