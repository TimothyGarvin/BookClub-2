package com.garvintimothy.bookclub.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Title cannot be blank.")
	@Size(min=3, max=30, message="Title must be between 3-30 characters.")
	private String title;
	
	@NotEmpty(message="Author cannot be blank.")
	@Size(min=1)
	private String author;
	
	@NotEmpty(message="Please share your opinion/theories regarding the book.")
	@Size(min=10, max=800, message="Please keep it at a reasonable length (10-800 characters).")
	private String thoughts;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id")
	private User owner;
	
	public Book() {}
	
	public Book(String title, String author, String thoughts) {
		this.title = title;
		this.author = author;
		this.thoughts = thoughts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
	
}
