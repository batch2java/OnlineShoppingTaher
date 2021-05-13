package com.cg.onlineshopping.service;

import java.util.List;
import com.cg.onlineshopping.pojo.InputCustomer;

public interface ICustomerService {
	
	public InputCustomer addCustomer(InputCustomer cust);
	public InputCustomer updateCustomer(InputCustomer cust);
	public InputCustomer removeCustomer(Integer cutomerId);
	public InputCustomer viewCustomer(Integer customerId);
	public List<InputCustomer> viewAllCustomers(String location);

}
