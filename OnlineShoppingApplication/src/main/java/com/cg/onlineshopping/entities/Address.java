package com.cg.onlineshopping.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Address {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_seq")
	    @SequenceGenerator(sequenceName = "address_seq", allocationSize = 1, name = "address_seq")
		private int addressId;
	    @NotEmpty(message="Street_no should not empty")
		private String streetNo;

		@NotEmpty(message="Building Name should not empty")
		private String buildingName;
		@NotEmpty(message="City should not empty")
		private String  city;

		@NotEmpty(message="State should not empty")
		private String state;
		@NotEmpty(message="Country should not empty")
		private String country;	
		@Size(min=6, max=10, message="Pincode should minimum be 6 and maximum 10")
		private String pincode;
		
		@OneToOne(mappedBy = "address")
		private Customer customer;
	
	    public int getAddressId() {
			return addressId;
		}

		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}

		public String getStreetNo() {
			return streetNo;
		}

		public void setStreetNo(String streetNo) {
			this.streetNo = streetNo;
		}

		public String getBuildingName() {
			return buildingName;
		}

		public void setBuildingName(String buildingName) {
			this.buildingName = buildingName;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

        @JsonBackReference
		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}


		@Override
		public String toString() {
			return "Address [addressId=" + addressId + ", streetNo=" + streetNo + ", buildingName=" + buildingName
					+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode
					+ ", customer=" + customer + "]";
		}


	
	
	
}
