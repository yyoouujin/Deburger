package com.deburger.app.shop.StoreMatCon.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.shop.StoreMatCon.service.StoreMatConService;
import com.deburger.app.shop.StoreMatCon.service.StoreMatConVO;

@Controller
public class StoreMatConController {

	private StoreMatConService storeMatConService;
	
	@Autowired
	StoreMatConController(StoreMatConService storeMatConService){
		this.storeMatConService = storeMatConService;
	}
	
	@GetMapping("StoreMaterialConList")
	public String StoreMaterialConList(Model model) {
		List<StoreMatConVO> list = storeMatConService.StoreMaterialList();
		model.addAttribute("StoreMaterialConList",list);
		
		return "shop/Material";
	}
	
	@GetMapping("StoreMaterialoneList")
	public String StoreMaterialoneList(StoreMatConVO storeMatConVO,Model model) {
		
		List<StoreMatConVO> list = storeMatConService.StoreMaterialoneList(storeMatConVO);
		
		model.addAttribute("StoreMaterialoneList", list);
		
		return"shop/MaterialGraph";
	}
}
