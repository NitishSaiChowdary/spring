package com.dl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dl.model.Users;
import com.dl.service.UsersService;

@RestController
public class UserController {
	@Autowired
	private UsersService usersService;
	
	
	
	public UserController(UsersService usersService) {
		super();
		this.usersService = usersService;
	}



	//create a new users
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		
		return usersService.register(user);
		
	}
	
	 @PostMapping("/login")
	    public String login(@RequestBody Users user) {

	        return usersService.verify(user);
	    }

}
