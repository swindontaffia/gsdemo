package test.brittonn.hibpract;

import org.hibernate.Session;

import test.brittonn.hibpract.model.Risk;

public class IFacesDao {
	static private IFacesDao instance;
	private IFacesDao() {
		
	}
	
	public static IFacesDao getInstance() {
		if(instance == null) {
			instance = new IFacesDao();
		}
		return instance;
	}

	public void addRisk(Risk risk) {
		Session session = null;
		try {
			session = Main.getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(risk);
			session.getTransaction().commit();
		}
		finally {
			if(session != null) session.close();
		}
		
	}
}
