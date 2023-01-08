package com.renderingbooks.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.renderingbooks.models.Book;
import com.renderingbooks.services.BookService;

@Controller
@RequestMapping("/book")
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
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		} else {
			bookServ.create(book);
			return "redirect:/";
		}
	}
	@GetMapping("/{id}/update")
	public String editForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book",bookServ.getOne(id));
		return "editBook.jsp";
	}
	// This will take us to the edit page, it doesn't actually submit the form and update the book
	@PutMapping("/{id}/update")
	// Query the DB and get a book that matches the id
	// Update the returned book with the data incoming from the form if it is valid
	// redirect back to home
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		} else {
			book.setId(id);
			bookServ.update(book);
			return "redirect:/";
		}
	}

	@DeleteMapping("/{id}")
	// Find a book via ID
	// Delete the book and redirect back to home page
	public String delete(@PathVariable("id") Long id) {
		bookServ.deleteById(id);
		return "redirect:/";
	}

}
