package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.app.models.dao.ICustomerDao;
import com.bolsadeideas.springboot.app.models.entity.Customer;

@Controller
public class CustomerController {

	@Autowired
	@Qualifier("customerDaoJPA") //Requerido solo cuando más de un JPA implementa la misma interfaz
	private ICustomerDao customerDao;
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("title", "All customers");
		model.addAttribute("customers", customerDao.findAll());
		
		return "customer/list";
	}
	
	@RequestMapping(value="/customers/new") //El método get se asigna por defecto
	public String create(Map<String, Object> model) {
		
		Customer customer = new Customer();
		model.put("customer", customer);
		model.put("title", "New Customer");
		
		return "customer/form";
	}
	
	@RequestMapping(value="/customers/new", method=RequestMethod.POST)
	public String store(@Valid Customer customer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "customer/form";
		}
		customerDao.save(customer);
		
		return "redirect:/customers";
		
	}
}
