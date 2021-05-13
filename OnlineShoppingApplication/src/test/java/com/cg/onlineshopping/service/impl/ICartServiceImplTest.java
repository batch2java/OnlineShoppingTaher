package com.cg.onlineshopping.service.impl;



import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.service.ICartService;
import com.cg.onlineshopping.serviceimpl.ICartServiceImpl;

@SpringBootTest
class ICartServiceImplTest {
	
	@InjectMocks
	ICartServiceImpl cartServiceImpl;

	 @Autowired
	 ICartService service;
	 
	 @Test 
		public void removeProductFromCartUnitTest()
		{
			Cart cart =service.removeProductFromCart(14,8);
			assertNotNull(cart, "Product removed from cart !!");
		}
		
		@Test
		public void makeCartEmptyUnitTest()
		{
			Cart cart =service.makeCartEmpty(14);
			assertNotNull(cart, "Products removed from cart !!");
		}
		@Test
		public void viewAllProductsByIdUnitTest()
		{
			Map<Integer,Integer> cart =service.viewAllProducts(14);
			assertNotNull(cart, "Product removed from cart !!");
		}
		
		
}
