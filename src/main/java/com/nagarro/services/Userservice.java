package com.nagarro.services;

import java.util.List;
import java.util.Optional;

import com.nagarro.entity.Userscred;

public interface Userservice {

	public List<Userscred> getUsers();

	public Optional<Userscred> getUser(int parseInt);
 
	public Userscred getauthenticateUser(String email,String password);
	
	public Userscred addUser(Userscred user);

}
