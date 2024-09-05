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
		
	

	//QnA 전체조회(지수)
	@GetMapping("qnaListShop")
	public String qnaList() {
		return "shop/qnaListShop";
	}
	
	//QnA 상세조회(지수)
	@GetMapping("qnaListInfoShop")
	public String qnaListInfo() {
		return "shop/qnaListInfoShop";
	}	
	
	//QnA작성(지수)
	@GetMapping("qnaInsertShop")
	public String qnaInsert() {
		return "shop/qnaInsertShop";
	}
	
	//QnA수정(지수)
	@GetMapping("qnaCorrectShop")
	public String qnaCorrect() {
		return "shop/qnaCorrectShop";
	}	
}
