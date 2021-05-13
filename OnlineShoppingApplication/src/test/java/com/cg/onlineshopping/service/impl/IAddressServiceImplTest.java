package com.cg.onlineshopping.service.impl;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.pojo.InputAddress;
import com.cg.onlineshopping.service.IAddressService;
import com.cg.onlineshopping.serviceimpl.IAdressServiceImpl;

@SpringBootTest
class IAddressServiceImplTest {

	 @InjectMocks
	 IAdressServiceImpl addressServiceImpl;
	    
	 @Autowired
	 IAddressService service;
	 
	    
	    //Functionality Level Test
	    
	    @Test
	    public void addAddressUnitTest()
	    {
	        InputAddress add = new InputAddress();
	        add.setStreetNo("131D");
	        add.setBuildingName("SrujanaComplex");
	        add.setCity("Hyderabad");
	        add.setState("Telangana");
	        add.setCountry("INDIA");
	        add.setPincode("500042");
	        
	        add=service.addAddress(add);
	        assertNotNull(add,"Address is added");
	    }
	    
	    
	    @Test
	    public void updateAddressUnitTest()
	    {
	    	InputAddress add = new InputAddress();
	        add.setAddressId(add.getAddressId());
	        add.setStreetNo("131D");
	        add.setBuildingName("SrujanaComplex");
	        add.setCity("Hyderabad");
	        add.setState("Telangana");
	        add.setCountry("INDIA");
	        add.setPincode("500042");
	        add=service.updateAddress(add);
	        
	        
	        assertNotNull(add,"Address is Updated");
	    }
	    
	    @Test
	    public void removeAddressUnitTest()
	    {
	    	InputAddress add=service.removeAddress(28);
	    	assertNotNull(add, "Address removed !!");
	    }
	    
	    
	    @Test
	    public void viewAddressByIdUnitTest()
	    {
	        InputAddress add = service.viewAddress(29);
	        assertNotNull(add,"Address found!");
	        
	    }
	    
	    @Test
	    public void viewAllAddressUnitTest()
	    {
	    	List<InputAddress> add=service.viewAllAddress();
	    	assertNotNull(add,"Address List Displayed");
	    	
	    }
}
	 
