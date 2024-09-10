package com.deburger.app.shop.productSale.web;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.shop.productSale.service.StoreSaleService;
import com.deburger.app.shop.productSale.service.StoreSaleVO;

import lombok.AllArgsConstructor;



@Controller
@AllArgsConstructor
public class StoreSaleController {
	
	StoreSaleService storeSaleService;
	
	// 가맹점 판매 정산 
	@GetMapping("StoreSale")
	public String getMethodName(Model model) {
		List<StoreSaleVO> list = storeSaleService.selectStoreSaleList();
		model.addAttribute("List", list);
		return "shop/StoreSale";
	}
	
	

	
	
}
