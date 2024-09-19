package com.deburger.app.shop.shopmain.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.shop.shopmain.service.ShopMainService;
import com.deburger.app.shop.shopmain.service.ShopMainVO;

@Controller
public class ShopMainController {

	private ShopMainService shopMainService;
	
	@Autowired
	ShopMainController(ShopMainService shopMainService){
		this.shopMainService = shopMainService;
	}
	
	@GetMapping("shop")
	public String shop(Model model) {
		
		List<ShopMainVO> list = shopMainService.listCount();
		model.addAttribute("shop", list);
		
		return "shop/main";
	}
	
	@GetMapping("shopSell")
	public String shopSellG(ShopMainVO shopMainVO,Model model) {
		
		List<ShopMainVO> list = shopMainService.shopSellG(shopMainVO);
		model.addAttribute("shopSellG", list);
		
		return "shop/mainSellG";
	}
	
	@GetMapping("shopOrder")
	public String shopOrderG(ShopMainVO shopMainVO,Model model) {
		
		List<ShopMainVO> list = shopMainService.shopOrderG(shopMainVO);
		model.addAttribute("shopOrderG", list);
		
		return "shop/mainOderG";
	}
	
	@GetMapping("limitList")
	public String limitList(Model model) {
		
		List<ShopMainVO> list = shopMainService.limitList();
		model.addAttribute("limitList", list);
		
		return "shop/Maininfo";
	}
		
	
}
