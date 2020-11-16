package com.zee.service;

import java.util.List;

import com.zee.domain.Customer;

public interface CustomerService {
	public Customer verifyUserCustomer(Customer customer);
	public void addCustomer(Customer customer);
	public void changeCustomer(Customer customer);
	public void removeCustomer(String email);
	public Customer searchCustById(String email);
	public List<Customer>showAllCustomers();
		
}
