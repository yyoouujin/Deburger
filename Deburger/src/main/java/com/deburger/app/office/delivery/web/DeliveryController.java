package com.deburger.app.office.delivery.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.office.delivery.service.DeliveryService;
import com.deburger.app.office.delivery.service.DeliveryVO;

@Controller
public class DeliveryController {
	
	private DeliveryService deliveryService;
	
	@Autowired
	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}
	
	//가맹점 발주 전체조회
	@GetMapping("deliveryList")
	public String deliveryList(Model model) {
		List<DeliveryVO> list = deliveryService.deliveryList();
		model.addAttribute("deliveries", list);
		return "office/delivery/deliveryList";
	}
	
	//발주 상세조회
	@GetMapping("deliveryInfo")
	@ResponseBody
	public List<DeliveryVO> getDeliveryInfo(DeliveryVO deliveryVO) {
		List<DeliveryVO> findVO = deliveryService.deliveryInfo(deliveryVO);
		return findVO;
	}
	
	//창고 재고 전체조회
	@GetMapping("logisticAllStock")
	@ResponseBody
	public int getLogisticAllStock(DeliveryVO deliveryVO) {
		int allStock = deliveryService.logisticAllStock(deliveryVO);
		return allStock;
	}
	
	
	//발주 전체수량
	@GetMapping("orderAllStock")
	@ResponseBody
	public int getOrderAllStock(DeliveryVO deliveryVO) {
		int allStock = deliveryService.orderAllStock(deliveryVO);
		return allStock;
	}
	
	//창고선택
	@GetMapping("selectLogistics")
	@ResponseBody
	public List<DeliveryVO> selectLogistics(DeliveryVO deliveryVO) {
		List<DeliveryVO> infoVO = deliveryService.logisticsStockInfo(deliveryVO);
		return infoVO;
	}
	
	
	//발주상태수정
	@PostMapping("oderappUpdate")
	public String oderappUpdate(DeliveryVO deliveryVO) {
		deliveryService.updateOderapp(deliveryVO);
		return "redirect:deliveryList";
	}
	
	
	
	
	
	
}
