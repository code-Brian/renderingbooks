package com.renderingbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.renderingbooks.models.Book;
import com.renderingbooks.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookServ;
	
	@GetMapping("/create")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	
	@PostMapping("/create")
	// this is the route which gets called when the submit button is pressed
	// First we need to store the data as request params
	// Once we store the data, we need to validate it
	// Then, if the data is valid, we need to store it in the DB and redirect to home
	public String create() {
		
	}
}
