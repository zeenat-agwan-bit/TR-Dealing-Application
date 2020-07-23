package com.zee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleDAOImpl implements VehicleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void addNewvehicle(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(vehicle);
		tr.commit();
		session.close();

	}

	public void updateVehicle(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(vehicle);
		tr.commit();
		session.close();

	}

	public Vehicle getVehicleById(String regno) {
		Session session = sessionFactory.openSession();
		Vehicle vehicle = session.get(Vehicle.class, regno);
		return vehicle;

	}

	public List<Vehicle> getAllVehicle() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Vehicle");
		List<Vehicle> vehicles = query.list();
		session.close();
		return vehicles;
	}

	public List<String> getAllRegNo(String email) {
		
	Session session=sessionFactory.openSession();
	Criteria criteria=session.createCriteria(Vehicle.class);
	Criterion crt=Restrictions.eq("transporter.email", email); //QBC filteration
	criteria.add(crt);
	List<Vehicle> vlist=criteria.list();
	List<String> regnos=new ArrayList<String>();
	for(Vehicle v:vlist){
		regnos.add(v.getRegno());
	}
	return regnos;
		
	}

	public List<Vehicle> getAllVehicleByTransp(String email) {
			Session session=sessionFactory.openSession();
			Criteria cr=session.createCriteria(Vehicle.class);
			Criterion crt=Restrictions.eq("transporter.email", email);
			cr.add(crt);
			List<Vehicle> vehicles=cr.list();
			session.close();
			return vehicles;
		}
	
	
	public Map<String,String> getAllRegnosMap(String email){
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Vehicle.class);
		Criterion crt=Restrictions.eq("transporter.email", email);
		criteria.add(crt);                     
		List<Vehicle> vlist=criteria.list();
		
		Map<String,String> map=new HashMap<String,String>();
		
		for(Vehicle vehicle:vlist){
			String key=vehicle.getRegno();
			String val=vehicle.getBrand();
			//String val=vehicle.getBrand()+"-"+key.substring(key.length()-4, key.length());
			map.put(key, val);
		}
		return map;
	}


	public void deleteVehicle(String regno) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Vehicle vehicle = session.get(Vehicle.class, regno);
		session.delete(vehicle);
		tr.commit();
		session.close();
	}

}
