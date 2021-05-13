package com.cg.onlineshopping.pojo;

import java.util.HashMap;
import java.util.Map;

public class OutputCart {
	private Integer cartId;
	private Map<Integer,Integer> map = new HashMap<Integer,Integer>();

		public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Map<Integer, Integer> getMap() {
		return map;
	}
	public void setMap(Map<Integer, Integer> map) {
		this.map = map;
	}
		
	
}
