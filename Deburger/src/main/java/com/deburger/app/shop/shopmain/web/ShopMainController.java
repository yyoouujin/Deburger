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
	
	//메인페이지
	@GetMapping("shop")
	public String shop(Model model) {
		
		//작업 현황 갯수 표시
		List<ShopMainVO> list1 = shopMainService.listCount1();
		
		//작업 현황 갯수 표시
		List<ShopMainVO> list2 = shopMainService.listCount2();
		
		//작업 현황 갯수 표시
		List<ShopMainVO> list3 = shopMainService.listCount3();
		
		//최근 공지 목록
		List<ShopMainVO> list0 = shopMainService.noticeList();
		
		model.addAttribute("shop3", list3);
		model.addAttribute("shop2", list2);
		model.addAttribute("shop1", list1);
		model.addAttribute("notice", list0);
		
		
		
		return "shop/main2";
	}
	
	//매출액 그래프
	@GetMapping("shopSell")
	public String shopSellG(ShopMainVO shopMainVO,Model model) {
		
		List<ShopMainVO> list = shopMainService.shopSellG(shopMainVO);
		model.addAttribute("shopSellG", list);
		
		return "shop/mainSellG";
	}
	
	//매출 제품
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
