package com.nagarro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.Userscred;
import com.nagarro.services.Userservice;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private Userservice userService;
	

	/**
	 * to get all users present in database
	 * @return
	 */
	@GetMapping("/users")
	public List<Userscred> getUser(){
		return this.userService.getUsers();		
	}
	
	/**
	 * to get user of userID
	 * @param userId
	 * @return
	 */
	@GetMapping("/users/{userId}")
	public Optional<Userscred> getUser(@PathVariable String userId){
		return this.userService.getUser(Integer.parseInt(userId));
		
	}
	/**
	 * to add user
	 * @param user
	 * @return
	 */
	@PostMapping("/users")
	public Userscred addUser(@RequestBody Userscred user) {
		return this.userService.addUser(user);
	}
	
	/**
	 * to authenticate user by email and password
	 * @param email
	 * @param password
	 * @return
	 */
	@GetMapping("/users/{email}/{password}")
	public Userscred getAuthenticUser(@PathVariable String email,@PathVariable String password) {
		
		return this.userService.getauthenticateUser(email, password);
	}
	

}
