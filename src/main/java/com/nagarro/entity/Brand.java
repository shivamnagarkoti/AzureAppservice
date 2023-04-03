package com.nagarro.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@CrossOrigin("*")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int brandId;
	private String name;
	
	@OneToMany(mappedBy = "brand",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Product> product=new ArrayList<>();
	public Brand(String name) {
		super();
		this.name = name;
	}
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
