package com.nagarro.controller;

import java.util.List;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.Product;
import com.nagarro.services.ProductService;


@RestController
@CrossOrigin("*")
public class ProductController {
	
	Logger logger=LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService productService;

	/**
	 * to get all the products present in the database
	 * 
	 * @return
	 */
	@GetMapping("/product")
	public ResponseEntity<?> getProduct() {
		return ResponseEntity.ok(this.productService.getproducts());
	}

	/**
	 * to get product of same productCode
	 * 
	 * @param productCode
	 * @return
	 */
	@GetMapping("/product/{productCode}")
	public Product product(@PathVariable("productCode") Long productCode) {
		return this.productService.getProductById(productCode);
	}

	/**
	 * to add product
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping("/product")
	public ResponseEntity<Product> addproduct(@RequestBody Product product) {
		return ResponseEntity.ok(this.productService.addBrand(product));
	}
	
	
//filter and total prices
	
	
	
	/**
	 * to filter products according to brand name or product name or product code
	 * @param name
	 * @param brand
	 * @param productCode
	 * @return
	 */
	@GetMapping("/product/search")
	public ResponseEntity<?> searchProducts(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "brand", required = false) String brand,
			@RequestParam(name = "productCode", required = false) Long productCode) {
		logger.info("search api hit"); 
		try {
			if (name.isEmpty()) {
				name = null;
			}
		} catch (Exception e) {
			return ResponseEntity.ok(this.productService.searchProducts(name, brand, productCode));
		}

		return ResponseEntity.ok(this.productService.searchProducts(name, brand, productCode));
	}

	/**
	 * to filter product according to product name and brand name
	 * @param name
	 * @param brand
	 * @return
	 */
	@GetMapping("/product/searchbyname")
	public ResponseEntity<?> searchProductsbyname(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "brand", required = false) String brand) {
		return ResponseEntity.ok(this.productService.searchProductsbyname(name, brand));
	}

	/**
	 * to get the total price of list of products
	 * @param ids
	 * @return
	 */
	@GetMapping("/product/getprice/{ids}")
	public double getprice(@PathVariable("ids") List<Long> ids) {
		logger.info("getprice api hit"); 
		return this.productService.getpriceList(ids);
	}

	/**
	 * to filter the products according to the price range
	 * @param min
	 * @param max
	 * @return
	 */
	@GetMapping("/product/filter")
	public ResponseEntity<?> filterByPrice(@RequestParam(name = "min") double min,
			@RequestParam(name = "max") double max) {
		logger.info("pricerange api hit"); 
		return ResponseEntity.ok(this.productService.filterbyPriceRange(min, max));
	}

}
