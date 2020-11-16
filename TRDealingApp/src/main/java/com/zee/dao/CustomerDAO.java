package com.zee.dao;

import java.util.List;

import com.zee.domain.Customer;

public interface CustomerDAO {
public Customer verifyCustomer(Customer customer);
public void saveCustomer(Customer customer);
public void updateCustomer(Customer customer);
public void deleteCustomer(String email);
public Customer getCustById(String email);
public List<Customer> findAllCustomer();
}
