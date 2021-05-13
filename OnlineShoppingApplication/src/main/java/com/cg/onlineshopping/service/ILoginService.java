package com.cg.onlineshopping.service;

import com.cg.onlineshopping.entities.User;

public interface ILoginService {
	
	public User addUser(User user);
	public User removeUser(Integer user);
	public User validateUser(Integer userId);
	public User signOut(User user);
}
