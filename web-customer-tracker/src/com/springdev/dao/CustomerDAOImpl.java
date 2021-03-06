package com.springdev.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdev.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// save/update the customer .. finally in db
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomers(int theId) {
		
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer theCustomer = session.get(Customer.class, theId); 
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}
