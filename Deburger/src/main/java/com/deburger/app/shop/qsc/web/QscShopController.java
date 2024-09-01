package com.deburger.app.shop.qsc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QscShopController {

	// 가맹점
	//QSC전체조회(희창)
	@GetMapping("qscListShop")
	public String qsclist() {
		return "shop/qscListShop";
	}
	
	//QSC상세조회(희창)
	@GetMapping("qscListInfoShop")
	public String qscListInfo() {
		return "shop/qscListInfoShop";
	}
	
	//QSC작성(희창)
	@GetMapping("qscInsertShop")
	public String qscInsert() {
		return "shop/qscInsertShop";
	}
	
	// 본점
	//QSC항목 작성(희창)
	@GetMapping("qscInsertOffice")
	public String qscInsertOffice() {
		return "office/qscInsertOffice";
	}
	
	//QSC결과 전체 조회(희창)
	@GetMapping("qscListOffice")
	public String qscListOffice() {
		return "office/qscListOffice";
	}	
	
	//QSC결과 상세 조회(희창)
	@GetMapping("qscListInfoOffice")
	public String qscListInfoOffice() {
		return "office/qscListInfoOffice";
	}
	
	
	
}
