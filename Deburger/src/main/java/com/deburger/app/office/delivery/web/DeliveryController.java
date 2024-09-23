package com.deburger.app.office.delivery.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.office.delivery.service.DeliveryService;
import com.deburger.app.office.delivery.service.DeliveryVO;
import com.deburger.app.office.logistic.service.Criteria;
import com.deburger.app.office.logistic.service.PageDTO;

@Controller
public class DeliveryController {
	
	private DeliveryService deliveryService;
	
	@Autowired
	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}
	
	
	
	//가맹점 발주 전체조회
	/**
	 * 
	 * @param criteria :
	 * @param model
	 * @return
	 * @
	 */
	@GetMapping("deliveryList")
	public String deliveryList(Criteria criteria, Model model) {
		List<DeliveryVO> list = deliveryService.deliveryList(criteria);
		
		model.addAttribute("deliveries", list);
		
		model.addAttribute("pageMaker", new PageDTO(deliveryService.getTotal(), 5, criteria));
		
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
	@ResponseBody
	public Map<String, Object> oderappUpdate(DeliveryVO deliveryVO) {
		String mcode = SecurityUtil.memberCode();
		deliveryVO.setPersonId(mcode);
		return deliveryService.updateOderapp(deliveryVO);
		
	}
	
	//취소상태수정
	@PostMapping("canceloperationUpdate")
	@ResponseBody
	public Map<String, Object> canceloperationUpdate(DeliveryVO deliveryVO) {
		return deliveryService.updateCancelOperation(deliveryVO);
	}
	
	
	
	
}
