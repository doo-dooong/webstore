package com.ezen.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.webstore.domain.repository.ProductRepository;
import com.ezen.webstore.service.ProductService;

import lombok.*;

@Getter @Setter
@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/market/products") 
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
}
