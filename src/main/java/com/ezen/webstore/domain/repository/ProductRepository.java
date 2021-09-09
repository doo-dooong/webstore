package com.ezen.webstore.domain.repository;

import java.util.List;
import com.ezen.webstore.domain.Product;

public interface ProductRepository {
	void updateStock(String productId, long noOfUnits);
	List<Product> getAllProducts();
}

