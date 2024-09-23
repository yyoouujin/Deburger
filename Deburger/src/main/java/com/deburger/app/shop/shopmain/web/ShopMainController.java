package com.deburger.app.shop.shopmain.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.shop.shopmain.service.ShopMainService;
import com.deburger.app.shop.shopmain.service.ShopMainVO;

/*
 * 2024/09/23 김도현 
 */
@Controller
public class ShopMainController {

	private ShopMainService shopMainService;
	
	@Autowired
	ShopMainController(ShopMainService shopMainService){
		this.shopMainService = shopMainService;
	}
	
	@GetMapping("shop")
	public String shop(Model model) {
		
		//작업 현황
		List<ShopMainVO> list = shopMainService.listCount();
		//최근공지
		List<ShopMainVO> list2 = shopMainService.noticeList();
		
		
		model.addAttribute("shop", list);
		model.addAttribute("notice", list2);
		
		
		
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
	
	// 유통임박 재고 리스트
	@GetMapping("limitList")
	public String limitList(Model model) {
		
		List<ShopMainVO> list = shopMainService.limitList();
		model.addAttribute("limitList", list);
		
		return "shop/Maininfo";
	}
		
	
}
