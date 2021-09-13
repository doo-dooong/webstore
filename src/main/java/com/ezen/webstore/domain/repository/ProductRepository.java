package com.ezen.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.ezen.webstore.domain.Product;

public interface ProductRepository {
	void updateStock(String productId, long noOfUnits);
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	List<Product> getProductsByFilter(
			Map<String, List<String>> filterParams);
	Product getProductById(String productID);
}

