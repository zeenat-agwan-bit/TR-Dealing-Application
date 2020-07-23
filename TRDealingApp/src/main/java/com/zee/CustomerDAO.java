package com.zee;

import java.util.List;

public interface CustomerDAO {
public Customer verifyCustomer(Customer customer);
public void saveCustomer(Customer customer);
public void updateCustomer(Customer customer);
public void deleteCustomer(String email);
public Customer getCustById(String email);
public List<Customer> findAllCustomer();
}
