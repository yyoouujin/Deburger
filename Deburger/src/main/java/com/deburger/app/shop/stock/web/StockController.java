package com.deburger.app.shop.stock.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.office.material.service.MaterialVO;
import com.deburger.app.shop.stock.service.StockService;
import com.deburger.app.shop.stock.service.StockVO;

@Controller
public class StockController {

	private StockService stockService;

	@Autowired
	StockController(StockService stockService) {
		this.stockService = stockService;
	}

	@GetMapping("shopStock")
	public String selectStock(StockVO stockVO, Model model, 
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {

		int total = stockService.shopcountMaterial();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		stockVO = new StockVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		//List<StockVO> list = stockService.selectStock(stockVO);

		//model.addAttribute("stockList", list);
		model.addAttribute("paging", stockVO);
		model.addAttribute("viewAll", stockService.selectStock(stockVO));
		
		List<StockVO> list2 = stockService.stockClassification();
		model.addAttribute("stockC", list2);

		return "shop/stocklist";

	}

	@GetMapping("shopCartInsert")
	public String shopCartInsert(StockVO stockVO, Model model) {

		int id = stockService.insertCart(stockVO);

		String url = null;
		if (id > -1) {
			url = "redirect:shopStock";
		} else {
			url = "redirect:shopStock";
		}

		return url;
	}

	@GetMapping("shopStockInfo")
	public String shopStockInfo(StockVO stockVO, Model model
			/*, 
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage
			*/) {
		
		
		int total = stockService.shopinfo(stockVO);
//		if (nowPage == null && cntPerPage == null) {
//			nowPage = "1";
//			cntPerPage = "10";
//		} else if (nowPage == null) {
//			nowPage = "1";
//		} else if (cntPerPage == null) { 
//			cntPerPage = "10";
//		}
		
		stockVO.setTotal(total);

		System.err.println(stockVO);
		model.addAttribute("paging", stockVO);
		model.addAttribute("viewAll", stockService.selectStockinfo(stockVO));
		 
		return "shop/stocklistinfo";
	}
	
	

	@PostMapping("storeStockUPandIN")
	public String storeStockUPandIN(@RequestBody StockVO stockVO) {

		stockService.updqtestoreStock(stockVO);

		return "redirect:shopStock";
	}

	@PostMapping("classificationList")
	@ResponseBody
	public List<StockVO> classificationList(@RequestBody StockVO stockVO, Model model) {
		List<StockVO> list = stockService.classificationList(stockVO);
		return list;
	}
}
