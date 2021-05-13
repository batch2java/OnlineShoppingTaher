package com.cg.onlineshopping.service.impl;


import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.pojo.InputCustomer;
import com.cg.onlineshopping.service.ICustomerService;
import com.cg.onlineshopping.serviceimpl.ICustomerServiceImpl;

@SpringBootTest
class ICustomerServiceImplTest {

	@InjectMocks
	ICustomerServiceImpl customerServiceimpl;
	
	 @Autowired
	 ICustomerService service;
	 
	@Test
	public void addCustomerUnitTest()
	{
		
		InputCustomer cust = new InputCustomer();
		
		cust.setFirstName("Pampari");
		cust.setLastName("Narender");
		cust.setMobileNumber("5878455448");
		cust.setEmail("abc@g.com");
		cust.setBuildingName("BK block");
		cust.setCity("Delhi");
		cust.setCountry("India");
		cust.setPincode("986573");
		cust.setState("NewDelhi");
		cust.setStreetNo("3H");
		
		cust=service.addCustomer(cust);
        assertNotNull(cust,"Customer is added");
        
	}
	
	@Test
	public void deleteCustomerUnitTest()
	{
		InputCustomer cust =service.removeCustomer(13);
		assertNotNull(cust, "Customer deleted !!");
	}
	
	@Test
	public void updateCustomerUnitTest()
	{
		InputCustomer cust = new InputCustomer();
		cust.setAddressId(34);
		cust.setFirstName("Vineeth");
		cust.setLastName("Sai");
		cust.setMobileNumber("5878455448");
		cust.setEmail("vinni1@g.com");
		cust.setBuildingName("BK block");
		cust.setCity("Delhi");
		cust.setCountry("India");
		cust.setPincode("986573");
		cust.setState("NewDelhi");
		cust.setStreetNo("3H");
		cust.setCartId(14);
		cust.setCustomerId(14);
		InputCustomer cust1 = new InputCustomer();
		cust1=service.updateCustomer(cust);
        assertNotNull(cust1,"Customer is added");
		
	}
	
	@Test
	public void viewAllCustomersUnitTest()
	{
		InputCustomer cust = service.viewCustomer(14);
		assertNotNull(cust, "Customer Found!!");
	}
	
	@Test
	public void viewCustomerUnitTest()
	{
		List<InputCustomer> cust = service.viewAllCustomers("Delhi");
		assertNotNull(cust, "Address removed !!");
		
	}
	
	
}
