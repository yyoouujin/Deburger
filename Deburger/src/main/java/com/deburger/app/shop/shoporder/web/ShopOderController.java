package com.deburger.app.shop.shoporder.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.shop.shoporder.service.ShopOrderService;
import com.deburger.app.shop.shoporder.service.ShopOrderVO;
import com.deburger.app.shop.stock.service.StockVO;
import com.deburger.app.shop.storein.service.ListVO;

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
	
	//입고처리 안된 발주 리스트
	@GetMapping("ShopOrderList")
	public String ShopOrderList(ShopOrderVO shopOrderVO, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {
		
		int total = shopOrderService.OrdercountMaterial();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		
		shopOrderVO = new ShopOrderVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

		model.addAttribute("paging", shopOrderVO);
		model.addAttribute("viewAll", shopOrderService.ShopOrderList(shopOrderVO));
		

		
		return "shop/Order";
	}
	
	//취소
	@PostMapping("updateOrderCancel")  
	@ResponseBody 
	public int updateOrderCancel(ShopOrderVO shopOrderVO){ 
	  return shopOrderService.updateOrderCancel(shopOrderVO);
	}
	
	//발주 상세조회
	@GetMapping("ShopOrderInfo")
	public String ShopOrderInfo(ShopOrderVO shopOrderVO,Model model) {
		List<ShopOrderVO> list = shopOrderService.orderInfo(shopOrderVO);
		model.addAttribute("ShopOrderInfo", list);
		return "shop/OrderInfo";
	}
	
	//자동 발주 리스트
	@GetMapping("ShopAutoOrderList")
	public String ShopAutoOrderList(ShopOrderVO shopOrderVO, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {
		
		int total = shopOrderService.AutoOrdercountMaterial();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		
		shopOrderVO = new ShopOrderVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", shopOrderVO);
		model.addAttribute("viewAll", shopOrderService.autoOrderInfo(shopOrderVO));
		
		
		return "shop/OrderAuto";
	}
	
	//삭제
	@GetMapping("Delauto")
	public String Delauto(String orderDetailsNumber) {
		shopOrderService.deleteAuto(orderDetailsNumber);		
		return "redirect:ShopAutoOrderList";
	}
	
	//조건 조회
	@PostMapping("selectdate")
	@ResponseBody
	public List<ShopOrderVO> selectdate(@RequestBody ShopOrderVO shopOrderVO, Model model){
		 List<ShopOrderVO> list = shopOrderService.selectdate(shopOrderVO);
		return list;
	}
	
	//재료 삭제
	@PostMapping("delMater")
	@ResponseBody
	public String delMater(@RequestBody List<ShopOrderVO> shopOrderVO) {
		System.err.println(shopOrderVO);
		shopOrderService.delMater(shopOrderVO);
		
		return "true";
	}
	
}
