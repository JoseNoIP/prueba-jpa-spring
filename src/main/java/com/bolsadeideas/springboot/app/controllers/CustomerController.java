package com.bolsadeideas.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.app.models.dao.ICustomerDao;

@Controller
public class CustomerController {

	@Autowired
	@Qualifier("customerDaoJPA") //Requerido solo cuando más de un JPA implementa la misma interfaz
	private ICustomerDao customerDao;
	
	@RequestMapping(name="customers", method=RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("title", "All customers");
		model.addAttribute("customers", customerDao.findAll());
		
		return "list";
	}
}
