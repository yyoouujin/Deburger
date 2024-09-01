package com.deburger.app.shop.shoporder.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.shop.shoporder.service.ShopOrderService;
import com.deburger.app.shop.shoporder.service.ShopOrderVO;

@Controller
public class ShopOderController {

	private ShopOrderService shopOrderService;
	
	@Autowired
	ShopOderController(ShopOrderService shopOrderService){
		this.shopOrderService = shopOrderService;
	}
	
	@GetMapping("selectOrderCart")
	public String selectShopOrder(Model model) {
		List<ShopOrderVO> list = shopOrderService.selectShopOrder();
		
		System.err.println(list);
		model.addAttribute("selectOrderCart", list);
		
		return "shop/purchaseorder";
	}
}
