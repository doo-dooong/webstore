package com.ezen.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.webstore.domain.repository.ProductRepository;
import com.ezen.webstore.service.ProductService;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("market//products") 
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
	
	@RequestMapping("market/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
	// @PathVariable String category) {
		model.addAttribute("products",
			productService.getProductsByCategory(productCategory));
			// productService.getProductsByCategory(category));
		return "products";
	}
	
	@RequestMapping("/market/products/filter/{params}") // 6Àý ½Ç½À
	public String getProductsByFilter(@MatrixVariable(pathVar="params") 
			Map<String,List<String>> filterParams, Model model) {
		model.addAttribute("products", 
			productService.getProductsByFilter(filterParams));
		return "products";
	}
	
}
