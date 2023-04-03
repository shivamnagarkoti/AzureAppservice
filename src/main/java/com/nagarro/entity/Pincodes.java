package com.nagarro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pincodes {
	@Id
	private int zipcode;
	private int estimatedDays;
	public Pincodes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pincodes(int zipcode, int estimatedDays) {
		super();
		this.zipcode = zipcode;
		this.estimatedDays = estimatedDays;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public int getEstimatedDays() {
		return estimatedDays;
	}
	public void setEstimatedDays(int estimatedDays) {
		this.estimatedDays = estimatedDays;
	}
	
	
}
