package com.deburger.app.shop.shoporder.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.shop.shoporder.service.ShopOrderService;
import com.deburger.app.shop.shoporder.service.ShopOrderVO;

@Controller
public class ShopOderController {

	private ShopOrderService shopOrderService;
	
	@Autowired
	ShopOderController(ShopOrderService shopOrderService){
		this.shopOrderService = shopOrderService;
	}
	
	//장바구니 전체 조회
	@GetMapping("selectOrderCart")
	public String selectShopOrder(Model model) {
		
		List<ShopOrderVO> list = shopOrderService.selectShopOrder();
		
		model.addAttribute("selectOrderCart", list);
		
		return "shop/purchaseorder";
	}
	
	//발주 저장
	@PostMapping("insertShopOrder")
	@ResponseBody
	public int insertShopOrder(@RequestBody ShopOrderVO shopOrderVO,Model model) {
		return shopOrderService.insertShopOrder(shopOrderVO);	
	}
	
	//발주 리스트
	@GetMapping("ShopOrderList")
	public String ShopOrderList(Model model) {
		List<ShopOrderVO> list = shopOrderService.ShopOrderList();
		
		model.addAttribute("ShopOrderList", list);
		
		return "shop/Order";
	}
	
	//취소
	@PostMapping("updateOrderCancel")  
	@ResponseBody 
	public int updateOrderCancel(ShopOrderVO shopOrderVO){ 
	  return shopOrderService.updateOrderCancel(shopOrderVO);
	}
	
	@GetMapping("ShopOrderInfo")
	public String ShopOrderInfo(ShopOrderVO shopOrderVO,Model model) {
		List<ShopOrderVO> list = shopOrderService.orderInfo(shopOrderVO);
		model.addAttribute("ShopOrderInfo", list);
		return "shop/Orderinfo";
	}
	
	
}
