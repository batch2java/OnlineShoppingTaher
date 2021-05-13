package com.cg.onlineshopping.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cg.onlineshopping.pojo.InputOrder;


public interface IOrderService {
	
	public InputOrder addOrder(InputOrder order);
	public InputOrder removeOrder(Integer orderId);
	public List<InputOrder> viewAllOrdersByLocation(String location);
	public List<InputOrder> viewAllOrderByCustomerId(Integer customerId);
	public List<InputOrder> viewAllOrderByDate(@Param("orderDate")LocalDate localdate);
}
