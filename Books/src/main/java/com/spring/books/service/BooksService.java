package com.spring.books.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.books.model.Books;
import com.spring.books.repository.BooksRepository;

@Service
public class BooksService {
	@Autowired
	private BooksRepository repository;
	
	//Get Method
	public List<Books> getBooks() {
		return repository.findAll();
	}
	//Get by ID Method----
	public Optional<Books> getBookbyId(int id) {
		return repository.findById(null);
	}
	//Post Method----
	public Books addBooks(Books books) {
		return repository.save(books);
	}
	//Update Method-----
	public Books editBooks(Books book, int id) {
		Books bookx = repository.findById(id).orElse(null);
		if(bookx != null) {
			bookx.setBookname(book.getBookname());
			bookx.setAuthorname(book.getAuthorname());
			bookx.setPrice(book.getPrice());
			return repository.saveAndFlush(bookx);
		}
		else {
			return null;
		}
	}
	public String deleteBooks(int id) {
		repository.deleteById(id);
		return "deleted !";
	}
}
