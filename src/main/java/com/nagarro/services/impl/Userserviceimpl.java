package com.nagarro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nagarro.dao.Userdao;
import com.nagarro.entity.Userscred;
import com.nagarro.exceptionManager.exceptions.ResourceNotFoundException;
import com.nagarro.exceptionManager.exceptions.UserAlreadyExists;
import com.nagarro.services.Userservice;

import antlr.RecognitionException;

/**
 * implementation class of Userservice
 * 
 * @author shivamnagarkoti
 *
 */
@Service
public class Userserviceimpl implements Userservice {

	@Autowired
	Userdao userDao;

	// to encrypt password
	PasswordEncoder passwordEncoder;

	public Userserviceimpl() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public List<Userscred> getUsers() {

		return userDao.findAll();
	}

	@Override
	public Optional<Userscred> getUser(int parseInt) {
		return userDao.findById(parseInt);
	}

	@Override
	public Userscred addUser(Userscred user) {
		// password encrption
		String encodedpass = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedpass);
		Userscred user2 = null;
		try {
			userDao.save(user);
		} catch (Exception e) {
			throw new UserAlreadyExists("user", user.getEmail());

		}

		return user;
	}

	@Override
	public Userscred getauthenticateUser(String email, String password) {
		Userscred user = this.userDao.findByEmail(email);
		Userscred userone = null;
		if (user == null) {
			return user;
		}
		String newpass = user.getPassword();
		if (this.passwordEncoder.matches(password, newpass)) {
			return user;
		}
		return userone;

	}

}
