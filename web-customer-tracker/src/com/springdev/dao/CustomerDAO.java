package com.springdev.dao;

import java.util.List;

import com.springdev.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}
