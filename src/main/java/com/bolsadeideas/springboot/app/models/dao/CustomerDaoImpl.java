package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.entity.Customer;


@Repository("customerDaoJPA") //Especifica nombre de JPA (Para cuando más de una clase implementa la misma interfaz DAO)
public class CustomerDaoImpl implements ICustomerDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Customer> findAll() {
		return entityManager.createQuery("from Customer").getResultList();
	}

	@Transactional
	@Override
	public void save(Customer customer) {
		entityManager.persist(customer);		
	}
	
	@Transactional
	@Override
	public void update(Customer customer) {
		entityManager.merge(customer);		
	}

	@Transactional(readOnly=true)
	@Override
	public Customer findOne(Long id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Customer customer = findOne(id);
		entityManager.remove(customer);
		
	}

}
