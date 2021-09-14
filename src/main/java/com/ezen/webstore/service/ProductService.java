package com.ezen.webstore.service;

import java.util.List;
import java.util.Map;

import com.ezen.webstore.domain.Product;

public interface ProductService {
	void updateAllStock();
	List<Product> getAllProducts();
	
	List<Product> getProductsByCategory(String category);
	
	List<Product> getProductsByFilter(
			Map<String, List<String>> filterParams);
	
	Product getProductById(String productID);
	
	List<Product> getProdsByMultiFilter( // 3Àå 7Àý Have a go hero
			String productCategory,
			Map<String,String> price, 
			String brand);
}
