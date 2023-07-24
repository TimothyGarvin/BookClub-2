package com.garvintimothy.bookclub.controllers;

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

import com.garvintimothy.bookclub.models.Book;
import com.garvintimothy.bookclub.services.BookService;
import com.garvintimothy.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	private BookService bookServ;
	@Autowired
	private UserService userServ;
	
	@GetMapping("/books")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("loggedIn", userServ.getUser((Long)session.getAttribute("userId")));
		model.addAttribute("bookList", bookServ.allBooks());
		return "home.jsp";
	}
	
	@GetMapping("/books/new")
	public String bookForm(@ModelAttribute("newBook")Book newBook) {
		return "newBook.jsp";
	}
	
	@PostMapping("/books/create")
	public String addBook(@Valid @ModelAttribute("newBook")Book newBook, BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		} else {
			bookServ.createBook(newBook);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id")Long id, Model model) {
		Book book = bookServ.oneBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@PutMapping("/books/edit/{id}")
	public String updateBook(@Valid @ModelAttribute("book")Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			bookServ.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{id}")
	public String details(@PathVariable("id")Long id, Model model) {
		model.addAttribute("book", bookServ.oneBook(id));
		return "details.jsp";
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable("id")Long id) {
		bookServ.delete(id);
		return "redirect:/books";
	}
	
	
	
}
