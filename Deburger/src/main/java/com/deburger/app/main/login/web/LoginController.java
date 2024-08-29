package com.deburger.app.main.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("login")
	public String officeMain() {
		return "main/login/loginForm";
	}

}
