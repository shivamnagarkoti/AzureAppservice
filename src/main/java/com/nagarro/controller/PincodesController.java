package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.Pincodes;
import com.nagarro.services.PincodesService;

@RestController
@CrossOrigin("*")
public class PincodesController {

	@Autowired
	PincodesService pincodesServics;
	
	/**
	 * to get by id
	 * @param zipcode
	 * @return
	 */
	@GetMapping("/pincodes/{zipcode}")
	public Pincodes getpincode(@PathVariable int zipcode){
		return this.pincodesServics.getPincodeById(zipcode);
	}
	
	/**
	 * to add pincodes to database
	 * @param pincodes
	 * @return
	 */
	@PostMapping("/pincodes")
	public ResponseEntity<?> addpincodes(@RequestBody Pincodes pincodes){
		return ResponseEntity.ok(this.pincodesServics.addPincodes(pincodes));
	}
	
	
}
