package com.nagarro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productCode;
	
	private String name;
	private double price;
	private String imageurl;
	@Column(length = 5000)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Brand brand;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getProductCode() {
		return productCode;
	}


	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getImageurl() {
		return imageurl;
	}


	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	

	
}
