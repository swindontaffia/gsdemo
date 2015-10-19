package com.pallelli.hibpract.dietlog;

import org.hibernate.Session;

public interface MyHibernateSessionFactory {

	Session openSession();
}
