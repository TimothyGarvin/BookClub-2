package com.garvintimothy.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garvintimothy.bookclub.models.Book;
import com.garvintimothy.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book oneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
