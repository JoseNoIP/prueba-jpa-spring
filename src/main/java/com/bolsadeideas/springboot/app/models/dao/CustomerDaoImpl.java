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
		return entityManager.createQuery("from CUSTOMERS").getResultList();
	}

}
