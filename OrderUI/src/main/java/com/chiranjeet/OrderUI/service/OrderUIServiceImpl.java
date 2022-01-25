package com.chiranjeet.OrderUI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chiranjeet.OrderUI.bean.ProductList;
import com.chiranjeet.OrderUI.bean.User;

@Service
public class OrderUIServiceImpl implements OrderUIService{
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Optional<User> getUser(String email, String password) {
		return Optional.ofNullable(requestUserFromUserService(email,password));
	}

	@Override
	public ProductList getProductList() {
		return requestProducListFromCatalogService();
	}
	
	@Override
	public boolean saveOrder(String email, Long productId, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private User requestUserFromUserService(String email,String password) {
		User user = restTemplate.getForObject("http://localhost:8084/user/"+email+"/"+password, User.class);
		return user;
	}
	
	private ProductList requestProducListFromCatalogService() {
		ProductList pro_list = restTemplate.getForObject("http://localhost:8081/products/", ProductList.class);
		return pro_list;
	}


}
