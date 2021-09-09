package com.ezen.webstore.service;

import java.util.List;

import com.ezen.webstore.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	void updateAllStock();
}
