package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class CustomerController {

	public String index(Model model) {
		
		model.addAttribute("title", "All customers");
		
		return "list";
	}
}
