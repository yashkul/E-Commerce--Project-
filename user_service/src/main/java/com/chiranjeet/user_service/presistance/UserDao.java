package com.chiranjeet.user_service.presistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiranjeet.user_service.bean.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmailIdAndPassword(String email, String password);

}
