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
	
	//가맹점 재고 관리
	@GetMapping("stocklist")
	public String shopstocklist() {
		return "shop/stocklist";
	}
	
	//가맹점 재고 상세관리
	@GetMapping("stocklistinfo")
	public String shopstocklistinfo() {
		return "shop/stocklistinfo";
	}
	
	//가맹점 수동 발주
	@GetMapping("shopOrder")
	public String shopOrder() {
		return "shop/shopOrder";
	}
	
	//가맹점 자동 발주
	@GetMapping("shopOrderAuto")
	public String shopOrderAuto() {
		return "shop/shopOrderAuto";
	}
}
