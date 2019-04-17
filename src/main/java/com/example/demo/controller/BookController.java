package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository  br;

	public BookController(BookRepository br) {
		super();
		this.br = br;
	}

	@RequestMapping("/books")
 public String getBooks(Model m)
 {
	 m.addAttribute("books",br.findAll());
	 return "books";
 }
}
