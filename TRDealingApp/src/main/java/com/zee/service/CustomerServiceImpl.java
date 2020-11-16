package com.zee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.dao.CustomerDAO;
import com.zee.domain.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO dao;

	public Customer verifyUserCustomer(Customer customer) {

		return dao.verifyCustomer(customer);
	}

	public void addCustomer(Customer customer) {
		dao.saveCustomer(customer);

	}

	public void changeCustomer(Customer customer) {

		dao.updateCustomer(customer);
	}

	public void removeCustomer(String email) {
		dao.deleteCustomer(email);
	}

	public Customer searchCustById(String email) {

		return dao.getCustById(email);
	}

	public List<Customer> showAllCustomers() {
		return dao.findAllCustomer();
	}

}
