package com.ezen.webstore.service;

import java.util.List;

import com.ezen.webstore.domain.Product;

public interface ProductService {
	void updateAllStock();
	List<Product> getAllProducts();
}
