package com.cg.onlineshopping.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.error.CartNotFoundException;
import com.cg.onlineshopping.pojo.InputCart;
import com.cg.onlineshopping.pojo.OutputCart;
import com.cg.onlineshopping.repository.ICartRepository;
import com.cg.onlineshopping.repository.ICustomerRepository;
import com.cg.onlineshopping.repository.IProductRepository;
import com.cg.onlineshopping.service.ICartService;

@Service
public class ICartServiceImpl implements ICartService{
	
	@Autowired
	ICartRepository  cartRepo;
	@Autowired
	IProductRepository productRepo;
	Logger logger = LoggerFactory.getLogger(ICartServiceImpl.class);
	@Autowired
	ICustomerRepository custRepo;

	
	

	@Override
	@Transactional
	public Cart removeProductFromCart(Integer cartId, Integer productId ) {
		
		 logger.info("Cart removeProductFromCart()");
		  Cart cart=cartRepo.findById(cartId).orElse(null);
	        Map<Product,Integer> productmap=cart.getProducts();
	        for(Product p:productmap.keySet()) {
	            if(p.getProductId().equals(productId)) {
	                productmap.remove(p);
	                cart.setProducts(productmap);
	               
	            }
	        }
	        
	       cart = cartRepo.save(cart);
	       return cart;
	        }
	       
	        
	    
	


	@Override
	@Transactional
	public Cart updateProductQuantity(Cart cart, Product p, int quantity) {
		
		 logger.info("Cart updateProductToCart()");
			
			p.setQuantity(quantity);
			productRepo.save(p);
			cartRepo.save(cart);
			return cart;
	}
	

	
	@Override
	@Transactional
	public Map<Integer,Integer>  viewAllProducts(Integer cartId) {
	
		logger.info("Cart viewAllProducts()");
		Cart cart = cartRepo.findById(cartId).orElse(null);
		if(cart==null) {
			throw new CartNotFoundException();
		}
		else {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		Map<Product,Integer>products= cart.getProducts();
		
		
		for(Product p:products.keySet()) {
			map.put(p.getProductId(), products.get(p));
			
		}
		return map;
		}
		 
	    }
	

	@Override
	@Transactional
	public OutputCart addProductToCart(InputCart cart) {
		
		logger.info("Cart addProductToCart1()");
		Cart cart1 = cartRepo.findById(cart.getCartId()).orElse(null);
		if(cart1==null) {
			cart1= new Cart();
		}
		Product product = productRepo.findById(cart.getProductId()).orElse(null);
		
		Map<Product,Integer> map = cart1.getProducts();
		map.put(product, cart.getQuantity());
		Customer cust = custRepo.findById(cart.getCustomerId()).orElse(null);
		cart1.setCustomer(cust);
		
		cart1= cartRepo.save(cart1);
		OutputCart c = new OutputCart();
		c.setCartId(cart1.getCartId());
		map= cart1.getProducts();
		for(Product p : map.keySet()) {
			c.getMap().put(p.getProductId(), map.get(p));
		}
		return c;
			
		
		
	}


	@Override
	@Transactional
	public Cart makeCartEmpty(Integer cartId) {
	
		Cart cart = cartRepo.findById(cartId).orElse(null);
		if(cart==null) {
			throw new CartNotFoundException();
		}
		else {
			cart.setProducts(new HashMap<Product,Integer>());
			cart =cartRepo.save(cart);
			return cart;
			
		}

		
		
	}



}