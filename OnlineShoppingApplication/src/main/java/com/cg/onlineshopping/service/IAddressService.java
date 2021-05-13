package com.cg.onlineshopping.service;

import java.util.List;


import com.cg.onlineshopping.pojo.InputAddress;

public interface IAddressService {

	public InputAddress addAddress(InputAddress add);
	public InputAddress updateAddress(InputAddress add);
	public InputAddress removeAddress(int addressId);
	public List<InputAddress> viewAllAddress();
	public InputAddress viewAddress(int addressId);
	
	
}
