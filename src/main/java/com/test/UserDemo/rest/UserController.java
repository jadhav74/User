package com.test.UserDemo.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.UserDemo.model.User;

@RequestMapping(value="/rest/users")
@RestController
public class UserController {

	static List<User> users = new ArrayList<>();
	
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> usersData = new ArrayList<>();
		for(User user : users){
	        if(user.isActive() != null && user.isActive() == true) {
	        	usersData.add(user);
	        }
	    }
		
	    return new ResponseEntity<List<User>>(usersData, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public  ResponseEntity<?> getUserById(@PathVariable(value = "id") String userId) {
		if(userId.equals(null)) {
			return new ResponseEntity<String>("Please provide user id", HttpStatus.NOT_FOUND);
	    }
		
		for(User user : users){
	        if(! user.getId().equals(null) && user.getId().equals(userId)) {
	        	return new ResponseEntity<User>(user, HttpStatus.OK);
	        }
	    }
		return new ResponseEntity<String>("No User record found for Given id :"+ userId, HttpStatus.NOT_FOUND);
	}

	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody User user) {
		if(user.equals(null)) {
			return new ResponseEntity<String>("Please provide user details", HttpStatus.NOT_FOUND);
	    } else if (user.getBirthDate().after(new Date())) {
	    	return new ResponseEntity<String>("Please provide birth date before current date", HttpStatus.NOT_ACCEPTABLE);
	    } else {
	    	for(User userData : users){
		        if(! userData.getId().equals(null) && userData.getId().equals(user.getId())) {
		        	return new ResponseEntity<String>("User allready present with id "+ user.getId(), HttpStatus.NOT_ACCEPTABLE);
		        }
		    }
	    	users.add(user);
	    	return new ResponseEntity<String>("New user added successfully.", HttpStatus.CREATED);	
	    }
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") String userId) {
		if(userId.equals(null)) {
			return new ResponseEntity<String>("Please provide user id", HttpStatus.NOT_FOUND);
	    }
		
		for(User user : users){
	        if(! user.getId().equals(null) && user.getId().equals(userId)) {
	        	user.setActive(false);
	        	return new ResponseEntity<String>("User Deleted Succesfully.", HttpStatus.OK);
	        }
	    }
		return new ResponseEntity<String>("No User record found for Given id :"+ userId, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "id") String userId, @RequestBody User user) {
		if(userId.equals(null)) {
			return new ResponseEntity<String>("Please provide user id", HttpStatus.NOT_FOUND);
	    } else if (user.getBirthDate().after(new Date())) {
	    	return new ResponseEntity<String>("Please provide birth date before current date", HttpStatus.NOT_ACCEPTABLE);
	    }
		
		for(User userData : users){
	        if(! userData.getId().equals(null) && userData.getId().equals(userId)) {
	        	userData.setActive(user.isActive());
	        	userData.setBirthDate(user.getBirthDate());
	        	userData.setfName(user.getfName());
	        	userData.setlName(user.getlName());
	        	userData.setPinCode(user.getPinCode());
	        	userData.setEmail(user.getEmail());
	        	return new ResponseEntity<String>("Records updated Successfully for user id "+ userId, HttpStatus.OK);
	        }
	    }
		return new ResponseEntity<String>("No User record found for Given id :"+ userId, HttpStatus.NOT_FOUND);
	}
}
