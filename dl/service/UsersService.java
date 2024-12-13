package com.dl.service;

import java.net.Authenticator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dl.model.Users;
import com.dl.repo.UserRepo;

@Service
public class UsersService {
	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private JwtService jwtService;
	
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//create a new user 
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
		
	}


    //checking user detials for login
	public String verify(Users user) {
	Authentication authentication=
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}else {
			return "Login failed";
		}
	}

}

//json-javascrpit object Notation is used 
