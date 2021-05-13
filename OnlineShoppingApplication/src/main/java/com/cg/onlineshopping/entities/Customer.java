package com.cg.onlineshopping.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Customer {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_seq")
	    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "customer_seq")
		private Integer customerId;
	 
		@NotEmpty(message= "First Name can not be null")
		private String firstName;
		@NotEmpty(message= "Last Name can not be null")
		private String lastName;
		@NotEmpty(message= "mobileNumber can not be null")
		@Size(min = 10, message="Mobile no should be in 10 digits")
		private String mobileNumber;
		@NotEmpty(message= "email can not be null")
		private String email;
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "address")
		private Address address;

		@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
		private Order order;
		@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
		private Cart cart;
		public Integer getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Integer customerId) {
			this.customerId = customerId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@JsonManagedReference
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}
		public Cart getCart() {
			return cart;
		}
		public void setCart(Cart cart) {
			this.cart = cart;
		}
		
		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + ", order="
					+ order + ", cart=" + cart + "]";
		}
		
	
}

	