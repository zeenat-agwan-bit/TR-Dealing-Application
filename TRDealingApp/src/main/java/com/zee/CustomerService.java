package com.zee;

import java.util.List;

public interface CustomerService {
	public Customer verifyUserCustomer(Customer customer);
	public void addCustomer(Customer customer);
	public void changeCustomer(Customer customer);
	public void removeCustomer(String email);
	public Customer searchCustById(String email);
	public List<Customer>showAllCustomers();
		
}
