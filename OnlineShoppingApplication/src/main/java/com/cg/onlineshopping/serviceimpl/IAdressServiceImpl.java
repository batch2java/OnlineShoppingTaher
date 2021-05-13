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
import com.cg.onlineshopping.error.AddressNotFoundException;
import com.cg.onlineshopping.pojo.InputAddress;
import com.cg.onlineshopping.repository.IAddressRepository;
import com.cg.onlineshopping.service.IAddressService;

@Service
public class IAdressServiceImpl implements IAddressService {
@Autowired
IAddressRepository addressRepo;
Logger logger = LoggerFactory.getLogger(IAdressServiceImpl.class);

@Transactional
public InputAddress rowMapperAddress(Address a) {
	
    InputAddress add = new InputAddress();
    add.setAddressId(a.getAddressId());
    add.setBuildingName(a.getBuildingName());
    add.setCity(a.getCity());
    add.setStreetNo(a.getStreetNo());
    add.setState(a.getState());
    add.setPincode(a.getPincode());
    add.setCountry(a.getCountry());
    
    
    return add;
}

@Override
@Transactional
public InputAddress addAddress(InputAddress add) {
	logger.info("Address AddAddress()");

	 Address add1 = new Address();
	 add1.setBuildingName(add.getBuildingName());
     add1.setCity(add.getCity());
     add1.setStreetNo(add.getStreetNo());
     add1.setState(add.getState());
     add1.setPincode(add.getPincode());
     add1.setCountry(add.getCountry());
     
	
	add1=addressRepo.save(add1);
	add.setAddressId(add1.getAddressId());

		return add;
	}



	@Override
	@Transactional
	public InputAddress updateAddress(InputAddress add) {

		logger.info("Address updateAddress()");
		
		 Address add1 = new Address();
		 add1.setAddressId(add.getAddressId());
		 add1.setBuildingName(add.getBuildingName());
	     add1.setCity(add.getCity());
	     add1.setStreetNo(add.getStreetNo());
	     add1.setState(add.getState());
	     add1.setPincode(add.getPincode());
	     add1.setCountry(add.getCountry());
	     
		
		add1=addressRepo.save(add1);
		add.setAddressId(add1.getAddressId());
			return add;
		}
	

	@Override
	@Transactional
	public InputAddress removeAddress(int addressId) {
		
		logger.info("Address removeAddress()");
		Optional<Address> add1 = addressRepo.findById(addressId);
		if(!add1.isPresent())
			throw new AddressNotFoundException();
		else {
			 addressRepo.deleteById(addressId);
	            InputAddress a = rowMapperAddress(add1.get());
	            return a;
		}
		
	}

	@Override
	@Transactional
	public List<InputAddress> viewAllAddress() {
		
		logger.info("Address viewAllAddress()");
		List<Address> list = addressRepo.findAll();
		if(list.isEmpty())
			throw new AddressNotFoundException();
		else {
			 List<InputAddress> alist = new ArrayList<InputAddress>();
        
			 for(Address a: list) {
            InputAddress ia = rowMapperAddress(a);
            alist.add(ia);
			 }   
        
			return alist;
	}
	}
	
	@Override
	@Transactional
	public InputAddress viewAddress(int addressId) {

		logger.info("Address viewAddress()");
		Optional<Address> add1 = addressRepo.findById(addressId);
		if(!add1.isPresent())
			throw new AddressNotFoundException();
		else {
			Address add2=add1.get();
			InputAddress add=rowMapperAddress(add2);
			
			return add;
		}
	}
	

}


