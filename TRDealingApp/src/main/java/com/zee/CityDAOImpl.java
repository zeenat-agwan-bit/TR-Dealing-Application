package com.zee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDAOImpl implements CityDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void saveCity(City city) {
	Session session=sessionFactory.openSession();
	Transaction tr=session.beginTransaction();
	session.save(city);
	tr.commit();
	session.close();
	
	}

	public void updateCity(City city) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(city);
		tr.commit();
		session.close();
			

	}

	public List<String> getAllCities() {
		
		return null;
	}

	public List<String> getAllStateNames() {
		
		return null;
	}

}
