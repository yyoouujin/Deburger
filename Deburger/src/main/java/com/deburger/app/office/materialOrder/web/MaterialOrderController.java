package com.deburger.app.office.materialOrder.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.office.logistic.service.LogisticVO;
import com.deburger.app.office.materialOrder.service.MaterialOrderListVO;
import com.deburger.app.office.materialOrder.service.MaterialOrderService;
import com.deburger.app.office.materialOrder.service.MaterialOrderVO;
import com.deburger.app.office.supplier.service.SupplierVO;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@AllArgsConstructor
public class MaterialOrderController {
	
	
	private MaterialOrderService materialOrderService;
	
	
	/*
	 * 물류창고 발주 등록, 업체별 판매상품검색, 물류창고 발주등록
	*/ 
	
	//물류창고 발주 등록 페이지
	@GetMapping("materialOrder")
	public String materialOrderForm(LogisticVO logisticVO,Model model) {
		
		List<SupplierVO> supplierList = materialOrderService.selectSupplierList();
		List<LogisticVO> logisticList = materialOrderService.selectLogisticsList();
		
		model.addAttribute("logisticVO", logisticVO);
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("logisticList", logisticList);		
		
		return "office/materialOrder/materialOrderInsert";
	}
	
	//물류창고 발주 -> 발주 상세(트랜잭션)
	@PostMapping("materialOrder")
	@ResponseBody
	public int postmaterialOrder(@RequestBody MaterialOrderListVO list) {
		return materialOrderService.insertLogisticOrder(list);
	}
	
	
	// 업체별 판매상품 검색
	@PostMapping("selectSupplierListOptions")
	@ResponseBody
	public List<MaterialOrderVO> selectSupplierListOptions(@RequestBody MaterialOrderVO meteMaterialOrderVO) {		
		return materialOrderService.selectSupplierListOptions(meteMaterialOrderVO);
	}
	
	@GetMapping("selectMaterialOrder")
	public String selectMaterialOrder(Model model) {
		List<MaterialOrderVO> list = materialOrderService.selectMaterialOrder();
		model.addAttribute("Orders", list);
		return "office/materialOrder/selectMaterialOrder";
	}
	
	//물류창고 발주 등록 페이지
	@GetMapping("materialOrderInfo")
	public String materialOrderInfo(MaterialOrderVO inVO,Model model) {
		MaterialOrderVO vo = new MaterialOrderVO();
		
		List<MaterialOrderVO> list = materialOrderService.selectMaterialOrderInfo(inVO);
		
		for(MaterialOrderVO materialOrderVO : list) {
			vo.setLogisticsName(materialOrderVO.getLogisticsName());
			vo.setPhone(materialOrderVO.getPhone());
			vo.setClientName(materialOrderVO.getClientName());
			vo.setEmail(materialOrderVO.getEmail());
			vo.setPhoneLog(materialOrderVO.getPhoneLog());
			vo.setOrderDay(materialOrderVO.getOrderDay());
		}
		
		model.addAttribute("Info", vo);
		model.addAttribute("Order", list);
		
		return "office/materialOrder/materialOrderInfo";
	}
		
}


/*

	// 폐기 처리
	@PostMapping("containerIn")
	public String disposeController(ContainerVO containerVO, Model model) {
		containerService.disposeItem(containerVO);
		return "redirect:container";
	}

*/
