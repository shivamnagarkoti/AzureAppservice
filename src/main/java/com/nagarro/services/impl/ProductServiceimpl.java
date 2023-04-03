package com.nagarro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.ProductDao;

import com.nagarro.entity.Product;
import com.nagarro.services.ProductService;

/**
 * implementation class of productservice
 * @author shivamnagarkoti
 *
 */
@Service
public class ProductServiceimpl implements ProductService {

	@Autowired
	ProductDao productDao;

	/**
	 *method to save the product
	 */
	@Override
	public Product addBrand(Product product) {
		return this.productDao.save(product);
	}

	/**
	 *method to get all products
	 */
	@Override
	public List<Product> getproducts() {
		return this.productDao.findAll();
	}

	/**
	 *method to get a product details by id
	 */
	@Override
	public Product getProductById(Long productID) {
		return this.productDao.findById(productID).get();
	}

	/**
	 *method to filter the products by name,brand and id
	 */
	@Override
	public List<Product> searchProducts(String name, String brand, Long productCode) {
		List<Product> products = this.productDao.searchProducts(name, brand, productCode);
		return products;
	}

	/**
	 *method to filter products by name and brand
	 */
	@Override
	public List<Product> searchProductsbyname(String name, String brand) {
		List<Product> products = this.productDao.searchProductsbynameandbrand(name, brand);
		return products;
	}

	/**
	 *method to get total price of the list of products
	 */
	@Override
	public double getpriceList(List<Long> ids) {
		double sum = 0.0;
		for (Long i : ids) {
			Product p = getProductById(i);
			sum += p.getPrice();
		}
		return sum;
	}

	/**
	 *method to get list of products of specific price range
	 */
	@Override
	public List<Product> filterbyPriceRange(double min, double max) {
		List<Product> products = this.productDao.searchPricerange(min, max);
		return products;
	}

}
