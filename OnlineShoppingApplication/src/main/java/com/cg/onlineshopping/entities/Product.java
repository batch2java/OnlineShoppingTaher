package com.cg.onlineshopping.entities;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
public class Product {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
	@SequenceGenerator(sequenceName = "product_seq", allocationSize = 1, name = "product_seq")
	private Integer productId;
	@NotEmpty(message="Product name should not be null")
	private String productName;
	@NotNull(message ="Price should not be empty")
	@Min(value=1,message="price should be greater than zero")
	private double price;
	@NotEmpty(message="color should not be null")
	private String color;
	@NotEmpty(message="dimension should not be null")
	private String dimension;
	@NotEmpty(message="specification name should not be null")
	private String specification;
	@NotEmpty(message="manufacturer should not be null")
	private String manufacturer;
	@NotNull(message =" quantity should not be empty")
	@Min(value=1,message="Quantity should be greater than zero")
	private int quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="category")
	private Category category;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", color="
				+ color + ", dimension=" + dimension + ", specification=" + specification + ", manufacturer="
				+ manufacturer + ", quantity=" + quantity + ", category=" + category + "]";
	}

	
}
