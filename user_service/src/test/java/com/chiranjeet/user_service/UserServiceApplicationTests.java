package com.chiranjeet.user_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chiranjeet.user_service.bean.User;
import com.chiranjeet.user_service.service.UserService;


@SpringBootTest
class UserServiceApplicationTests {
	@Autowired
	UserService userService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void createUser() {
		boolean b = userService.createUser(new User(1, "sdsfsd", "fd", "fdfd", null, null));
	}

}
