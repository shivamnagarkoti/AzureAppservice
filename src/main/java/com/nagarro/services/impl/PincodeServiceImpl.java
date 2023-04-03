package com.nagarro.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.PincodesDao;
import com.nagarro.entity.Pincodes;
import com.nagarro.exceptionManager.exceptions.ResourceNotFoundException;
import com.nagarro.services.PincodesService;

@Service
public class PincodeServiceImpl implements PincodesService {

	@Autowired
	PincodesDao pincodesDao;

	@Override
	public Pincodes getPincodeById(int parseInt) {
		return this.pincodesDao.findById(parseInt).orElseThrow(()->new ResourceNotFoundException("","pincode",parseInt));
	}

	

	@Override
	public Pincodes addPincodes(Pincodes pincode) {
		return this.pincodesDao.save(pincode);
	}



	
	
	
}
