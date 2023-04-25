package com.spring.books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.books.model.Books;
import com.spring.books.service.BooksService;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	private BooksService service;
	@GetMapping()
	public List<Books> read(){
		return service.getBooks();
	}
	@GetMapping("/{id}")
	public Optional<Books> readbyId(@PathVariable int id) {
		return service.getBookbyId(id);
	}
	@PostMapping
	public Books create(@RequestBody Books books) {
		return service.addBooks(books);
	}
	@PutMapping("/{id}")
	public Books update(@RequestBody Books books, @PathVariable int id) {
		return service.editBooks(books, id);
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return service.deleteBooks(id);
	}
	
}
