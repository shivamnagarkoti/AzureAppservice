package com.nagarro.services;

import java.util.List;
import java.util.Optional;

import com.nagarro.entity.Brand;

public interface Brandservice {

	public Brand addBrand(Brand brand);

	public List<Brand> getBrands();

	public Brand getBrandById(int parseInt);

}
