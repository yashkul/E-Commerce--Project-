package com.chiranjeet.user_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chiranjeet.user_service.bean.User;
import com.chiranjeet.user_service.presistance.UserDao;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean createUser(User user) {
		try {
			userDao.save(user);
		}catch(IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	@Override
	public Optional<User> findUser(String email, String password) {
		Optional<User> user;
		try {
			user = Optional.ofNullable(userDao.findByEmailIdAndPassword(email,password));
		}catch(Exception e) {
			return Optional.empty();
		}
		return user;
	}

}
