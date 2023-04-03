package com.nagarro.services;

import java.util.List;
import java.util.Optional;

import com.nagarro.entity.Product;

public interface ProductService {
	public Product addBrand(Product product);

	public List<Product> getproducts();

	public Product getProductById(Long productId);

	public List<Product> searchProducts(String name, String brand, Long productCode);

	public List<Product> searchProductsbyname(String name, String brand);

	public double getpriceList(List<Long> ids);

	public List<Product> filterbyPriceRange(double min, double max);
}
