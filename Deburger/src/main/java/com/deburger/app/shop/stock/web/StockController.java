package com.deburger.app.shop.stock.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
		List<StockVO> list = stockService.selectStockinfo(stockVO);
		model.addAttribute("shopStockInfo",list);
		return "shop/stocklistinfo";
	}
	
	@PostMapping("storeStockUPandIN")
	public String storeStockUPandIN (@RequestBody StockVO stockVO) {
		
		System.err.println(stockVO);
		stockService.updqtestoreStock(stockVO);
		
		return "redirect:shopStock";
	}
}
