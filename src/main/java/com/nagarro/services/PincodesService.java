package com.nagarro.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.entity.Pincodes;

public interface PincodesService {
	public Pincodes addPincodes(Pincodes pincode);
	Pincodes getPincodeById(int parseInt);
}
