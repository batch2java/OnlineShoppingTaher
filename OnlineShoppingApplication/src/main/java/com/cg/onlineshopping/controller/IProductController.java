package com.cg.onlineshopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.service.IProductService;

@RestController
@RequestMapping("/api/v1")
public class IProductController {
	@Autowired
	IProductService productService;
	Logger logger = LoggerFactory.getLogger(IProductController.class);


	
	@PostMapping(path="/createproduct")
    public Product addProduct( @RequestBody Product product) {
        logger.info("Product addProduct");
        return productService.addProduct(product);
    }
	
	@PutMapping(path="/updateproduct")
    public Product updateProduct( @RequestBody Product product) {
		logger.info("Product updateProduct");
        return productService.updateProduct(product);
    }
	
	@DeleteMapping(path="/deleteproductById/{productId}")
    public Product removeProduct( @PathVariable Integer productId) {
		logger.info("Product removeProduct");
        return productService.removeProduct(productId);
    }
	
	@GetMapping(path = "/getallproduct")
    public List<Product> viewAllProducts(){
        logger.info("product viewAllProducts");
        
        return productService.viewAllProducts();
    }
	
	@GetMapping(path = "/getproductById/{productId}")
    public Product viewProduct(@PathVariable Integer productId){
        logger.info("product viewProduct");
        
        return productService.viewProduct(productId);
    }
	@GetMapping(path = "/getproductByCategory/{category}")
    public List<Product> viewProductsByCategory(@PathVariable String category){
        logger.info("product viewProduct");
        
        return productService.viewProductsByCategory(category);
    }

	

}