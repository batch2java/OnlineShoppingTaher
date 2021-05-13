package com.cg.onlineshopping.service.impl;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.pojo.InputOrder;
import com.cg.onlineshopping.repository.IOrderRepository;

import com.cg.onlineshopping.service.IOrderService;
import com.cg.onlineshopping.serviceimpl.IOrderServiceImpl;

@SpringBootTest
public class IOrderServiceImplTest {

	@InjectMocks
	IOrderServiceImpl orderServiceImpl;

	@Mock
	IOrderRepository orderRepo;
	
	 @Autowired
	 IOrderService service;
	
	@Test 
	public void removeOrderUnitTest()
	{
		InputOrder order =service.removeOrder(2);
		assertNotNull(order, "Order deleted !!");
	}
	
	@Test
	public void orderByDateUnitTest()
	{
		List<InputOrder> order =service.viewAllOrderByDate(LocalDate.of(2021, 05, 17));
		assertNotNull(order, "Order found");	
	}
	@Test
	public void orderByIdUnitTest()
	{
		List<InputOrder> order =service.viewAllOrderByCustomerId(14);
		assertNotNull(order, "Order found !!");
	}
	
	@Test
	public void orderByLocationUnitTest()
	{
		List<InputOrder> order =service.viewAllOrdersByLocation("Delhi");
		assertNotNull(order, "Order found !!");
}

}
