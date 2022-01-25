package com.chiranjeet.user_service.service;

import java.util.Optional;

import com.chiranjeet.user_service.bean.User;

public interface UserService {
	public boolean createUser(User user);
	public Optional<User> findUser(String email,String password);
}
