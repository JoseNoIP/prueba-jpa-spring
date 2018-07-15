package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.entity.Customer;


@Repository
public class CustomerDaoImpl implements ICustomerDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly=true)
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from CUSTOMERS").getResultList();
	}

}
