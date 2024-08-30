package com.deburger.app.main.login.service;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String password;
	private String authority;
	private String passwordChangeOpertation;	
}
