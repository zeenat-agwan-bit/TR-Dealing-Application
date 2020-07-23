package com.zee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Customer verifyCustomer(Customer customer) {
		Session session=sessionFactory.openSession();
		Customer cust=session.get(Customer.class, customer.getEmail());
		if(cust==null) {
				return null;
	}
		else {
			if(customer.getPassword().equals(cust.getPassword())) {
				return cust;
			}
			else {
				return null;
			}
		}
		}

	public void saveCustomer(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(customer);
		tr.commit();
		session.close();
	}

	public void updateCustomer(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(customer);
		tr.commit();
		session.close();

	}

	public void deleteCustomer(String email) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Customer cust=session.get(Customer.class, email);
		session.delete(cust);
		tr.commit();
		session.close();
	}

	public Customer getCustById(String email) {
		Session session=sessionFactory.openSession();
		Customer cust=session.get(Customer.class, email);
		return cust;
	}

	public List<Customer> findAllCustomer() {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Customer");
	List<Customer>customers=query.list();
	session.close();
	return customers;
	
	}

	
	
}
