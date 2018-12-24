package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Customer;

public interface ICustomerDao {
	
	public List<Customer> findAll();
	
	public void save(Customer customer);
	
	public void update(Customer customer);
	
	public Customer findOne(Long id);
	
	public void delete(Long id);

}
