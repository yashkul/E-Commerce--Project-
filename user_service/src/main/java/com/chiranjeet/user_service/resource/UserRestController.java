package com.chiranjeet.user_service.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chiranjeet.user_service.bean.User;
import com.chiranjeet.user_service.exception.UserNotFound;
import com.chiranjeet.user_service.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/user/{email}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable String email,@PathVariable String password) {
		Optional<User> user = userService.findUser(email, password);
		if(user.isEmpty())
			throw new UserNotFound("User Not Exist");
		return user.get();
	}
	
	@PostMapping(path = "/user",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateInventoryItemQuantityByProductCode(@RequestBody User user){
		System.out.println("In Order rest Service");
		boolean status = userService.createUser(user);
		if(!status) {
			throw new UserNotFound("Can't Save User");
		}
		return new ResponseEntity<Boolean>(status, HttpStatus.ACCEPTED);
	}
}
