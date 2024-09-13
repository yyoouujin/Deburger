package com.deburger.app.office.materialOrder.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.office.logistic.service.LogisticVO;
import com.deburger.app.office.materialOrder.service.MaterialOrderService;
import com.deburger.app.office.supplier.service.SupplierVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MaterialOrderController {
	
	
	private MaterialOrderService materialOrderService;
	//물류창고 발주 -> 발주 상세(트랜잭션)
	
	
	//물류창고 발주 등록 페이지
	@GetMapping("materialOrder")
	public String materialOrderForm(Model model) {
		
		List<SupplierVO> supplierList = materialOrderService.selectSupplierList();
		List<LogisticVO> logisticList = materialOrderService.selectLogisticsList();
		
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("logisticList", logisticList);		
		
		return "office/materialOrder/materialOrderInsert";
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
