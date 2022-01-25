package com.chiranjeet.OrderUI.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.chiranjeet.OrderUI.bean.ProductList;
import com.chiranjeet.OrderUI.bean.User;
import com.chiranjeet.OrderUI.service.OrderUIService;

@Controller
@SessionAttributes("email")
public class OrderUIController {
	@Autowired
	private OrderUIService orderUIService;
	@RequestMapping("/")
	public ModelAndView showLoginPage() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(path ="/loginCheck",method = RequestMethod.POST)
	public ModelAndView showMenuController(@RequestParam("email") String email,@RequestParam("password") String password){
		Optional<User> user = orderUIService.getUser(email, password);
		if(user.isEmpty())
			return new ModelAndView("login","message","Email Or Password Wrong");
		
		ProductList productList = orderUIService.getProductList();
		ModelAndView model_view = new ModelAndView("catalog","item_list",productList.getProducts());
		model_view.addObject("email",email);
		HashMap<Integer,Integer> product_quant = new HashMap<Integer,Integer>();
		product_quant.put(1, 2);
		product_quant.put(2, 4);
		product_quant.put(3, 3);
		model_view.addObject("product_quant",product_quant);
		return model_view;
	}
	
	@RequestMapping("/order")
	public ModelAndView getOrders(HashMap<Integer,Integer>product_quant) {
		System.out.println(product_quant);
		return new ModelAndView("login");
	}
	//@RequestParam("productId")Long id,@RequestParam("quantity")int quantity
}
