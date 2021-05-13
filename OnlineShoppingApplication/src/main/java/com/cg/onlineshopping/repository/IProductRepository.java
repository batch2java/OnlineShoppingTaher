package com.cg.onlineshopping.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.onlineshopping.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

	
	/*public List<Product> viewAllProducts();
	 public Product addProduct(Product product);
	 public Product updateProduct(Product product);
	 public Product viewProduct(int id);
	 public List<Product> viewProductsByCategory(String cat); 
	 public Product removeProduct(String prodid);*/
	
	 @Query("select p from Product p where p.category.categoryName=:categoryName")
	 public List<Product> viewAllProductsByCategory(@Param("categoryName")String category);
	 
}
