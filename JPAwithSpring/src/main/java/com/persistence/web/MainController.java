package com.persistence.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.persistence.service.FooService;

@Controller
public class MainController {

	@Autowired
	private FooService fooService;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("foos", fooService.findAll());
		return "index";
	}

}
