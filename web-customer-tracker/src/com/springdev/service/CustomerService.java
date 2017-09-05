package com.springdev.service;

import java.util.List;

import com.springdev.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}
