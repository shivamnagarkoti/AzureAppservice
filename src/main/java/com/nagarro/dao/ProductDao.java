package com.nagarro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.constants.Constants;
import com.nagarro.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
	
//	custom finder methods for filters
	
	@Query(Constants.PARENTQUERY +Constants.SEARCHBYNAMEBRANDPRODUCTCODE)
	List<Product> searchProducts(@Param("name") String name,@Param("brand") String brand,@Param("productCode") Long productCode);
	
	@Query(Constants.PARENTQUERY+Constants.SEARCHBYNAMEBRAND)
	List<Product> searchProductsbynameandbrand(@Param("name") String name,@Param("brand") String brand);
	
	@Query(Constants.PARENTQUERY + Constants.PRICERANGEQUERY)
	List<Product> searchPricerange(@Param("min") double min, @Param("max") double max);
}
 