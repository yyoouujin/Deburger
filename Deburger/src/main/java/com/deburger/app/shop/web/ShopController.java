package com.deburger.app.shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

	//메인페이지
	@GetMapping("shop")
	public String shopMain() {
		return "shop/main";
	}
		
	


}
