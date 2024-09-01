package com.deburger.app.shop.stock.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.deburger.app.shop.stock.service.StockService;
import com.deburger.app.shop.stock.service.StockVO;

@Controller
public class StockController {
	
	private StockService stockService;
	
	@Autowired
	StockController(StockService stockService){
		this.stockService = stockService;
	}
	
	@GetMapping("shopStock")
	public String selectStock(Model model) {
		
		List<StockVO> list = stockService.selectStock();
		
		model.addAttribute("stockList", list);

		
		
		return "shop/stocklist";
		
	}
	
	@GetMapping("shopCartInsert")
	public String shopCartInsert(StockVO stockVO,Model model) {
		System.err.println(stockVO);
		
		int id = stockService.insertCart(stockVO);
		
		
		
		String url = null;
		if(id > -1) {
			url =  "redirect:shopStock";
		}else {
			url = "deburger/shop";
		}
		
		return url;
	}
	
	@GetMapping("shopStockInfo")
	public String shopStockInfo(StockVO stockVO,Model model) {
		
		StockVO findVO = stockService.selectStockinfo(stockVO);
		
		model.addAttribute("shopStockInfo",findVO);
		
		return "shop/purchaseorder";
		

	}
}
