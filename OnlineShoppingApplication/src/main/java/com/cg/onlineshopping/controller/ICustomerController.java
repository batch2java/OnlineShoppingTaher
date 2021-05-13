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
import com.cg.onlineshopping.pojo.InputCustomer;
import com.cg.onlineshopping.service.ICustomerService;

@RestController
@RequestMapping("/api/v1")
public class ICustomerController {

	@Autowired
	ICustomerService customerService;
	Logger logger = LoggerFactory.getLogger(ICustomerController.class);
	
	@PostMapping(path="/createcustomer")
    public InputCustomer addCustomer(@Valid @RequestBody InputCustomer customer) {
        logger.info("Customer addCustomer");
        return customerService.addCustomer(customer) ;
    }
	
	@PutMapping(path="/updatecustomer")
    public InputCustomer updateCustomer( @RequestBody InputCustomer customer) {
		logger.info("Customer addCustomer");
        return customerService.updateCustomer(customer);
    }
	
	@DeleteMapping(path="/deletecustomerById/{customerId}")
    public InputCustomer removeCustomer( @PathVariable Integer customerId) {
		logger.info("Customer removeCustomer");
        return customerService.removeCustomer(customerId) ;
    }
	
	@GetMapping(path = "/getallcustomer/{location}")
    public List<InputCustomer> viewAllCustomers(@PathVariable String location){
		logger.info("Customer viewAllCustomer");
        return customerService.viewAllCustomers(location) ;
        
    }
	
	@GetMapping(path = "/getcustomerById/{customerId}")
    public InputCustomer viewCustomer(@PathVariable Integer customerId){
		logger.info("Customer viewCustomer");
        return customerService.viewCustomer(customerId) ;
    }


}