package com.cg.onlineshopping.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entities.Cart;

public interface ICartRepository extends JpaRepository<Cart, Integer>{
	
		//public interface ICartRepository extends JpaRepository<Cart, String>  {
			/*public Cart addProductToCart(Cart cart, Product p,int quantity);
			public Cart removeProductFromCart(Cart cart,Product p);
			public Cart updateProductQuantity(Cart cart, Product p,int quantity);
			public Cart removeAllProducts(Cart cart);
			public List<Product> viewAllProducts(Cart cart);*/
}
