package com.deburger.app.office.materialOrder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaterialOrderController {
	
	//물류창고 발주 -> 발주 상세(트랜잭션)
	
	
	//물류창고 발주 등록 페이지
	@GetMapping("materialOrder")
	public String materialOrderForm() {
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
