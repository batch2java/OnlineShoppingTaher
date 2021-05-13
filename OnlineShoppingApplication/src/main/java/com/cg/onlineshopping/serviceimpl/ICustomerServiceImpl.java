package com.cg.onlineshopping.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.error.CustomerNotFoundException;
import com.cg.onlineshopping.pojo.InputCustomer;
import com.cg.onlineshopping.repository.IAddressRepository;
import com.cg.onlineshopping.repository.ICustomerRepository;
import com.cg.onlineshopping.service.ICustomerService;
@Service
public class ICustomerServiceImpl implements ICustomerService {

	
	@Autowired
	ICustomerRepository customerRepo;
	@Autowired
	IAddressRepository addressRepo;
	Logger logger = LoggerFactory.getLogger(ICustomerServiceImpl.class);
	
	@Transactional
	public InputCustomer rowMapperCustomer(Customer c) {
		
        InputCustomer cust = new InputCustomer();
        cust.setAddressId(c.getAddress().getAddressId());
        cust.setBuildingName(c.getAddress().getBuildingName());
        cust.setStreetNo(c.getAddress().getCity());
        cust.setState(c.getAddress().getState());
        cust.setPincode(c.getAddress().getPincode());
        cust.setCountry(c.getAddress().getCountry());
        cust.setCustomerId(c.getCustomerId());
        cust.setFirstName(c.getFirstName());
        cust.setLastName(c.getLastName());
        cust.setEmail(c.getEmail());
        cust.setMobileNumber(c.getMobileNumber());
        cust.setCartId(c.getCart().getCartId());
        
        return cust;
	}
	
	@Override
	@Transactional
	public InputCustomer addCustomer(InputCustomer cust) {
		
	logger.info("Customer addCustomer");
	       Customer cust1 = new Customer();
	        Address add = new Address();
	        Cart cart = new Cart();
	        
	        
	        cust1.setFirstName(cust.getFirstName());
	        cust1.setLastName(cust.getLastName());
	        cust1.setEmail(cust.getEmail());
	        cust1.setMobileNumber(cust.getMobileNumber());
	        
	        add.setBuildingName(cust.getBuildingName());
	        add.setCity(cust.getCity());
	        add.setStreetNo(cust.getStreetNo());
	        add.setState(cust.getState());
	        add.setPincode(cust.getPincode());
	        add.setCountry(cust.getCountry());
	        
	        add.setCustomer(cust1);
	        cust1.setAddress(add);
	        
	       
			cart.setCustomer(cust1);
			cust1.setCart(cart);
			
			
			cust1=customerRepo.save(cust1);
			
			cust.setCustomerId(cust1.getCustomerId());
			cust.setAddressId(cust1.getAddress().getAddressId());
			cust.setCartId(cust1.getCart().getCartId());
			
			
			return cust;
			
			
		}
	

	@Override
	@Transactional
	public InputCustomer updateCustomer(InputCustomer cust) {
		logger.info("Customer updateCustomer");
		
		 Customer cust1= new Customer();
		 cust1 = customerRepo.findById(cust.getCustomerId()).orElse(null);
		 
		if(cust1 == null) {
			throw new CustomerNotFoundException();
		}
		
		else{
		
			 cust1.setCustomerId(cust.getCustomerId());
			 cust1.setFirstName(cust.getFirstName());
			 cust1.setLastName(cust.getLastName());
			 cust1.setMobileNumber(cust.getMobileNumber());
			 cust1.setEmail(cust.getEmail());

			 Address add = new Address();
			 add.setAddressId(cust.getAddressId());
			 add.setBuildingName(cust.getBuildingName());
		     add.setCity(cust.getCity());
		     add.setStreetNo(cust.getStreetNo());
		     add.setState(cust.getState());
		     add.setPincode(cust.getPincode());
		     add.setCountry(cust.getCountry());
		     
		     Cart cart=new Cart();
		     cart.setCartId(cust.getCartId());
		     cust1.setCart(cart);
		     cust1.setAddress(add);
			
			cust1=customerRepo.save(cust1);
			cust.setCustomerId(cust1.getCustomerId());
			cust.setAddressId(cust1.getAddress().getAddressId());
			cust.setCartId(cust1.getCart().getCartId());
			
			
			return cust;
			
		}
	}

    @Override
    @Transactional
	public InputCustomer removeCustomer(Integer customerId) {
    	
    	logger.info("Customer removeCustomer");

        Optional<Customer> customer=customerRepo.findById(customerId);
        if(!customer.isPresent()) {
            throw new CustomerNotFoundException();
        }
        else {
            customerRepo.deleteById(customerId);
            InputCustomer cust = rowMapperCustomer(customer.get());
            return cust;
            
        }
    }

	@Override
	@Transactional
	public InputCustomer viewCustomer(Integer customerId) {
		
		logger.info("Customer viewCustomer");

        Optional<Customer> customer = customerRepo.findById(customerId);
        if(!customer.isPresent()) {
            throw new CustomerNotFoundException();
        }
        else {
            
        Customer c = customer.get();
        InputCustomer cust = rowMapperCustomer(c);
        return cust;
        
        
            
    }
    }
	

	@Override
	@Transactional
	public List<InputCustomer> viewAllCustomers(String location) {
		
		logger.info("Customer viewAllCustomers");

        List<Customer> list = customerRepo.viewAllCustomer(location);
        if(list.isEmpty())
            throw new CustomerNotFoundException();
        
            List<InputCustomer> clist = new ArrayList<InputCustomer>();
            for(Customer c: list) {
            
                InputCustomer cust = rowMapperCustomer(c);
                clist.add(cust);
                
            }
        return clist;
    }
	
	}