package com.ezen.webstore.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.webstore.domain.Product;
import com.ezen.webstore.domain.repository.ProductRepository;
import com.ezen.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public void updateAllStock() {      
		List<Product> allProducts = productRepository.getAllProducts();
  
		for (Product product : allProducts) {
			if (product.getUnitsInStock() < 500) {
				productRepository.updateStock(product.getProductId(), 
		  			product.getUnitsInStock() + 1000);
			}
		}
	}
	
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
	
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}
	
	public List<Product> getProductsByFilter(
			Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}

	public Product getProductById(String productID) {
		return productRepository.getProductById(productID);
	}
	
	public List<Product> getProdsByMultiFilter(
			String productCategory, Map<String, String> price, 
			String brand) {
		return productRepository.getProdsByMultiFilter(
				productCategory, price, brand);
	}

}
