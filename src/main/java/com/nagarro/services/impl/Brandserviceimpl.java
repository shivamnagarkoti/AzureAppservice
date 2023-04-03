package com.nagarro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.BrandDao;
import com.nagarro.entity.Brand;
import com.nagarro.exceptionManager.exceptions.ResourceNotFoundException;
import com.nagarro.services.Brandservice;
@Service
public class Brandserviceimpl implements Brandservice {

	@Autowired
	BrandDao brandDao;
	
	@Override
	public Brand addBrand(Brand brand) {
		return this.brandDao.save(brand);
	}

	@Override
	public List<Brand> getBrands() {
		return this.brandDao.findAll();
	}

	@Override
	public Brand getBrandById(int parseInt) {
		return this.brandDao.findById(parseInt).orElseThrow(()->new ResourceNotFoundException("Brand","brandId",parseInt));
	}

}
