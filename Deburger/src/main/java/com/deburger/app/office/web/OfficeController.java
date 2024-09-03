package com.deburger.app.office.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfficeController {
	
	@GetMapping("office")
	public String officeMain() {
		return "office/main";
	}			
	
		
	
}
