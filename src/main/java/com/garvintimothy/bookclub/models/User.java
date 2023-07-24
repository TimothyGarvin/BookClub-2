package com.garvintimothy.bookclub.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Please input your name.")
	private String name;
	
	@NotEmpty(message="Email is required!")
	@Email(message="Please input a valid email address.")
	private String email;
	
	@NotEmpty(message="Password is required.")
	@Size(min=8, max=128, message="Password must be greater than 8 characters and less than 120.")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm password is required.")
	private String confirm;
	
	@OneToMany(mappedBy="owner", fetch=FetchType.LAZY)
	private List<Book> ownedBooks;
	
	public List<Book> getOwnedBooks() {
		return ownedBooks;
	}

	public void setOwnedBooks(List<Book> ownedBooks) {
		this.ownedBooks = ownedBooks;
	}

	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	
}
