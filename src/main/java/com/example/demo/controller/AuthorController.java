package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	AuthorRepository ar;
	
	public AuthorController(AuthorRepository ar) {
		super();
		this.ar = ar;
	}

	@RequestMapping("/authors")
	public String getAuthors(Model m)
	{
		m.addAttribute("authors",ar.findAll());
		return "authors";
	}

}
