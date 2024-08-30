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
	@GetMapping("Order")
	public String shopOrder() {
		return "shop/Order";
	}
	
	//가맹점 자동 발주
	@GetMapping("OrderAuto")
	public String shopOrderAuto() {
		return "shop/OrderAuto";
	}
	
	//구매 발주서
	@GetMapping("purchaseorder")
	public String purchaseorder() {
		return "shop/purchaseorder";
	}
	
	//입고 전체조회

	@GetMapping("receivesList")
	public String receivesList() {
		return "shop/receivesList";
	}
	
	//입고 상세조회
	@GetMapping("receiveInfo")
	public String receiveInfo() {
		return "shop/receiveInfo";
	}
	
	//제품 통계
	@GetMapping("productss")
	public String products() {
		return "shop/products";
	}
	
	//재료 통계
	@GetMapping("materials")
	public String materials() {
		return "shop/materials";
	}
}
