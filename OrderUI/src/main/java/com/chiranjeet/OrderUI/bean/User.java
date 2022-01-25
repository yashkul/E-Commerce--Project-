package com.chiranjeet.OrderUI.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int userId;
	private String emailId;
	private String password;
	private String name;
	private String phone;
	private String address;
}
