package com.cg.onlineshopping.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.service.ILoginService;

@RestController
@RequestMapping("/api/v1")
public class ILoginController {
	

	@Autowired
	ILoginService loginService;
	Logger logger = LoggerFactory.getLogger(ILoginController.class);

	
	@PostMapping("/userlogin")
	public User addUser(@Valid @RequestBody User user) {
		logger.info("User addUser()");
		return loginService.addUser(user);
	}

	@GetMapping("/getuser/{userId}")
	public User validateUser(@PathVariable Integer userId) {
		logger.info("User validateUser()");
		return loginService.validateUser(userId);
	}

	@DeleteMapping("/deleteuser/{userId}")
	public User removeUser(@PathVariable Integer userId) {
		logger.info("User removeUser()");
		return loginService.removeUser(userId);
	}
}