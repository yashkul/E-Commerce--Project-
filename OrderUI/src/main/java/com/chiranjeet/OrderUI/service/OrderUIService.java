package com.chiranjeet.OrderUI.service;

import java.util.Optional;

import com.chiranjeet.OrderUI.bean.ProductList;
import com.chiranjeet.OrderUI.bean.User;

public interface OrderUIService {
	Optional<User> getUser(String email,String password);	
	ProductList getProductList();
	boolean saveOrder(String email,Long productId,int quantity);
}
