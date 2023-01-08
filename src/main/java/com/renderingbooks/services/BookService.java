package com.renderingbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renderingbooks.models.Book;
import com.renderingbooks.repositories.BookRepository;

@Service
public class BookService {
	
	// Inject your BookRepository dependency ez pz with Autowired
	@Autowired
	private BookRepository bookRepo;
	
	// Now we need to implement our CRUD calls from the controller
	// Our service will then communicate with the DB and perform the request
	
	// This will return one Book via matching ID in the DB
	public Book getOne(Long id) {
		Optional<Book> optBook = bookRepo.findById(id);
		if(optBook.isPresent()) {
			return optBook.get();
		} else {
			return null;
		}
	}
	
	// This will return all Books found from the query to the DB
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	// This will create a new Book in the DB
	public Book create(Book b) {
		return bookRepo.save(b);
	}
	
	// This will update a given book in the DB with the matching ID
	public Book update(Book b) {
		return bookRepo.save(b);
	}
	
	// This will delete a book in the DB with the matching ID
	public void deleteById(Long id) {
		bookRepo.deleteById(id);
	}
}
