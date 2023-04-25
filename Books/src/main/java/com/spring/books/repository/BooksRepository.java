package com.spring.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.books.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

}
