package com.zee.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.domain.Transporter;

@Repository
public class TranporterDAOImpl implements TransporterDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Transporter verifyTransporter(Transporter transporter) {
		Session session = sessionFactory.openSession();
		Transporter trans = session.get(Transporter.class, transporter.getEmail());
		if (trans == null) {
			return null;
		} else {
			if (transporter.getPassword().equals(trans.getPassword())) {
				return trans;
			} else {
				return null;
			}
		}
	}

	public void saveTransporter(Transporter transporter) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(transporter);
		tr.commit();
		session.close();

	}

	public Transporter getTransById(String email) {
		Session session = sessionFactory.openSession();
		Transporter trans = session.get(Transporter.class, email);
		return trans;
	}

	public void updateTransporter(Transporter transpoter) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(transpoter);
		tr.commit();
		session.close();

	}

	public void deleteTrans(String email) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Transporter trans = session.get(Transporter.class, email);
		session.delete(trans);
		tr.commit();
		session.close();

	}

}
