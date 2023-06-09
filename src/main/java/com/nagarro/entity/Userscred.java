package com.nagarro.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Userscred {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String firstname;
	private String lastname;
	@Column(unique = true)
	private String email;
	private String password;
	public Userscred() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Userscred(int id, String firstname, String lastname, String email, String password) {
		super();
		this.userId = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return userId;
	}
	public void setId(int id) {
		this.userId = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	@Override
	public String toString() {
		return "User [id=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + "]";
	}

	
	
	
}
