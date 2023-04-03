package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entity.Brand;

public interface BrandDao extends JpaRepository<Brand,Integer>{

}
