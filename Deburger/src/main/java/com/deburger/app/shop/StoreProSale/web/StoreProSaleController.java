package com.deburger.app.shop.StoreProSale.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.shop.StoreProSale.service.StoreProSaleService;
import com.deburger.app.shop.StoreProSale.service.StoreProSaleVO;

@Controller
public class StoreProSaleController {

	private StoreProSaleService storeProSaleService;

	@Autowired
	StoreProSaleController(StoreProSaleService storeProSaleService) {
		this.storeProSaleService = storeProSaleService;
	}

	@GetMapping("StoreProSaleList")
	public String StoreProSaleList(Model model) {

		List<StoreProSaleVO> list = storeProSaleService.StoreProSaleList();
		model.addAttribute("StoreProSaleList", list);

		return "shop/materials";
	}

	@GetMapping("StoreProSaleoneList")
	public String StoreProSaleoneList(StoreProSaleVO storeProSaleVO, Model model) {
		
		List<StoreProSaleVO> list = storeProSaleService.StoreProSaleoneList(storeProSaleVO);
		
		model.addAttribute("StoreProSaleoneList", list);
		
		return "shop/materialsGraph";
	}
	
	
}
