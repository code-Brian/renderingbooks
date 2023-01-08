package com.renderingbooks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.renderingbooks.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long>{
	public List<Book> findAll();
}
