package com.deburger.app.shop.productSale.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class StoreSaleController {
	
	// 가맹점 판매 정산 
	@GetMapping("StoreSale")
	public String getMethodName() {
		
		return "shop/StoreSale";
	}
	
	

	
	
}
