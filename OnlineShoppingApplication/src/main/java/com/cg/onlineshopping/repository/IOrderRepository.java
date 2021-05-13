package com.cg.onlineshopping.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.onlineshopping.entities.Order;


public interface IOrderRepository extends JpaRepository<Order, Integer> {

	
	/*public Order addOrder(Order order);
	public Order updateOrder(Order order);
	public Order removeOrder(Order order);
	public Order viewOrder(Order order);*/
	//public List<Order> viewAllOrders(LocalDate date);
	
	@Query("select o from Order o where o.orderDate=:orderDate")
	public List<Order> viewAllOrderByDate(@Param("orderDate")LocalDate localdate);

	 @Query("select o from Order o where o.customer.customerId=:customerId")
	    public List<Order> viewAllOrdersByCustomer(@Param("customerId") Integer customerId);
	 
	 @Query("select o from Order o where o.address.city=:location")
		public List<Order> viewAllOrdersByLocation(@Param("location")String location);
	
}
