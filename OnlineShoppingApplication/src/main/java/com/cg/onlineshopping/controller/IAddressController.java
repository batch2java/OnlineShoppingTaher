package com.cg.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineshopping.pojo.InputAddress;
import com.cg.onlineshopping.service.IAddressService;


@RestController
@RequestMapping("/api/v1")


public class IAddressController {
	
	@Autowired
	IAddressService addressService;
	Logger logger = LoggerFactory.getLogger(IAddressController.class);

	
	@PostMapping(path="/addaddress")
	public InputAddress addAddress(@Valid @RequestBody InputAddress add)
	{
		logger.info("Address addAddress()");
		return addressService.addAddress(add);
	}

	@PutMapping("/updateaddress")
	public InputAddress updateAddress(@RequestBody InputAddress add)
	{
		logger.info("Address updateAddress()");
		return addressService.updateAddress(add);
	}

	@DeleteMapping("/deleteaddressById/{addressId}")
	public InputAddress removeCustomer(@PathVariable int addressId)
	{
		logger.info("Address removeAddress()");
		return addressService.removeAddress(addressId);
	}
	@GetMapping(path = "/getalladdress")
	public List<InputAddress> viewAllAddress()
	{
		logger.info("Address viewAllAddress()");
		return addressService.viewAllAddress();
	}
	@GetMapping(path = "/getaddressById/{addressId}")
	public InputAddress viewAddress(@PathVariable int addressId)
	{
		logger.info("Address viewAddress(addressId)");
		return addressService.viewAddress(addressId);
	}
	
   

}
