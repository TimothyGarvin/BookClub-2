package com.garvintimothy.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.garvintimothy.bookclub.models.LoginUser;
import com.garvintimothy.bookclub.models.User;
import com.garvintimothy.bookclub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User getUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialNewUser = userRepo.findByEmail(newUser.getEmail());
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "Please make sure both passwords match.");
		}
		else if (potentialNewUser.isPresent()) {
			result.rejectValue("email", "Present", "This email is already assigned to another account.");
			return null;
		}
		else if (result.hasErrors()) {
			return null;
		}
		String hashed=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		if (result.hasErrors()) {
			return null;
		}
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Absent", "We did not find an email matching your input, did you make a typo?");
			return null;
		}
		User user = potentialUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
			return null;
		}
		return user;
	}
}
