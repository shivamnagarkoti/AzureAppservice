package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.Brand;
import com.nagarro.services.Brandservice;

@RestController
@CrossOrigin("*")
public class BrandController {

	@Autowired
	private Brandservice brandService; 
	
	/**
	 * 
	 * @return all the brands
	 */
	@GetMapping("/brand")
	public  ResponseEntity<?> getBrands(){ 
		return ResponseEntity.ok(this.brandService.getBrands());
		
	}
	
	/**
	 * return brand which have same brandId
	 * @param brandId
	 * @return
	 */
	@GetMapping("/brand/{brandId}")
	public Brand getbrand(@PathVariable("brandId") String brandId) {
		return this.brandService.getBrandById(Integer.parseInt(brandId));
	}
	
	/**
	 * to add brands
	 * @param brand
	 * @return
	 */
	@PostMapping("/brand")
	public  ResponseEntity<Brand> addBrand(@RequestBody Brand brand){ 
		Brand brand1=this.brandService.addBrand(brand);
		return ResponseEntity.ok(brand1);
		
	}
	
	
	
}
