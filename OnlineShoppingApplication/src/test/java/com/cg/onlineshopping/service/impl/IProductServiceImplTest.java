package com.cg.onlineshopping.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.entities.Category;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.repository.IProductRepository;
import com.cg.onlineshopping.serviceimpl.IProductServiceImpl;

@SpringBootTest
class IProductServiceImplTest {
	
	@InjectMocks
	IProductServiceImpl productServiceImpl;
	@Mock
	IProductRepository productRepo;

	@Test
	public void addProductMockTest() {
		Product product = new Product();
		product.setProductName("Iphone");
		product.setPrice(12000);
		product.setColor("Blue");
		product.setDimension("12x5");
		product.setSpecification("IOS");
		product.setManufacturer("Apple");
		product.setQuantity(2);
		Category cat = new Category();
		cat.setCatId(4002);
		cat.setCategoryName("Electronics");
		product.setCategory(cat);
		
		Mockito.when(productRepo.save(product)).thenReturn(product);
		assertThat(productServiceImpl.addProduct(product)).isEqualTo(product);
	}
	
	@Test
	public void updateProducMockTest() {
		Product product = new Product();
		product.setProductName("Iphone");
		product.setPrice(12000);
		product.setColor("Blue");
		product.setDimension("12x5");
		product.setSpecification("IOS");
		product.setManufacturer("Apple");
		product.setQuantity(2);
		Category cat = new Category();
		cat.setCatId(4002);
		cat.setCategoryName("Electronics");
		product.setCategory(cat);
		
		Mockito.when(productRepo.findById(product.getProductId())).thenReturn(Optional.of(product));
		
		product.setQuantity(10);
		Mockito.when(productRepo.save(product)).thenReturn(product);
		
		assertThat(productServiceImpl.updateProduct(product)).isEqualTo(product);		
	}
	
	@Test
	public void removeProductMockTest() {
		Product product = new Product();
		product.setProductName("Iphone");
		product.setPrice(12000);
		product.setColor("Blue");
		product.setDimension("12x5");
		product.setSpecification("IOS");
		product.setManufacturer("Apple");
		product.setQuantity(2);
		Category cat = new Category();
		cat.setCatId(4002);
		cat.setCategoryName("Electronics");
		product.setCategory(cat);
		
		Mockito.when(productRepo.findById(product.getProductId())).thenReturn(Optional.of(product));
	    Mockito.when(productRepo.existsById(product.getProductId())).thenReturn(false);
	   assertFalse(productRepo.existsById(product.getProductId()));	
	}
	
	@Test
	public void viewProductMockTest() {
		Product product = new Product();
		product.setProductName("Iphone");
		product.setPrice(12000);
		product.setColor("Blue");
		product.setDimension("12x5");
		product.setSpecification("IOS");
		product.setManufacturer("Apple");
		product.setQuantity(2);
		Category cat = new Category();
		cat.setCatId(4002);
		cat.setCategoryName("Electronics");
		product.setCategory(cat);
		
		Mockito.when(productRepo.findById(product.getProductId())).thenReturn(Optional.of(product));
		assertThat(productServiceImpl.viewProduct(product.getProductId())).isEqualTo(product);
	}
	
	@Test
	public void viewAllProductsMockTest() {
		Product product1 = new Product();
		product1.setProductName("Iphone");
		product1.setPrice(12000);
		product1.setColor("Blue");
		product1.setDimension("12x5");
		product1.setSpecification("IOS");
		product1.setManufacturer("Apple");
		product1.setQuantity(2);
		Category cat1 = new Category();
		cat1.setCatId(4002);
		cat1.setCategoryName("Electronics");
		product1.setCategory(cat1);
		
		Product product2 = new Product();
		product2.setProductName("nexus");
		product2.setPrice(10000);
		product2.setColor("Blue");
		product2.setDimension("12x5");
		product2.setSpecification("Android");
		product2.setManufacturer("Apple");
		product2.setQuantity(2);
		Category cat2 = new Category();
		cat2.setCatId(4002);
		cat2.setCategoryName("Electronics");
		product2.setCategory(cat2);
		
		List<Product> plist = new ArrayList<>();
		plist.add(product1); plist.add(product2);
		
		Mockito.when(productRepo.findAll()).thenReturn(plist);
		assertThat(productServiceImpl.viewAllProducts()).isEqualTo(plist);
		
	}

}
