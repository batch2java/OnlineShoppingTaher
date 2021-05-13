package com.cg.onlineshopping.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entities.Address;

public interface IAddressRepository extends JpaRepository<Address,Integer> {  
	
	/*public InputAddress AddAddress(InputAddress add);
	public InputAddress updateAddress(InputAddress add);
	public Address removeAddress(Address add);
	public List<Address> viewAllAddress(String id);
	public Address viewAddress(Address add);*/
	
}
