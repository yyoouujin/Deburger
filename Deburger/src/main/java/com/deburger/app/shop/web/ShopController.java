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
		
	
	//공지사항 전체조회(지수)
	@GetMapping("noticeListShop")
	public String noticeList() {
		return "shop/noticeListShop";
	}
	
	//공지사항 상세조회(지수)
	@GetMapping("noticeListInfoShop")
	public String noticeListInfo() {
		return "shop/noticeListInfoShop";
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
	
	//가맹점 재고 관리
	@GetMapping("shopstocklist")
	public String shopstocklist() {
		return "shop/stocklist";
	}
	
	//가맹점 재고 상세관리
	@GetMapping("shopstocklistinfo")
	public String shopstocklistinfo() {
		return "shop/stocklistinfo";
	}
	
	//가맹점 수동 발주
	@GetMapping("shopOrder")
	public String shopOrder() {
		return "shop/Order";
	}
	
	//가맹점 자동 발주
	@GetMapping("shopOrderAuto")
	public String shopOrderAuto() {
		return "shop/OrderAuto";
	}
	
	//구매 발주서
	@GetMapping("shoppurchaseorder")
	public String purchaseorder() {
		return "shop/purchaseorder";
	}
	
	//입고 전체조회

	@GetMapping("shopreceivesList")
	public String receivesList() {
		return "shop/receivesList";
	}
	
	//입고 상세조회
	@GetMapping("shopreceiveInfo")
	public String receiveInfo() {
		return "shop/receiveInfo";
	}
	
	//제품 통계
	@GetMapping("shopproducts")
	public String products() {
		return "shop/products";
	}
	
	//재료 통계
	@GetMapping("shopmaterials")
	public String materials() {
		return "shop/materials";
	}
}
