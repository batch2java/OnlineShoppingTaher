package com.cg.onlineshopping.controller;

import java.util.Map;

import javax.validation.Valid;

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

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.pojo.InputCart;
import com.cg.onlineshopping.pojo.OutputCart;
import com.cg.onlineshopping.service.ICartService;


@RestController
@RequestMapping("/api/v1")


public class ICartController {
	
	@Autowired
	ICartService cartService;
	Logger logger = LoggerFactory.getLogger(ICartController.class);

	

	@PostMapping("/addcart")
	public OutputCart addProductToCart1(@Valid @RequestBody InputCart cart)
	{
		logger.info("Cart addProductToCart()");
		return cartService.addProductToCart(cart);
	}

	@PutMapping("/updatecart")
	public Cart updateProductQuantity(@RequestBody Cart cart, @RequestBody Product p, @RequestBody int quantity)
	{
		logger.info("Cart updateProductToCart()");
		return cartService.updateProductQuantity(cart, p, quantity);
	}

	@DeleteMapping("/deletecart/{productId}/{cartId}")
	public Cart removeProductFromCart(@PathVariable Integer cartId,@PathVariable Integer productId)
	{
		logger.info("Cart removeProductFromCart()");
		return cartService.removeProductFromCart(cartId, productId);
	}
	@DeleteMapping("/emptycart/{cartId}")
	public Cart makeCartEmpty(@PathVariable Integer cartId)
	{
		logger.info("Cart makeCartEmpty()");
		return cartService.makeCartEmpty( cartId);
	}
	
	@GetMapping("/getcartproducts/{cartId}")
	public Map<Integer,Integer>  viewAllProducts( @PathVariable Integer cartId)
	{
		logger.info("Cart viewAllProducts()");
		return cartService.viewAllProducts(cartId);
		
	}

}

   


