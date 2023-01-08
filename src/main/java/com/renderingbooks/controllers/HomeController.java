package com.renderingbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.renderingbooks.models.Book;
import com.renderingbooks.services.BookService;

@Controller
public class HomeController {
	// Inject your service dependency
	@Autowired
	private BookService bookServ;
	
	@GetMapping("/")
	public String index(Model model) {
		// using the book service, query the DB and get all books
		List<Book> allBooks = bookServ.getAll();
		// now, we need to store the list as a view model attribute
		model.addAttribute("allBooks", allBooks);
		// once the query is complete and the view model attribute is stored, return the index.jsp file and render the page
		return "index.jsp";
	}
}
