package com.ezen.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.webstore.domain.repository.ProductRepository;
import com.ezen.webstore.service.ProductService;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("market/products") 
	public String list(Model model) { 
		model.addAttribute("products", productRepository.getAllProducts());
		return "products";
	} 
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/update/stock")
	public String updateStock(Model model) { 
		productService.updateAllStock();
		return "redirect:/market/products";
	}
	
	@RequestMapping("products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
	// @PathVariable String category) {
		model.addAttribute("products",
			productService.getProductsByCategory(productCategory));
			// productService.getProductsByCategory(category));
		return "products";
	}
	
	@RequestMapping("products/filter/{params}") // 6�� �ǽ�
	public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model) {
		model.addAttribute("products", 
			productService.getProductsByFilter(filterParams));
		return "products";
	}
	
	@RequestMapping("market/product") // 7�� �ǽ�
	public String getProductById(
			@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", 
			productService.getProductById(productId));
		return "product";
	}	
}
